package itaf.framework.web.action;

import itaf.framework.business.certificate.service.IBzApplySellingCertificateService;
import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.domain.certificate.BzApplySellingCertificate;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.web.workflow.action.BaseFormAction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

@ManagedBean(name = "bzApplySellingCertificateAction")
@ViewScoped
public class BzApplySellingCertificateAction extends BaseFormAction {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{bzApplySellingCertificateServiceImpl}")
	IBzApplySellingCertificateService bzApplySellingCertificateService;
	
	BzApplySellingCertificate bzApplySellingCertificate;
	
	@ManagedProperty(value = "#{sysRoleServiceImpl}")
	ISysRoleService roleService;
	
	@ManagedProperty(value = "#{sysUserServiceImpl}")
	private ISysUserService userService;
	
	
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

	public IBzApplySellingCertificateService getBzApplySellingCertificateService() {
		return bzApplySellingCertificateService;
	}

	public void setBzApplySellingCertificateService(
			IBzApplySellingCertificateService bzApplySellingCertificateService) {
		this.bzApplySellingCertificateService = bzApplySellingCertificateService;
	}

	public BzApplySellingCertificate getBzApplySellingCertificate() {
		String id = ProcessQueryUtil.getValueOfForm("id");
		if (StringUtils.trimToNull(id) != null) {
			bzApplySellingCertificate = bzApplySellingCertificateService.findById(Long.valueOf(id));
		}
		if(bzApplySellingCertificate==null){
			bzApplySellingCertificate = new BzApplySellingCertificate();
		}
		return bzApplySellingCertificate;
	}

	public void setBzApplySellingCertificate(
			BzApplySellingCertificate bzApplySellingCertificate) {
		this.bzApplySellingCertificate = bzApplySellingCertificate;
	}
	
	public void submit() {
		BzApplySellingCertificate bzApplySellingCertificate = this.getBzApplySellingCertificate();
		bzApplySellingCertificate.setProcessDefinitionId(ProcessQueryUtil.getValueOfForm("processDefinitionId"));
		bzApplySellingCertificate.setTitle(bzApplySellingCertificate.getCompanyName());
		bzApplySellingCertificate.setFormName("商家认证申请");
		bzApplySellingCertificate.setProcessDefinitionName("sideSecondLevel");
		bzApplySellingCertificate.setProcessDefinitionId("sideSecondLevel");
		bzApplySellingCertificate.setPageUrl("/pages/workflow/apply_selling_form.xhtml");
		bzApplySellingCertificate.setFormType("selling");
		bzApplySellingCertificate.setFirstApproval(roleService.findById(2l));
		bzApplySellingCertificate.setSecondApproval(roleService.findById(3l));;
		SysUser currentUser = userService.findById(getCurrUserId());
		bzApplySellingCertificate.setSysUser(currentUser);
		bzApplySellingCertificate.setSysUserId(currentUser.getId());
		bzApplySellingCertificate.setCreateUserName(currentUser.getUsername());
		bzApplySellingCertificate.setCompanyAddress("123");
		bzApplySellingCertificateService.doSubmitApply(bzApplySellingCertificate);
	}
}
