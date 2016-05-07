package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzMerchantFavoriteService;
import itaf.framework.consumer.dto.BzConsumerDto;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.merchant.BzMerchantFavorite;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.merchant.dto.BzMerchantFavoriteDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsMerchantFavoriteService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsMerchantFavoriteServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsMerchantFavoriteService", serviceName = "wsMerchantFavoriteService")
public class WsMerchantFavoriteServiceImpl extends
		WsBaseImpl<BzMerchantFavoriteDto> implements WsMerchantFavoriteService {

	@Autowired
	private IBzMerchantFavoriteService bzMerchantFavoriteService;

	public WsPageResult<BzMerchantFavoriteDto> findPager(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzMerchantFavoriteDto> pr = new WsPageResult<BzMerchantFavoriteDto>();
		try {
			PageResult<BzMerchantFavorite> content = bzMerchantFavoriteService
					.findPager(bzConsumerId, currentIndex, pageSize);
			for (BzMerchantFavorite bzMerchantFavorite : content.getContent()) {
				BzMerchantFavoriteDto bzMerchantFavoriteDto = new BzMerchantFavoriteDto();
				bzMerchantFavoriteDto
						.setBzConsumerDto(CopyPropertiesCglibHelper
								.copyProperties(BzConsumerDto.class,
										bzMerchantFavorite.getBzConsumer()));
				bzMerchantFavoriteDto
						.setBzMerchantDto(CopyPropertiesCglibHelper
								.copyProperties(BzMerchantDto.class,
										bzMerchantFavorite.getBzMerchant()));
				pr.getContent().add(bzMerchantFavoriteDto);
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

	public WsPageResult<String> merchantFavorite(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzMerchantId") Long bzMerchantId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			if (bzMerchantFavoriteService.findByBzConsumerIdAndBzMerchantId(
					bzConsumerId, bzMerchantId) == null) {
				bzMerchantFavoriteService.doMerchantFavorite(bzConsumerId,
						bzMerchantId);
				pr.setStatus(WsPageResult.STATUS_SUCCESS);
			} else {
				pr.setStatus(WsPageResult.STATUS_ERROR);
				pr.setErrorMsg("商家已经被收藏！");
			}
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> cancelMerchantFavorite(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzMerchantId") Long bzMerchantId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzMerchantFavoriteService.doCancelMerchantFavorite(bzConsumerId,
					bzMerchantId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzMerchantFavoriteDto getObject() {
		return new BzMerchantFavoriteDto();
	}
}
