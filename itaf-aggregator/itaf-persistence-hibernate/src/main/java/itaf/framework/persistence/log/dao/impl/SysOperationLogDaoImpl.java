package itaf.framework.persistence.log.dao.impl;

import itaf.framework.domain.log.SysOperationLog;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.log.dao.ISysOperationLogDao;

import org.springframework.stereotype.Repository;

@Repository("sysOperationLogDaoImpl")
public class SysOperationLogDaoImpl extends BaseDaoImpl<SysOperationLog>
		implements ISysOperationLogDao {

}