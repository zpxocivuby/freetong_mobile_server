package itaf.framework.ws.server.cart.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.cart.service.IBzCartItemService;
import itaf.framework.business.consumer.service.IBzConsumerService;
import itaf.framework.business.product.service.IBzProductService;
import itaf.framework.cart.dto.BzCartItemDto;
import itaf.framework.consumer.dto.BzConsumerDto;
import itaf.framework.domain.cart.BzCartItem;
import itaf.framework.domain.consumer.BzConsumer;
import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.domain.product.BzProductAttachment;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.product.dto.BzProductDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.cart.WsCartItemService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsCartItemServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.cart.WsCartItemService", serviceName = "WsCartItemService")
public class WsCartItemServiceImpl extends WsBaseImpl<BzCartItemDto> implements
		WsCartItemService {

	@Autowired
	private IBzCartItemService bzCartItemService;
	@Autowired
	private IBzConsumerService bzConsumerService;
	@Autowired
	private IBzProductService bzProductService;

	private BzCartItemDto entity2Dto(BzCartItem bzCartItem) {
		BzCartItemDto bzCartItemDto = CopyPropertiesCglibHelper.copyProperties(
				BzCartItemDto.class, bzCartItem);
		BzConsumer bzConsumer = bzCartItem.getBzConsumer();
		BzConsumerDto bzConsumerDto = CopyPropertiesCglibHelper.copyProperties(
				BzConsumerDto.class, bzConsumer);
		bzConsumerDto.setUsername(bzConsumer.getUsername());
		bzConsumerDto.setNickname(bzConsumer.getNickname());
		bzCartItemDto.setBzConsumerDto(bzConsumerDto);
		BzMerchant bzMerchant = bzCartItem.getBzProduct().getBzMerchant();
		BzMerchantDto bzMerchantDto = CopyPropertiesCglibHelper.copyProperties(
				BzMerchantDto.class, bzMerchant);
		bzMerchantDto.setUsername(bzMerchant.getUsername());
		bzMerchantDto.setNickname(bzMerchant.getNickname());
		bzCartItemDto.setBzMerchantDto(bzMerchantDto);
		BzProductDto bzProductDto = CopyPropertiesCglibHelper.copyProperties(
				BzProductDto.class, bzCartItem.getBzProduct());
		bzProductDto
				.setBzMerchantDto(CopyPropertiesCglibHelper.copyProperties(
						BzMerchantDto.class, bzCartItem.getBzProduct()
								.getBzMerchant()));
		List<Long> bzProductAttachmentIds = new ArrayList<Long>();
		for (BzProductAttachment bzProductAttachment : bzCartItem
				.getBzProduct().getBzProductAttachments()) {
			bzProductAttachmentIds.add(bzProductAttachment.getId());
		}
		bzProductDto.setBzProductAttachmentIds(bzProductAttachmentIds);
		bzCartItemDto.setBzProductDto(bzProductDto);
		return bzCartItemDto;
	}

	public WsPageResult<BzCartItemDto> findList(
			@WebParam(name = "bzConsumerId") Long bzConsumerId) {
		WsPageResult<BzCartItemDto> pr = new WsPageResult<BzCartItemDto>();
		try {
			List<BzCartItem> bzCartItems = bzCartItemService
					.findList(bzConsumerId);
			for (BzCartItem bzCartItem : bzCartItems) {
				pr.getContent().add(entity2Dto(bzCartItem));
			}
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> deleteByIds(
			@WebParam(name = "bzCartItemIds") String bzCartItemIds) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzCartItemService.doDeleteByIds(bzCartItemIds);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzCartItemDto> putProductInCart(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzProductId") Long bzProductId,
			@WebParam(name = "putType") int putType) {
		WsPageResult<BzCartItemDto> pr = new WsPageResult<BzCartItemDto>();
		try {
			pr.getContent().add(
					entity2Dto(bzCartItemService.doPutProductInCart(
							bzConsumerId, bzProductId, putType)));
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> updateItemNum(
			@WebParam(name = "bzCartItemId") Long bzCartItemId,
			@WebParam(name = "itemNum") Long itemNum) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzCartItemService.doUpdateItemNum(bzCartItemId, itemNum);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzCartItemDto getObject() {
		return new BzCartItemDto();
	}

}
