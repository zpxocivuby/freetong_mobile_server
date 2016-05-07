package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysResourceService;
import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.cache.business.service.ICacheResourceService;
import itaf.framework.domain.platform.SysResource;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.web.base.action.BaseAction;
import itaf.framework.web.tree.ResourceTreeNode;
import itaf.framework.web.util.ProcessQueryUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.swing.tree.TreeNode;

import org.apache.commons.lang.StringUtils;

/**
 * 角色资源管理
 * 
 * @authorXINXIN
 * 
 * @Update 2014年5月26日
 */
@ManagedBean(name = "roleResourceManageAction")
@ViewScoped
public class RoleResourceManageAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysResourceServiceImpl}")
	private ISysResourceService resourceService;

	@ManagedProperty(value = "#{ehCacheResourceServiceImpl}")
	private ICacheResourceService cacheResourceService;

	@ManagedProperty(value = "#{sysRoleServiceImpl}")
	private ISysRoleService roleService;

	private SysRole role = null;

	private List<SysResource> authorizedResources;

	private List<TreeNode> treeRoots = new ArrayList<TreeNode>();

	@Override
	protected void execute() {
		if (METHOD_SAVE.equals(this.getMethodType())) {
			this.save();
		}
	}

	/**
	 * 保存步骤：<br/>
	 * 1. 获取页面上checked为true,且是node节点的元素 2. 清空role的关联资源清单，并加入以上资源 3. 保存 TODO:
	 * 认为这里的授权设计仍有问题，若仅允许对子节点授权，那如何处理是否可访问应用的授权。另外action隶属与item，也会有授权问题。
	 */
	private void save() {
		Set<SysResource> authorized = getAllChecked(treeRoots);
		role.setSysResources(authorized);
		roleService.doUpdate(role);
	}

	@PostConstruct
	private void init() {
		String dataId = ProcessQueryUtil.getValueOfForm("dataId");
		if (StringUtils.isNotEmpty(dataId)) {
			Long roleId = Long.valueOf(dataId);
			role = roleService.findById(roleId);
			authorizedResources = new ArrayList<SysResource>(
					role.getSysResources());
		}
		SysResource resourceRoot = cacheResourceService.getCacheTreeRoot();
		treeRoots = recursionCopy(resourceRoot.getTreeChildren());
	}

	private List<TreeNode> recursionCopy(List<SysResource> target) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (target == null || target.size() == 0) {
			return result;
		}
		for (SysResource sysResource : target) {
			ResourceTreeNode node = new ResourceTreeNode();
			node.setHref(sysResource.getPath());
			node.setId(sysResource.getId());
			node.setType(sysResource.getIsLeaf() ? "leaf" : "root");
			node.setName(sysResource.getNameZh());
			node.setTreeNodes(recursionCopy(sysResource.getTreeChildren()));
			node.setChecked(authorizedResources.indexOf(sysResource) > -1);
			result.add(node);
		}
		return result;
	}

	private Set<SysResource> getAllChecked(List<TreeNode> treeNodes) {
		Set<SysResource> resources = new HashSet<SysResource>();
		if (treeNodes == null || treeNodes.size() == 0) {
			return resources;
		}
		for (TreeNode treeNode : treeNodes) {
			ResourceTreeNode node = (ResourceTreeNode) treeNode;
			if (node.getChecked() != null && node.getChecked()) {
				resources.add(cacheResourceService.getCacheById(node.getId()));
			}
			resources.addAll(getAllChecked(node.getTreeNodes()));
		}
		return resources;
	}

	public ISysResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ISysResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public ISysRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(ISysRoleService roleService) {
		this.roleService = roleService;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

	public List<SysResource> getAuthorizedResources() {
		return authorizedResources;
	}

	public void setAuthorizedResources(List<SysResource> authorizedResources) {
		this.authorizedResources = authorizedResources;
	}

	public List<TreeNode> getTreeRoots() {
		return treeRoots;
	}

	public void setTreeRoots(List<TreeNode> treeRoots) {
		this.treeRoots = treeRoots;
	}

	public ICacheResourceService getCacheResourceService() {
		return cacheResourceService;
	}

	public void setCacheResourceService(ICacheResourceService cacheResourceService) {
		this.cacheResourceService = cacheResourceService;
	}

}
