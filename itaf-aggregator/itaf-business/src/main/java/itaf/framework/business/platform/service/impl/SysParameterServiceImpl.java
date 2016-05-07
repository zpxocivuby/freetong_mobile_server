package itaf.framework.business.platform.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysParameterService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.platform.SysParameter;
import itaf.framework.persistence.platform.dao.ISysParameterDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysParameterServiceImpl")
public class SysParameterServiceImpl extends BaseServiceImpl implements
		ISysParameterService {

	public static final String CLOB_CUT_LENGTH = "CLOB_CUT_LENGTH";

	@Autowired
	private ISysParameterDao paramDao = null;

	public SysParameter doCreate(SysParameter tsParameter) {
		paramDao.saveOrUpdate(tsParameter);
		return tsParameter;
	}

	public void doDelete(SysParameter tsParameter) {
		paramDao.remove(tsParameter);
	}

	public SysParameter findById(Long id) {
		return paramDao.findById(id);
	}

	public PageResult<SysParameter> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select parameter";
		String[] whereBodies = new String[] { "parameter.nameEn like :nameEnLike",
				"parameter.nameZh like:nameZhLike" };
		String fromJoinSubClause = "from SysParameter parameter";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<SysParameter> result = (PageResult<SysParameter>) paramDao
				.query(hql, HqlUtils.generateCountHql(hql, null), params,
						startIndex, pageSize);
		return result;
	}

	public SysParameter findByType(String type) {
		if (StringUtils.isEmpty(type)) {
			return null;
		}
		return paramDao.findByType(type);
	}

	public int findClobCutLength() {
		SysParameter parameter = this.findByType(CLOB_CUT_LENGTH);
		int leg = 4000;
		try {
			leg = Integer.parseInt(parameter.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leg > 0 ? leg : 4000;
	}

	public List<SysParameter> findAll() {
		return paramDao.findAll();
	}
}
