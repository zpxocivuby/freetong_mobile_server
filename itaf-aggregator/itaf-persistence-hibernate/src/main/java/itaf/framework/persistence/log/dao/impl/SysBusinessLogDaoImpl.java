package itaf.framework.persistence.log.dao.impl;

import itaf.framework.domain.log.SysBusinessLog;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.log.dao.ISysBusinessLogDao;

import org.springframework.stereotype.Repository;

@Repository("sysBusinessLogDaoImpl")
public class SysBusinessLogDaoImpl extends BaseDaoImpl<SysBusinessLog>
		implements ISysBusinessLogDao {

}