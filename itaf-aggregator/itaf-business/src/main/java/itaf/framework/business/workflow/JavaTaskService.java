package itaf.framework.business.workflow;

import itaf.framework.business.certificate.service.IBzApplyDistCertificateService;
import itaf.framework.business.certificate.service.IBzApplyRealnameCertificateService;
import itaf.framework.business.certificate.service.IBzApplySellingCertificateService;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.certificate.BzApplyDistCertificate;
import itaf.framework.domain.certificate.BzApplyRealnameCertificate;
import itaf.framework.domain.certificate.BzApplySellingCertificate;
import itaf.framework.workflow.vo.WorkflowMapDefine;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class JavaTaskService implements JavaDelegate {
	IBzApplyRealnameCertificateService bzApplyRealnameCertificateService;
	
	IBzApplySellingCertificateService bzApplySellingCertificateService;
	
	IBzApplyDistCertificateService bzApplyDistCertificateService;

	public void execute(DelegateExecution execution) throws Exception {
		/*
		 * Long formId = (Long) execution.getVariable(WorkflowMapDefine.FORMID);
		 * String ProcessDefinitionId = (String)
		 * execution.getVariable(WorkflowMapDefine.PROCESSDEFINITIONID); String
		 * finalApprovlState = (String)
		 * execution.getVariable(WorkflowMapDefine.FINALAPPROVALSTATE);
		 * 
		 * bzDailyWorkService =
		 * (IBzDailyWorkService)SpringContextUtil.getBean("bzDailyWorkServiceImpl"
		 * ); bzOtrCreateService =
		 * (IBzOtrCreateService)SpringContextUtil.getBean
		 * ("bzOtrCreateServiceImpl");
		 * 
		 * if(ProcessDefinitionId.equals("firstLevel") ||
		 * ProcessDefinitionId.equals("secondLevel") ||
		 * ProcessDefinitionId.equals("thirdLevel") ){ BzDailyWork bzDailyWork =
		 * bzDailyWorkService.findById(formId); bzDailyWork.setApprovalState(3);
		 * if(finalApprovlState.equals("1")){ bzDailyWork.setStatus("1"); }else{
		 * bzDailyWork.setStatus("0"); } bzDailyWorkService.doSave(bzDailyWork);
		 * }
		 * 
		 * if(ProcessDefinitionId.equals("otr")){ BzOtrCreate bzOtrCreate =
		 * bzOtrCreateService.findById(formId); bzOtrCreate.setApprovalState(3);
		 * if(finalApprovlState.equals("1")){ bzOtrCreate.setStatus("1"); }else{
		 * bzOtrCreate.setStatus("0"); } bzOtrCreateService.doSave(bzOtrCreate);
		 * }
		 */

		Long formId = (Long) execution.getVariable(WorkflowMapDefine.FORMID);
		String finalApprovlState = (String) execution
				.getVariable(WorkflowMapDefine.FINALAPPROVALSTATE);// 最后一次审批 1/0
		String type = (String) execution.getVariable(WorkflowMapDefine.TYPE);
		
		if (type != null) {
			if (type.equals("realname")) {
				bzApplyRealnameCertificateService = (IBzApplyRealnameCertificateService) SpringContextUtil
						.getBean("bzApplyRealnameCertificateServiceImpl");
				BzApplyRealnameCertificate bzApplyRealnameCertificate = bzApplyRealnameCertificateService
						.findById(formId);
				bzApplyRealnameCertificate.setApprovalState(3l);;
				if (finalApprovlState.equals("1")) {
					bzApplyRealnameCertificate.setState("1");
				} else {
					bzApplyRealnameCertificate.setState("0");
				}
				bzApplyRealnameCertificateService.doSupportJavaService(
						bzApplyRealnameCertificate, finalApprovlState);
				
			}else if(type.equals("selling")){
				bzApplySellingCertificateService = (IBzApplySellingCertificateService) SpringContextUtil
						.getBean("bzApplySellingCertificateServiceImpl");
				BzApplySellingCertificate bzApplySellingCertificate = bzApplySellingCertificateService.findById(formId);
				bzApplySellingCertificate.setApprovalState(3l);
				if (finalApprovlState.equals("1")) {
					bzApplySellingCertificate.setState("1");
				} else {
					bzApplySellingCertificate.setState("0");
				}
				bzApplySellingCertificateService.doSupportJavaService(bzApplySellingCertificate, finalApprovlState);
			}else if(type.equals("dist")){
				bzApplyDistCertificateService = (IBzApplyDistCertificateService) SpringContextUtil
						.getBean("bzApplyDistCertificateServiceImpl");
				BzApplyDistCertificate bzApplyDistCertificate = bzApplyDistCertificateService.findById(formId);
				bzApplyDistCertificate.setApprovalState(3l);
				if (finalApprovlState.equals("1")) {
					bzApplyDistCertificate.setState("1");
				} else {
					bzApplyDistCertificate.setState("0");
				}
				bzApplyDistCertificateService.doSupportJavaService(bzApplyDistCertificate, finalApprovlState);
			}
		}
	}
}
