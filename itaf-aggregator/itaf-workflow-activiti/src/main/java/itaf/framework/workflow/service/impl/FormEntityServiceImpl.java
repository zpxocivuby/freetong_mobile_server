package itaf.framework.workflow.service.impl;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.workflow.BzFormEntity;
import itaf.framework.persistence.util.HqlUtils;
import itaf.framework.persistence.workflow.dao.BzFormEntityDao;
import itaf.framework.workflow.base.service.impl.BaseServiceImpl;
import itaf.framework.workflow.service.FormEntityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年2月7日
 */
@Service("formEntityServiceImpl")
public class FormEntityServiceImpl extends BaseServiceImpl implements
		FormEntityService {

	@Autowired
	private BzFormEntityDao formEntityDao;

	public PageResult<BzFormEntity> findByCriteria(QueryCriteria queryCriteria) {
		String queryEntry = "select fe ";
		String fromJoinSubClause = " from FormEntity fe ";
		String[] whereBodies = new String[] { "fe.createdBy = :userId",
				"fe.approvalState = :approvalState", "fe.title like :title",
				"fe.createdDate >= :startDate", "fe.createdDate <= :endDate",
				"fe.processDefinitionId = :processDefinitionId",
				"fe.markForDelete = :markForDelete" };
		Map<String, Object> params = queryCriteria.getQueryCondition();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, "fe.id", "desc", params);
		PageResult<BzFormEntity> result = formEntityDao.query(hql.toString(),
				HqlUtils.generateCountHql(hql.toString(), null), params,
				queryCriteria.getStartIndex(), queryCriteria.getPageSize());
		return result;
	}

	public BzFormEntity doSave(BzFormEntity formEntity) {
		formEntityDao.saveOrUpdate(formEntity);
		return formEntity;
	}

	public void doDeleteById(Long id) {
		BzFormEntity formEntity = formEntityDao.findById(id);
		formEntity.setMarkForDelete(true);
		formEntityDao.saveOrUpdate(formEntity);
	}

	public BzFormEntity findById(Long id) {
		return formEntityDao.findById(id);
	}

	public List<BzFormEntity> findByIds(Set<Long> ids) {
		String hql = "select fe from BzFormEntity fe where fe.id in (:ids)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		return formEntityDao.query(hql, params);
	}
}
