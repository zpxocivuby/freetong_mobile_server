package itaf.framework.business.order.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.cart.service.IBzCartItemService;
import itaf.framework.business.merchant.service.IBzShelfService;
import itaf.framework.business.order.service.IBzOrderPaymentService;
import itaf.framework.business.order.service.IBzOrderService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.cart.BzCartItem;
import itaf.framework.domain.merchant.BzShelf;
import itaf.framework.domain.order.BzOrder;
import itaf.framework.domain.order.BzOrderItem;
import itaf.framework.persistence.order.dao.IBzOrderDao;
import itaf.framework.persistence.order.dao.IBzOrderItemDao;
import itaf.framework.persistence.util.HqlUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzOrderServiceImpl")
public class BzOrderServiceImpl extends BaseServiceImpl implements
		IBzOrderService {

	@Autowired
	private IBzOrderDao bzOrderDao;
	@Autowired
	private IBzOrderItemDao bzOrderItemDao;
	@Autowired
	private IBzCartItemService bzCartItemService;
	@Autowired
	private IBzOrderPaymentService bzOrderPaymentService;
	@Autowired
	private IBzShelfService bzShelfService;

	public PageResult<BzOrder> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] { "b.bzConsumerId=:bzConsumerId",
				"b.bzMerchantId=:bzMerchantId",
				"b.bzUserAddressId=:bzUserAddressId",
				"b.orderSerialNo=:orderSerialNo", "b.orderStatus=:orderStatus",
				"b.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzOrder b";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzOrder> result = bzOrderDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public BzOrder getById(Long bzOrderId) {
		return bzOrderDao.getById(bzOrderId);
	}

	public List<BzOrder> findByIds(String bzOrderIds) {
		return bzOrderDao.findByIds(StringHelper.stringToLongList(bzOrderIds));
	}

	public synchronized void doSubmitOrder(BzOrder bzOrder,
			List<Long> bzCartItemIds) {

		// TODO
		bzOrder.setOrderSerialNo(new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()));

		if (1 == bzOrder.getBzOrderPayment().getBzPaymentTypeId().intValue()) {
			bzOrder.setOrderStatus(2L);
		} else {
			bzOrder.setOrderStatus(1L);
		}
		bzOrder.setOrderDiscount(new BigDecimal(100L));
		bzOrder.setOrderPreferential(new BigDecimal(0L));
		bzOrderDao.saveOrUpdate(bzOrder);
		for (Long bzCartItemId : bzCartItemIds) {
			BzCartItem bzCartItem = bzCartItemService.getById(bzCartItemId);

			BzOrderItem bzOrderItem = new BzOrderItem();
			bzOrderItem.setBzProduct(bzCartItem.getBzProduct());
			bzOrderItem.setBzOrder(bzOrder);
			bzOrderItem.setItemNum(bzCartItem.getItemNum());
			bzOrderItem.setItemUnitPrice(bzCartItem.getItemUnitPrice());
			bzOrderItem.setItemDiscount(bzCartItem.getItemDiscount());
			bzOrderItem.setItemPreferential(bzCartItem.getItemPreferential());
			bzOrderItem.setItemAmount(bzCartItem.getItemPrice());
			bzOrderItem.setItemStockStatus(1L);
			bzOrderItemDao.saveOrUpdate(bzOrderItem);

			BzShelf bzShelf = bzCartItem.getBzProduct().getBzShelf();
			bzShelf.setStockNum(bzShelf.getStockNum() - bzCartItem.getItemNum());
			bzShelf.setSoldNum(bzShelf.getSoldNum() + bzCartItem.getItemNum());
			bzShelfService.doSaveOrUpdate(bzShelf);

			bzCartItemService.doDelete(bzCartItem);
		}

		bzOrderPaymentService.saveOrUpdate(bzOrder.getBzOrderPayment());
	}

	public void doUpdateStatus(Long bzOrderId, Long orderStatus) {
		BzOrder bzOrder = bzOrderDao.findById(bzOrderId);
		bzOrder.setOrderStatus(orderStatus);
		bzOrderDao.saveOrUpdate(bzOrder);
	}

	public void doConfirmReceived(Long bzOrderId) {
		BzOrder bzOrder = bzOrderDao.getById(bzOrderId);
		bzOrder.setOrderStatus(4L);
		bzOrderDao.saveOrUpdate(bzOrder);
		for (BzOrderItem bzOrderItem : bzOrder.getBzOrderItems()) {
			BzShelf bzShelf = bzOrderItem.getBzProduct().getBzShelf();
			bzShelf.setSoldNum(bzShelf.getSoldNum() - bzOrderItem.getItemNum());
			bzShelfService.doSaveOrUpdate(bzShelf);
		}
	}

}