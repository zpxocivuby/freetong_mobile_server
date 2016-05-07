package itaf.framework.persistence.base.dao;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.domain.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;

public interface IBaseDao<T extends BaseEntity> {

	/**
	 * 以HQL语句方式进行insert, update, delete操作， 可以方便进行批量数据操作。例如批量删除符合某个条件的记录
	 * 批量更新符合某个条件的记录等等。
	 * 
	 * @param hql
	 *            进行insert, update, delete操作的HQL语句
	 * @param params
	 *            HQL语句中参数的值
	 * @return 该语句操作涉及到的数据库记录数
	 */
	public int hqlExecute(final String hql, final Map<String, Object> params);

	/**
	 * 强制Hibernate立刻加载该obj对象数据实例
	 * 
	 * @param obj
	 */
	public void eagerLoad(T obj);

	/**
	 * 将指定的obj对象数据实例从Hibernate Session关联中脱离
	 * 
	 * @param obj
	 */
	public void evict(T obj);

	/**
	 * 根据样例查找符合条件的T类型数据库记录
	 * 
	 * @param example
	 *            T类型的样例，根据其属性中不为null的信息进行相等的过滤查找
	 * @return 返回符合样例过滤条件的数据库记录
	 */
	public List<T> find(T example);

	/**
	 * 查找所有类型为T的数据库记录
	 * 
	 * @return 所有数据库中指定为T类型的表记录
	 */
	public List<T> findAll();

	/**
	 * 根据指定ID返回数据库记录
	 * 
	 * @param id
	 *            记录ID，类型为Long，最小为0，最大为999999999
	 * @return 符合指定id的唯一数据库记录，如果没找到会抛出异常
	 */
	public T findById(Long id);

	/**
	 * 根据指定ID返回数据库记录
	 * 
	 * @param id
	 *            记录ID，类型为Long，最小为0，最大为999999999
	 * @return 符合指定id的唯一数据库记录，如果没找到会抛出异常
	 */
	public T getById(Long id);

	public List<T> getByIds(List<Long> ids);

	/**
	 * 根据指定ID返回数据库记录，但是用一个NO_WAIT锁的方式进行锁定。
	 * 适用于当针对某个对象进行业务操作时（往往具有流程性），在方法入口处就使用该方法读取记录。
	 * 
	 * @param id
	 *            记录ID，类型为Long，最小为0，最大为999999999
	 * @return 符合指定id的唯一数据库记录，如果没找到会抛出异常
	 */
	public T findByIdNoWaitLock(Long id);

	/**
	 * 使用Hibernate Named Query查找数据库对象
	 * 
	 * @param queryName
	 *            命名在hbm.xml配置文件中的查询语句
	 * @param params
	 *            查询语句的参数值
	 * @return 匹配符合条件的记录列表
	 */

	public List<T> findByNamedQuery(String queryName, Map<String, Object> params);

	/**
	 * 手工主动flush Hibernate缓存数据到数据库中
	 */
	public void flush();

	/**
	 * 将指定的实体加锁
	 * 
	 * @param entity
	 *            实体
	 * @param lock
	 *            Hibernate的锁模式
	 */
	public void lock(T entity, LockMode lock);

	/**
	 * 建议使用HQL模式的queryCount方法，但是某些特殊的数据库操作以SQL语句方式进行更有效率
	 * 根据指定的查找记录数量的SQL语句，返回找到的符合条件的数据库记录数
	 * 
	 * @param countSql
	 *            类似于 select count(*) from ....
	 *            类型的SQL语句，可以通过SqlUtils.parseSqlCount方法生成
	 * @param params
	 *            countSql中对应参数的值
	 * @return 返回符合条件的数据库记录数
	 */
	public int sqlQueryCount(final String countSql,
			final Map<String, Object> params);

	public List<T> sqlQuery(final String sql, final Map<String, Object> params);

