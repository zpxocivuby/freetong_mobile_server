package itaf.framework.workflow.service;

import itaf.framework.domain.workflow.BzApprovalInfo;
import itaf.framework.workflow.vo.ApprovalInfoVo;

import java.util.List;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;


/**
 * 
 * @author XINXIN
 * 
 * @update 2013年2月1日
 */
public interface ApprovalInfoService {
	
	public List<ApprovalInfoVo> findApprovalInfos(String processInstanceId);
	
	public List<BzApprovalInfo> findByProcessInstanceId(String processInstanceId);

	public void doSaveObjects(List<BzApprovalInfo> approvalInfos);
	
	public void doSaveObject(BzApprovalInfo approvalInfo);
	
	public BzApprovalInfo getApprovalInfoById(Long approvalInfoId);
	
	public BzApprovalInfo getApprovalInfoByTaskId(String taskId);
	
	public void doSaveApprove(HistoricProcessInstance processInstance,Task task, String approvalInfo, Long userId);
	
	public void doSaveReject(HistoricProcessInstance processInstance,Task task, String approvalInfo, Long userId);
}
