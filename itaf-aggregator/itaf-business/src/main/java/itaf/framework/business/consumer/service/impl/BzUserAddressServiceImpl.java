package itaf.framework.business.consumer.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.consumer.service.IBzUserAddressService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.consumer.BzUserAddress;
import itaf.framework.exception.bean.BusinessException;
import itaf.framework.persistence.consumer.dao.IBzUserAddressDao;
import itaf.framework.persistence.position.dao.IBzPositionDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzUserAddressServiceImpl")
public class BzUserAddressServiceImpl extends BaseServiceImpl implements
		IBzUserAddressService {

	@Autowired
	private IBzUserAddressDao userAddressDao;
	@Autowired
	private IBzPositionDao positionDao;

	public PageResult<BzUserAddress> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] { "b.sysUser.id=:sysUserId",
				"b.addressTag like :addressTag", "b.address like :address",
				"b.contactPerson like :contactPerson",
				"b.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzUserAddress b";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzUserAddress> result = userAddressDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public List<BzUserAddress> findList(Long bzConsumerId) {
		QueryCriteria criteria = new QueryCriteria();
		criteria.addQueryCondition("sysUserId", bzConsumerId);
		criteria.setPageSize(100);
		criteria.setOrderField("b.id");
		criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
		return (List<BzUserAddress>) this.findByCriteria(criteria).getContent();
	}

	private BzUserAddress findById(Long bzUserAddressId) {
		return userAddressDao.findById(bzUserAddressId);
	}

	public BzUserAddress getById(Long bzUserAddressId) {
		return userAddressDao.getById(bzUserAddressId);
	}

	public void doCreate(BzUserAddress bzUserAddress) {
		positionDao.saveOrUpdate(bzUserAddress.getBzPosition());
		bzUserAddress.setBzPositionId(bzUserAddress.getBzPosition().getId());
		userAddressDao.saveOrUpdate(bzUserAddress);
	}

	public void doUpdate(BzUserAddress bzUserAddress) {
		positionDao.saveOrUpdate(bzUserAddress.getBzPosition());
		userAddressDao.saveOrUpdate(bzUserAddress);
	}

	public void doDelete(BzUserAddress bzUserAddress) {
		if (bzUserAddress == null) {
			log.error("没有找到对应的BzUserAddress！");
			throw new BusinessException("BE0008");
		}
		userAddressDao.remove(bzUserAddress);
		positionDao.remove(bzUserAddress.getBzPosition());
	}

	public void doDeleteById(Long bzUserAddressId) {
		this.doDelete(this.findById(bzUserAddressId));
	}

}