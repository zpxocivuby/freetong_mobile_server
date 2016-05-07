package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysResourceService;
import itaf.framework.cache.business.service.ICacheResourceService;
import itaf.framework.core.app.AppContext;
import itaf.framework.core.constant.CodeListConstant;
import itaf.framework.core.constant.CommonConstants;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.platform.SysResource;
import itaf.framework.web.base.action.AbstractPageAction;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * 导航Action类
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月25日
 */
@ManagedBean(name = "navigationAction")
@ViewScoped
public class NavigationAction extends AbstractPageAction {

	private static final long serialVersionUID = -3430860108739996372L;

	/**
	 * 以ROLE_开头字符串
	 */
	public static final String START_ROLE = "ROLE_";

	@ManagedProperty(value = "#{sysResourceServiceImpl}")
	private ISysResourceService resourceService;

	@ManagedProperty(value = "#{ehCacheResourceServiceImpl}")
	private ICacheResourceService cacheResourceService;

	private static List<SysResource> authResources;

	private String navHtmlString = "";

	private String quickMenuStr;

	private String quickMenuOverseasStr;

	public String getNavHtmlString() {
		SysResource resourceRoot = cacheResourceService.getCacheTreeRoot();
		// 每次获取都更新自己的权限
		authResources = resourceService.findByUserId(AppContext
				.getSessionUser().getId());
		navHtmlString = "<div class=\"menu\">"
				+ recursion(resourceRoot.getTreeChildren()) + "</div>";
		return navHtmlString;
	}

	public String recursion(List<SysResource> target) {
		if (target == null || target.size() <= 0) {
			return "";
		}
		StringBuilder htmlBuilder = new StringBuilder();
		int liCounter = 0;
		for (SysResource resource : target) {
			if (!isAuth(resource)) {
				continue;
			}
			if (resource.getIsNav()) {
				htmlBuilder.append("<li>");
				String path = resource.getPath();
				if (StringHelper.isNotEmpty(path)
						&& path.indexOf(CommonConstants.JSF_URL_PATTERN) != -1) {
					htmlBuilder.append("<a class=\"hide\" href=\""
							+ this.getContextPath() + resource.getPath()
							+ "\">");
					htmlBuilder.append(resource.getNameZh());
					htmlBuilder.append("</a>");
				} else {
					htmlBuilder.append("<a class=\"hide\" href=\"#\">");
					htmlBuilder.append(resource.getNameZh());
					htmlBuilder.append("</a>");
				}
				++liCounter;
			}
			htmlBuilder.append(recursion(resource.getTreeChildren()));
			if (resource.getIsNav()) {
				htmlBuilder.append("</li>");
			}
		}
		if (liCounter > 0) {
			htmlBuilder.insert(0, "<ul>");
			htmlBuilder.append("</ul>");
		}
		return htmlBuilder.toString();
	}

	private boolean isAuth(SysResource target) {
		if (authResources == null) {
			return false;
		}
		return authResources.contains(target);
	}

	public String getQuickMenuStr() {
		quickMenuStr = "";
		String contextPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestContextPath();
		List<SysResource> sysResourceList = resourceService.findByUserIdAndType(
				getCurrUserId(), CodeListConstant.ITAF_MENU,
				CodeListConstant.ITAF_MENU_CATEGORY,
				CodeListConstant.ITAF_MENU_ITEM);
		List<SysResource> quickMenuList = new ArrayList<SysResource>();
		for (int i = 0; i < sysResourceList.size(); i++) {
			SysResource sysResource = sysResourceList.get(i);
			if (sysResource.getNameZh().equals("OTR申请")
					|| sysResource.getNameZh().equals("工作事项一级审批")
					|| sysResource.getNameZh().equals("工作事项二级审批")
					|| sysResource.getNameZh().equals("工作事项三级审批")
					|| sysResource.getNameZh().equals("资源使用申请")
					|| sysResource.getNameZh().equals("我提交的申请")
					|| sysResource.getNameZh().equals("我的代办工作")
					|| sysResource.getNameZh().equals("我的已办工作")
					|| sysResource.getNameZh().equals("我的办结任务")
					|| sysResource.getNameZh().equals("我的收藏")
					|| sysResource.getNameZh().equals("消息与通知")
					|| sysResource.getNameZh().equals("辅助任务-提醒")
					|| sysResource.getNameZh().equals("导出查询结果下载")) {
				quickMenuList.add(sysResource);
			}
		}
		for (int i = 0; i < quickMenuList.size(); i++) {
			SysResource sysResource = quickMenuList.get(i);
			quickMenuStr += "<li><a href=\"" + contextPath
					+ sysResource.getPath() + "\">" + sysResource.getNameZh()
					+ "</a></li>";
		}
		return quickMenuStr;
	}

	public String getQuickMenuOverseasStr() {
		quickMenuOverseasStr = "";
		String contextPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestContextPath();
		List<SysResource> sysResourceList = resourceService.findByUserIdAndType(
				getCurrUserId(), CodeListConstant.ITAF_MENU,
				CodeListConstant.ITAF_MENU_CATEGORY,
				CodeListConstant.ITAF_MENU_ITEM);
		List<SysResource> quickMenuList = new ArrayList<SysResource>();
		for (int i = 0; i < sysResourceList.size(); i++) {
			SysResource sysResource = sysResourceList.get(i);
			if (sysResource.getNameZh().equals("特别报道员管理")
					|| sysResource.getNameZh().equals("薪酬模式管理")
					|| sysResource.getNameZh().equals("劳务发放管理")
					|| sysResource.getNameZh().equals("劳务公司管理")
					|| sysResource.getNameZh().equals("台内付款账单管理")) {
				quickMenuList.add(sysResource);
			}
		}
		for (int i = 0; i < quickMenuList.size(); i++) {
			SysResource sysResource = quickMenuList.get(i);
			quickMenuOverseasStr += "<li><a href=\"" + contextPath
					+ sysResource.getPath() + "\">" + sysResource.getNameZh()
					+ "</a></li>";
		}
		return quickMenuOverseasStr;
	}

	public void setQuickMenuStr(String quickMenuStr) {
		this.quickMenuStr = quickMenuStr;
	}

	public ISysResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ISysResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public void setNavHtmlString(String navHtmlString) {
		this.navHtmlString = navHtmlString;
	}

	public void setQuickMenuOverseasStr(String quickMenuOverseasStr) {
		this.quickMenuOverseasStr = quickMenuOverseasStr;
	}

	public ICacheResourceService getCacheResourceService() {
		return cacheResourceService;
	}

	public void setCacheResourceService(
			ICacheResourceService cacheResourceService) {
		this.cacheResourceService = cacheResourceService;
	}

}
