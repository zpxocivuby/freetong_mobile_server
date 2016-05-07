package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.account.service.IBzAccountService;
import itaf.framework.business.merchant.service.IBzDistCompanyService;
import itaf.framework.business.merchant.service.IBzDistOrderService;
import itaf.framework.business.merchant.service.IBzDistStatementItemService;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzDistOrder;
import itaf.framework.domain.merchant.BzDistStatementItem;
import itaf.framework.persistence.merchant.dao.IBzDistStatementItemDao;
import itaf.framework.persistence.util.HqlUtils;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzDistStatementItemServiceImpl")
public class BzDistStatementServiceItemImpl implements
		IBzDistStatementItemService {

	@Autowired
	private IBzDistStatementItemDao bzDistStatementItemDao;
	@Autowired
	private IBzDistOrderService bzDistOrderService;
	@Autowired
	private IBzMerchantService bzMerchantService;
	@Autowired
	private IBzDistCompanyService bzDistCompanyService;
	@Autowired
	private IBzAccountService bzAccountService;

	public PageResult<BzDistStatementItem> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] {
				"b.bzDistStatement.id=:bzDistStatementId",
				"b.bzDistOrder.id=:bzDistOrderId",
				"b.bzMerchant.id=:bzMerchantId",
				"b.bzMerchant.username like :bzMerchantName",
				"b.bzDistCompany.id=:bzDistCompanyId",
				"b.bzDistCompany.username like :bzDistCompanyName",
				"b.statementStatus=:statementStatus",
				"b.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzDistStatementItem b";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzDistStatementItem> result = bzDistStatementItemDao.query(
				hql, HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public void doCreateDistStatementItem(BzDistOrder bzDistOrder) {
		BzDistStatementItem bzDistStatementItem = new BzDistStatementItem();
		bzDistStatementItem.setBzDistOrder(bzDistOrder);
		bzDistStatementItem.setBzMerchant(bzDistOrder.getBzMerchant());
		bzDistStatementItem.setBzDistCompany(bzDistOrder.getBzDistCompany());
		// bzDistStatement.setStatementSerialNo(new SimpleDateFormat(
		// "yyyyMMddHHmmssSSS").format(new Date()));
		bzDistStatementItem.setStatementStatus(1L);
		BigDecimal distAmount = bzDistOrder.getBzCollectionOrder()
				.getDistAmount();
		BigDecimal receivableAmount = bzDistOrder.getBzCollectionOrder()
				.getReceivableAmount();
		if (1 == bzDistOrder.getBzOrder().getBzOrderPayment()
				.getBzPaymentTypeId()) {
			bzDistStatementItem.setMerchantReceivableAmount(receivableAmount
					.subtract(distAmount));
			bzDistStatementItem.setMerchantReceivedAmount(new BigDecimal(0L));
			bzDistStatementItem.setDistCompanyReceivableAmount(distAmount);
			bzDistStatementItem.setDistCompanyReceivedAmount(receivableAmount);
		} else {
			bzDistStatementItem.setMerchantReceivableAmount(receivableAmount
					.subtract(distAmount));
			bzDistStatementItem.setMerchantReceivedAmount(receivableAmount);
			bzDistStatementItem.setDistCompanyReceivableAmount(distAmount);
			bzDistStatementItem
					.setDistCompanyReceivedAmount(new BigDecimal(0L));
		}
		bzDistStatementItemDao.saveOrUpdate(bzDistStatementItem);
	}

}
