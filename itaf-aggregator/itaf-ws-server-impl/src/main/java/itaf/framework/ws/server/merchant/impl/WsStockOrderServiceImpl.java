package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzStockOrderService;
import itaf.framework.domain.merchant.BzStockOrder;
import itaf.framework.domain.merchant.BzStockOrderItem;
import itaf.framework.merchant.dto.BzStockOrderDto;
import itaf.framework.merchant.dto.BzStockOrderItemDto;
import itaf.framework.product.dto.BzProductDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsStockOrderService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsStockOrderServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsStockOrderService", serviceName = "WsStockOrderService")
public class WsStockOrderServiceImpl extends WsBaseImpl<String> implements
		WsStockOrderService {

	@Autowired
	private IBzStockOrderService bzStockOrderService;

	private BzStockOrderDto entity2Dto(BzStockOrder bzStockOrder) {
		BzStockOrderDto bzStockOrderDto = CopyPropertiesCglibHelper
				.copyProperties(BzStockOrderDto.class, bzStockOrder);
		for (BzStockOrderItem bzStockOrderItem : bzStockOrder
				.getBzStockOrderItems()) {
			BzStockOrderItemDto bzStockOrderItemDto = CopyPropertiesCglibHelper
					.copyProperties(BzStockOrderItemDto.class, bzStockOrderItem);
			bzStockOrderItemDto.setBzProductDto(CopyPropertiesCglibHelper
					.copyProperties(BzProductDto.class,
							bzStockOrderItem.getBzProduct()));
			bzStockOrderDto.getBzStockOrderItemDtos().add(bzStockOrderItemDto);
		}
		return bzStockOrderDto;
	}

	public WsPageResult<BzStockOrderDto> getList( 
			@WebParam(name = "bzMerchantId") Long bzMerchantId) {
		WsPageResult<BzStockOrderDto> pr = new WsPageResult<BzStockOrderDto>();
		try {
			List<BzStockOrder> bzStockOrders = bzStockOrderService
					.findList(bzMerchantId);
			for (BzStockOrder bzStockOrder : bzStockOrders) {
				pr.getContent().add(entity2Dto(bzStockOrder));
			}
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzStockOrderDto> getById(
			@WebParam(name = "bzStockOrderId") Long bzStockOrderId) {
		WsPageResult<BzStockOrderDto> pr = new WsPageResult<BzStockOrderDto>();
		try {
			pr.getContent().add(
					entity2Dto(bzStockOrderService.getById(bzStockOrderId)));
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> createStockOrder(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzOrderItemIds") String bzOrderItemIds) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzStockOrderService
					.doCreateStockOrder(bzMerchantId,
					bzOrderItemIds);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> finishedStockOrder(@WebParam(name = "bzStockOrderId") Long bzStockOrderId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzStockOrderService.doFinishedStockOrder(bzStockOrderId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public String getObject() {
		return new String();
	}

}
