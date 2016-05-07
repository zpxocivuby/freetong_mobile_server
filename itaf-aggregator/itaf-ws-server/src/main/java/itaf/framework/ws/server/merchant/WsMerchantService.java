package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzMerchantDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsMerchantService {

	public WsPageResult<BzMerchantDto> getById(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzMerchantId") Long bzMerchantId);

}
