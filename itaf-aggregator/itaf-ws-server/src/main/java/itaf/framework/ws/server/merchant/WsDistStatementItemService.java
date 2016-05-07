package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzDistStatementItemDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsDistStatementItemService {

	public WsPageResult<BzDistStatementItemDto> findPager(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

}
