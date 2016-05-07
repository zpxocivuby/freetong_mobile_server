package itaf.framework.ws.server.platform;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.platform.dto.SysAttachmentDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.platform")
public interface WsSysAttachmentService {

	public WsPageResult<SysAttachmentDto> findByClueId(
			@WebParam(name = "clueId") Long clueId);
}
