package itaf.framework.cache.app;

import itaf.framework.cache.aop.base.IRefreshCacheService;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 应用服务器启动时初始化数据
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月22日
 */
@Component
@Lazy(false)
public class CacheDataInAppServerStartup {

	private static final Log log = LogFactory
			.getLog(CacheDataInAppServerStartup.class);

	@Autowired
	@Qualifier("ehCacheCodeListServiceImpl")
	private IRefreshCacheService codeListService;

	@Autowired
	@Qualifier("ehCacheResourceServiceImpl")
	private IRefreshCacheService resourceService;

	public CacheDataInAppServerStartup() {
		super();
		log.debug("AppServerStartup is Startup");
	}

	@PostConstruct
	public void init() {
		log.info("codeListService init data start");
		codeListService.refreshCache();
		log.info("codeListService init data end");

		log.info("resourceService init data start");
		resourceService.refreshCache();
		log.info("resourceService init data end");

	}
}
