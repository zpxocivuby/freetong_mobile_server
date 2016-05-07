package itaf.framework.ws.server.platform.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.consumer.service.IBzConsumerService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.domain.consumer.BzConsumer;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.platform.dto.SysUserDto;
import itaf.framework.security.service.AuthenticationService;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.platform.WsSysRegisterService;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wsSysRegisterServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.platform.WsSysRegisterService")
public class WsSysRegisterServiceImpl extends WsBaseImpl<SysUserDto> implements
		WsSysRegisterService {

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private IBzConsumerService bzConsumerService;

	@Autowired
	private AuthenticationService authService;

	public WsPageResult<SysUserDto> register(
			@WebParam(name = "username") String username,
			@WebParam(name = "password") String password,
			@WebParam(name = "mobile") String mobile) {
		WsPageResult<SysUserDto> pr = new WsPageResult<SysUserDto>();
		try {
			SysUser user = sysUserService.findByUsername(username);
			if (user != null) {
				pr.setStatus(WsPageResult.STATUS_ERROR);
				pr.setErrorMsg("已有此用户");
				return pr;
			}
			BzConsumer bzConsumer = bzConsumerService.doRegister(username,
					password, mobile);

			authService.doMobileAuthenticate(username, password, mobile);

			SysUserDto sysUserDto = new SysUserDto();
			sysUserDto.setMarkForDelete(bzConsumer.getMarkForDelete());
			sysUserDto.setId(bzConsumer.getId());
			sysUserDto.setMobile(bzConsumer.getSysUser().getMobile());
			sysUserDto.setPassword(bzConsumer.getSysUser().getPassword());
			sysUserDto.setType(bzConsumer.getSysUser().getType());
			sysUserDto.setUsername(bzConsumer.getSysUser().getUsername());
			sysUserDto.setNickname(bzConsumer.getSysUser().getNickname());
			sysUserDto.setEmail(bzConsumer.getSysUser().getNickname());

			List<SysUserDto> wsList = new ArrayList<SysUserDto>();
			wsList.add(sysUserDto);
			pr.setContent(wsList);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);

		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public SysUserDto getObject() {
		return new SysUserDto();
	}
}
