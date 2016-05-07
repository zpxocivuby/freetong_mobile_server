package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzDistOrder;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzDistOrderDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("bzDistOrderDaoImpl")
public class BzDistOrderDaoImpl extends BaseDaoImpl<BzDistOrder> implements
		IBzDistOrderDao {

	public List<BzDistOrder> findByIds(List<Long> bzDistOrderIds) {
		String hql = "select b from BzDistOrder b where b.id in (:bzDistOrderIds)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzDistOrderIds", bzDistOrderIds);
		return this.query(hql, params);
	}

}