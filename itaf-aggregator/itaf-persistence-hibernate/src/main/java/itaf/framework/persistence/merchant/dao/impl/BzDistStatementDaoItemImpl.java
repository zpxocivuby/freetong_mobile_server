package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzDistStatementItem;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzDistStatementItemDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("bzDistStatementItemDaoImpl")
public class BzDistStatementDaoItemImpl extends
		BaseDaoImpl<BzDistStatementItem> implements IBzDistStatementItemDao {

	public List<BzDistStatementItem> findByIds(List<Long> bzDistStatementItemIds) {
		String hql = "select b from BzDistStatementItem b where b.id in (:bzDistStatementItemIds)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzDistStatementItemIds", bzDistStatementItemIds);
		return this.query(hql, params);
	}

}