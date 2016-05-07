package itaf.framework.business.certificate.service;

import itaf.framework.domain.certificate.BzApplyDistCertificate;
import itaf.framework.domain.certificate.BzApplySellingCertificate;

public interface IBzApplyDistCertificateService {

	public void doSubmitApply(BzApplyDistCertificate bzApplyDistCertificate);

	public BzApplyDistCertificate getByBzConsumerId(Long bzConsumerId);
	
	public BzApplyDistCertificate findById(Long id);
	
	public void doSupportJavaService(BzApplyDistCertificate bzApplyDistCertificate, String finalApprovlState);

}
