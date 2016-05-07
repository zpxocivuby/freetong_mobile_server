package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzDistOrderService;
import itaf.framework.business.merchant.service.IBzDistStatementItemService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.merchant.BzDistOrder;
import itaf.framework.persistence.merchant.dao.IBzDistOrderDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzDistOrderServiceImpl")
public class BzDistOrderServiceImpl extends BaseServiceImpl implements
		IBzDistOrderService {

	@Autowired
	private IBzDistOrderDao bzDistOrderDao;
	@Autowired
	private IBzDistStatementItemService bzDistStatementItemService;

	public PageResult<BzDistOrder> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] {
				"b.bzDistCompany.id=:bzDistCompanyId",
				"b.bzDistCompany.username like :bzDistCompanyName",
				"b.bzMerchant.id=:bzMerchantId",
				"b.bzMerchant.username like :bzMerchantName",
				"b.orderSerialNo=:orderSerialNo", "b.orderStatus=:orderStatus",
				"b.distContactPerson=:distContactPerson",
				"b.orderStatementStatus=:orderStatementStatus",
				"b.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzDistOrder b";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzDistOrder> result = bzDistOrderDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public void doSaveOrUpdate(BzDistOrder bzDistOrder) {
		bzDistOrderDao.saveOrUpdate(bzDistOrder);
	}

	public BzDistOrder getById(Long bzDistOrderId) {
		return bzDistOrderDao.findById(bzDistOrderId);
	}

	public List<BzDistOrder> findByIds(String bzDistOrderIds) {
		return bzDistOrderDao.findByIds(StringHelper
				.stringToLongList(bzDistOrderIds));
	}

	public void doStartDist(BzDistOrder bzDistOrder) {
		bzDistOrder.setOrderStatus(2L);
		bzDistOrderDao.saveOrUpdate(bzDistOrder);
	}

	public void doFinishDist(BzDistOrder bzDistOrder) {
		bzDistOrder.setOrderStatus(3L);
		bzDistOrderDao.saveOrUpdate(bzDistOrder);

		// 生成结算单条目
		bzDistStatementItemService.doCreateDistStatementItem(bzDistOrder);
	}

}