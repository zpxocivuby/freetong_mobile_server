package itaf.framework.workflow.service.impl;

import itaf.framework.domain.workflow.BzApprovalInfo;
import itaf.framework.persistence.workflow.dao.BzApprovalInfoDao;
import itaf.framework.workflow.base.service.impl.BaseServiceImpl;
import itaf.framework.workflow.service.ApprovalInfoService;
import itaf.framework.workflow.vo.ApprovalInfoVo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年2月1日
 */
@Service("approvalInfoServiceImpl")
public class ApprovalInfoServiceImpl extends BaseServiceImpl implements
		ApprovalInfoService {

	@Autowired
	private BzApprovalInfoDao approvalInfoDao;

	public List<BzApprovalInfo> findByProcessInstanceId(String processInstanceId) {
		List<BzApprovalInfo> approvalInfos = approvalInfoDao
				.findApprovalInfos(processInstanceId);
		return approvalInfos;
	}

	public List<ApprovalInfoVo> findApprovalInfos(String processInstanceId) {
		List<ApprovalInfoVo> result = new ArrayList<ApprovalInfoVo>();
		List<BzApprovalInfo> approvalInfos = approvalInfoDao
				.findApprovalInfos(processInstanceId);
		if (approvalInfos != null && approvalInfos.size() > 0) {
			try {
				for (BzApprovalInfo approvalInfo : approvalInfos) {
					ApprovalInfoVo vo = new ApprovalInfoVo();
					BeanUtils.copyProperties(vo, approvalInfo);
					result.add(vo);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public void doSaveObjects(List<BzApprovalInfo> approvalInfos) {
		approvalInfoDao.saveOrUpdateAll(approvalInfos);
	}

	public void doSaveObject(BzApprovalInfo approvalInfo) {
		approvalInfoDao.saveOrUpdate(approvalInfo);
	}

	public BzApprovalInfo getApprovalInfoById(Long approvalInfoId) {
		return approvalInfoDao.findById(approvalInfoId);
	}

	public BzApprovalInfo getApprovalInfoByTaskId(String taskId) {
		BzApprovalInfo approvalInfo = new BzApprovalInfo();
		approvalInfo.setTaskId(taskId);
		List<BzApprovalInfo> approvalInfoList = approvalInfoDao.find(approvalInfo);
		//String hql = "from BzApprovalInfo b where b.taskId="+taskId;
		//List<BzApprovalInfo> approvalInfoList = approvalInfoDao.query(hql, new HashMap());
		
		if (approvalInfoList == null || approvalInfoList.size() == 0) {
			return null;
		} else {
			return approvalInfoList.get(0);
		}
	}

	public void doSaveApprove(HistoricProcessInstance processInstance,
			Task task, String approvalInfo, Long userId) {
		BzApprovalInfo approval = this.getApprovalInfoByTaskId(task.getId());
		BzApprovalInfo approvalObject;
		// 新建
		if (approval == null) {
			approvalObject = new BzApprovalInfo();
			approvalObject.setActivityName(task.getName());
			approvalObject.setApprovalName(String.valueOf(userId));
			approvalObject.setApprovalInfo(approvalInfo);
			approvalObject.setApprovalState("通过");
			approvalObject.setTaskId(task.getId());
			approvalObject.setProcessInstanceId(processInstance.getId());
			approvalObject.setBussinessKey(processInstance.getBusinessKey());
			approvalObject.setApprovalTime(new Date());
		} else {
			approvalObject = this.getApprovalInfoById(approval.getId());
			approvalObject.setApprovalInfo(approvalInfo);
			approvalObject.setApprovalTime(new Date());
			approvalObject.setApprovalState("通过");
		}
		this.doSaveObject(approvalObject);
	}

	public void doSaveReject(HistoricProcessInstance processInstance,
			Task task, String approvalInfo, Long userId) {
		BzApprovalInfo approval = this.getApprovalInfoByTaskId(task.getId());
		BzApprovalInfo approvalObject;
		// 新建
		if (approval == null) {
			approvalObject = new BzApprovalInfo();
			approvalObject.setActivityName(task.getName());
			approvalObject.setApprovalName(String.valueOf(userId));
			approvalObject.setApprovalInfo(approvalInfo);
			approvalObject.setApprovalState("退回");
			approvalObject.setTaskId(task.getId());
			approvalObject.setProcessInstanceId(processInstance.getId());
			approvalObject.setBussinessKey(processInstance.getBusinessKey());
			approvalObject.setApprovalTime(new Date());
		} else {
			approvalObject = this.getApprovalInfoById(approval.getId());
			approvalObject.setApprovalInfo(approvalInfo);
			approvalObject.setApprovalTime(new Date());
			approvalObject.setApprovalState("退回");
		}
		this.doSaveObject(approvalObject);
	}

}
