package itaf.framework.ws.server.merchant.impl;

import java.math.BigDecimal;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzCollectionOrderService;
import itaf.framework.merchant.dto.BzCollectionOrderDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsCollectionOrderService;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsCollectionOrderServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsCollectionOrderService", serviceName = "WsCollectionOrderService")
public class WsCollectionOrderServiceImpl extends
		WsBaseImpl<BzCollectionOrderDto> implements WsCollectionOrderService {

	@Autowired
	private IBzCollectionOrderService bzCollectionOrderService;

	// 收款
	public WsPageResult<String> confirmCollection(
			@WebParam(name = "bzCollectionOrderId") Long bzCollectionOrderId,
			@WebParam(name = "actualAmountString") String actualAmountString) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzCollectionOrderService.doConfirmCollection(bzCollectionOrderId,
					new BigDecimal(actualAmountString));
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzCollectionOrderDto getObject() {
		// TODO Auto-generated method stub
		return new BzCollectionOrderDto();
	}

}
