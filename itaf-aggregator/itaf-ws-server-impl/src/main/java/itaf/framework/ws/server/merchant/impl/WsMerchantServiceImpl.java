package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzMerchantFavoriteService;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.domain.merchant.BzMerchantRate;
import itaf.framework.domain.merchant.BzUserDeliveryAddress;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.merchant.dto.BzServiceProviderTypeDto;
import itaf.framework.position.dto.BzPositionDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsMerchantService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsMerchantServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsMerchantService", serviceName = "WsMerchantService")
public class WsMerchantServiceImpl extends WsBaseImpl<BzMerchantDto> implements
		WsMerchantService {

	@Autowired
	private IBzMerchantService bzMerchantService;
	@Autowired
	private IBzMerchantFavoriteService bzMerchantFavoriteService;

	public WsPageResult<BzMerchantDto> getById(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzMerchantId") Long bzMerchantId) {
		WsPageResult<BzMerchantDto> pr = new WsPageResult<BzMerchantDto>();
		try {
			BzMerchant bzMerchant = bzMerchantService.getById(bzMerchantId);
			if (bzMerchant != null) {
				BzMerchantDto bzMerchantDto = CopyPropertiesCglibHelper
						.copyProperties(BzMerchantDto.class, bzMerchant);
				bzMerchantDto.setUsername(bzMerchant.getUsername());
				bzMerchantDto.setMobile(bzMerchant.getSysUser().getMobile());
				bzMerchantDto.setType(bzMerchant.getSysUser().getType());
				bzMerchantDto.setEmail(bzMerchant.getSysUser().getNickname());
				bzMerchantDto.setRealnameStatus(bzMerchant.getSysUser()
						.getRealnameCertificateStatus());
				if (bzConsumerId == null
						|| bzConsumerId <= 0
						|| bzMerchantFavoriteService
								.findByBzConsumerIdAndBzMerchantId(
										bzConsumerId, bzMerchantId) == null) {
					bzMerchantDto.setIsFavorited(false);
				} else {
					bzMerchantDto.setIsFavorited(true);
				}
				bzMerchantDto.setHeadIco(bzMerchant.getSysUser().getHeadIco());
				BzMerchantRate bzMerchantRate = bzMerchant.getBzMerchantRate();
				if (bzMerchantRate != null) {
					bzMerchantDto
							.setRatingScore((bzMerchantRate
									.getDescriptionScore()
									+ bzMerchantRate.getAttitudeScore()
									+ bzMerchantRate.getDeliveryScore() + bzMerchantRate
										.getLogisticsScore())
									/ (bzMerchantRate.getRatingNumber() * 4.0F));
				}
				bzMerchantDto
						.setBzServiceProviderTypeDto(CopyPropertiesCglibHelper
								.copyProperties(BzServiceProviderTypeDto.class,
										bzMerchant.getBzServiceProviderType()));
				List<BzUserDeliveryAddress> bzUserDeliveryAddress = bzMerchant
						.getSysUser().getBzUserDeliveryAddress();
				if (bzUserDeliveryAddress != null
						&& bzUserDeliveryAddress.size() > 0) {
					bzMerchantDto.setBzPositionDto(CopyPropertiesCglibHelper
							.copyProperties(BzPositionDto.class,
									bzUserDeliveryAddress.get(0)
											.getBzPosition()));
				}
				pr.getContent().add(bzMerchantDto);
			}
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzMerchantDto getObject() {
		return new BzMerchantDto();
	}
}
