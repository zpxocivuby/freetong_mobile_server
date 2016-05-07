package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysResourceService;
import itaf.framework.web.base.action.AbstractPageAction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

/**
 * 按钮权限管理
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月15日
 */
@ManagedBean(name = "buttonAuthAction")
@ViewScoped
public class ButtonAuthAction extends AbstractPageAction {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysResourceServiceImpl}")
	private ISysResourceService resourceService;

	public boolean showButton(String resourceId) {
		if (StringUtils.isEmpty(resourceId)) {
			return false;
		}
		return resourceService.isHasButtonAuth(getCurrUserId(),
				Long.valueOf(resourceId));
	}

	public ISysResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ISysResourceService resourceService) {
		this.resourceService = resourceService;
	}

}
