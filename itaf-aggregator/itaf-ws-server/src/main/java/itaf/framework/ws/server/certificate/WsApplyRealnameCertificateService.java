package itaf.framework.ws.server.certificate;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.certificate.dto.BzApplyRealnameCertificateDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.certificate")
public interface WsApplyRealnameCertificateService {

	public WsPageResult<String> submitApply(
			@WebParam(name = "dtoString") String dtoString);

	public WsPageResult<BzApplyRealnameCertificateDto> getByBzConsumerId(
			@WebParam(name = "bzConsumerId") Long bzConsumerId);

}
