package itaf.framework.persistence.certificate.dao.impl;

import itaf.framework.domain.certificate.BzServiceParameterDef;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.certificate.dao.IBzServiceParameterDefDao;

import org.springframework.stereotype.Repository;

@Repository("bzServiceParameterDefDaoImpl")
public class BzServiceParameterDefDaoImpl extends
		BaseDaoImpl<BzServiceParameterDef> implements IBzServiceParameterDefDao {

}