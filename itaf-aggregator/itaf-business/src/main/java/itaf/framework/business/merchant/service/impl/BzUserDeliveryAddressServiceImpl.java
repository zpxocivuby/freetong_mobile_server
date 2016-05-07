package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzUserDeliveryAddressService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzUserDeliveryAddress;
import itaf.framework.exception.bean.BusinessException;
import itaf.framework.persistence.merchant.dao.IBzUserDeliveryAddressDao;
import itaf.framework.persistence.position.dao.IBzPositionDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzUserDeliveryAddressServiceImpl")
public class BzUserDeliveryAddressServiceImpl extends BaseServiceImpl implements
		IBzUserDeliveryAddressService {

	@Autowired
	private IBzUserDeliveryAddressDao userAddressDao;
	@Autowired
	private IBzPositionDao positionDao;

	@Override
	public PageResult<BzUserDeliveryAddress> findByCriteria(
			QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] { "b.sysUser.id=:sysUserId",
				"b.addressTag like :addressTag", "b.address like :address",
				"b.contactPerson like :contactPerson",
				"b.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzUserDeliveryAddress b";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzUserDeliveryAddress> result = userAddressDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	@Override
	public List<BzUserDeliveryAddress> findList(Long bzMerchantId) {
		QueryCriteria criteria = new QueryCriteria();
		criteria.addQueryCondition("sysUserId", bzMerchantId);
		criteria.setPageSize(100);
		criteria.setOrderField("b.id");
		criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
		return (List<BzUserDeliveryAddress>) this.findByCriteria(criteria)
				.getContent();
	}

	private BzUserDeliveryAddress findById(Long bzUserDeliveryAddressId) {
		return userAddressDao.findById(bzUserDeliveryAddressId);
	}

	public BzUserDeliveryAddress getById(Long bzUserDeliveryAddressId) {
		return userAddressDao.getById(bzUserDeliveryAddressId);
	}

	public void doCreate(BzUserDeliveryAddress bzUserDeliveryAddress) {
		positionDao.saveOrUpdate(bzUserDeliveryAddress.getBzPosition());
		bzUserDeliveryAddress.setBzPositionId(bzUserDeliveryAddress
				.getBzPosition().getId());
		userAddressDao.saveOrUpdate(bzUserDeliveryAddress);
	}

	public void doUpdate(BzUserDeliveryAddress bzUserDeliveryAddress) {
		userAddressDao.saveOrUpdate(bzUserDeliveryAddress);
	}

	public void doDelete(BzUserDeliveryAddress bzUserDeliveryAddress) {
		if (bzUserDeliveryAddress == null) {
			log.error("没有找到对应的BzUserDeliveryAddress！");
			throw new BusinessException("BE0008");
		}
		userAddressDao.remove(bzUserDeliveryAddress);
		positionDao.remove(bzUserDeliveryAddress.getBzPosition());
	}

	public void doDeleteById(Long bzUserDeliveryAddressId) {
		this.doDelete(this.findById(bzUserDeliveryAddressId));
	}

}