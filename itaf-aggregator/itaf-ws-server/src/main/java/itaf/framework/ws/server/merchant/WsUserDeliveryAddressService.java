package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzUserDeliveryAddressDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsUserDeliveryAddressService {

	public WsPageResult<BzUserDeliveryAddressDto> getList(
			@WebParam(name = "bzMerchantId") Long bzMerchantId);

	public WsPageResult<BzUserDeliveryAddressDto> getById(
			@WebParam(name = "bzUserDeliveryAddressId") Long bzUserDeliveryAddressId);

	public WsPageResult<String> saveOrUpdate(
			@WebParam(name = "dtoString") String dtoString);

	public WsPageResult<String> deleteById(
			@WebParam(name = "bzUserDeliveryAddressId") Long bzUserDeliveryAddressId);
}
