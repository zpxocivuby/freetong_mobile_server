package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzUserDeliveryAddressService;
import itaf.framework.domain.merchant.BzUserDeliveryAddress;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.domain.position.BzPosition;
import itaf.framework.merchant.dto.BzUserDeliveryAddressDto;
import itaf.framework.platform.dto.SysUserDto;
import itaf.framework.position.dto.BzPositionDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsUserDeliveryAddressService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsUserDeliveryAddressServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsUserDeliveryAddressService", serviceName = "WsUserDeliveryAddressService")
public class WsUserDeliveryAddressServiceImpl extends
		WsBaseImpl<BzUserDeliveryAddressDto> implements
		WsUserDeliveryAddressService {

	@Autowired
	IBzUserDeliveryAddressService bzUserDeliveryAddressService;

	private BzUserDeliveryAddressDto entity2Dto(
			BzUserDeliveryAddress bzUserDeliveryAddress) {
		BzUserDeliveryAddressDto bzUserDeliveryAddressDto = CopyPropertiesCglibHelper
				.copyProperties(BzUserDeliveryAddressDto.class,
						bzUserDeliveryAddress);
		bzUserDeliveryAddressDto.setSysUserDto(CopyPropertiesCglibHelper
				.copyProperties(SysUserDto.class,
						bzUserDeliveryAddress.getSysUser()));
		bzUserDeliveryAddressDto.setBzPositionDto(CopyPropertiesCglibHelper
				.copyProperties(BzPositionDto.class,
						bzUserDeliveryAddress.getBzPosition()));
		return bzUserDeliveryAddressDto;
	}

	private BzUserDeliveryAddress dto2Entity(
			BzUserDeliveryAddressDto bzUserDeliveryAddressDto) {
		BzUserDeliveryAddress bzUserDeliveryAddress = CopyPropertiesCglibHelper
				.copyProperties(BzUserDeliveryAddress.class,
						bzUserDeliveryAddressDto);
		bzUserDeliveryAddress.setSysUser(CopyPropertiesCglibHelper
				.copyProperties(SysUser.class,
						bzUserDeliveryAddressDto.getSysUserDto()));
		bzUserDeliveryAddress.setBzPosition(CopyPropertiesCglibHelper
				.copyProperties(BzPosition.class,
						bzUserDeliveryAddressDto.getBzPositionDto()));
		return bzUserDeliveryAddress;
	}

	public WsPageResult<BzUserDeliveryAddressDto> getList(
			@WebParam(name = "bzMerchantId") Long bzMerchantId) {
		WsPageResult<BzUserDeliveryAddressDto> pr = new WsPageResult<BzUserDeliveryAddressDto>();
		try {
			List<BzUserDeliveryAddress> content = bzUserDeliveryAddressService
					.findList(bzMerchantId);
			for (BzUserDeliveryAddress bzUserDeliveryAddress : content) {
				pr.getContent().add(entity2Dto(bzUserDeliveryAddress));
			}
			pr.setTotalCount(content.size());
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzUserDeliveryAddressDto> getById(
			@WebParam(name = "bzUserDeliveryAddressId") Long bzUserDeliveryAddressId) {
		WsPageResult<BzUserDeliveryAddressDto> pr = new WsPageResult<BzUserDeliveryAddressDto>();
		try {
			pr.getContent().add(
					entity2Dto(bzUserDeliveryAddressService
							.getById(bzUserDeliveryAddressId)));
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> saveOrUpdate(
			@WebParam(name = "dtoString") String dtoString) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			BzUserDeliveryAddress entity = dto2Entity((BzUserDeliveryAddressDto) decodeBase64(dtoString));
			if (entity.getId() == null || entity.getId() == 0) {
				bzUserDeliveryAddressService.doCreate(entity);
			} else {
				bzUserDeliveryAddressService.doUpdate(entity);
			}
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> deleteById(
			@WebParam(name = "bzUserDeliveryAddressId") Long bzUserDeliveryAddressId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzUserDeliveryAddressService.doDeleteById(bzUserDeliveryAddressId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzUserDeliveryAddressDto getObject() {
		return new BzUserDeliveryAddressDto();
	}

}
