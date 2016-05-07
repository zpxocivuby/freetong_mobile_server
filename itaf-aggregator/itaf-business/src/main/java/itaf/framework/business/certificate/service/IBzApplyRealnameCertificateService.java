package itaf.framework.business.certificate.service;

import itaf.framework.domain.certificate.BzApplyRealnameCertificate;

public interface IBzApplyRealnameCertificateService {

	public void doSubmitApply(
			BzApplyRealnameCertificate bzApplyRealnameCertificate);

	public BzApplyRealnameCertificate getByBzConsumerId(Long bzConsumerId);
	
	public BzApplyRealnameCertificate findById(Long id);
		
	public void doSupportJavaService(BzApplyRealnameCertificate bzApplyRealnameCertificate, String finalApprovlState);

}
