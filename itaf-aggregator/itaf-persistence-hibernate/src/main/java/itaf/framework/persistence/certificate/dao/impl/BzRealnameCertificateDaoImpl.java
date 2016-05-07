package itaf.framework.persistence.certificate.dao.impl;

import itaf.framework.domain.certificate.BzRealnameCertificate;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.certificate.dao.IBzRealnameCertificateDao;

import org.springframework.stereotype.Repository;

@Repository("bzRealnameCertificateDaoImpl")
public class BzRealnameCertificateDaoImpl extends
		BaseDaoImpl<BzRealnameCertificate> implements IBzRealnameCertificateDao {

}