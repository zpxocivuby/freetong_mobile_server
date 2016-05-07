package itaf.framework.web.platform.action;

import itaf.framework.cache.business.service.ICacheResourceService;
import itaf.framework.domain.platform.SysResource;
import itaf.framework.web.base.action.AbstractPageAction;
import itaf.framework.web.json.JSONParseHelper;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "resourceColumnTreeAction")
@ViewScoped
public class ResourceColumnTreeAction extends AbstractPageAction {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ehCacheResourceServiceImpl}")
	private ICacheResourceService cacheResourceService;

	private SysResource rootResource = null;

	public String getRootResource() {
		if (rootResource == null) {
			rootResource = cacheResourceService.getCacheTreeRoot();
		}
		Set<String> filterColumn = new HashSet<String>();
		filterColumn.add("id");
		filterColumn.add("nameZh");
		filterColumn.add("nameEn");
		filterColumn.add("description");
		filterColumn.add("path");
		filterColumn.add("isLeaf");
		filterColumn.add("orderNo");
		filterColumn.add("treeChildren");
		String json = JSONParseHelper.java2Json(rootResource, filterColumn,
				null);
		json = json.replaceAll("\"treeChildren\"", "\"children\"");
		json = json.replaceAll("\"isLeaf\"", "\"leaf\"");
		return json;
	}

	public void setRootResource(SysResource rootResource) {
		this.rootResource = rootResource;
	}

	public ICacheResourceService getCacheResourceService() {
		return cacheResourceService;
	}

	public void setCacheResourceService(
			ICacheResourceService cacheResourceService) {
		this.cacheResourceService = cacheResourceService;
	}

}
