package itaf.framework.persistence.platform.dao.impl;

import itaf.framework.domain.platform.SysResource;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.platform.dao.ISysResourceDao;

import org.springframework.stereotype.Repository;

@Repository("sysResourceDaoImpl")
public class SysResourceDaoImpl extends BaseDaoImpl<SysResource> implements
		ISysResourceDao {

}