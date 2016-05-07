package itaf.framework.persistence.order.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import itaf.framework.domain.order.BzOrder;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.order.dao.IBzOrderDao;

import org.springframework.stereotype.Repository;

@Repository("bzOrderDaoImpl")
public class BzOrderDaoImpl extends BaseDaoImpl<BzOrder> implements IBzOrderDao {

	public List<BzOrder> findByIds(List<Long> bzOrderIds) {
		String hql = "select b from BzOrder b where b.id in (:bzOrderIds)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzOrderIds", bzOrderIds);
		return this.query(hql, params);
	}

}