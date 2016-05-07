package itaf.framework.business.certificate.service;

import itaf.framework.domain.certificate.BzRealnameCertificate;

public interface IBzRealnameCertificateService {
	public BzRealnameCertificate findByUserId(Long userId);
}
