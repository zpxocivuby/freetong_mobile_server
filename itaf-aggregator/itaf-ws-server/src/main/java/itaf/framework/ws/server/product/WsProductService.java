package itaf.framework.ws.server.product;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.product.dto.BzProductDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.product")
public interface WsProductService {

	public WsPageResult<BzProductDto> getById(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzProductId") Long bzProductId);

	public WsPageResult<String> createOrUpdate(
			@WebParam(name = "dtoString") String dtoString);

	public WsPageResult<String> deleteById(
			@WebParam(name = "bzProductId") Long bzProductId);

	public WsPageResult<String> putProductOnShelf(
			@WebParam(name = "bzProductId") Long bzProductId,
			@WebParam(name = "onShelfNumber") Long onShelfNumber);

	public WsPageResult<String> removeProductFromShelf(
			@WebParam(name = "bzProductId") Long bzProductId);

}
