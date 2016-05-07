package itaf.framework.business.merchant.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzDistOrder;
import itaf.framework.domain.merchant.BzDistStatementItem;

public interface IBzDistStatementItemService {

	PageResult<BzDistStatementItem> findByCriteria(QueryCriteria criteria);

	void doCreateDistStatementItem(BzDistOrder bzDistOrder);

}