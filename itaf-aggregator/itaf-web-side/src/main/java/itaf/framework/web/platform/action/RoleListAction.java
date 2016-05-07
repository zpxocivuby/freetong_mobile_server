package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * 角色列表界面
 * 
 * @author sherlockq
 *         <p>
 */
@ManagedBean(name = "roleListAction")
@ViewScoped
public class RoleListAction extends BaseRichFacesDataGridAction<SysRole> {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysRoleServiceImpl}")
	private ISysRoleService roleService;

	@Override
	protected void execute() {
		if (METHOD_DELETE.equals(this.getMethodType())) {
			this.delete();
		}
	}

	@Override
	protected PageResult<SysRole> getPageContent() {
		processQueryCondiction();
		return getRoleService().findByCriteria(queryCriteria);
	}

	private void delete() {
		List<Long> dataIds = ProcessQueryUtil.getIdsOfForm("dataIds", ",");
		roleService.doDeleteByIds(dataIds);
	}

	private void processQueryCondiction() {
		queryCriteria.addQueryCondition("nameZhLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "nameZh", 3, 1));
		queryCriteria.addQueryCondition("nameEnLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "nameEn", 3, 1));
		queryCriteria.addQueryCondition("descriptionLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "description", 3, 1));
	}

	public ISysRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(ISysRoleService roleService) {
		this.roleService = roleService;
	}

}
