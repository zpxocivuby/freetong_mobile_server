package itaf.framework.persistence.platform.dao;

import itaf.framework.domain.platform.SysWhitelist;
import itaf.framework.persistence.base.dao.IBaseDao;

import java.util.List;

public interface ISysWhitelistDao extends IBaseDao<SysWhitelist> {

	List<SysWhitelist> findByLoginName(String loginName);
}
