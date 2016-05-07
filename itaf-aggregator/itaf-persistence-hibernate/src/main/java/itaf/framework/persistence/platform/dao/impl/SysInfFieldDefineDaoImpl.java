package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysInfFieldDefine;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysInfFieldDefineDao;

import org.springframework.stereotype.Repository;

@Repository("sysInfFieldDefineDaoImpl")
public class SysInfFieldDefineDaoImpl extends BaseDaoImpl<SysInfFieldDefine>
		implements ISysInfFieldDefineDao {

}