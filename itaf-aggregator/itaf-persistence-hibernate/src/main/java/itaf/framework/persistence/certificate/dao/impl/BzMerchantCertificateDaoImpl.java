package itaf.framework.persistence.certificate.dao.impl;

import itaf.framework.domain.certificate.BzMerchantCertificate;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.certificate.dao.IBzMerchantCertificateDao;

import org.springframework.stereotype.Repository;

@Repository("bzMerchantCertificateDaoImpl")
public class BzMerchantCertificateDaoImpl extends
		BaseDaoImpl<BzMerchantCertificate> implements IBzMerchantCertificateDao {

}