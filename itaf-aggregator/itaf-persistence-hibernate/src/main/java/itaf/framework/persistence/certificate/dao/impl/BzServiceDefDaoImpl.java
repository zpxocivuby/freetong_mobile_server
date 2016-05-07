package itaf.framework.persistence.certificate.dao.impl;

import itaf.framework.domain.certificate.BzServiceDef;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.certificate.dao.IBzServiceDefDao;

import org.springframework.stereotype.Repository;

@Repository("bzServiceDefDaoImpl")
public class BzServiceDefDaoImpl extends BaseDaoImpl<BzServiceDef> implements
		IBzServiceDefDao {

}