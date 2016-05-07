package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysCodeType;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysCodeTypeDao;

import org.springframework.stereotype.Repository;

@Repository("sysCodeTypeDaoImpl")
public class SysCodeTypeDaoImpl extends BaseDaoImpl<SysCodeType> implements
		ISysCodeTypeDao {

}