package itaf.framework.persistence.certificate.dao.impl;

import itaf.framework.domain.certificate.BzApplyRealnameCertificate;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.certificate.dao.IBzApplyRealnameCertificateDao;

import org.springframework.stereotype.Repository;

@Repository("bzApplyRealnameCertificateDaoImpl")
public class BzApplyRealnameCertificateDaoImpl extends
		BaseDaoImpl<BzApplyRealnameCertificate> implements
		IBzApplyRealnameCertificateDao {

}