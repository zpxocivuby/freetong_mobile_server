package itaf.framework.ws.server.consumer;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.consumer.dto.BzUserAddressDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.consumer")
public interface WsUserAddressService {

	public WsPageResult<BzUserAddressDto> getList(
			@WebParam(name = "bzConsumerId") Long bzConsumerId);

	public WsPageResult<BzUserAddressDto> getById(
			@WebParam(name = "bzUserAddressId") Long bzUserAddressId);

	public WsPageResult<String> saveOrUpdate(
			@WebParam(name = "dtoString") String dtoString);

	public WsPageResult<String> deleteById(
			@WebParam(name = "bzUserAddressId") Long bzUserAddressId);

}
