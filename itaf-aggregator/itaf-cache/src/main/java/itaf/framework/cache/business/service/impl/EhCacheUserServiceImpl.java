package itaf.framework.cache.business.service.impl;

import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.cache.aop.base.ICacheObject;
import itaf.framework.cache.business.service.ICacheUserService;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.domain.platform.SysUser;

import java.util.HashSet;
import java.util.Set;

import net.sf.cglib.beans.BeanCopier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Cachable user service implementor class that caches system user for further
 * use.
 * 
 * @author Danne
 * 
 */
@Service("ehCacheUserServiceImpl")
public class EhCacheUserServiceImpl implements ICacheUserService {

	private static final String USER_KEY = "user_key_";

	@Autowired(required = false)
	@Qualifier("ehCacheObjectImpl")
	private ICacheObject<SysUser> sysUserCache;

	@Autowired
	private ISysUserService userService = null;

	/**
	 * Get user object according given user name.
	 * 
	 * @param username
	 *            unique user name.
	 * @return user object or null.
	 */
	public SysUser getCacheByUsername(String username) {
		SysUser user = sysUserCache.getByKey(USER_KEY + username);
		if (user == null) {
			user = userService.findByUsername(username);
			if (user == null) {
				return null;
			}
			SysUser saveUser = new SysUser();
			/**
			 * 以下取得用户相对应的Role、resource权限
			 */
			BeanCopier copier = BeanCopier.create(user.getClass(),
					saveUser.getClass(), false);
			copier.copy(user, saveUser, null);
			Set<SysRole> roles = user.getSysRoles();
			if (roles != null && roles.size() >= 0) {
				Set<SysRole> saveRoles = new HashSet<SysRole>();
				for (SysRole sysRole : roles) {
					SysRole saveRole = new SysRole();
					copier = BeanCopier.create(sysRole.getClass(),
							saveRole.getClass(), false);
					copier.copy(sysRole, saveRole, null);
					saveRoles.add(saveRole);
				}
				saveUser.setSysRoles(saveRoles);
			}
			sysUserCache.cacheObject(USER_KEY + username, saveUser);
			user = saveUser;
		}
		return user;
	}
}
