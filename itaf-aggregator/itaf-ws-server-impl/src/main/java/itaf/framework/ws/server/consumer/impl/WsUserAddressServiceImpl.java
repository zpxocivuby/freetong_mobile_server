package itaf.framework.ws.server.consumer.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.consumer.service.IBzUserAddressService;
import itaf.framework.consumer.dto.BzUserAddressDto;
import itaf.framework.domain.consumer.BzUserAddress;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.domain.position.BzPosition;
import itaf.framework.platform.dto.SysUserDto;
import itaf.framework.position.dto.BzPositionDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.consumer.WsUserAddressService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsUserAddressServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.consumer.WsUserAddressService", serviceName = "WsUserAddressService")
public class WsUserAddressServiceImpl extends WsBaseImpl<BzUserAddressDto>
		implements WsUserAddressService {

	@Autowired
	IBzUserAddressService bzUserAddressService;

	private BzUserAddressDto entity2Dto(BzUserAddress bzUserAddress) {
		BzUserAddressDto bzUserAddressDto = CopyPropertiesCglibHelper
				.copyProperties(BzUserAddressDto.class, bzUserAddress);
		bzUserAddressDto.setSysUserDto(CopyPropertiesCglibHelper
				.copyProperties(SysUserDto.class, bzUserAddress.getSysUser()));
		bzUserAddressDto.setBzPositionDto(CopyPropertiesCglibHelper
				.copyProperties(BzPositionDto.class,
						bzUserAddress.getBzPosition()));
		return bzUserAddressDto;
	}

	private BzUserAddress dto2Entity(BzUserAddressDto bzUserAddressDto) {
		BzUserAddress bzUserAddress = CopyPropertiesCglibHelper.copyProperties(
				BzUserAddress.class, bzUserAddressDto);
		bzUserAddress.setSysUser(CopyPropertiesCglibHelper.copyProperties(
				SysUser.class, bzUserAddressDto.getSysUserDto()));
		bzUserAddress.setBzPosition(CopyPropertiesCglibHelper.copyProperties(
				BzPosition.class, bzUserAddressDto.getBzPositionDto()));
		return bzUserAddress;
	}

	public WsPageResult<BzUserAddressDto> getList(
			@WebParam(name = "bzConsumerId") Long bzConsumerId) {
		WsPageResult<BzUserAddressDto> pr = new WsPageResult<BzUserAddressDto>();
		try {
			List<BzUserAddress> content = bzUserAddressService
					.findList(bzConsumerId);
			for (BzUserAddress bzUserAddress : content) {
				pr.getContent().add(entity2Dto(bzUserAddress));
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

	public WsPageResult<BzUserAddressDto> getById(
			@WebParam(name = "bzUserAddressId") Long bzUserAddressId) {
		WsPageResult<BzUserAddressDto> pr = new WsPageResult<BzUserAddressDto>();
		try {
			pr.getContent().add(
					entity2Dto(bzUserAddressService.getById(bzUserAddressId)));
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
			BzUserAddress entity = dto2Entity((BzUserAddressDto) decodeBase64(dtoString));
			if (entity.getId() == null || entity.getId() == 0) {
				bzUserAddressService.doCreate(entity);
			} else {
				bzUserAddressService.doUpdate(entity);
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
			@WebParam(name = "bzUserAddressId") Long bzUserAddressId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzUserAddressService.doDeleteById(bzUserAddressId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzUserAddressDto getObject() {
		return new BzUserAddressDto();
	}

}
