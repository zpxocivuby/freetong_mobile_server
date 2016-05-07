package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysInfFieldValueDefine;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysInfFieldValueDefineDao;

import org.springframework.stereotype.Repository;

@Repository("sysInfFieldValueDefineDaoImpl")
public class SysInfFieldValueDefineDaoImpl extends
		BaseDaoImpl<SysInfFieldValueDefine> implements
		ISysInfFieldValueDefineDao {

}