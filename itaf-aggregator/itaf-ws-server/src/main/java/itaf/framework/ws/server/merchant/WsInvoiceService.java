package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzInvoiceDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsInvoiceService {

	public WsPageResult<BzInvoiceDto> findPager(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzDistCompanyName") String bzDistCompanyName,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public WsPageResult<BzInvoiceDto> getById(
			@WebParam(name = "bzOrderId") Long bzOrderId);

	public WsPageResult<String> invoice(
			@WebParam(name = "bzOrderId") Long bzOrderId,
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId);

}
