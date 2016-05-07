package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysResourceService;
import itaf.framework.core.constant.CodeListConstant;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.platform.SysResource;
import itaf.framework.web.base.action.BaseAction;
import itaf.framework.web.util.CodeListHelper;
import itaf.framework.web.util.ProcessQueryUtil;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 * 资源管理
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月24日
 */
@ManagedBean(name = "resourceManageAction")
@ViewScoped
public class ResourceManageAction extends BaseAction {

	private static final long serialVersionUID = -6689876595694967161L;

	@ManagedProperty(value = "#{sysResourceServiceImpl}")
	private ISysResourceService resourceService;

	private SysResource resource = null;
	private SysResource newResource = new SysResource();

	private SelectItem[] availableResTypes = null;

	public String save() {
		resourceService.doSaveOrUpdate(getResource());
		return null;
	}

	public String delete() {
		resourceService.doDeleteById(getResource().getId());
		return null;
	}

	public String saveNew() {
		newResource.setParentId(getResource().getId());
		if (newResource.getIsNav() == null) {
			newResource.setIsNav(false);
		}
		resourceService.doSaveOrUpdate(newResource);
		// 重置，用来继续新增
		newResource = new SysResource();
		return null;
	}

	public SelectItem[] getAvailableResTypes() {
		try {
			if (availableResTypes != null) {
				return availableResTypes;
			}
			String type = getResource().getType();
			SelectItem[] target = CodeListHelper
					.initItems(CodeListConstant.RESTYPE);
			List<SelectItem> result = new ArrayList<SelectItem>();
			for (SelectItem selectItem : target) {
				String value = selectItem.getValue().toString();
				if (value.startsWith(type)) {
					result.add(selectItem);
				}
			}
			availableResTypes = result.toArray(new SelectItem[result.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			this.getLog().error(e.getMessage());
		}
		return availableResTypes;
	}

	/**
	 * 根据当前Resource类型决定是否可以增加子节点 是否以_action结尾
	 * 
	 * @return t/f
	 */
	public boolean isCanAddNode() {
		return !getResource().getType().matches(
				".*" + CodeListConstant.RESTYPE_LEVEL_SEPARATOR
						+ CodeListConstant.RESTYPE_ACTION + "$");

	}

	/**
	 * @return the resource
	 */
	public SysResource getResource() {
		String id = ProcessQueryUtil.getValueOfForm("id");
		if (StringHelper.isNotEmpty(id)) {
			resource = resourceService.findById(Long.valueOf(id));
		}
		return resource;
	}

	public SysResource getNewResource() {
		return newResource;
	}

	public ISysResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ISysResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

}
