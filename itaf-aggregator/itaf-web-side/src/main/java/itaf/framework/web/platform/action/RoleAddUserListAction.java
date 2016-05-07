package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang.StringUtils;

/**
 * 增加角色关联用户用列表
 */
@ManagedBean(name = "roleAddUserListAction")
@ViewScoped
public class RoleAddUserListAction extends BaseRichFacesDataGridAction<SysUser> {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysRoleServiceImpl}")
	private ISysRoleService roleService;

	@ManagedProperty(value = "#{sysUserServiceImpl}")
	private ISysUserService userService;

	private Long roleId = null;

	private Set<Long> authUserIds;

	@Override
	protected void execute() {
		if (METHOD_SAVE.equals(this.getMethodType())) {
			this.save();
		}
	}

	@Override
	protected PageResult<SysUser> getPageContent() {
		processQueryCondiction();
		PageResult<SysUser> result = userService.findByCriteria(queryCriteria);
		if (result != null) {
			List<SysUser> contents = (List<SysUser>) result.getContent();
			if (contents != null && contents.size() > 0) {
				Set<Long> userIds = this.getAuthUserIds();
				for (SysUser sysUser : contents) {
					if (sysUser != null && userIds.contains(sysUser.getId())) {
						// sysUser.setIsAuth(true);
					}
				}
			}
		}
		return result;
	}

	private void processQueryCondiction() {
		queryCriteria.setOrderDirection("desc");
		queryCriteria.setOrderField("user.updatedDate desc, user.id");
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
		queryCriteria.addQueryCondition("markForDelete", false);
	}

	public void updateAuthUserIds(ValueChangeEvent changeEvent) {
		String userIdStr = (String) changeEvent.getComponent().getAttributes()
				.get("lang");
		boolean flag = "true".equals(changeEvent.getNewValue().toString());
		if (StringUtils.trimToNull(userIdStr) != null) {
			Long userId = Long.valueOf(userIdStr);
			//SysUser sysUser = userService.findById(userId);
			// sysUser.setIsAuth(flag);
			if (authUserIds == null) {
				authUserIds = this.getAuthUserIds();
			}
			if (flag) {
				authUserIds.add(userId);
			} else {
				authUserIds.remove(userId);
			}
		}
	}

	private void save() {
		Set<Long> dataIds = getAuthUserIds();
		Set<SysUser> sysUsers = new HashSet<SysUser>();
		for (Long dataId : dataIds) {
			SysUser sysUser = userService.findById(dataId);
			sysUsers.add(sysUser);
		}
		roleService.doUpdateUsersToRole(getRoleId(), sysUsers);
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

	public Set<Long> getAuthUserIds() {
		if (authUserIds == null) {
			authUserIds = new HashSet<Long>();
			Long roleId = this.getRoleId();
			SysRole sysRole = roleService.findById(roleId);
			Set<SysUser> sysUsers = sysRole.getSysUsers();
			if (sysUsers != null && sysUsers.size() > 0) {
				for (SysUser sysUser : sysUsers) {
					authUserIds.add(sysUser.getId());
				}
			}
		}
		return authUserIds;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setAuthUserIds(Set<Long> authUserIds) {
		this.authUserIds = authUserIds;
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
