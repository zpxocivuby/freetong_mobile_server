package itaf.framework.business.log.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.log.service.ISysUserAccLogService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.log.SysUserAccLog;
import itaf.framework.persistence.log.dao.ISysUserAccLogDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户访问日志Service
 * 
 * @author XINXIN
 * 
 */
@Service("sysUserAccLogServiceImpl")
public class SysUserAccLogServiceImpl extends BaseServiceImpl implements
		ISysUserAccLogService {

	@Autowired
	private ISysUserAccLogDao sysUserAccLogDao;

	public PageResult<SysUserAccLog> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select tsua";
		String[] whereBodies = new String[] {
				"tsua.username like :usernameLike",
				"tsua.remoteAddr=:remoteAddr", "tsua.loginTime>=:loginTime",
				"tsua.loginTime<=:logoutTime" };
		String fromJoinSubClause = "from SysUserAccLog tsua";
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		PageResult<SysUserAccLog> result = (PageResult<SysUserAccLog>) sysUserAccLogDao
				.query(hql, HqlUtils.generateCountHql(hql, null), params,
						startIndex, pageSize);
		return result;
	}

	public SysUserAccLog doCreate(SysUserAccLog tlSysUserAccLog) {
		sysUserAccLogDao.saveOrUpdate(tlSysUserAccLog);
		return tlSysUserAccLog;
	}

	public SysUserAccLog findBySessionIdAndUserName(String sessionId,
			String userName) {
		return sysUserAccLogDao.findBySessionIdAndUserName(sessionId, userName);
	}

}
