package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.web.base.action.BaseAction;
import itaf.framework.web.util.ProcessQueryUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

@ManagedBean(name = "roleManageAction")
@ViewScoped
public class RoleManageAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysRoleServiceImpl}")
	private ISysRoleService roleService;

	private SysRole sysRole = null;

	@Override
	protected void execute() {
		if (METHOD_SAVE.equals(this.getMethodType())) {
			this.save();
		}
	}

	private void save() {
		SysRole sysRole = this.getSysRole();
		String nameEn = ProcessQueryUtil.getValueOfForm("nameEn");
		String nameZh = ProcessQueryUtil.getValueOfForm("nameZh");
		String description = ProcessQueryUtil.getValueOfForm("description");
		sysRole.setNameEn(nameEn);
		sysRole.setNameZh(nameZh);
		sysRole.setDescription(description);
		roleService.doUpdate(sysRole);
	}

	public SysRole getSysRole() {
		String id = ProcessQueryUtil.getValueOfForm("dataId");
		if (StringUtils.trimToNull(id) != null) {
			sysRole = roleService.findById(Long.valueOf(id));
		}
		if (sysRole == null) {
			sysRole = new SysRole();
		}
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public ISysRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(ISysRoleService roleService) {
		this.roleService = roleService;
	}

}
