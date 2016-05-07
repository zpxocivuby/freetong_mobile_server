package itaf.framework.business.platform.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysClientPublishService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.platform.SysClientPublish;
import itaf.framework.domain.platform.SysClientVersion;
import itaf.framework.persistence.platform.dao.ISysClientPublishDao;
import itaf.framework.persistence.platform.dao.ISysClientVersionDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysClientPublishServiceImpl")
public class SysClientPublishServiceImpl extends BaseServiceImpl implements
		ISysClientPublishService {

	@Autowired
	private ISysClientPublishDao sysClientPublishDao;
	@Autowired
	private ISysClientVersionDao sysClientVersionDao;

	public PageResult<SysClientPublish> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] {
				"b.sysClientVersion.versionNo like :versionNo",
				"b.publishStatus=:publishStatus", "b.createdDate>=:startTime",
				"b.createdDate<=:endTime", "b.sysClientVersion.status='on'",
				"b.sysClientVersion.type=:type" };
		String fromJoinSubClause = "from SysClientPublish b";
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		PageResult<SysClientPublish> result = (PageResult<SysClientPublish>) sysClientPublishDao
				.query(hql, HqlUtils.generateCountHql(hql, null), params,
						startIndex, pageSize);
		return result;
	}

	public SysClientPublish findById(Long id) {
		return sysClientPublishDao.findById(id);
	}

	public void doSaveOrUpdate(SysClientPublish clientPublicOpInfo) {
		sysClientPublishDao.saveOrUpdate(clientPublicOpInfo);
	}

	public void doPublish(SysClientPublish sysClientPublish) {
		SysClientVersion sysClientVersion = sysClientPublish
				.getSysClientVersion();
		sysClientVersion.setPublishStatus(SysClientPublish.PUBLISHED);
		sysClientVersionDao.saveOrUpdate(sysClientVersion);

		for (SysClientPublish temp : sysClientVersion.getSysClientPublishs()) {
			if (temp.getPublishStatus().equals(SysClientPublish.PUBLISHED)) {
				temp.setPublishStatus(SysClientPublish.ABANDONED);
			}
		}

		sysClientPublish.setSysClientVersion(sysClientVersion);
		sysClientPublish.setPublishStatus(SysClientPublish.PUBLISHED);
		sysClientPublish.setPublishTime(new Date());
		sysClientPublishDao.saveOrUpdate(sysClientPublish);
	}

	public void doAbandon(SysClientPublish sysClientPublish) {
		SysClientVersion sysClientVersion = sysClientPublish
				.getSysClientVersion();
		sysClientVersion.setPublishStatus(SysClientPublish.ABANDONED);
		sysClientVersionDao.saveOrUpdate(sysClientVersion);

		sysClientPublish.setPublishStatus(SysClientPublish.ABANDONED);
		sysClientPublishDao.saveOrUpdate(sysClientPublish);
	}

}