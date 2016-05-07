package itaf.framework.ws.server.order.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.cart.service.IBzCartItemService;
import itaf.framework.business.merchant.service.IBzShelfService;
import itaf.framework.business.order.service.IBzOrderItemService;
import itaf.framework.business.order.service.IBzOrderRatingService;
import itaf.framework.business.order.service.IBzOrderService;
import itaf.framework.consumer.dto.BzConsumerDto;
import itaf.framework.consumer.dto.BzUserAddressDto;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzMerchantRating;
import itaf.framework.domain.order.BzOrder;
import itaf.framework.domain.order.BzOrderItem;
import itaf.framework.domain.order.BzOrderPayment;
import itaf.framework.domain.product.BzProductRating;
import itaf.framework.merchant.dto.BzDistCompanyDto;
import itaf.framework.merchant.dto.BzDistOrderDto;
import itaf.framework.merchant.dto.BzInvoiceDto;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.order.dto.BzOrderDto;
import itaf.framework.order.dto.BzOrderItemDto;
import itaf.framework.order.dto.BzOrderPaymentDto;
import itaf.framework.order.dto.BzOrderRatingDto;
import itaf.framework.order.dto.BzPaymentTypeDto;
import itaf.framework.product.dto.BzProductDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.order.WsOrderService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsOrderServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.order.WsOrderService", serviceName = "WsOrderService")
public class WsOrderServiceImpl extends WsBaseImpl<BzOrderDto> implements
		WsOrderService {

	@Autowired
	private IBzOrderService bzOrderService;
	@Autowired
	private IBzShelfService bzShelfService;
	@Autowired
	private IBzCartItemService bzCartItemService;
	@Autowired
	private IBzOrderItemService bzOrderItemService;
	@Autowired
	private IBzOrderRatingService bzOrderRatingService;

	private BzOrderDto entity2Dto(BzOrder bzOrder) {
		BzOrderDto bzOrderDto = CopyPropertiesCglibHelper.copyProperties(
				BzOrderDto.class, bzOrder);
		bzOrderDto.setBzConsumerDto(CopyPropertiesCglibHelper.copyProperties(
				BzConsumerDto.class, bzOrder.getBzConsumer()));
		bzOrderDto.setBzMerchantDto(CopyPropertiesCglibHelper.copyProperties(
				BzMerchantDto.class, bzOrder.getBzMerchant()));
		bzOrderDto.setBzUserAddressDto(CopyPropertiesCglibHelper
				.copyProperties(BzUserAddressDto.class,
						bzOrder.getBzUserAddress()));
		BzOrderPaymentDto bzOrderPaymentDto = CopyPropertiesCglibHelper
				.copyProperties(BzOrderPaymentDto.class,
						bzOrder.getBzOrderPayment());
		bzOrderPaymentDto.setBzPaymentTypeDto(CopyPropertiesCglibHelper
				.copyProperties(BzPaymentTypeDto.class, bzOrder
						.getBzOrderPayment().getBzPaymentType()));
		bzOrderDto.setBzOrderPaymentDto(bzOrderPaymentDto);
		for (BzOrderItem bzOrderItem : bzOrder.getBzOrderItems()) {
			BzOrderItemDto bzOrderItemDto = CopyPropertiesCglibHelper
					.copyProperties(BzOrderItemDto.class, bzOrderItem);
			bzOrderItemDto.setBzProductDto(CopyPropertiesCglibHelper
					.copyProperties(BzProductDto.class,
							bzOrderItem.getBzProduct()));
			bzOrderDto.getBzOrderItemDtos().add(bzOrderItemDto);
		}
		return bzOrderDto;
	}

	public WsPageResult<BzOrderDto> findPager(
			@WebParam(name = "roleType") String roleType,
			@WebParam(name = "roleTypeValue") Long roleTypeValue,
			@WebParam(name = "orderStatus") Long orderStatus,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzOrderDto> pr = new WsPageResult<BzOrderDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.getQueryCondition().put(roleType, roleTypeValue);
			if (orderStatus != null
					&& !BzOrderDto.STATUS_ALL.equals(orderStatus)) {
				criteria.getQueryCondition().put("orderStatus", orderStatus);
			}
			criteria.getQueryCondition().put("markForDelete", false);
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			criteria.setOrderField("b.id");
			criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
			PageResult<BzOrder> pageResult = bzOrderService
					.findByCriteria(criteria);
			for (BzOrder bzOrder : pageResult.getContent()) {
				pr.getContent().add(entity2Dto(bzOrder));
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

	@Override
	public WsPageResult<BzOrderDto> getById(
			@WebParam(name = "bzOrderId") Long bzOrderId) {
		WsPageResult<BzOrderDto> pr = new WsPageResult<BzOrderDto>();
		try {
			BzOrder bzOrder = bzOrderService.getById(bzOrderId);
			BzOrderDto bzOrderDto = entity2Dto(bzOrder);
			if (bzOrder.getBzInvoice() != null
					&& bzOrder.getBzInvoice().getId() != null
					&& bzOrder.getBzInvoice().getId() > 0) {
				BzInvoiceDto bzInvoiceDto = CopyPropertiesCglibHelper
						.copyProperties(BzInvoiceDto.class,
								bzOrder.getBzInvoice());
				bzInvoiceDto.setBzDistCompanyDto(CopyPropertiesCglibHelper
						.copyProperties(BzDistCompanyDto.class, bzOrder
								.getBzInvoice().getBzDistCompany()));
				bzInvoiceDto.setBzDistOrderDto(CopyPropertiesCglibHelper
						.copyProperties(BzDistOrderDto.class, bzOrder
								.getBzInvoice().getBzDistOrder()));
			}
			pr.getContent().add(bzOrderDto);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzOrderDto> submitOrder(
			@WebParam(name = "dtoString") String dtoString) {
		WsPageResult<BzOrderDto> pr = new WsPageResult<BzOrderDto>();
		try {
			BzOrderDto dto = (BzOrderDto) decodeBase64(dtoString);
			BzOrder bzOrder = new BzOrder();
			bzOrder.setBzConsumerId(dto.getBzConsumerId());
			bzOrder.setBzMerchantId(dto.getBzMerchantId());
			bzOrder.setBzUserAddressId(dto.getBzUserAddressDto().getId());
			bzOrder.setOrderAmount(dto.getOrderAmount());
			bzOrder.setOrderDesc(dto.getOrderDesc());

			BzOrderPayment bzOrderPayment = new BzOrderPayment();
			bzOrderPayment.setBzOrder(bzOrder);
			bzOrderPayment.setBzPaymentTypeId(dto.getBzOrderPaymentDto()
					.getBzPaymentTypeDto().getId());
			bzOrderPayment.setPayStatus(dto.getBzOrderPaymentDto()
					.getPayStatus());
			bzOrderPayment.setPayAmount(dto.getBzOrderPaymentDto()
					.getPayAmount());
			bzOrder.setBzOrderPayment(bzOrderPayment);

			bzOrderService.doSubmitOrder(bzOrder, dto.getBzCartItemIds());

			dto.setOrderSerialNo(bzOrder.getOrderSerialNo());
			dto.setOrderStatus(bzOrder.getOrderStatus());
			dto.setOrderDiscount(bzOrder.getOrderDiscount());
			dto.setOrderPreferential(bzOrder.getOrderPreferential());

			pr.getContent().add(dto);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> confirmReceived(
			@WebParam(name = "bzOrderId") Long bzOrderId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzOrderService.doConfirmReceived(bzOrderId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> orderRating(
			@WebParam(name = "bzOrderId") Long bzOrderId,
			@WebParam(name = "dtoString") String dtoString) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			BzOrderRatingDto bzOrderRatingDto = (BzOrderRatingDto) decodeBase64(dtoString);
			bzOrderRatingService.doRating(bzOrderId, CopyPropertiesCglibHelper
					.copyProperties(BzMerchantRating.class,
							bzOrderRatingDto.getBzMerchantRatingDto()),
					(List<BzProductRating>) CopyPropertiesCglibHelper
							.copyProperties(BzProductRating.class,
									bzOrderRatingDto.getBzProductRatingDtos()));
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzOrderDto getObject() {
		return new BzOrderDto();
	}

}
