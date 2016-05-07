package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

/**
 * 角色关联用户列表
 */
@ManagedBean(name = "roleUserListAction")
@ViewScoped
public class RoleUserListAction extends BaseRichFacesDataGridAction<SysUser> {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{roleServiceImpl}")
	private ISysRoleService roleService;

	@ManagedProperty(value = "#{sysUserServiceImpl}")
	private ISysUserService userService;

	private Long roleId = null;

	@Override
	protected void execute() {
		if (METHOD_DELETE.equals(this.getMethodType())) {
			this.delete();
		}
	}

	@Override
	protected PageResult<SysUser> getPageContent() {
		processQueryCondiction();
		return getUserService().findByCriteria(queryCriteria);
	}

	private void processQueryCondiction() {
		queryCriteria.setOrderDirection("desc");
		queryCriteria.setOrderField("user.updatedDate desc, user.id");
		String idStr = ProcessQueryUtil
				.processString(queryCriteria, "treename");
		Long departId = null;
		if (StringUtils.trimToNull(idStr) != null) {
			int position = idStr.indexOf("-", 1);
			if (position != -1) {
				departId = Long.valueOf(idStr.substring(0, position));
			}
		}
		queryCriteria.addQueryCondition("roleId", this.getRoleId());
		queryCriteria.addQueryCondition("tsDepartmentId", departId);
		queryCriteria.addQueryCondition("usernameLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "username", 3));
		queryCriteria.addQueryCondition("realnameZhLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "realnameZh", 3));
		queryCriteria.addQueryCondition("realnameEnLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "realnameEn", 3));
		queryCriteria.addQueryCondition("telephoneLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "telephone", 3));
		queryCriteria.addQueryCondition("emailLike",
				ProcessQueryUtil.processStirngLike(queryCriteria, "email", 3));
		queryCriteria.addQueryCondition("markForDelete", false);// 线索采集接口状态
	}

	private void delete() {
		List<Long> dataIds = ProcessQueryUtil.getIdsOfForm("dataIds", ",");
		Collection<SysUser> sysUsers = new ArrayList<SysUser>();
		for (Long dataId : dataIds) {
			SysUser sysUser = userService.getById(dataId);
			sysUsers.add(sysUser);
		}
		roleService.doRemoveUsersFromRole(getRoleId(), sysUsers);
	}

	public Long getRoleId() {
		if (roleId == null || roleId <= 0) {
			String dataId = ProcessQueryUtil.getValueOfForm("dataId");
			if (StringUtils.trimToNull(dataId) != null) {
				roleId = Long.valueOf(dataId);
			}
		}
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public ISysRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(ISysRoleService roleService) {
		this.roleService = roleService;
	}

	public ISysUserService getUserService() {
		return userService;
	}

	public void setUserService(ISysUserService userService) {
		this.userService = userService;
	}

}
