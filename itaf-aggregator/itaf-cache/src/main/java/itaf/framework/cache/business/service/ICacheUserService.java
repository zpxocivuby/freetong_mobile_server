package itaf.framework.cache.business.service;

import itaf.framework.domain.platform.SysUser;

/**
 * Interface defines contract for retrieve user data from cache.
 * 
 * @author Danne
 * 
 */
public interface ICacheUserService {
	/**
	 * Get user object according given user name.
	 * 
	 * @param username
	 *            unique user name.
	 * @return user object or null.
	 */
	SysUser getCacheByUsername(String username);

}
