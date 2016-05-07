package itaf.framework.persistence.base.dao.impl;

import itaf.framework.core.app.AppContext;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.domain.BaseEntity;
import itaf.framework.domain.base.AuditEntity;
import itaf.framework.persistence.base.dao.IBaseDao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("baseDaoImpl")
public class BaseDaoImpl<T extends BaseEntity> extends HibernateDaoSupport
		implements IBaseDao<T> {

	protected final Log log = LogFactory.getLog(getClass());
	private Class<T> entityClass;

	/**
	 * 构造函数，根据模板类 T 初始化 entityClass对象类别
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		if (ParameterizedType.class.isAssignableFrom(getClass()
				.getGenericSuperclass().getClass())) {
			Type[] actualTypeArguments = ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments();
			entityClass = (Class<T>) actualTypeArguments[0];
		}
	}

	/**
	 * @param sessionFactory
	 */
	@Autowired
	@Qualifier("sessionFactory")
	public void setHibernateSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 对于更新或增加的Model对象，加入操作人和操作时间信息
	 * 
	 * @param obj
	 *            Model数据库记录
	 */
	private void addAuditInfo(T obj) {
		// 如果需要保存的对象是 审计类型记录 ，则自动 添加 操作人和操作时间 信息
		if (obj instanceof AuditEntity) {
			AuditEntity auditEntity = (AuditEntity) obj;
			// 判断 是否是新增记录还是更新记录
			Long id = auditEntity.getId();
			if (null == id || id.longValue() <= 0) {
				auditEntity.setCreatedBy(AppContext.getSessionUser().getId());
				auditEntity.setCreatedDate(Calendar.getInstance().getTime());
			}
			auditEntity.setUpdatedBy(AppContext.getSessionUser().getId());
			auditEntity.setUpdatedDate(Calendar.getInstance().getTime());
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * itaf.framework.dao.BaseDao#eagerLoad(itaf.framework.model.BaseEntity)
	 */
	public void eagerLoad(T obj) {
		super.getHibernateTemplate().initialize(obj);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.IBaseDao#evict(itaf.framework.model.BaseEntity)
	 */
	public void evict(T obj) {
		super.getHibernateTemplate().evict(obj);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#find(itaf.framework.model.BaseEntity)
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(T example) {
		return super.getHibernateTemplate().findByExample(example);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#findAll()
	 */
	public List<T> findAll() {
		return super.getHibernateTemplate().loadAll(this.entityClass);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#findById(java.lang.Long)
	 */
	public T findById(Long id) {
		return (T) super.getHibernateTemplate().load(this.entityClass, id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#findById(java.lang.Long)
	 */
	public T getById(Long id) {
		return (T) super.getHibernateTemplate().get(this.entityClass, id);
	}

	public List<T> getByIds(List<Long> ids) {
		List<T> list = new ArrayList<T>();
		for (Long id : ids) {
			list.add(getById(id));
		}
		return list;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#findById(java.lang.Long)
	 */
	public T findByIdNoWaitLock(Long id) {
		return (T) super.getHibernateTemplate().load(this.entityClass, id,
				LockMode.UPGRADE_NOWAIT);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#findByNamedQuery(java.lang.String,
	 * java.util.Map)
	 */

	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName, Map<String, Object> params) {
		Session session = SessionFactoryUtils.getSession(getSessionFactory(),
				getHibernateTemplate().isAllowCreate());
		Query query = session.getNamedQuery(queryName);
		query.setProperties(params);
		return query.list();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#flush()
	 */
	public void flush() {
		super.getHibernateTemplate().flush();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.IBaseDao#lock(itaf.framework.model.BaseEntity,
	 * org.hibernate.LockMode)
	 */
	public void lock(T entity, LockMode lock) {
		super.getHibernateTemplate().lock(entity, lock);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#bulkUpdate(java.lang.String,
	 * java.util.Map)
	 */
	public int hqlExecute(final String hql, final Map<String, Object> params) {
		Integer result = super.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session)
							throws SQLException {
						Query query = session.createQuery(hql);
						query.setProperties(params);
						return query.executeUpdate();
					}
				});
		return result.intValue();

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.IBaseDao#query(java.lang.String, java.util.Map)
	 */
	public List<T> query(final String hql, final Map<String, Object> params) {
		return getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@SuppressWarnings("unchecked")
			public List<T> doInHibernate(Session session) throws SQLException {
				Query query = session.createQuery(hql);
				query.setProperties(params);
				return query.list();
			}
		});
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#query(java.lang.String, java.lang.String,
	 * java.util.Map, int, int)
	 */
	public PageResult<T> query(final String hql, final String countHql,
			final Map<String, Object> params, final int offsetIndex,
			final int pageSize) {

		PageResult<T> pr = new PageResult<T>();

		pr.setCurrentIndex(offsetIndex);
		pr.setPageSize(pageSize);

		if (null != countHql) {
			pr.setTotalCount(queryCount(countHql, params));
		}

		if (0 != pageSize) {
			pr.setTotalPage((int) ((pr.getTotalCount() + pageSize - 1) / pageSize));
			pr.setCurrentPage((int) ((offsetIndex + pageSize) / pageSize));
		}

		List<T> content = getHibernateTemplate().execute(
				new HibernateCallback<List<T>>() {
					@SuppressWarnings("unchecked")
					public List<T> doInHibernate(Session session)
							throws SQLException {
						Query query = session.createQuery(hql);
						query.setProperties(params);
						if (pageSize != 0) {
							query.setFirstResult(offsetIndex);
							query.setMaxResults(pageSize);
						}
						return query.list();
					}
				});

		pr.setContent(content);
		return pr;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#queryCount(java.lang.String,
	 * java.util.Map)
	 */
	public int queryCount(final String countHql,
			final Map<String, Object> params) {
		List<Long> result = getHibernateTemplate().execute(
				new HibernateCallback<List<Long>>() {
					@SuppressWarnings("unchecked")
					public List<Long> doInHibernate(Session session)
							throws SQLException {
						Query query = session.createQuery(countHql);
						query.setProperties(params);
						return query.list();
					}
				});
		return result.get(0).intValue();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#remove(itaf.framework.model.BaseEntity)
	 */
	public void remove(T obj) {
		super.getHibernateTemplate().delete(this.findById(obj.getId()));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#removeObjects(java.util.Collection)
	 */
	public void removeObjects(Collection<T> objs) {
		super.getHibernateTemplate().deleteAll(objs);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * itaf.framework.dao.BaseDao#saveOrUpdate(itaf.framework.model.BaseEntity)
	 */
	public void saveOrUpdate(T obj) {
		addAuditInfo(obj);
		super.getHibernateTemplate().saveOrUpdate(obj);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#saveOrUpdateAll(java.util.Collection)
	 */
	public void saveOrUpdateAll(Collection<T> objs) {
		for (T obj : objs) {
			addAuditInfo(obj);
		}
		super.getHibernateTemplate().saveOrUpdateAll(objs);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#save(itaf.framework.model.BaseEntity)
	 */
	public void save(T obj) {
		addAuditInfo(obj);
		super.getHibernateTemplate().save(obj);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#updateByNamedQuery(java.lang.String,
	 * java.util.Map)
	 */
	public int updateByNamedQuery(String queryName, Map<String, Object> params) {
		Session session = SessionFactoryUtils.getSession(getSessionFactory(),
				getHibernateTemplate().isAllowCreate());
		Query query = session.getNamedQuery(queryName);
		query.setProperties(params);
		return query.executeUpdate();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#nativeQueryCountSQL(java.lang.String,
	 * java.util.Map)
	 */
	public int sqlQueryCount(final String countSql,
			final Map<String, Object> params) {
		return super.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					@SuppressWarnings("rawtypes")
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						SQLQuery sqlQuery = session.createSQLQuery(countSql);
						sqlQuery.setProperties(params);
						List list = sqlQuery.list();
						if (list != null && !list.isEmpty()) {
							return (((BigDecimal) list.get(0)).intValue());
						}
						return Integer.valueOf(0);
					}
				});
	}

	public List<T> sqlQuery(final String sql, final Map<String, Object> params) {
		return super.getHibernateTemplate().execute(
				new HibernateCallback<List<T>>() {
					@SuppressWarnings("unchecked")
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						SQLQuery sqlQuery = session.createSQLQuery(
								sql.toString()).addEntity(entityClass);
						sqlQuery.setProperties(params);
						return sqlQuery.list();
					}
				});

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#nativeQuerySQL(java.lang.String,
	 * java.lang.String, java.util.Map, int, int)
	 */
	public PageResult<T> sqlQuery(final String sql, final String countSql,
			final Map<String, Object> params, final int offsetIndex,
			final int pageSize) {

		PageResult<T> pr = new PageResult<T>();

		pr.setCurrentIndex(offsetIndex);
		pr.setPageSize(pageSize);

		if (null != countSql) {
			pr.setTotalCount(sqlQueryCount(countSql, params));
		}

		if (0 != pageSize) {
			pr.setTotalPage((int) ((pr.getTotalCount() + pageSize - 1) / pageSize));
			pr.setCurrentPage((int) ((offsetIndex + pageSize) / pageSize));
		}

		List<T> content = super.getHibernateTemplate().execute(
				new HibernateCallback<List<T>>() {
					@SuppressWarnings("unchecked")
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {

						StringBuffer queryBuffer = new StringBuffer();
						if (0 != pageSize) {
							queryBuffer.append(" Select main.* ");
							queryBuffer.append(" From  ");
							queryBuffer.append(" (Select t.*,rownum rn  ");
							queryBuffer.append("  from ( ");
							queryBuffer.append(sql);
							queryBuffer.append("       ) t  ");
							queryBuffer.append(" ) main ");
							queryBuffer.append(" where main.rn > ");
							queryBuffer.append(offsetIndex);
							queryBuffer.append(" and main.rn <=");
							queryBuffer.append(offsetIndex + pageSize);
						} else {
							queryBuffer.append(sql);
						}
						SQLQuery sqlQuery = session.createSQLQuery(
								queryBuffer.toString()).addEntity(entityClass);
						sqlQuery.setProperties(params);
						return sqlQuery.list();
					}
				});

		pr.setContent(content);
		return pr;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see itaf.framework.dao.BaseDao#nativeUpdateSQL(java.lang.String,
	 * java.util.Map)
	 */
	public int sqlExecute(final String sql, final Map<String, Object> params) {
		Integer result = super.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						SQLQuery sqlQuery = session.createSQLQuery(sql);
						sqlQuery.setProperties(params);
						return sqlQuery.executeUpdate();
					}
				});
		return result.intValue();
	}

}
