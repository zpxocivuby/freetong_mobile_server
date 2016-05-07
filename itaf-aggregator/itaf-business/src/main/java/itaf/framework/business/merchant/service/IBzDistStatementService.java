package itaf.framework.business.merchant.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzDistStatement;

import java.math.BigDecimal;

public interface IBzDistStatementService {

	PageResult<BzDistStatement> findByCriteria(QueryCriteria criteria);

	void doStartDistStatement(Long bzMerchantId, Long bzDistCompanyId,
			String bzDistStatementItemIds);

	void doAcceptDistStatement(Long bzDistCompanyId, Long bzDistStatementId);

	void doRejectDistStatement(Long bzDistCompanyId, Long bzDistStatementId);

	BzDistStatement getById(Long bzDistStatementId);

	BigDecimal getReceivableAmount(Long bzDistCompanyId, Long statementStatus);

	BigDecimal getRefundAmount(Long bzDistCompanyId, Long statementStatus);

	BigDecimal getReceivedAmount(Long bzDistCompanyId);

}