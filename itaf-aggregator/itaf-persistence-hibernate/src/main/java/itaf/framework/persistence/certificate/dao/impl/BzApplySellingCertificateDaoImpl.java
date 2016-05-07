package itaf.framework.persistence.certificate.dao.impl;

import itaf.framework.domain.certificate.BzApplySellingCertificate;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.certificate.dao.IBzApplySellingCertificateDao;

import org.springframework.stereotype.Repository;

@Repository("bzApplySellingCertificateDaoImpl")
public class BzApplySellingCertificateDaoImpl extends
		BaseDaoImpl<BzApplySellingCertificate> implements
		IBzApplySellingCertificateDao {

}