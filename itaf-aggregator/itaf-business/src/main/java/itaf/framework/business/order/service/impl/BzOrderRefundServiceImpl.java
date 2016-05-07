package itaf.framework.business.order.service.impl;

import itaf.framework.business.account.service.IBzAccountService;
import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.order.service.IBzOrderRefundService;
import itaf.framework.business.order.service.IBzOrderService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.account.BzAccount;
import itaf.framework.domain.order.BzOrder;
import itaf.framework.domain.order.BzOrderRefund;
import itaf.framework.exception.bean.BusinessException;
import itaf.framework.persistence.order.dao.IBzOrderRefundDao;
import itaf.framework.persistence.util.HqlUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzOrderRefundServiceImpl")
public class BzOrderRefundServiceImpl extends BaseServiceImpl implements
		IBzOrderRefundService {

	@Autowired
	private IBzOrderRefundDao bzOrderRefundDao;
	@Autowired
	private IBzOrderService bzOrderService;
	@Autowired
	private IBzAccountService bzAccountService;

	public PageResult<BzOrderRefund> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] { "b.bzOrder.id=:bzOrderId",
				"b.bzConsumerId=:bzConsumerId", "b.bzMerchantId=:bzMerchantId",
				"b.refundSerialNo=:orderSerialNo",
				"b.refundStatus=:refundStatus",
				"b.refundStatus!=:unRefundStatus",
				"b.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzOrderRefund b";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzOrderRefund> result = bzOrderRefundDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public void doApplyRefund(Long bzConsumerId, Long bzOrderId) {
		BzOrder bzOrder = bzOrderService.getById(bzOrderId);
		BzOrderRefund bzOrderRefund = new BzOrderRefund();
		bzOrderRefund.setBzOrder(bzOrder);
		bzOrderRefund.setBzConsumerId(bzOrder.getBzConsumerId());
		bzOrderRefund.setBzMerchantId(bzOrder.getBzMerchantId());
		bzOrderRefund.setRefundSerialNo(new SimpleDateFormat(
				"yyyyMMddHHmmssSSS").format(new Date()));
		bzOrderRefund.setRefundStatus(1L);
		// 计算金额, 运费不退
		BigDecimal m2cAmount = bzOrder.getOrderAmount().subtract(
				bzOrder.getBzInvoice().getBzDistOrder().getBzCollectionOrder()
						.getDistAmount());
		bzOrderRefund.setRefundAmount(m2cAmount);
		bzOrderService.doUpdateStatus(bzOrder.getId(), 5L);
		bzOrderRefundDao.saveOrUpdate(bzOrderRefund);
	}

	public void doCancelRefund(Long bzConsumerId, Long bzOrderRefundId) {
		BzOrderRefund bzOrderRefund = bzOrderRefundDao.getById(bzOrderRefundId);
		bzOrderService.doUpdateStatus(bzOrderRefund.getBzOrder().getId(), 4L);
		bzOrderRefundDao.remove(bzOrderRefund);
	}

	public void doAcceptRefund(Long bzMerchantId, Long bzOrderRefundId) {
		BzOrderRefund bzOrderRefund = bzOrderRefundDao.getById(bzOrderRefundId);
		bzOrderRefund.setRefundStatus(2L);
		BzOrder bzOrder = bzOrderRefund.getBzOrder();
		BzAccount bzAccountOfMerchant = bzAccountService.getById(bzMerchantId);
		if (bzAccountOfMerchant.getAccountBalance().compareTo(
				bzOrderRefund.getRefundAmount()) > 0) {
			// 商家扣减金额
			bzAccountOfMerchant.setAccountBalance(bzAccountOfMerchant
					.getAccountBalance().subtract(
							bzOrderRefund.getRefundAmount()));
			bzAccountService.doUpdate(bzAccountOfMerchant);
		} else {
			throw new BusinessException("余额不足");
		}
		bzOrderService.doUpdateStatus(bzOrder.getId(), 8L);
		bzOrderRefundDao.saveOrUpdate(bzOrderRefund);
	}

	public void doRejectRefund(Long bzMerchantId, Long bzOrderRefundId) {
		BzOrderRefund bzOrderRefund = bzOrderRefundDao.getById(bzOrderRefundId);
		bzOrderRefund.setRefundStatus(3L);
		bzOrderService.doUpdateStatus(bzOrderRefund.getBzOrder().getId(), 4L);
		bzOrderRefundDao.saveOrUpdate(bzOrderRefund);
	}

}