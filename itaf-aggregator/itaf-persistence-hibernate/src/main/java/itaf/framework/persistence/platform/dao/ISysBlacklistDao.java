package itaf.framework.persistence.platform.dao;

import itaf.framework.domain.platform.SysBlacklist;
import itaf.framework.persistence.base.dao.IBaseDao;

import java.util.List;

public interface ISysBlacklistDao extends IBaseDao<SysBlacklist> {

	List<SysBlacklist> findByLoginName(String username);
}
