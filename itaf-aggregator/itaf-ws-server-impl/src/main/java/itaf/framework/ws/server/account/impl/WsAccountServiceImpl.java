package itaf.framework.ws.server.account.impl;

import itaf.framework.account.dto.BzAccountDto;
import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.account.service.IBzAccountService;
import itaf.framework.ws.server.account.WsAccountService;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsAccountServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.account.WsAccountService", serviceName = "WsAccountService")
public class WsAccountServiceImpl extends WsBaseImpl<BzAccountDto> implements
		WsAccountService {

	@Autowired
	private IBzAccountService bzAccountService;

	public WsPageResult<BzAccountDto> getById(
			@WebParam(name = "bzAccountId") Long bzAccountId) {
		WsPageResult<BzAccountDto> pr = new WsPageResult<BzAccountDto>();
		try {
			pr.getContent().add(
					CopyPropertiesCglibHelper.copyProperties(
							BzAccountDto.class,
							bzAccountService.getById(bzAccountId)));
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzAccountDto getObject() {
		return new BzAccountDto();
	}

}
