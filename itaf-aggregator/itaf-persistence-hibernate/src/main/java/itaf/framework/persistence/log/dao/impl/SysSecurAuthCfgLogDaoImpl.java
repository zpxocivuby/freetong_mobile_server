package itaf.framework.persistence.log.dao.impl;

import itaf.framework.domain.log.SysSecurAuthCfgLog;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.log.dao.ISysSecurAuthCfgLogDao;

import org.springframework.stereotype.Repository;

@Repository("sysSecurAuthCfgLogDaoImpl")
public class SysSecurAuthCfgLogDaoImpl extends BaseDaoImpl<SysSecurAuthCfgLog>
		implements ISysSecurAuthCfgLogDao {

}