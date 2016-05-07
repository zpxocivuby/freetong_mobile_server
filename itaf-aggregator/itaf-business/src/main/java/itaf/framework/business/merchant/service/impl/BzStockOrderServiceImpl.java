package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzStockOrderService;
import itaf.framework.business.order.service.IBzOrderItemService;
import itaf.framework.domain.merchant.BzStockOrder;
import itaf.framework.domain.merchant.BzStockOrderItem;
import itaf.framework.domain.order.BzOrderItem;
import itaf.framework.domain.product.BzProduct;
import itaf.framework.persistence.merchant.dao.IBzStockOrderDao;
import itaf.framework.persistence.merchant.dao.IBzStockOrderItemDao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("bzStockOrderServiceImpl")
public class BzStockOrderServiceImpl extends BaseServiceImpl implements
		IBzStockOrderService {

	@Autowired
	private IBzStockOrderDao bzStockOrderDao;
	@Autowired
	private IBzStockOrderItemDao bzStockOrderItemDao;
	@Autowired
	private IBzOrderItemService bzOrderItemService;

	public List<BzStockOrder> findList(Long bzMerchantId) {
		String hql = "from BzStockOrder b where b.bzMerchantId=:bzMerchantId and b.orderStatus=:orderStatus and b.markForDelete=:markForDelete order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzMerchantId", bzMerchantId);
		params.put("orderStatus", 1L);
		params.put("markForDelete", false);
		return bzStockOrderDao.query(hql, params);
	}

	public BzStockOrder getById(Long bzStockOrderId) {
		return bzStockOrderDao.getById(bzStockOrderId);
	}

	public void doCreateStockOrder(Long bzMerchantId, String bzOrderItemIds) {
		Assert.notNull(bzMerchantId);
		Assert.notNull(bzOrderItemIds);
		BzStockOrder bzStockOrder = new BzStockOrder();
		bzStockOrder.setBzMerchantId(bzMerchantId);

		// TODO
		bzStockOrder.setOrderSerialNo(new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()));

		bzStockOrder.setOrderStatus(1L);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, 2);
		bzStockOrder.setOrderEdc(cal.getTime());
		bzStockOrderDao.saveOrUpdate(bzStockOrder);
		List<BzOrderItem> bzOrderItems = bzOrderItemService
				.findByIds(bzOrderItemIds);
		Map<Long, ObjectCounter> mpObjectCounter = new HashMap<Long, ObjectCounter>();
		for (BzOrderItem bzOrderItem : bzOrderItems) {
			BzProduct bzProduct = bzOrderItem.getBzProduct();
			ObjectCounter objectCounter = mpObjectCounter
					.get(bzProduct.getId());
			if (objectCounter == null) {
				objectCounter = new ObjectCounter(bzProduct,
						bzOrderItem.getItemNum());
				mpObjectCounter.put(bzProduct.getId(), objectCounter);
			} else {
				objectCounter.plusCount(bzOrderItem.getItemNum());
			}
		}
		for (ObjectCounter objectCounter : mpObjectCounter.values()) {
			BzStockOrderItem bzStockOrderItem = new BzStockOrderItem();
			bzStockOrderItem.setBzStockOrder(bzStockOrder);
			bzStockOrderItem.setBzProductId(((BzProduct) objectCounter
					.getObject()).getId());
			bzStockOrderItem.setItemStatus(1L);
			bzStockOrderItem.setItemNum(objectCounter.getCount());
			bzStockOrderItemDao.saveOrUpdate(bzStockOrderItem);
		}
	}

	public void doFinishedStockOrder(Long bzStockOrderId) {
		BzStockOrder bzStockOrder = bzStockOrderDao.findById(bzStockOrderId);
		bzStockOrder.setOrderStatus(2L);
		bzStockOrderDao.saveOrUpdate(bzStockOrder);
	}

	class ObjectCounter {

		private Object object;
		private Long count = 0L;

		public ObjectCounter(Object object, Long count) {
			this.object = object;
			this.count = count;
		}

		public Object getObject() {
			return this.object;
		}

		public Long getCount() {
			return this.count;
		}

		public void plusCount(Long count) {
			this.count = this.count + count;
		}

	}

}