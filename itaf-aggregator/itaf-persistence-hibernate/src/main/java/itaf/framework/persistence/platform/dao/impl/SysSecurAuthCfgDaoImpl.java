package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysSecurAuthCfg;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysSecurAuthCfgDao;

import org.springframework.stereotype.Repository;

@Repository("sysSecurAuthCfgDaoImpl")
public class SysSecurAuthCfgDaoImpl extends BaseDaoImpl<SysSecurAuthCfg>
		implements ISysSecurAuthCfgDao {

}