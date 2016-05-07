package itaf.framework.persistence.log.dao.impl;

import itaf.framework.domain.log.SysDataInteractLog;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.log.dao.ISysDataInteractLogDao;

import org.springframework.stereotype.Repository;

@Repository("sysDataInteractLogDaoImpl")
public class SysDataInteractLogDaoImpl extends BaseDaoImpl<SysDataInteractLog>
		implements ISysDataInteractLogDao {

}