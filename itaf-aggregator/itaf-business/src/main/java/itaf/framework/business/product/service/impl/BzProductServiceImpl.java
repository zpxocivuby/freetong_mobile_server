package itaf.framework.business.product.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.cart.service.IBzCartItemService;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.business.merchant.service.IBzShelfService;
import itaf.framework.business.merchant.service.IBzStockService;
import itaf.framework.business.product.service.IBzProductAttachmentService;
import itaf.framework.business.product.service.IBzProductService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzShelf;
import itaf.framework.domain.merchant.BzStock;
import itaf.framework.domain.product.BzProduct;
import itaf.framework.domain.product.BzProductAttachment;
import itaf.framework.persistence.product.dao.IBzProductDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("bzProductServiceImpl")
public class BzProductServiceImpl extends BaseServiceImpl implements
		IBzProductService {

	@Autowired
	private IBzProductDao bzProductDao;
	@Autowired
	private IBzMerchantService bzMerchantService;
	@Autowired
	private IBzStockService bzStockService;
	@Autowired
	private IBzShelfService bzShelfService;
	@Autowired
	private IBzProductAttachmentService bzProductAttachmentService;
	@Autowired
	private IBzCartItemService bzCartItemService;

	public PageResult<BzProduct> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] { "b.bzMerchantId=:bzMerchantId",
				"b.productName like :productName",
				"b.productColor like :productColor",
				"b.productDescription like :productDescription",
				"b.productOnSale=:productOnSale",
				"b.isStockLimitless=:isStockLimitless",
				"b.isShelfLimitless=:isShelfLimitless",
				"b.isStockSupport=:isStockSupport",
				"b.isShelfSupport=:isShelfSupport",
				"b.markForDelete=:markForDelete", null, null, null, null, null,
				null, null };
		String fromJoinSubClause = "from BzProduct b";
		Map<String, Object> params = criteria.getQueryCondition();
		if (params.containsKey("positionX") && params.containsKey("positionY")) {
			whereBodies[10] = "b.bzMerchantId=m.id";
			whereBodies[11] = "uda.sysUserId=m.id";
			whereBodies[12] = "uda.bzPositionId=p.id";
			whereBodies[13] = "p.x+m.serviceCoverage/111.31955>=:positionX";
			whereBodies[14] = "p.x-m.serviceCoverage/111.31955<=:positionX";
			whereBodies[15] = "p.y+m.serviceCoverage/1.8553258>=:positionY";
			whereBodies[16] = "p.y-m.serviceCoverage/1.8553258<=:positionY";
			fromJoinSubClause = "from BzProduct b,BzMerchant m,BzUserDeliveryAddress uda,BzPosition p";
		}
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzProduct> result = bzProductDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public BzProduct findById(Long bzProductId) {
		return bzProductDao.findById(bzProductId);
	}

	public BzProduct getById(Long id) {
		return bzProductDao.getById(id);
	}

	public void doSaveOrUpdate(BzProduct bzProduct, Long shelfNum, Long stockNum) {
		Assert.notNull(bzProduct);
		boolean bAddModel = false;
		if (bzProduct.getId() == null || bzProduct.getId() <= 0) {
			bzProduct.setId(null);
			bAddModel = true;
		}
		bzProductDao.saveOrUpdate(bzProduct);
		if (bzProduct.getBzProductAttachments() != null
				&& bzProduct.getBzProductAttachments().size() > 0) {
			bzProductAttachmentService.doMarkForValid(bzProduct
					.getBzProductAttachments());
			for (BzProductAttachment bzProductAttachment : bzProduct
					.getBzProductAttachments()) {
				bzProductAttachment.setBzProduct(bzProduct);
				bzProductAttachmentService.doSaveOrUpdate(bzProductAttachment);
			}
		}
		if (bAddModel) {
			BzStock bzStock = new BzStock();
			bzStock.setBzProduct(bzProduct);
			bzStock.setBzMerchantId(bzProduct.getBzMerchantId());
			bzStock.setStockNum(stockNum);
			bzStockService.doSaveOrUpdate(bzStock);
			if (Long.valueOf(1).equals(bzProduct.getProductOnSale())) {
				BzShelf bzShelf = bzShelfService
						.findEmptyByMerchantId(bzProduct.getBzMerchantId());
				if (bzShelf == null) {
					bzShelf = new BzShelf();
				}
				bzShelf.setBzProduct(bzProduct);
				bzShelf.setBzMerchantId(bzProduct.getBzMerchantId());
				bzShelf.setStockNum(shelfNum);
				bzShelf.setSoldNum(0L);
				bzShelfService.doSaveOrUpdate(bzShelf);
			}
		} else {
			BzStock bzStock = bzProduct.getBzStock();
			bzStock.setStockNum(stockNum);
			bzStockService.doSaveOrUpdate(bzStock);
		}
	}

	public void doMarkForDelete(BzProduct bzProduct) {
		Assert.notNull(bzProduct);
		BzShelf bzShelf = bzProduct.getBzShelf();
		if (bzShelf != null) {
			throw new RuntimeException("商品未下架!");
		}
		bzProduct.setMarkForDelete(true);
		bzProductDao.saveOrUpdate(bzProduct);
	}

	public void doMarkForDeleteById(Long bzProductId) {
		doMarkForDelete(bzProductDao.findById(bzProductId));
	}

	public void doMarkForDeleteByIds(String bzProductIds) {
		for (String bzProductId : bzProductIds.split(",")) {
			doMarkForDeleteById(Long.valueOf(bzProductId));
		}
	}

	public void doPutProductOnShelf(Long bzProductId, Long onShelfNumber) {
		doPutProductOnShelf(bzProductDao.findById(bzProductId), onShelfNumber);
	}

	public void doPutProductsOnShelf(String bzProductIds) {
		for (String bzProductId : bzProductIds.split(",")) {
			doPutProductOnShelf(
					bzProductDao.findById(Long.valueOf(bzProductId)), 0L);
		}
	}

	private void doPutProductOnShelf(BzProduct bzProduct, Long onShelfNumber) {
		BzShelf bzShelf = bzShelfService.findEmptyByMerchantId(bzProduct
				.getBzMerchantId());
		if (bzShelf == null) {
			bzShelf = new BzShelf();
		}
		bzShelf.setBzProduct(bzProduct);
		bzShelf.setBzMerchantId(bzProduct.getBzMerchantId());
		bzShelf.setStockNum(onShelfNumber);
		bzShelf.setSoldNum(0L);
		bzShelfService.doSaveOrUpdate(bzShelf);

		BzStock bzStock = bzProduct.getBzStock();
		bzStock.setStockNum(bzStock.getStockNum() - onShelfNumber);
		bzStockService.doSaveOrUpdate(bzStock);

		bzProduct.setProductOnSale(1L);
		bzProductDao.saveOrUpdate(bzProduct);

		bzCartItemService.doMarkForValid(bzProduct.getId());
	}

	public void doRemoveProductFromShelf(Long bzProductId) {
		doRemoveProductFromShelf(bzProductDao.findById(bzProductId));
	}

	public void doRemoveProductsFromShelf(String bzProductIds) {
		for (String bzProductId : bzProductIds.split(",")) {
			doRemoveProductFromShelf(bzProductDao.findById(Long
					.valueOf(bzProductId)));
		}
	}

	private void doRemoveProductFromShelf(BzProduct bzProduct) {
		BzShelf bzShelf = bzProduct.getBzShelf();

		BzStock bzStock = bzProduct.getBzStock();
		bzStock.setStockNum(bzStock.getStockNum() + bzShelf.getStockNum());
		bzStockService.doSaveOrUpdate(bzStock);

		bzShelf.setBzProduct(null);
		bzShelf.setSoldNum(0L);
		bzShelf.setStockNum(0L);
		bzShelfService.doSaveOrUpdate(bzShelf);

		bzProduct.setProductOnSale(0L);
		bzProductDao.saveOrUpdate(bzProduct);

		bzCartItemService.doMarkForInvalid(bzProduct.getId());
	}

}