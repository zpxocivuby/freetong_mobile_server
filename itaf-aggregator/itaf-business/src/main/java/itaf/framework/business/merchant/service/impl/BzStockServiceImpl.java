package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzStockService;
import itaf.framework.domain.merchant.BzStock;
import itaf.framework.persistence.merchant.dao.IBzStockDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzStockServiceImpl")
public class BzStockServiceImpl extends BaseServiceImpl implements
		IBzStockService {

	@Autowired
	private IBzStockDao bzStockDao;

	public void doSaveOrUpdate(BzStock bzStock) {
		bzStockDao.saveOrUpdate(bzStock);
	}

}