package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzDistStatement;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzDistStatementDao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository("bzDistStatementDaoImpl")
public class BzDistStatementDaoImpl extends BaseDaoImpl<BzDistStatement>
		implements IBzDistStatementDao {

	public List<BzDistStatement> findByIds(List<Long> bzDistStatementIds) {
		String hql = "select b from BzDistStatement b where b.id in (:bzDistStatementIds)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzDistStatementIds", bzDistStatementIds);
		return this.query(hql, params);
	}

	public BigDecimal sum(final String hql, final Map<String, Object> params) {
		return getHibernateTemplate().execute(
				new HibernateCallback<BigDecimal>() {
					public BigDecimal doInHibernate(Session session)
							throws SQLException {
						Query query = session.createQuery(hql);
						query.setProperties(params);
						return (BigDecimal) query.list().get(0);
					}
				});
	}

}