package itaf.framework.ws.server.product;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.product.dto.BzProductFavoriteDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.product")
public interface WsProductFavoriteService {

	public WsPageResult<BzProductFavoriteDto> findPager(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public WsPageResult<String> productFavorite(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzProductId") Long bzProductId);

	public WsPageResult<String> cancelProductFavorite(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzProductId") Long bzProductId);

}
