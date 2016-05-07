package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzDistCompanyService;
import itaf.framework.business.merchant.service.IBzInvoiceService;
import itaf.framework.business.order.service.IBzOrderService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzCollectionOrder;
import itaf.framework.domain.merchant.BzDistCompany;
import itaf.framework.domain.merchant.BzDistOrder;
import itaf.framework.domain.merchant.BzDistOrderItem;
import itaf.framework.domain.merchant.BzInvoice;
import itaf.framework.domain.merchant.BzInvoiceItem;
import itaf.framework.domain.order.BzOrder;
import itaf.framework.domain.order.BzOrderItem;
import itaf.framework.domain.position.BzPosition;
import itaf.framework.persistence.merchant.dao.IBzCollectionOrderDao;
import itaf.framework.persistence.merchant.dao.IBzDistOrderDao;
import itaf.framework.persistence.merchant.dao.IBzDistOrderItemDao;
import itaf.framework.persistence.merchant.dao.IBzInvoiceDao;
import itaf.framework.persistence.merchant.dao.IBzInvoiceItemDao;
import itaf.framework.persistence.util.HqlUtils;

import java.awt.Point;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzInvoiceServiceImpl")
public class BzInvoiceServiceImpl extends BaseServiceImpl implements
		IBzInvoiceService {

	@Autowired
	private IBzInvoiceDao bzInvoiceDao;
	@Autowired
	private IBzInvoiceItemDao bzInvoiceItemDao;
	@Autowired
	private IBzDistOrderDao bzDistOrderDao;
	@Autowired
	private IBzDistOrderItemDao bzDistOrderItemDao;
	@Autowired
	private IBzCollectionOrderDao bzCollectionOrderDao;
	@Autowired
	private IBzOrderService bzOrderService;
	@Autowired
	private IBzDistCompanyService bzDistCompanyService;

	public PageResult<BzInvoice> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] { "b.bzMerchant.id=:bzMerchant",
				"b.bzDistCompany.username like :bzDistCompanyName",
				"b.invoiceSerialNo=:invoiceSerialNo",
				"b.invoiceStatus=:invoiceStatus",
				"b.distContactPerson=:distContactPerson",
				"b.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzInvoice b";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzInvoice> result = bzInvoiceDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public BzInvoice getById(Long id) {
		return bzInvoiceDao.getById(id);
	}

	public void doInvoice(Long bzOrderId, Long bzDistCompanyId) {
		BzOrder bzOrder = bzOrderService.getById(bzOrderId);
		BzDistCompany bzDistCompany = bzDistCompanyService
				.getById(bzDistCompanyId);

		BzInvoice bzInvoice = new BzInvoice();
		bzInvoice.setBzMerchant(bzOrder.getBzMerchant());
		bzInvoice.setBzOrder(bzOrder);
		bzInvoice.setBzDistCompany(bzDistCompany);
		bzInvoice.setInvoiceSerialNo(new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()));
		bzInvoice.setInvoiceStatus(1L);
		bzInvoice.setDistAddress(bzOrder.getBzUserAddress().getAddress());
		bzInvoice.setDistContactPerson(bzOrder.getBzUserAddress()
				.getContactPerson());
		bzInvoice.setDistContactNo(bzOrder.getBzUserAddress().getContactNo());
		bzInvoice.setDistPostcode(bzOrder.getBzUserAddress().getPostcode());
		bzInvoiceDao.saveOrUpdate(bzInvoice);

		Long orderNum = 0L;
		for (BzOrderItem bzOrderItem : bzOrder.getBzOrderItems()) {
			BzInvoiceItem bzInvoiceItem = new BzInvoiceItem();
			bzInvoiceItem.setBzInvoice(bzInvoice);
			bzInvoiceItem.setBzProduct(bzOrderItem.getBzProduct());
			bzInvoiceItem.setItemNum(bzOrderItem.getItemNum());
			bzInvoiceItemDao.saveOrUpdate(bzInvoiceItem);

			orderNum += bzOrderItem.getItemNum();

		}

		BzDistOrder bzDistOrder = new BzDistOrder();
		bzDistOrder.setBzMerchant(bzOrder.getBzMerchant());
		bzDistOrder.setBzDistCompany(bzDistCompany);
		bzDistOrder.setBzInvoice(bzInvoice);
		bzDistOrder.setBzOrder(bzOrder);
		bzDistOrder.setOrderStatus(1L);

		BzPosition bzPositionUa = bzOrder.getBzUserAddress().getBzPosition();// 用户收货地址
		BzPosition bzPositionDc = bzDistCompany.getSysUser()
				.getBzUserDeliveryAddress().get(0).getBzPosition();// 配送商地址
		Point p1 = new Point(bzPositionUa.getX().intValue(), bzPositionUa
				.getY().intValue());
		Point p2 = new Point(bzPositionDc.getX().intValue(), bzPositionDc
				.getY().intValue());
		double orderDistance = GetDistance(p1.getX(), p1.getY(), p2.getX(),
				p2.getY());
		bzDistOrder.setOrderDistance(new BigDecimal(orderDistance));

		bzDistOrder.setOrderDirection(0L);
		bzDistOrder.setOrderSerialNo(new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()));

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, 2);
		bzDistOrder.setOrderEdc(cal.getTime());

		bzDistOrder.setOrderNum(orderNum);
		bzDistOrder.setDistAddress(bzOrder.getBzUserAddress().getAddress());
		bzDistOrder.setDistContactPerson(bzOrder.getBzUserAddress()
				.getContactPerson());
		bzDistOrder.setDistContactNo(bzOrder.getBzUserAddress().getContactNo());
		bzDistOrder.setDistPostcode(bzOrder.getBzUserAddress().getPostcode());
		bzDistOrder.setOrderStatementStatus(1L);
		bzDistOrderDao.saveOrUpdate(bzDistOrder);

		for (BzOrderItem bzOrderItem : bzOrder.getBzOrderItems()) {
			BzDistOrderItem bzDistOrderItem = new BzDistOrderItem();
			bzDistOrderItem.setBzDistOrder(bzDistOrder);
			bzDistOrderItem.setBzProduct(bzOrderItem.getBzProduct());
			bzDistOrderItem.setItemNum(bzOrderItem.getItemNum());
			bzDistOrderItemDao.saveOrUpdate(bzDistOrderItem);
		}

		BzCollectionOrder bzCollectionOrder = new BzCollectionOrder();
		bzCollectionOrder.setBzDistOrder(bzDistOrder);

		bzCollectionOrder.setDistAmount(new BigDecimal(5L));

		BigDecimal receivableAmountLong = new BigDecimal(0L);
		// 货到付款
		if (1 == bzOrder.getBzOrderPayment().getBzPaymentTypeId().intValue()) {
			receivableAmountLong = receivableAmountLong.add(bzOrder
					.getOrderAmount());
		}
		receivableAmountLong = receivableAmountLong.add(bzCollectionOrder
				.getDistAmount());
		bzCollectionOrder.setReceivableAmount(receivableAmountLong);

		bzCollectionOrderDao.saveOrUpdate(bzCollectionOrder);

		bzOrderService.doUpdateStatus(bzOrderId, 3L);
	}

	public double getDistance(Point p1, Point p2) {
		double _x = Math.abs(p1.x - p2.x);
		double _y = Math.abs(p1.y - p2.y);
		return Math.sqrt(_x * _x + _y * _y);
	}

	private double EARTH_RADIUS = 6378137;

	private double rad(double d) {
		return d * Math.PI / 180.0;
	}

	public double GetDistance(double lng1, double lat1, double lng2, double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

};