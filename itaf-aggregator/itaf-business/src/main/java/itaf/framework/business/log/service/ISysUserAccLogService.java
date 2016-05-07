package itaf.framework.business.log.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.log.SysUserAccLog;

/**
 * 用户访问日志
 * 
 * @author
 * 
 */
public interface ISysUserAccLogService {

	/**
	 * 添加用户访问日志
	 * 
	 * @param tlSysUserAccLog
	 * @return
	 */
	SysUserAccLog doCreate(SysUserAccLog tlSysUserAccLog);

	/**
	 * 根据查询约束条件返回用户数据的查询结果（分页处理），结果集合在{@link PageResult}中。
	 * 
	 * @param criteria
	 * @return
	 */
	PageResult<SysUserAccLog> findByCriteria(QueryCriteria criteria);

	SysUserAccLog findBySessionIdAndUserName(String sessionId, String userName);

}
