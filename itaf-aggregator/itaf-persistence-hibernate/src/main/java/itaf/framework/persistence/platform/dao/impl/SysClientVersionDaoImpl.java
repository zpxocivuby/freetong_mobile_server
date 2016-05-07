package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysClientVersion;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysClientVersionDao;

import org.springframework.stereotype.Repository;

@Repository("sysClientVersionDaoImpl")
public class SysClientVersionDaoImpl extends BaseDaoImpl<SysClientVersion>
		implements ISysClientVersionDao {

}