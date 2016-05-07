package itaf.framework.persistence.merchant.dao;

import itaf.framework.domain.merchant.BzDistStatementItem;
import itaf.framework.persistence.base.dao.IBaseDao;

import java.util.List;

public interface IBzDistStatementItemDao extends IBaseDao<BzDistStatementItem> {

	List<BzDistStatementItem> findByIds(List<Long> bzDistStatementItemIds);

}