	/**
	 * 通过SQL方式自动加载分页功能，但是没有使用Hibernate SQLQuery功能中所提供的分页， 因为其有Bug，请参见
	 * http://opensource.atlassian.com/projects/hibernate/browse/HHH-2383
	 * 
	 * @param hql
	 *            查询用的HQL语句
	 * @param countHql
	 *            查询记录数量用的HQL语句，可以通过HqlUtils.parseHqlCount方法生成。如果不需要返回数量，可以为null
	 * @param params
	 *            HQL语句对应的参数
	 * @param offsetIndex
	 *            返回的第一条记录位置，分页用。 如果不需要，可以为0
	 * @param pageSize
	 *            分页的每页记录数，如果不需要，可以为0，则返回全部符合条件的记录
	 * @return 根据查询条件返回的记录内容，如果有分页需求，则PageResult中包含分页所需的各种信息
	 */
	public PageResult<T> sqlQuery(final String sql, final String countSql,
			final Map<String, Object> params, final int offsetIndex,
			final int pageSize);

	/**
	 * 建议使用HQL模式的bulkUpdate方法，但是某些特殊的数据库操作以SQL语句方式进行更有效率 以SQL语句方式进行insert,
	 * update, delete操作， 可以方便进行批量数据操作。例如批量删除符合某个条件的记录 批量更新符合某个条件的记录等等。
	 * 
	 * @param sql
	 *            进行insert, update, delete操作的SQL语句
	 * @param params
	 *            SQL语句中参数的值
	 * @return 该语句操作涉及到的数据库记录数
	 */
	public int sqlExecute(final String sql, final Map<String, Object> params);

	/**
	 * @param hql
	 *            查询用的HQL语句
	 * @param params
	 *            HQL语句对应的参数
	 * @return 根据查询条件返回的记录内容。
	 */
	public List<T> query(final String hql, final Map<String, Object> params);

	/**
	 * 根据指定的HQL语句，HQL计数语句，查询约束条件值的Map，返回找到的符合条件的数据库记录数，该记录封装于{@link PageResult}
	 * 中。
	 * 
	 * @param hql
	 *            查询用的HQL语句
	 * @param countHql
	 *            查询记录数量用的HQL语句，可以通过HqlUtils.parseHqlCount方法生成。如果不需要返回数量，可以为null
	 * @param params
	 *            HQL语句对应的参数
	 * @param offsetIndex
	 *            返回的第一条记录位置，分页用。 如果不需要，可以为0
	 * @param pageSize
	 *            分页的每页记录数，如果不需要，可以为0，则返回全部符合条件的记录
	 * @return 根据查询条件返回的记录内容，如果有分页需求，则PageResult中包含分页所需的各种信息
	 */
	public PageResult<T> query(final String hql, final String countHql,
			final Map<String, Object> params, final int offsetIndex,
			final int pageSize);

	/**
	 * 根据指定的查找记录数量的HQL语句，返回找到的符合条件的数据库记录数
	 * 
	 * @param countHql
	 *            类似于 select count(*) from ....
	 *            类型的SQL语句，可以通过HqlUtils.parseHqlCount方法生成
	 * @param params
	 *            countHql中对应参数的值
	 * @return 返回符合条件的数据库记录数
	 */
	public int queryCount(final String countHql,
			final Map<String, Object> params);

	/**
	 * 删除指定的数据库记录
	 * 
	 * @param obj
	 *            数据库记录实例，obj的主键ID不可为null
	 */
	public void remove(T obj);

	/**
	 * 批量删除指定的数据库记录
	 * 
	 * @param objs
	 *            数据库记录实例集合，集合中的每个对象主键ID不可为null
	 */
	public void removeObjects(Collection<T> objs);

	/**
	 * 保存或更新指定T类型的数据库记录，根据obj的主键ID是否为null来自动判断采用insert或者update方法
	 * 如果是insert方法，则会更新obj的主键ID为最新的值
	 * 
	 * @param obj
	 *            T类型的数据库记录实例
	 */
	public void saveOrUpdate(T obj);

	/**
	 * 批量保存或更新指定T类型的数据库记录，根据obj的主键ID是否为null来自动判断采用insert或者update方法
	 * 如果是insert方法，则会更新obj的主键ID为最新的值
	 * 
	 * @param objs
	 *            T类型的数据库记录实例集合
	 */
	public void saveOrUpdateAll(Collection<T> objs);

	public void save(T obj);

	/**
	 * 使用Hibernate Named Query更新数据库对象
	 * 
	 * @param queryName
	 *            命名在hbm.xml配置文件中的查询语句
	 * @param params
	 *            查询语句的参数值
	 * @return 匹配符合条件的记录列表
	 */
	public int updateByNamedQuery(String queryName, Map<String, Object> params);
}
