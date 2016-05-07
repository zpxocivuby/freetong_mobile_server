package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysWhitelist;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysWhitelistDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("sysWhitelistDaoImpl")
public class SysWhitelistDaoImpl extends BaseDaoImpl<SysWhitelist> implements
		ISysWhitelistDao {

	public List<SysWhitelist> findByLoginName(String loginName) {
		String hql = "select w from SysWhitelist w where w.loginCode=:loginName";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		return this.query(hql, params);
	}
}
