package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysInfParamDefine;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysInfParamDefineDao;

import org.springframework.stereotype.Repository;

@Repository("sysInfParamDefineDaoImpl")
public class SysInfParamDefineDaoImpl extends BaseDaoImpl<SysInfParamDefine>
		implements ISysInfParamDefineDao {

}