package itaf.framework.persistence.certificate.dao.impl;

import itaf.framework.domain.certificate.BzApplyDistCertificate;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.certificate.dao.IBzApplyDistCertificateDao;

import org.springframework.stereotype.Repository;

@Repository("bzApplyDistCertificateDaoImpl")
public class BzApplyDistCertificateDaoImpl extends
		BaseDaoImpl<BzApplyDistCertificate> implements
		IBzApplyDistCertificateDao {

}