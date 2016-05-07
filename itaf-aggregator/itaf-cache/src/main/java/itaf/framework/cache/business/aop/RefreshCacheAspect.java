package itaf.framework.cache.business.aop;

import itaf.framework.cache.aop.base.IRefreshCacheService;
import itaf.framework.core.util.SpringContextUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * 刷新缓存切面
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月21日
 */
public class RefreshCacheAspect {

	private static final Log log = LogFactory.getLog(RefreshCacheAspect.class);

	public void refreshCodeList(JoinPoint obj) {
		log.info("ehCacheCodeListServiceImpl.refreshCache() is start");
		IRefreshCacheService refreshCacheService = (IRefreshCacheService) SpringContextUtil
				.getBean("ehCacheCodeListServiceImpl");
		refreshCacheService.refreshCache();
		log.info("ehCacheCodeListServiceImpl.refreshCache() is end");
	}

	public void refreshResource(JoinPoint obj) {
		log.info("ehCacheResourceServiceImpl.refreshCache() is start");
		IRefreshCacheService refreshCacheService = (IRefreshCacheService) SpringContextUtil
				.getBean("ehCacheResourceServiceImpl");
		refreshCacheService.refreshCache();
		log.info("ehCacheResourceServiceImpl.refreshCache() is end");
	}

}
