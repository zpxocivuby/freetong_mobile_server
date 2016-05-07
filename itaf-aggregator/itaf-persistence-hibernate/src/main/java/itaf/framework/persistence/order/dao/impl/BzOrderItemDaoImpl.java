package itaf.framework.persistence.order.dao.impl;

import itaf.framework.domain.order.BzOrderItem;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.order.dao.IBzOrderItemDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("bzOrderItemDaoImpl")
public class BzOrderItemDaoImpl extends BaseDaoImpl<BzOrderItem> implements
		IBzOrderItemDao {

	public List<BzOrderItem> findByIds(List<Long> bzOrderItemIds) {
		String hql = "select b from BzOrderItem b where b.id in (:bzOrderItemIds)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzOrderItemIds", bzOrderItemIds);
		return this.query(hql, params);
	}

}