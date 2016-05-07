package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzDistOrderService;
import itaf.framework.business.merchant.service.IBzInvoiceService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzDistOrder;
import itaf.framework.domain.merchant.BzDistOrderItem;
import itaf.framework.merchant.dto.BzCollectionOrderDto;
import itaf.framework.merchant.dto.BzDistOrderDto;
import itaf.framework.merchant.dto.BzDistOrderItemDto;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.product.dto.BzProductDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsDistOrderService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsDistOrderServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsDistOrderService", serviceName = "WsDistOrderService")
public class WsDistOrderServiceImpl extends WsBaseImpl<BzDistOrderDto>
		implements WsDistOrderService {

	@Autowired
	private IBzDistOrderService bzDistOrderService;
	@Autowired
	private IBzInvoiceService bzInvoiceService;

	private BzDistOrderDto entity2Dto(BzDistOrder bzDistOrder) {
		BzDistOrderDto bzDistOrderDto = CopyPropertiesCglibHelper
				.copyProperties(BzDistOrderDto.class, bzDistOrder);
		BzMerchantDto bzMerchantDto = CopyPropertiesCglibHelper.copyProperties(
				BzMerchantDto.class, bzDistOrder.getBzMerchant());
		bzMerchantDto.setUsername(bzDistOrder.getBzMerchant().getUsername());
		bzMerchantDto.setNickname(bzDistOrder.getBzMerchant().getNickname());
		bzDistOrderDto.setBzMerchantDto(bzMerchantDto);
		BzCollectionOrderDto bzCollectionOrderDto = CopyPropertiesCglibHelper
				.copyProperties(BzCollectionOrderDto.class,
						bzDistOrder.getBzCollectionOrder());
		bzDistOrderDto.setBzCollectionOrderDto(bzCollectionOrderDto);
		for (BzDistOrderItem bzDistOrderItem : bzDistOrder
				.getBzDistOrderItems()) {
			BzDistOrderItemDto bzDistOrderItemDto = CopyPropertiesCglibHelper
					.copyProperties(BzDistOrderItemDto.class, bzDistOrderItem);
			bzDistOrderItemDto.setBzProductDto(CopyPropertiesCglibHelper
					.copyProperties(BzProductDto.class,
							bzDistOrderItem.getBzProduct()));
			bzDistOrderDto.getBzDistOrderItemDtos().add(bzDistOrderItemDto);
		}
		return bzDistOrderDto;
	}

	@SuppressWarnings("unchecked")
	public WsPageResult<BzDistOrderDto> findPager(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzDistOrderDto> pr = new WsPageResult<BzDistOrderDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			Map<String, Object> queryMap = (Map<String, Object>) decodeBase64(queryMapString);
			queryMap.put("markForDelete", false);
			criteria.setQueryCondition(queryMap);
			int orderType = (Integer) queryMap.get("orderType");
			if (orderType == 1) {
				criteria.setOrderField("b.orderDistance");
				criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_ASC);
			} else if (orderType == 2) {
				criteria.setOrderField("b.id");
				criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
			}
			PageResult<BzDistOrder> pageResult = bzDistOrderService
					.findByCriteria(criteria);
			for (BzDistOrder bzDistOrder : pageResult.getContent()) {
				pr.getContent().add(entity2Dto(bzDistOrder));
			}
			pr.setTotalCount(pageResult.getTotalCount());
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzDistOrderDto> getById(
			@WebParam(name = "bzDistOrderId") Long bzDistOrderId) {
		WsPageResult<BzDistOrderDto> pr = new WsPageResult<BzDistOrderDto>();
		try {
			pr.getContent().add(
					entity2Dto(bzDistOrderService.getById(bzDistOrderId)));
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> startDist(
			@WebParam(name = "bzDistOrderId") Long bzDistOrderId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzDistOrderService.doStartDist(bzDistOrderService
					.getById(bzDistOrderId));
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzDistOrderDto getObject() {
		return new BzDistOrderDto();
	}

}
