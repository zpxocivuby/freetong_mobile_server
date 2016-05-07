package itaf.framework.ws.server.certificate;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.certificate.dto.BzApplyDistCertificateDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.certificate")
public interface WsApplyDistCertificateService {

	public WsPageResult<String> submitApply(
			@WebParam(name = "dtoString") String dtoString);

	public WsPageResult<BzApplyDistCertificateDto> getByBzConsumerId(
			@WebParam(name = "bzConsumerId") Long bzConsumerId);

}
