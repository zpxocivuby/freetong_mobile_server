package itaf.framework.ws.server.product.impl;

import java.util.ArrayList;
import java.util.List;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.product.service.IBzProductFavoriteService;
import itaf.framework.consumer.dto.BzConsumerDto;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.product.BzProductAttachment;
import itaf.framework.domain.product.BzProductFavorite;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.product.dto.BzProductDto;
import itaf.framework.product.dto.BzProductFavoriteDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.product.WsProductFavoriteService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsProductFavoriteServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.product.WsProductFavoriteService", serviceName = "WsProductFavoriteService")
public class WsProductFavoriteServiceImpl extends
		WsBaseImpl<BzProductFavoriteDto> implements WsProductFavoriteService {

	@Autowired
	private IBzProductFavoriteService bzProductFavoriteService;

	public WsPageResult<BzProductFavoriteDto> findPager(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzProductFavoriteDto> pr = new WsPageResult<BzProductFavoriteDto>();
		try {
			PageResult<BzProductFavorite> content = bzProductFavoriteService
					.findPager(bzConsumerId, currentIndex, pageSize);
			for (BzProductFavorite bzProductFavorite : content.getContent()) {
				BzProductFavoriteDto bzProductFavoriteDto = new BzProductFavoriteDto();
				bzProductFavoriteDto.setBzConsumerDto(CopyPropertiesCglibHelper
						.copyProperties(BzConsumerDto.class,
								bzProductFavorite.getBzConsumer()));
				BzProductDto bzProductDto = CopyPropertiesCglibHelper
						.copyProperties(BzProductDto.class,
								bzProductFavorite.getBzProduct());
				bzProductDto.setBzMerchantDto(CopyPropertiesCglibHelper
						.copyProperties(BzMerchantDto.class, bzProductFavorite
								.getBzProduct().getBzMerchant()));
				List<Long> bzProductAttachmentIds = new ArrayList<Long>();
				for (BzProductAttachment bzProductAttachment : bzProductFavorite
						.getBzProduct().getBzProductAttachments()) {
					bzProductAttachmentIds.add(bzProductAttachment.getId());
				}
				bzProductDto.setBzProductAttachmentIds(bzProductAttachmentIds);
				bzProductFavoriteDto.setBzProductDto(bzProductDto);
				pr.getContent().add(bzProductFavoriteDto);
			}
			pr.setTotalCount(content.getTotalCount());
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> productFavorite(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzProductId") Long bzProductId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			if (bzProductFavoriteService.findByBzConsumerIdAndBzProductId(
					bzConsumerId, bzProductId) == null) {
				bzProductFavoriteService.doProductFavorite(bzConsumerId,
						bzProductId);
				pr.setStatus(WsPageResult.STATUS_SUCCESS);
			} else {
				pr.setStatus(WsPageResult.STATUS_ERROR);
				pr.setErrorMsg("商品已经被收藏！");
			}
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> cancelProductFavorite(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzProductId") Long bzProductId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzProductFavoriteService.doCancelProductFavorite(bzConsumerId,
					bzProductId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzProductFavoriteDto getObject() {
		return new BzProductFavoriteDto();
	}
}
