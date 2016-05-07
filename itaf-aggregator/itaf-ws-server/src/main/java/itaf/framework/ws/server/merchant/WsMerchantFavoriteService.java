package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzMerchantFavoriteDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsMerchantFavoriteService {

	public WsPageResult<BzMerchantFavoriteDto> findPager(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public WsPageResult<String> merchantFavorite(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzMerchantId") Long bzMerchantId);

	public WsPageResult<String> cancelMerchantFavorite(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzMerchantId") Long bzMerchantId);

}
