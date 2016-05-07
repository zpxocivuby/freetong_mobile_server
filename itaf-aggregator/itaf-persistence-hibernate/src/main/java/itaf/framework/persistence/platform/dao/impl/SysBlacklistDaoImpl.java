package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysBlacklist;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysBlacklistDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("sysBlacklistDaoImpl")
public class SysBlacklistDaoImpl extends BaseDaoImpl<SysBlacklist> implements
		ISysBlacklistDao {

	public List<SysBlacklist> findByLoginName(String loginName) {
		String hql = "select b from SysBlacklist b where b.loginCode=:loginName";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		return this.query(hql, params);
	}
}
