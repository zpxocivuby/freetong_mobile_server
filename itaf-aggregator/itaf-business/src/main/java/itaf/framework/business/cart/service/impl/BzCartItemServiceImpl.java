package itaf.framework.business.cart.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.cart.service.IBzCartItemService;
import itaf.framework.business.consumer.service.IBzConsumerService;
import itaf.framework.business.product.service.IBzProductService;
import itaf.framework.domain.cart.BzCartItem;
import itaf.framework.domain.product.BzProduct;
import itaf.framework.persistence.cart.dao.IBzCartItemDao;
import itaf.framework.persistence.order.dao.IBzOrderDao;
import itaf.framework.persistence.order.dao.IBzOrderItemDao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzCartItemServiceImpl")
public class BzCartItemServiceImpl extends BaseServiceImpl implements
		IBzCartItemService {

	@Autowired
	private IBzCartItemDao bzCartItemDao;
	@Autowired
	private IBzOrderDao bzOrderDao;
	@Autowired
	private IBzOrderItemDao bzOrderItemDao;
	@Autowired
	private IBzConsumerService bzConsumerService;
	@Autowired
	private IBzProductService bzProductService;

	public List<BzCartItem> findList(Long bzConsumerId) {
		String hql = "from BzCartItem b where b.bzConsumerId=:bzConsumerId and b.markForDelete=:markForDelete order by b.itemStatus desc, b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzConsumerId", bzConsumerId);
		params.put("markForDelete", false);
		return bzCartItemDao.query(hql, params);
	}

	public BzCartItem doPutProductInCart(Long bzConsumerId, Long bzProductId,
			int putType) {
		BzCartItem bzCartItem = null;
		if (putType == 1) {
			bzCartItem = findByBzConsumerIdAndBzProductId(bzConsumerId,
					bzProductId);
		}
		if (bzCartItem == null) {
			bzCartItem = new BzCartItem();
			bzCartItem.setBzConsumerId(bzConsumerId);
			bzCartItem.setBzConsumer(bzConsumerService.getById(bzConsumerId));
			bzCartItem.setBzProductId(bzProductId);
			BzProduct bzProduct = bzProductService.findById(bzProductId);
			bzCartItem.setBzProduct(bzProduct);
			// bzCartItem.setItemDiscount();
			bzCartItem.setItemNum(1L);
			// bzCartItem.setItemPreferential();
			bzCartItem.setItemPrice(bzProduct.getProductPrice());
			bzCartItem.setItemUnitPrice(bzProduct.getProductPrice());
			bzCartItem.setItemStatus(1L);
			if (putType == 2) {
				bzCartItem.setMarkForDelete(true);
			}
		} else {
			bzCartItem.setItemNum(bzCartItem.getItemNum() + 1);
			bzCartItem.setItemPrice(bzCartItem.getItemUnitPrice().multiply(
					new BigDecimal(bzCartItem.getItemNum())));
		}
		bzCartItemDao.saveOrUpdate(bzCartItem);
		return bzCartItem;
	}

	private synchronized BzCartItem findByBzConsumerIdAndBzProductId(
			Long bzConsumerId, Long bzProductId) {
		String hql = "from BzCartItem b where b.bzConsumerId=:bzConsumerId and bzProductId=:bzProductId and b.markForDelete=:markForDelete order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzConsumerId", bzConsumerId);
		params.put("bzProductId", bzProductId);
		params.put("markForDelete", false);
		List<BzCartItem> result = bzCartItemDao.query(hql, params);
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public void doUpdateItemNum(Long bzCartItemId, Long itemNum) {
		BzCartItem bzCartItem = bzCartItemDao.findById(bzCartItemId);
		bzCartItem.setItemNum(itemNum);
		bzCartItem.setItemPrice(bzCartItem.getItemUnitPrice().multiply(
				new BigDecimal(bzCartItem.getItemNum())));
		bzCartItemDao.save(bzCartItem);
	}

	public void doDelete(BzCartItem bzCartItem) {
		bzCartItemDao.remove(bzCartItem);
	}

	public void doDeleteByIds(String bzCartItemIds) {
		for (String bzCartItemId : bzCartItemIds.split(",")) {
			bzCartItemDao.remove(bzCartItemDao.findById(Long
					.valueOf(bzCartItemId)));
		}
	}

	public BzCartItem getById(Long bzCartItemId) {
		return bzCartItemDao.getById(bzCartItemId);
	}

	public void doMarkForValid(Long bzProductId) {
		String hql = "update BzCartItem b set b.itemStatus=1 where b.bzProductId=:bzProductId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzProductId", bzProductId);
		bzCartItemDao.hqlExecute(hql, params);
	}

	public void doMarkForInvalid(Long bzProductId) {
		String hql = "update BzCartItem b set b.itemStatus=0 where b.bzProductId=:bzProductId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzProductId", bzProductId);
		bzCartItemDao.hqlExecute(hql, params);
	}

}