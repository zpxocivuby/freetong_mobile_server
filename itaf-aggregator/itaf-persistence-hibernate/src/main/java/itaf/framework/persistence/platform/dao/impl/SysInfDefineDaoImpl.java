package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysInfDefine;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysInfDefineDao;

import org.springframework.stereotype.Repository;

@Repository("sysInfDefineDaoImpl")
public class SysInfDefineDaoImpl extends BaseDaoImpl<SysInfDefine> implements
		ISysInfDefineDao {

}