package itaf.framework.ws.server.certificate;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.certificate.dto.BzApplySellingCertificateDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.certificate")
public interface WsApplySellingCertificateService {

	public WsPageResult<String> submitApply(
			@WebParam(name = "dtoString") String dtoString);

	public WsPageResult<BzApplySellingCertificateDto> getByBzConsumerId(
			@WebParam(name = "bzConsumerId") Long bzConsumerId);

}
