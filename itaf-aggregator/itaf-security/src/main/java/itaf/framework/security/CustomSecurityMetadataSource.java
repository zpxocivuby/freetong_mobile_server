package itaf.framework.security;

import itaf.framework.business.platform.service.ISysResourceService;
import itaf.framework.core.constant.CommonConstants;
import itaf.framework.domain.platform.SysResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

/**
 * 4加载资源（路径）与权限（英文名称）的对应关系
 * 
 * @author XINXIN
 * 
 * @update 2013-6-4
 */
@Service("customSecurityMetadataSource")
public class CustomSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private static final Log log = LogFactory
			.getLog(CustomSecurityMetadataSource.class);

	@Autowired
	private ISysResourceService resourceService;
	// 加载所有资源与权限的关系
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public CustomSecurityMetadataSource() {
		//
	}

	/**
	 * 返回所请求资源所需要的权限
	 */
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		log.info("requestUrl is " + requestUrl);
		if (resourceMap == null) {
			initResourceDefine();
		}
		Collection<ConfigAttribute> result = resourceMap
				.get(removeParams(requestUrl));
		if (result == null || result.isEmpty()) {
			Collection<ConfigAttribute> returnCollection = new ArrayList<ConfigAttribute>();
			returnCollection.add(new SecurityConfig("NO_LOGIN_NO_AUTH"));
			return returnCollection;
		}
		return result;
	}

	/**
	 * 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
	 * 
	 * @see CustomUserDetailServiceImpl#obtionGrantedAuthorities
	 * 
	 */
	private void initResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		List<SysResource> resources = resourceService.findAll();
		log.debug("resources.size() is " + resources.size());
		for (SysResource resource : resources) {
			String path = resource.getPath();
			if (path == null
					|| path.indexOf(CommonConstants.JSF_URL_PATTERN) == -1) {
				continue;
			}
			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
			configAttributes.add(new SecurityConfig(CommonConstants.START_ROLE
					+ resource.getNameEn()));
			resourceMap.put(removeParams(path), configAttributes);
		}
	}

	private String removeParams(String path) {
		int pos = path.indexOf("?");
		return pos == -1 ? path : path.substring(0, pos);
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

}
