package itaf.framework.web.platform.action;

import itaf.framework.cache.aop.base.IRefreshCacheService;
import itaf.framework.web.base.action.BaseAction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * 刷新内存中的缓存
 * 
 * @author XINXIN
 * 
 */
@ManagedBean(name = "refreshCacheAction")
@RequestScoped
public class RefreshCacheAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static final String TYPE_CODE_LIST = "refreshCodeList";

	private static final String TYPE_RESOURCE = "refreshResource";

	@ManagedProperty(value = "#{ehCacheCodeListServiceImpl}")
	private IRefreshCacheService codeListService;

	@ManagedProperty(value = "#{ehCacheResourceServiceImpl}")
	private IRefreshCacheService resourceService;

	@Override
	protected void execute() {
		if (TYPE_CODE_LIST.equals(this.getMethodType())) {
			codeListService.refreshCache();
		} else if (TYPE_RESOURCE.equals(this.getMethodType())) {
			resourceService.refreshCache();
		}

	}

	public IRefreshCacheService getCodeListService() {
		return codeListService;
	}

	public void setCodeListService(IRefreshCacheService codeListService) {
		this.codeListService = codeListService;
	}

	public IRefreshCacheService getResourceService() {
		return resourceService;
	}

	public void setResourceService(IRefreshCacheService resourceService) {
		this.resourceService = resourceService;
	}

}
