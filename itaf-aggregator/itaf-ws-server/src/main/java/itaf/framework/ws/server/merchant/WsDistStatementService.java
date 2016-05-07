package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzDistStatementDto;
import itaf.framework.merchant.dto.BzDistStatementSummaryDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsDistStatementService {

	public WsPageResult<BzDistStatementDto> findPager(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public WsPageResult<String> startDistStatement(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId,
			@WebParam(name = "bzDistStatementItemIds") String bzDistStatementItemIds);

	public WsPageResult<String> acceptDistStatement(
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId,
			@WebParam(name = "bzDistStatementId") Long bzDistStatementId);

	public WsPageResult<String> rejectDistStatement(
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId,
			@WebParam(name = "bzDistStatementId") Long bzDistStatementId);

	public WsPageResult<BzDistStatementDto> getById(
			@WebParam(name = "bzDistStatementId") Long bzDistStatementId);

	public WsPageResult<BzDistStatementSummaryDto> getBzDistStatementSummaryDto(
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId);

}
