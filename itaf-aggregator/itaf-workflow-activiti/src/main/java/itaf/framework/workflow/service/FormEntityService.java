package itaf.framework.workflow.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.workflow.BzFormEntity;

import java.util.List;
import java.util.Set;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年2月7日
 */
public interface FormEntityService {

	PageResult<BzFormEntity> findByCriteria(QueryCriteria queryCriteria);

	BzFormEntity doSave(BzFormEntity formEntity);

	void doDeleteById(Long id);

	BzFormEntity findById(Long id);

	List<BzFormEntity> findByIds(Set<Long> ids);

}
