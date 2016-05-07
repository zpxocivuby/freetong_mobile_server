package itaf.framework.persistence.workflow.dao;

import itaf.framework.domain.workflow.BzApprovalInfo;
import itaf.framework.persistence.base.dao.IBaseDao;

import java.util.List;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年2月1日
 */
public interface BzApprovalInfoDao extends IBaseDao<BzApprovalInfo> {

	List<BzApprovalInfo> findApprovalInfos(String processInstanceId);

}
