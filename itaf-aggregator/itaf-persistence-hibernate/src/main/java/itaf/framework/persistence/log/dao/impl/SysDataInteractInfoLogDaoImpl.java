package itaf.framework.persistence.log.dao.impl;

import itaf.framework.domain.log.SysDataInteractInfoLog;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.log.dao.ISysDataInteractInfoLogDao;

import org.springframework.stereotype.Repository;

@Repository("sysDataInteractInfoLogDaoImpl")
public class SysDataInteractInfoLogDaoImpl extends
		BaseDaoImpl<SysDataInteractInfoLog> implements
		ISysDataInteractInfoLogDao {

}