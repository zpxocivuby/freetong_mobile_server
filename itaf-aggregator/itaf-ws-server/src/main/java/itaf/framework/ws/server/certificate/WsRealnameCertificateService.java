package itaf.framework.ws.server.certificate;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.certificate.dto.BzApplyRealnameCertificateDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.certificate")
public interface WsRealnameCertificateService {

	public WsPageResult<BzApplyRealnameCertificateDto> findCertificating(
			@WebParam(name = "userId") Long userId);

	public WsPageResult<BzApplyRealnameCertificateDto> findCertificated(
			@WebParam(name = "userId") Long userId);

}
