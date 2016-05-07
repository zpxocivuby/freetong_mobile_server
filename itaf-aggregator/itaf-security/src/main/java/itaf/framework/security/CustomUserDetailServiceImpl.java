package itaf.framework.security;

import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.core.constant.CommonConstants;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.platform.SysResource;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.domain.platform.SysUser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 2取得用户的权限（英文名称）
 * 
 * @author XINXIN
 * 
 * @update 2013-6-4
 */
public class CustomUserDetailServiceImpl implements UserDetailsService {

	private static final Log log = LogFactory
			.getLog(CustomUserDetailServiceImpl.class);

	private ISysUserService userService;

	public ISysUserService getUserService() {
		if (userService == null) {
			userService = (ISysUserService) SpringContextUtil
					.getBean("sysUserServiceImpl");
		}
		return userService;
	}

	// 登录验证
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		log.debug("username is " + username);
		SysUser user = getUserService().findByUsername(username);
		// 封装成spring security的user
		if (user == null) {
			return new User(null, null, true, true, true, true, null);
		}
		return new User(user.getUsername(), user.getPassword(), true, true,
				true, true, obtionGrantedAuthorities(user));
	}

	/**
	 * 用户所拥有的权限（英文名称） 注意：必须"ROLE_"开头
	 * 
	 * @See CustomSecurityMetadataSource#initResourceDefine
	 * 
	 * @param user
	 *            用户信息
	 * @return Set<GrantedAuthority>
	 */
	private Set<GrantedAuthority> obtionGrantedAuthorities(SysUser user) {
		List<SysResource> resources = new ArrayList<SysResource>();
		for (SysRole role : user.getSysRoles()) {
			resources.addAll(role.getSysResources());
		}
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (SysResource res : resources) {
			authSet.add(new SimpleGrantedAuthority(CommonConstants.START_ROLE
					+ res.getNameEn()));
		}
		return authSet;
	}

}
