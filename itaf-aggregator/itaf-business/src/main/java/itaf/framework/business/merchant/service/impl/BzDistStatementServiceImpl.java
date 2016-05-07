package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.account.service.IBzAccountService;
import itaf.framework.business.merchant.service.IBzDistCompanyService;
import itaf.framework.business.merchant.service.IBzDistOrderService;
import itaf.framework.business.merchant.service.IBzDistStatementService;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.account.BzAccount;
import itaf.framework.domain.merchant.BzDistCompany;
import itaf.framework.domain.merchant.BzDistStatement;
import itaf.framework.domain.merchant.BzDistStatementItem;
import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.exception.bean.BusinessException;
import itaf.framework.persistence.merchant.dao.IBzDistStatementDao;
import itaf.framework.persistence.merchant.dao.IBzDistStatementItemDao;
import itaf.framework.persistence.util.HqlUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzDistStatementServiceImpl")
public class BzDistStatementServiceImpl implements IBzDistStatementService {

	@Autowired
	private IBzDistStatementDao bzDistStatementDao;
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

	public PageResult<BzDistStatement> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] { "b.bzMerchant.id=:bzMerchantId",
				"b.bzMerchant.username like :bzMerchantName",
				"b.bzDistCompany.id=:bzDistCompanyId",
				"b.bzDistCompany.username like :bzDistCompanyName",
				"b.statementSerialNo=:statementSerialNo",
				"b.statementStatus=:statementStatus",
				"b.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from BzDistStatement b";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzDistStatement> result = bzDistStatementDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public void doStartDistStatement(Long bzMerchantId, Long bzDistCompanyId,
			String bzDistStatementItemIds) {

		BigDecimal merchantReceivableAmount = new BigDecimal(0L);
		BigDecimal merchantReceivedAmount = new BigDecimal(0L);
		BigDecimal distCompanyReceivableAmount = new BigDecimal(0L);
		BigDecimal distCompanyReceivedAmount = new BigDecimal(0L);

		List<BzDistStatementItem> bzDistStatementItems = bzDistStatementItemDao
				.findByIds(StringHelper
						.stringToLongList(bzDistStatementItemIds));
		for (BzDistStatementItem bzDistStatementItem : bzDistStatementItems) {
			merchantReceivableAmount = merchantReceivableAmount
					.add(bzDistStatementItem.getMerchantReceivableAmount());
			merchantReceivedAmount = merchantReceivedAmount
					.add(bzDistStatementItem.getMerchantReceivedAmount());
			distCompanyReceivableAmount = distCompanyReceivableAmount
					.add(bzDistStatementItem.getDistCompanyReceivableAmount());
			distCompanyReceivedAmount = distCompanyReceivedAmount
					.add(bzDistStatementItem.getDistCompanyReceivedAmount());
		}

		// 计算金额
		BigDecimal m2dAmount = distCompanyReceivedAmount
				.subtract(distCompanyReceivableAmount);
		// 商家支付配送商
		if (m2dAmount.doubleValue() < 0) {
			BzAccount bzAccountOfMerchant = bzAccountService
					.getById(bzMerchantId);
			if (bzAccountOfMerchant.getAccountBalance().compareTo(
					m2dAmount.abs()) > 0) {
				// 商家扣减金额
				bzAccountOfMerchant.setAccountBalance(bzAccountOfMerchant
						.getAccountBalance().subtract(m2dAmount.abs()));
				bzAccountService.doUpdate(bzAccountOfMerchant);
				// 系统增加临时金额
				BzAccount bzAccountOfSystem = bzAccountService
						.getSystemAccount();
				bzAccountOfSystem.setAccountBalance(bzAccountOfSystem
						.getAccountBalance().add(m2dAmount.abs()));
				bzAccountService.doUpdate(bzAccountOfSystem);
			} else {
				throw new BusinessException("余额不足");
			}
		}

		BzDistStatement bzDistStatement = new BzDistStatement();

		BzMerchant bzMerchant = bzMerchantService.findById(bzMerchantId);
		bzDistStatement.setBzMerchant(bzMerchant);
		BzDistCompany bzDistCompany = bzDistCompanyService
				.findById(bzDistCompanyId);
		bzDistStatement.setBzDistCompany(bzDistCompany);

		// TODO
		bzDistStatement.setStatementSerialNo(new SimpleDateFormat(
				"yyyyMMddHHmmssSSS").format(new Date()));

		bzDistStatement.setMerchantReceivableAmount(merchantReceivableAmount);
		bzDistStatement.setMerchantReceivedAmount(merchantReceivedAmount);
		bzDistStatement
				.setDistCompanyReceivableAmount(distCompanyReceivableAmount);
		bzDistStatement.setDistCompanyReceivedAmount(distCompanyReceivedAmount);

		bzDistStatement.setStatementStatus(2L);

		bzDistStatementDao.saveOrUpdate(bzDistStatement);

		for (BzDistStatementItem bzDistStatementItem : bzDistStatementItems) {
			bzDistStatementItem.setBzDistStatement(bzDistStatement);
			bzDistStatementItem.setStatementStatus(2L);
			bzDistStatementItemDao.saveOrUpdate(bzDistStatementItem);
		}

	}

	public void doAcceptDistStatement(Long bzDistCompanyId,
			Long bzDistStatementId) {
		BzDistStatement bzDistStatement = bzDistStatementDao
				.getById(bzDistStatementId);
		// 金额结算
		BigDecimal m2dAmount = bzDistStatement.getDistCompanyReceivedAmount()
				.subtract(bzDistStatement.getDistCompanyReceivableAmount());
		BzAccount bzAccountOfDistCompany = bzAccountService
				.getById(bzDistCompanyId);
		// 商家支付配送商
		if (m2dAmount.doubleValue() < 0) {
			// 配送商增加金额
			bzAccountOfDistCompany.setAccountBalance(bzAccountOfDistCompany
					.getAccountBalance().add(m2dAmount.abs()));
			bzAccountService.doUpdate(bzAccountOfDistCompany);
			// 系统减少临时金额
			BzAccount bzAccountOfSystem = bzAccountService.getSystemAccount();
			bzAccountOfSystem.setAccountBalance(bzAccountOfSystem
					.getAccountBalance().subtract(m2dAmount.abs()));
			bzAccountService.doUpdate(bzAccountOfSystem);
		} else {
			if (bzAccountOfDistCompany.getAccountBalance().compareTo(
					m2dAmount.abs()) > 0) {
				// 配送商减少金额
				bzAccountOfDistCompany.setAccountBalance(bzAccountOfDistCompany
						.getAccountBalance().subtract(m2dAmount.abs()));
				bzAccountService.doUpdate(bzAccountOfDistCompany);

				BzAccount bzAccountOfMerchant = bzAccountService
						.getById(bzDistStatement.getBzMerchant().getId());
				// 商家增加金额
				bzAccountOfMerchant.setAccountBalance(bzAccountOfMerchant
						.getAccountBalance().add(m2dAmount.abs()));
				bzAccountService.doUpdate(bzAccountOfMerchant);
			} else {
				throw new BusinessException("余额不足");
			}
		}

		Date statementTime = new Date();
		bzDistStatement.setStatementStatus(3L);
		bzDistStatement.setStatementTime(statementTime);
		bzDistStatementDao.saveOrUpdate(bzDistStatement);
		for (BzDistStatementItem bzDistStatementItem : bzDistStatement
				.getBzDistStatementItems()) {
			bzDistStatementItem.setStatementStatus(3L);
			bzDistStatementItem.setStatementTime(statementTime);
			bzDistStatementItemDao.saveOrUpdate(bzDistStatementItem);
		}
	}

	public void doRejectDistStatement(Long bzDistCompanyId,
			Long bzDistStatementId) {
		BzDistStatement bzDistStatement = bzDistStatementDao
				.getById(bzDistStatementId);
		// 金额结算
		BigDecimal m2dAmount = bzDistStatement.getDistCompanyReceivedAmount()
				.subtract(bzDistStatement.getDistCompanyReceivableAmount());
		// 商家支付配送商
		if (m2dAmount.doubleValue() < 0) {
			BzAccount bzAccountOfMerchant = bzAccountService
					.getById(bzDistStatement.getBzMerchant().getId());
			// 商家增加金额
			bzAccountOfMerchant.setAccountBalance(bzAccountOfMerchant
					.getAccountBalance().add(m2dAmount.abs()));
			bzAccountService.doUpdate(bzAccountOfMerchant);
			// 系统减少临时金额
			BzAccount bzAccountOfSystem = bzAccountService.getSystemAccount();
			bzAccountOfSystem.setAccountBalance(bzAccountOfSystem
					.getAccountBalance().subtract(m2dAmount.abs()));
			bzAccountService.doUpdate(bzAccountOfSystem);
		}
		bzDistStatement.setStatementStatus(1L);
		bzDistStatementDao.saveOrUpdate(bzDistStatement);
		for (BzDistStatementItem bzDistStatementItem : bzDistStatement
				.getBzDistStatementItems()) {
			bzDistStatementItem.setStatementStatus(1L);
			bzDistStatementItemDao.saveOrUpdate(bzDistStatementItem);
		}
	}

	public BzDistStatement getById(Long bzDistStatementId) {
		return bzDistStatementDao.getById(bzDistStatementId);
	}

	public BigDecimal getReceivableAmount(Long bzDistCompanyId,
			Long statementStatus) {
		String hql = "select sum(b.distCompanyReceivableAmount) from BzDistStatementItem b where b.bzDistCompany.id=:bzDistCompanyId and b.statementStatus=:statementStatus";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzDistCompanyId", bzDistCompanyId);
		params.put("statementStatus", statementStatus);
		return bzDistStatementDao.sum(hql, params);
	}

	public BigDecimal getRefundAmount(Long bzDistCompanyId, Long statementStatus) {
		String hql = "select sum(b.distCompanyReceivedAmount-b.distCompanyReceivableAmount) from BzDistStatementItem b where b.bzDistCompany.id=:bzDistCompanyId and b.statementStatus=:statementStatus";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzDistCompanyId", bzDistCompanyId);
		params.put("statementStatus", statementStatus);
		return bzDistStatementDao.sum(hql, params);
	}

	public BigDecimal getReceivedAmount(Long bzDistCompanyId) {
		String hql = "select sum(b.distCompanyReceivableAmount) from BzDistStatementItem b where b.bzDistCompany.id=:bzDistCompanyId and b.statementStatus=:statementStatus";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzDistCompanyId", bzDistCompanyId);
		params.put("statementStatus", 3L);
		return bzDistStatementDao.sum(hql, params);
	}

}
