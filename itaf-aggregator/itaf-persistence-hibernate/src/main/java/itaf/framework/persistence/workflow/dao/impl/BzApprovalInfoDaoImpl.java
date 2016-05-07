package itaf.framework.persistence.workflow.dao.impl;

import itaf.framework.domain.workflow.BzApprovalInfo;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.workflow.dao.BzApprovalInfoDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年2月1日
 */
@Repository("approvalInfoDaoImpl")
public class BzApprovalInfoDaoImpl extends BaseDaoImpl<BzApprovalInfo>
		implements BzApprovalInfoDao {

	public List<BzApprovalInfo> findApprovalInfos(String processInstanceId) {
		String hql = "select ai from BzApprovalInfo ai where ai.processInstanceId=:processInstanceId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("processInstanceId", processInstanceId);
		return this.query(hql, params);
	}

}
