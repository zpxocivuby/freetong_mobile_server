package itaf.framework.business.certificate.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.certificate.service.IBzApplyRealnameCertificateService;
import itaf.framework.business.common.service.IBzAttachmentService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.domain.certificate.BzApplyRealnameCertificate;
import itaf.framework.domain.certificate.BzRealnameCertificate;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.persistence.certificate.dao.IBzApplyRealnameCertificateDao;
import itaf.framework.persistence.certificate.dao.IBzRealnameCertificateDao;
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

@Service("bzApplyRealnameCertificateServiceImpl")
public class BzApplyRealnameCertificateServiceImpl extends BaseServiceImpl
		implements IBzApplyRealnameCertificateService {

	@Autowired
	private IBzApplyRealnameCertificateDao bzApplyRealnameCertificateDao;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private IBzAttachmentService bzAttachmentService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	WorkflowProcessService workflowProcessService;
	@Autowired
	private IBzRealnameCertificateDao bzRealnameCertificateDao;

	public void doSubmitApply(
			BzApplyRealnameCertificate bzApplyRealnameCertificate) {
		bzApplyRealnameCertificateDao.saveOrUpdate(bzApplyRealnameCertificate);
		//bzAttachmentService.doMarkForValid(bzApplyRealnameCertificate.getBzAttachmentId());
		SysUser sysUser = sysUserService.getById(bzApplyRealnameCertificate
				.getSysUserId());
		sysUser.setRealnameCertificateStatus(1L);
		sysUserService.doUpdate(sysUser);
		////////////////////////////////////////////////////
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(WorkflowMapDefine.CLASSNAME, bzApplyRealnameCertificate.getFormType());
		variables.put(WorkflowMapDefine.PAGEURL, bzApplyRealnameCertificate.getPageUrl());
		variables.put(WorkflowMapDefine.FORMID, bzApplyRealnameCertificate.getId());
		variables.put(WorkflowMapDefine.PROCESSDEFINITIONID, bzApplyRealnameCertificate.getProcessDefinitionId());
		variables.put(WorkflowMapDefine.FINALAPPROVALSTATE, "NO");
		variables.put(WorkflowMapDefine.FIRSTAPPROVAL, String.valueOf(bzApplyRealnameCertificate.getFirstApprovalID()));
		variables.put(WorkflowMapDefine.SECONDAPPROVAL, String.valueOf(bzApplyRealnameCertificate.getSecondApprovalID()));
		variables.put(WorkflowMapDefine.TYPE, "realname");
		String processInstanceId = workFlowService.doStartWorkflow(
				String.valueOf(bzApplyRealnameCertificate.getSysUserId()), bzApplyRealnameCertificate.getProcessDefinitionId(),
				bzApplyRealnameCertificate.getId().toString(), variables);
		//回填更新
		bzApplyRealnameCertificate.setProcessInstanceId(processInstanceId);
		bzApplyRealnameCertificate.setApprovalState(FormConstants.FORM_STATE_RUNNING);
		bzApplyRealnameCertificate.setSubmitTime(new Date());
		bzApplyRealnameCertificateDao.save(bzApplyRealnameCertificate);
	}

	public BzApplyRealnameCertificate getByBzConsumerId(Long bzConsumerId) {
		String hql = "from BzApplyRealnameCertificate b where b.sysUserId=:sysUserId and b.markForDelete=:markForDelete order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sysUserId", bzConsumerId);
		params.put("markForDelete", false);
		List<BzApplyRealnameCertificate> list = bzApplyRealnameCertificateDao
				.query(hql, params);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public BzApplyRealnameCertificate findById(Long id){
		return bzApplyRealnameCertificateDao.findById(id);
	}
	
	public void doSupportJavaService(BzApplyRealnameCertificate bzApplyRealnameCertificate, String finalApprovlState){
		if(finalApprovlState.equals("1")){
			bzApplyRealnameCertificate.setState("1");
			BzRealnameCertificate bzRealnameCertificate = new BzRealnameCertificate();
			bzRealnameCertificate.setBzRealnameCertificateApply(bzApplyRealnameCertificate);
			bzRealnameCertificate.setName(bzApplyRealnameCertificate.getName());
			bzRealnameCertificate.setSex(bzApplyRealnameCertificate.getSex());
			bzRealnameCertificate.setBirthdate(bzApplyRealnameCertificate.getBirthdate());
			bzRealnameCertificate.setMobile(bzApplyRealnameCertificate.getMobile());
			bzRealnameCertificate.setIdType(bzApplyRealnameCertificate.getIdType());
			bzRealnameCertificate.setIdNo(bzApplyRealnameCertificate.getIdNo());
			bzRealnameCertificateDao.save(bzRealnameCertificate);
		}else{
			bzApplyRealnameCertificate.setState("0");
		}
		bzApplyRealnameCertificateDao.saveOrUpdate(bzApplyRealnameCertificate);
	}

}