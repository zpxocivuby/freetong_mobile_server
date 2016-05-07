package itaf.framework.web.action;

import itaf.framework.business.certificate.service.IBzApplyDistCertificateService;
import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.domain.certificate.BzApplyDistCertificate;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.web.workflow.action.BaseFormAction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

@ManagedBean(name = "bzApplyDistCertificateAction")
@ViewScoped
public class BzApplyDistCertificateAction extends BaseFormAction {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{sysRoleServiceImpl}")
	private ISysRoleService roleService;
	
	@ManagedProperty(value = "#{sysUserServiceImpl}")
	private ISysUserService userService;
	
	@ManagedProperty(value = "#{bzApplyDistCertificateServiceImpl}")
	private IBzApplyDistCertificateService bzApplyDistCertificateService;
	
	BzApplyDistCertificate bzApplyDistCertificate;
	
	
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

	public IBzApplyDistCertificateService getBzApplyDistCertificateService() {
		return bzApplyDistCertificateService;
	}

	public void setBzApplyDistCertificateService(
			IBzApplyDistCertificateService bzApplyDistCertificateService) {
		this.bzApplyDistCertificateService = bzApplyDistCertificateService;
	}

	public BzApplyDistCertificate getBzApplyDistCertificate() {
		String id = ProcessQueryUtil.getValueOfForm("id");
		if (StringUtils.trimToNull(id) != null) {
			bzApplyDistCertificate = bzApplyDistCertificateService.findById(Long.valueOf(id));
		}
		if(bzApplyDistCertificate==null){
			bzApplyDistCertificate = new BzApplyDistCertificate();
		}
		return bzApplyDistCertificate;
	}

	
	public void setBzApplyDistCertificate(
			BzApplyDistCertificate bzApplyDistCertificate) {
		this.bzApplyDistCertificate = bzApplyDistCertificate;
	}

	public void submit() {
		BzApplyDistCertificate bzApplyDistCertificate = this.getBzApplyDistCertificate();
		bzApplyDistCertificate.setProcessDefinitionId(ProcessQueryUtil.getValueOfForm("processDefinitionId"));
		bzApplyDistCertificate.setTitle(bzApplyDistCertificate.getCompanyName());
		bzApplyDistCertificate.setFormName("配送商认证申请");
		bzApplyDistCertificate.setProcessDefinitionName("sideSecondLevel");
		bzApplyDistCertificate.setProcessDefinitionId("sideSecondLevel");
		bzApplyDistCertificate.setPageUrl("/pages/workflow/apply_dist_form.xhtml");
		bzApplyDistCertificate.setFormType("dist");
		bzApplyDistCertificate.setFirstApproval(roleService.findById(2l));
		bzApplyDistCertificate.setSecondApproval(roleService.findById(3l));;
		SysUser currentUser = userService.findById(getCurrUserId());
		bzApplyDistCertificate.setSysUser(currentUser);
		bzApplyDistCertificate.setSysUserId(currentUser.getId());
		bzApplyDistCertificate.setCreateUserName(currentUser.getUsername());
		bzApplyDistCertificate.setCompanyAddress("123");
		bzApplyDistCertificateService.doSubmitApply(bzApplyDistCertificate);
	}
	
}
