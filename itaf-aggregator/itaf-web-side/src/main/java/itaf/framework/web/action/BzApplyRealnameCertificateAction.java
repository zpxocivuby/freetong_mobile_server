package itaf.framework.web.action;

import itaf.framework.business.certificate.service.IBzApplyRealnameCertificateService;
import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.domain.certificate.BzApplyRealnameCertificate;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.web.workflow.action.BaseFormAction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

@ManagedBean(name = "bzApplyRealnameCertificateAction")
@ViewScoped
public class BzApplyRealnameCertificateAction extends BaseFormAction {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{bzApplyRealnameCertificateServiceImpl}")
	IBzApplyRealnameCertificateService bzApplyRealnameCertificateService;
	
	@ManagedProperty(value = "#{sysUserServiceImpl}")
	private ISysUserService userService;
	
	BzApplyRealnameCertificate bzApplyRealnameCertificate;
	
	@ManagedProperty(value = "#{sysRoleServiceImpl}")
	ISysRoleService roleService;

	public ISysUserService getUserService() {
		return userService;
	}

	public void setUserService(ISysUserService userService) {
		this.userService = userService;
	}

	public ISysRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(ISysRoleService roleService) {
		this.roleService = roleService;
	}

	public IBzApplyRealnameCertificateService getBzApplyRealnameCertificateService() {
		return bzApplyRealnameCertificateService;
	}

	public void setBzApplyRealnameCertificateService(
			IBzApplyRealnameCertificateService bzApplyRealnameCertificateService) {
		this.bzApplyRealnameCertificateService = bzApplyRealnameCertificateService;
	}

	public BzApplyRealnameCertificate getBzApplyRealnameCertificate() {
		String id = ProcessQueryUtil.getValueOfForm("id");
		if (StringUtils.trimToNull(id) != null) {
			bzApplyRealnameCertificate = bzApplyRealnameCertificateService.findById(Long.valueOf(id));
		}
		if(bzApplyRealnameCertificate==null){
			bzApplyRealnameCertificate = new BzApplyRealnameCertificate();
		}
		return bzApplyRealnameCertificate;
	}

	public void setBzApplyRealnameCertificate(
			BzApplyRealnameCertificate bzApplyRealnameCertificate) {
		this.bzApplyRealnameCertificate = bzApplyRealnameCertificate;
	}
	
	public void submit() {
		BzApplyRealnameCertificate bzApplyRealnameCertificate = this.getBzApplyRealnameCertificate();
		bzApplyRealnameCertificate.setProcessDefinitionId(ProcessQueryUtil.getValueOfForm("processDefinitionId"));
		bzApplyRealnameCertificate.setTitle(bzApplyRealnameCertificate.getName());
		bzApplyRealnameCertificate.setFormName("实名认证申请");
		bzApplyRealnameCertificate.setProcessDefinitionName("sideSecondLevel");
		bzApplyRealnameCertificate.setProcessDefinitionId("sideSecondLevel");
		bzApplyRealnameCertificate.setPageUrl("/pages/workflow/apply_realname_form.xhtml");
		bzApplyRealnameCertificate.setFormType("realname");
		bzApplyRealnameCertificate.setFirstApproval(roleService.findById(2l));
		bzApplyRealnameCertificate.setSecondApproval(roleService.findById(3l));;
		SysUser currentUser = userService.findById(getCurrUserId());
		bzApplyRealnameCertificate.setSysUser(currentUser);
		bzApplyRealnameCertificate.setSex(1l);
		bzApplyRealnameCertificate.setIdType(1l);
		bzApplyRealnameCertificate.setMobile("123123123");
		bzApplyRealnameCertificate.setSysUserId(currentUser.getId());
		bzApplyRealnameCertificate.setCreateUserName(currentUser.getUsername());
		bzApplyRealnameCertificateService.doSubmitApply(bzApplyRealnameCertificate);
	}
}
