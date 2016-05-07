package itaf.framework.business.platform.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysClientVersionService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.platform.SysClientVersion;
import itaf.framework.persistence.platform.dao.ISysClientVersionDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysClientVersionServiceImpl")
public class SysClientVersionServiceImpl extends BaseServiceImpl implements
		ISysClientVersionService {

	@Autowired
	private ISysClientVersionDao sysClientVersionDao;

	public SysClientVersion getNewVesion(String type) {
		String hql = "select b from SysClientVersion b"
				+ " where b.status='on' and b.publishStatus='published'";
		if (type != null && !type.equals("")) {
			hql += " and type='" + type + "'";
		}
		hql += " order by b.id desc";
		List<SysClientVersion> sysClientVersions = sysClientVersionDao.query(
				hql, null);
		if (sysClientVersions != null && sysClientVersions.size() > 0) {
			return sysClientVersions.get(0);
		}
		return null;
	}

	public List<SysClientVersion> findByStatus(String status) {
		String hsql = "select b from SysClientVersion b where b.status='"
				+ status + "' order by b.id desc";
		List<SysClientVersion> sysClientVersions = sysClientVersionDao.query(
				hsql, null);
		return sysClientVersions;
	}

	public void doSaveOrUpdate(SysClientVersion sysClientVersion) {
		sysClientVersionDao.saveOrUpdate(sysClientVersion);
	}

	public SysClientVersion findById(Long id) {
		return sysClientVersionDao.findById(id);
	}

	public PageResult<SysClientVersion> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] { "b.versionNo like :versionNo",
				"b.status=:status", "b.createdDate>=:startTime",
				"b.createdDate<=:endTime", "b.type like :type" };
		String fromJoinSubClause = "from SysClientVersion b";
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		PageResult<SysClientVersion> result = (PageResult<SysClientVersion>) sysClientVersionDao
				.query(hql, HqlUtils.generateCountHql(hql, null), params,
						startIndex, pageSize);
		return result;
	}

}