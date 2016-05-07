package itaf.framework.ws.server.search;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzDistCompanyDto;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.product.dto.BzProductDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.search")
public interface WsSearchService {

	public WsPageResult<BzProductDto> searchProducts(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public WsPageResult<BzMerchantDto> searchMerchants(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public WsPageResult<BzDistCompanyDto> searchDistCompanys(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public BzProductDto getBzProductDtoObject();

	public BzMerchantDto getBzMerchantDtoObject();

	public BzDistCompanyDto getBzDistCompanyDtoObject();
}
