package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzCollectionOrderService;
import itaf.framework.business.merchant.service.IBzDistOrderService;
import itaf.framework.domain.merchant.BzCollectionOrder;
import itaf.framework.persistence.merchant.dao.IBzCollectionOrderDao;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzCollectionOrderServiceImpl")
public class BzCollectionOrderServiceImpl extends BaseServiceImpl implements
		IBzCollectionOrderService {

	@Autowired
	private IBzCollectionOrderDao bzCollectionOrderDao;
	@Autowired
	private IBzDistOrderService bzDistOrderService;

	public BzCollectionOrder getById(Long id) {
		return bzCollectionOrderDao.getById(id);
	}

	public void doSaveOrUpdate(BzCollectionOrder bzCollectionOrder) {
		bzCollectionOrderDao.saveOrUpdate(bzCollectionOrder);
	}

	public void doConfirmCollection(Long bzCollectionOrderId,
			BigDecimal actualAmount) {
		BzCollectionOrder bzCollectionOrder = bzCollectionOrderDao
				.getById(bzCollectionOrderId);
		bzCollectionOrder.setReceivedAmount(actualAmount);
		bzCollectionOrderDao.saveOrUpdate(bzCollectionOrder);// 收款单

		bzDistOrderService.doFinishDist(bzCollectionOrder.getBzDistOrder());// 配送单
	}

}