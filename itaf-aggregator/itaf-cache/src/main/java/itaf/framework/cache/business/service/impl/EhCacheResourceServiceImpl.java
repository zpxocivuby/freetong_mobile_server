package itaf.framework.cache.business.service.impl;

import itaf.framework.business.platform.service.ISysResourceService;
import itaf.framework.cache.aop.base.ICacheObject;
import itaf.framework.cache.aop.base.IRefreshCacheService;
import itaf.framework.cache.business.service.ICacheResourceService;
import itaf.framework.domain.platform.SysResource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ehCacheResourceServiceImpl")
public class EhCacheResourceServiceImpl implements ICacheResourceService,
		IRefreshCacheService {

	private static final String RESOURCE_KEY = "resource_key_";

	@Autowired(required = false)
	@Qualifier("ehCacheObjectImpl")
	private ICacheObject<SysResource> cacheSysResource;

	@Autowired
	private ISysResourceService resourceService;

	@Override
	public void refreshCache() {
		cacheSysResource.clearByPrefix(RESOURCE_KEY);
		List<SysResource> elements = resourceService.findAll();
		if (elements.size() == 0) {
			return;
		}
		SysResource resourceRoot = new SysResource();
		cacheSysResource.cacheObject(RESOURCE_KEY, resourceRoot);
		// 1.缓存数据
		for (SysResource element : elements) {
			cacheSysResource.cacheObject(RESOURCE_KEY + element.getId(),
					element);
		}
		// 2.构造树形
		for (SysResource element : elements) {
			if (element.getParentId() == null || element.getParentId() == 0) {
				resourceRoot.addTreeChild(element);
			} else {
				SysResource parent = cacheSysResource.getByKey(RESOURCE_KEY
						+ element.getParentId());
				element.setTreeParent(parent);
				parent.addTreeChild(element);
			}
		}

	}

	@Override
	public SysResource getCacheTreeRoot() {
		return cacheSysResource.getByKey(RESOURCE_KEY).getTreeChildren().get(0);
	}

	@Override
	public SysResource getCacheById(Long id) {
		return cacheSysResource.getByKey(RESOURCE_KEY + id);
	}

}
