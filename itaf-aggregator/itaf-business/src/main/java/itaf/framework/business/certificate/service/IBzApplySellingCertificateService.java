package itaf.framework.business.certificate.service;

import itaf.framework.domain.certificate.BzApplyRealnameCertificate;
import itaf.framework.domain.certificate.BzApplySellingCertificate;

public interface IBzApplySellingCertificateService {

	public void doSubmitApply(BzApplySellingCertificate bzSellingApplyService);

	public BzApplySellingCertificate getByBzConsumerId(Long bzConsumerId);
	
	public BzApplySellingCertificate findById(Long id);
	
	public void doSupportJavaService(BzApplySellingCertificate bzApplySellingCertificate, String finalApprovlState);

}
