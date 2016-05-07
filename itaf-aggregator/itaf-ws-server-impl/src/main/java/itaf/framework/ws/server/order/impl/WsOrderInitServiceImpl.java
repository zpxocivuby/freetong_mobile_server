package itaf.framework.ws.server.order.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.consumer.service.IBzUserAddressService;
import itaf.framework.business.order.service.IBzPaymentTypeService;
import itaf.framework.consumer.dto.BzUserAddressDto;
import itaf.framework.domain.consumer.BzUserAddress;
import itaf.framework.domain.order.BzPaymentType;
import itaf.framework.order.dto.BzOrderInitDto;
import itaf.framework.order.dto.BzPaymentTypeDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.order.WsOrderInitService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsOrderInitServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.order.WsOrderInitService", serviceName = "WsOrderInitService")
public class WsOrderInitServiceImpl extends WsBaseImpl<BzOrderInitDto>
		implements WsOrderInitService {

	@Autowired
	private IBzUserAddressService bzUserAddressService;
	@Autowired
	private IBzPaymentTypeService bzPaymentTypeService;

	public WsPageResult<BzOrderInitDto> orderCreateInit(
			@WebParam(name = "userId") Long userId) {
		WsPageResult<BzOrderInitDto> pr = new WsPageResult<BzOrderInitDto>();
		try {
			BzOrderInitDto bzOrderInitDto = new BzOrderInitDto();
			List<BzUserAddress> bzUserAddresses = bzUserAddressService
					.findList(userId);
			if (bzUserAddresses != null && bzUserAddresses.size() > 0) {
				bzOrderInitDto.setBzUserAddressDto(CopyPropertiesCglibHelper
						.copyProperties(BzUserAddressDto.class,
								bzUserAddresses.get(0)));
			}
			bzOrderInitDto.setDistPrice(new BigDecimal(5L));
			List<BzPaymentType> bzPaymentTypes = bzPaymentTypeService.findAll();
			if (bzPaymentTypes != null && bzPaymentTypes.size() > 0) {
				bzOrderInitDto
						.setBzPaymentTypeDtos((List<BzPaymentTypeDto>) CopyPropertiesCglibHelper
								.copyProperties(BzPaymentTypeDto.class,
										bzPaymentTypes));
			}
			pr.getContent().add(bzOrderInitDto);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzOrderInitDto getObject() {
		return new BzOrderInitDto();
	}
}
