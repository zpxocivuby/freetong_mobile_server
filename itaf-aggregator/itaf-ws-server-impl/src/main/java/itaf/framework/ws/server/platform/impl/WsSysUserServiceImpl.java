package itaf.framework.ws.server.platform.impl;

import java.math.BigDecimal;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.account.service.IBzAccountService;
import itaf.framework.business.consumer.service.IBzConsumerService;
import itaf.framework.business.merchant.service.IBzDistCompanyService;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.domain.account.BzAccount;
import itaf.framework.domain.consumer.BzConsumer;
import itaf.framework.domain.merchant.BzDistCompany;
import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.platform.dto.SysUserDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.platform.WsSysUserService;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsSysUserServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.platform.WsSysUserService", serviceName = "WsSysUserService")
public class WsSysUserServiceImpl extends WsBaseImpl<SysUserDto> implements
		WsSysUserService {

	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private IBzConsumerService bzConsumerService;
	@Autowired
	private IBzMerchantService bzMerchantService;
	@Autowired
	private IBzDistCompanyService bzDistCompanyService;
	@Autowired
	private IBzAccountService bzAccountService;

	public WsPageResult<SysUserDto> getById(
			@WebParam(name = "sysUserId") Long sysUserId) {
		WsPageResult<SysUserDto> pr = new WsPageResult<SysUserDto>();
		try {
			SysUser sysUser = sysUserService.getById(sysUserId);
			if (sysUser == null || sysUser.getMarkForDelete()) {
				pr.setStatus(WsPageResult.STATUS_ERROR);
				pr.setErrorMsg("无此用户");
				return pr;
			}

			SysUserDto sysUserDto = new SysUserDto();
			sysUserDto.setId(sysUser.getId());
			sysUserDto.setMobile(sysUser.getMobile());
			sysUserDto.setType(sysUser.getType());
			sysUserDto
					.setRealnameStatus(sysUser.getRealnameCertificateStatus());

			BzConsumer bzConsumer = bzConsumerService.getById(sysUser.getId());
			if (bzConsumer != null) {
				//
			}
			BzMerchant bzMerchant = bzMerchantService.getById(sysUser.getId());
			if (bzMerchant != null) {
				sysUserDto.setSellingStatus(bzMerchant.getCertificateStatus());
			}
			BzDistCompany bzDistCompany = bzDistCompanyService.getById(sysUser
					.getId());
			if (bzDistCompany != null) {
				sysUserDto.setDistStatus(bzDistCompany.getCertificateStatus());
			}

			sysUserDto.setUsername(sysUser.getUsername());
			sysUserDto.setNickname(sysUser.getNickname());
			sysUserDto.setEmail(sysUser.getEmail());

			// TODO
			BzAccount bzAccount = bzAccountService.getById(sysUser.getId());
			if (bzAccount == null) {
				bzAccount = new BzAccount();
				bzAccount.setId(sysUser.getId());
				bzAccount.setAccountName("");
				bzAccount.setAccountBalance(new BigDecimal(0L));
				bzAccountService.doCreate(bzAccount);
			}
			sysUserDto.setAccountBalance(bzAccount.getAccountBalance());

			sysUserDto.setMarkForDelete(sysUser.getMarkForDelete());

			pr.getContent().add(sysUserDto);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
			return pr;
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public SysUserDto getObject() {
		return new SysUserDto();
	}

}
