package itaf.framework.business.certificate.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.certificate.service.IBzApplyDistCertificateService;
import itaf.framework.business.common.service.IBzAttachmentService;
import itaf.framework.business.merchant.service.IBzDistCompanyService;
import itaf.framework.domain.certificate.BzApplyDistCertificate;
import itaf.framework.domain.certificate.BzApplySellingCertificate;
import itaf.framework.domain.certificate.BzMerchantCertificate;
import itaf.framework.domain.merchant.BzDistCompany;
import itaf.framework.persistence.certificate.dao.IBzApplyDistCertificateDao;
import itaf.framework.persistence.certificate.dao.IBzMerchantCertificateDao;
import itaf.framework.workflow.service.WorkFlowService;
import itaf.framework.workflow.service.WorkflowProcessService;
import itaf.framework.workflow.util.FormConstants;
import itaf.framework.workflow.vo.WorkflowMapDefine;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzApplyDistCertificateServiceImpl")
public class BzApplyDistCertificateServiceImpl extends BaseServiceImpl
		implements IBzApplyDistCertificateService {

	@Autowired
	private IBzApplyDistCertificateDao bzApplyDistCertificateDao;
	@Autowired
	private IBzDistCompanyService bzDistCompanyService;
	@Autowired
	private IBzAttachmentService bzAttachmentService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	WorkflowProcessService workflowProcessService;
	@Autowired
	IBzMerchantCertificateDao bzMerchantCertificateDao;

	public void doSubmitApply(BzApplyDistCertificate bzApplyDistCertificate) {
		bzApplyDistCertificateDao.saveOrUpdate(bzApplyDistCertificate);
		// bzAttachmentService.doMarkForValid(bzApplyDistCertificate.getBzAttachmentId());
		BzDistCompany bzDistCompany = bzDistCompanyService
				.getById(bzApplyDistCertificate.getSysUserId());
		if (bzDistCompany == null) {
			bzDistCompany = new BzDistCompany();
			bzDistCompany.setId(bzApplyDistCertificate.getSysUserId());
			bzDistCompany.setMarkForDelete(false);
		}
		bzDistCompany.setCertificateStatus(1L);
		bzDistCompanyService.doSave(bzDistCompany);

		// //////////////////////////////////////////////////
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(WorkflowMapDefine.CLASSNAME,
				bzApplyDistCertificate.getFormType());
		variables.put(WorkflowMapDefine.PAGEURL,
				bzApplyDistCertificate.getPageUrl());
		variables.put(WorkflowMapDefine.FORMID, bzApplyDistCertificate.getId());
		variables.put(WorkflowMapDefine.PROCESSDEFINITIONID,
				bzApplyDistCertificate.getProcessDefinitionId());
		variables.put(WorkflowMapDefine.FINALAPPROVALSTATE, "NO");
		variables.put(WorkflowMapDefine.FIRSTAPPROVAL, String
				.valueOf(bzApplyDistCertificate.getFirstApproval().getId()));
		variables.put(WorkflowMapDefine.SECONDAPPROVAL, String
				.valueOf(bzApplyDistCertificate.getSecondApproval().getId()));
		variables.put(WorkflowMapDefine.TYPE, "dist");
		String processInstanceId = workFlowService.doStartWorkflow(
				String.valueOf(bzApplyDistCertificate.getSysUser().getId()),
				bzApplyDistCertificate.getProcessDefinitionId(),
				bzApplyDistCertificate.getId().toString(), variables);
		// 回填更新
		bzApplyDistCertificate.setProcessInstanceId(processInstanceId);
		bzApplyDistCertificate
				.setApprovalState(FormConstants.FORM_STATE_RUNNING);
		bzApplyDistCertificate.setSubmitTime(new Date());
		bzApplyDistCertificateDao.save(bzApplyDistCertificate);
	}

	public BzApplyDistCertificate getByBzConsumerId(Long bzConsumerId) {
		String hql = "from BzApplyDistCertificate b where b.sysUser.id=:sysUserId and b.markForDelete=:markForDelete order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sysUserId", bzConsumerId);
		params.put("markForDelete", false);
		List<BzApplyDistCertificate> list = bzApplyDistCertificateDao.query(
				hql, params);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public BzApplyDistCertificate findById(Long id) {
		return bzApplyDistCertificateDao.findById(id);
	}
	
	public void doSupportJavaService(BzApplyDistCertificate bzApplyDistCertificate, String finalApprovlState){
		if(finalApprovlState.equals("1")){
			bzApplyDistCertificate.setState("1");
			BzMerchantCertificate bzMerchantCertificate = new BzMerchantCertificate();
			bzMerchantCertificate.setBzDistServiceApply(bzApplyDistCertificate);
			bzMerchantCertificate.setCompanyName(bzApplyDistCertificate.getCompanyName());
			bzMerchantCertificate.setCompanyAddress(bzApplyDistCertificate.getCompanyAddress());
			bzMerchantCertificate.setSysUser(bzApplyDistCertificate.getSysUser());
			bzMerchantCertificateDao.save(bzMerchantCertificate);
		}else{
			bzApplyDistCertificate.setState("0");
		}
		bzApplyDistCertificateDao.saveOrUpdate(bzApplyDistCertificate);
	}

}