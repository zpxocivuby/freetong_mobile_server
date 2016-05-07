package itaf.framework.business.order.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.order.BzOrderRefund;

public interface IBzOrderRefundService {

	PageResult<BzOrderRefund> findByCriteria(QueryCriteria criteria);

	void doApplyRefund(Long bzConsumerId, Long bzOrderId);

	void doCancelRefund(Long bzConsumerId, Long bzOrderRefundId);

	void doAcceptRefund(Long bzMerchantId, Long bzOrderRefundId);

	void doRejectRefund(Long bzMerchantId, Long bzOrderRefundId);

}
