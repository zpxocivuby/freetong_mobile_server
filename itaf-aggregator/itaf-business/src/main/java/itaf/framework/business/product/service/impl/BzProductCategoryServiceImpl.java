package itaf.framework.business.product.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.product.service.IBzProductCategoryService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.product.BzProductCategory;
import itaf.framework.persistence.product.dao.IBzProductCategoryDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzProductCategoryServiceImpl")
public class BzProductCategoryServiceImpl extends BaseServiceImpl implements
		IBzProductCategoryService {

	@Autowired
	private IBzProductCategoryDao bzProductCategoryDao;

	@Override
	public PageResult<BzProductCategory> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select pc";
		String[] whereBodies = new String[] { "pc.parentId=:parentId",
				"pc.categoryName like :typeName",
				"pc.categoryCode like :typeCode",
				"pc.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzProductCategory pc";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzProductCategory> result = bzProductCategoryDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public BzProductCategory getById(Long id) {
		return bzProductCategoryDao.getById(id);
	}

	public List<BzProductCategory> getByIds(List<Long> ids) {
		return bzProductCategoryDao.getByIds(ids);
	}

}