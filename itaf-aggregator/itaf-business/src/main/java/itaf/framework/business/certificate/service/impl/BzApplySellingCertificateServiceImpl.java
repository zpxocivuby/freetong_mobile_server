package itaf.framework.business.certificate.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.certificate.service.IBzApplySellingCertificateService;
import itaf.framework.business.common.service.IBzAttachmentService;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.domain.certificate.BzApplySellingCertificate;
import itaf.framework.domain.certificate.BzMerchantCertificate;
import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.persistence.certificate.dao.IBzApplySellingCertificateDao;
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

@Service("bzApplySellingCertificateServiceImpl")
public class BzApplySellingCertificateServiceImpl extends BaseServiceImpl
		implements IBzApplySellingCertificateService {

	@Autowired
	private IBzApplySellingCertificateDao bzApplySellingCertificateDao;
	@Autowired
	private IBzMerchantService bzMerchantService;
	@Autowired
	private IBzAttachmentService bzAttachmentService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	WorkflowProcessService workflowProcessService;
	@Autowired
	IBzMerchantCertificateDao bzMerchantCertificateDao;

	public void doSubmitApply(
			BzApplySellingCertificate bzApplySellingCertificate) {
		bzApplySellingCertificateDao.saveOrUpdate(bzApplySellingCertificate);
		//bzAttachmentService.doMarkForValid(bzApplySellingCertificate.getBzAttachmentId());
		BzMerchant bzMerchant = bzMerchantService
				.getById(bzApplySellingCertificate.getSysUserId());
		if (bzMerchant == null) {
			bzMerchant = new BzMerchant();
			bzMerchant.setId(bzApplySellingCertificate.getSysUserId());
			bzMerchant.setMarkForDelete(false);
		}
		bzMerchant.setCertificateStatus(1L);
		bzMerchantService.doSave(bzMerchant);

		// //////////////////////////////////////////////////
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(WorkflowMapDefine.CLASSNAME,
				bzApplySellingCertificate.getFormType());
		variables.put(WorkflowMapDefine.PAGEURL,
				bzApplySellingCertificate.getPageUrl());
		variables.put(WorkflowMapDefine.FORMID,
				bzApplySellingCertificate.getId());
		variables.put(WorkflowMapDefine.PROCESSDEFINITIONID,
				bzApplySellingCertificate.getProcessDefinitionId());
		variables.put(WorkflowMapDefine.FINALAPPROVALSTATE, "NO");
		variables.put(WorkflowMapDefine.FIRSTAPPROVAL, String
				.valueOf(bzApplySellingCertificate.getFirstApproval().getId()));
		variables
				.put(WorkflowMapDefine.SECONDAPPROVAL, String
						.valueOf(bzApplySellingCertificate.getSecondApproval()
								.getId()));
		variables.put(WorkflowMapDefine.TYPE, "selling");
		String processInstanceId = workFlowService.doStartWorkflow(
				String.valueOf(bzApplySellingCertificate.getSysUser().getId()),
				bzApplySellingCertificate.getProcessDefinitionId(),
				bzApplySellingCertificate.getId().toString(), variables);
		// 回填更新
		bzApplySellingCertificate.setProcessInstanceId(processInstanceId);
		bzApplySellingCertificate
				.setApprovalState(FormConstants.FORM_STATE_RUNNING);
		bzApplySellingCertificate.setSubmitTime(new Date());
		bzApplySellingCertificateDao.save(bzApplySellingCertificate);
	}

	public BzApplySellingCertificate getByBzConsumerId(Long bzConsumerId) {
		String hql = "from BzApplySellingCertificate b where b.sysUserId=:sysUserId and b.markForDelete=:markForDelete order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sysUserId", bzConsumerId);
		params.put("markForDelete", false);
		List<BzApplySellingCertificate> list = bzApplySellingCertificateDao
				.query(hql, params);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public BzApplySellingCertificate findById(Long id) {
		return bzApplySellingCertificateDao.getById(id);
	}
	
	public void doSupportJavaService(BzApplySellingCertificate bzApplySellingCertificate, String finalApprovlState){
		if(finalApprovlState.equals("1")){
			bzApplySellingCertificate.setState("1");
			BzMerchantCertificate bzMerchantCertificate = new BzMerchantCertificate();
			bzMerchantCertificate.setBzSellingServiceApply(bzApplySellingCertificate);
			bzMerchantCertificate.setCompanyName(bzApplySellingCertificate.getCompanyName());
			bzMerchantCertificate.setCompanyAddress(bzApplySellingCertificate.getCompanyAddress());
			bzMerchantCertificate.setSysUser(bzApplySellingCertificate.getSysUser());
			bzMerchantCertificateDao.save(bzMerchantCertificate);
		}else{
			bzApplySellingCertificate.setState("0");
		}
		bzApplySellingCertificateDao.saveOrUpdate(bzApplySellingCertificate);
	}

}