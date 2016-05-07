package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzServiceProviderTypeService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzServiceProviderType;
import itaf.framework.persistence.merchant.dao.IBzServiceProviderTypeDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzServiceProviderTypeServiceImpl")
public class BzServiceProviderTypeServiceImpl extends BaseServiceImpl implements
		IBzServiceProviderTypeService {

	@Autowired
	private IBzServiceProviderTypeDao bzServiceProviderTypeDao;

	@Override
	public PageResult<BzServiceProviderType> findByCriteria(
			QueryCriteria criteria) {
		String queryEntry = "select spt";
		String[] whereBodies = new String[] { "spt.parentId=:parentId",
				"spt.typeName like :typeName",
				"spt.typeCode like :typeCode",
				"spt.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzServiceProviderType spt";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzServiceProviderType> result = bzServiceProviderTypeDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}
	
	public List<BzServiceProviderType> findByUpdateTime(Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "select b from BzServiceProviderType b where b.markForDelete = 0 ";
		if (date != null) {
			hql += " and b.updatedDate>=:date ";
			params.put("date", date);
		}
		hql += " order by b.updatedDate asc,b.id asc ";
		List<BzServiceProviderType> bzServiceProviderTypeList = bzServiceProviderTypeDao
				.query(hql, params);
		return bzServiceProviderTypeList;
	}
	
}