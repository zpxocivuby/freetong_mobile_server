package itaf.framework.persistence.merchant.dao;

import itaf.framework.domain.merchant.BzDistOrder;
import itaf.framework.persistence.base.dao.IBaseDao;

import java.util.List;

public interface IBzDistOrderDao extends IBaseDao<BzDistOrder> {

	List<BzDistOrder> findByIds(List<Long> bzDistOrderIds);

}
