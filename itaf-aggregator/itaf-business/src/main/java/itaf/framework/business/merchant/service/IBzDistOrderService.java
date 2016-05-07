package itaf.framework.business.merchant.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzDistOrder;

import java.util.List;

public interface IBzDistOrderService {

	public PageResult<BzDistOrder> findByCriteria(QueryCriteria criteria);

	public void doSaveOrUpdate(BzDistOrder bzDistOrder);

	public BzDistOrder getById(Long bzDistOrderId);

	public List<BzDistOrder> findByIds(String bzDistOrderIds);

	public void doStartDist(BzDistOrder bzDistOrderId);

	public void doFinishDist(BzDistOrder bzDistOrderId);

}
