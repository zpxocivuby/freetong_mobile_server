package itaf.framework.cache.business.service;

import itaf.framework.domain.platform.SysResource;

public interface ICacheResourceService {

	SysResource getCacheTreeRoot();

	SysResource getCacheById(Long id);

}
