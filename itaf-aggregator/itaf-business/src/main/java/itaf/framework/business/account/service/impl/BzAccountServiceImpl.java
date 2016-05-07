package itaf.framework.business.account.service.impl;

import itaf.framework.business.account.service.IBzAccountService;
import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.domain.account.BzAccount;
import itaf.framework.persistence.account.dao.IBzAccountDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzAccountServiceImpl")
public class BzAccountServiceImpl extends BaseServiceImpl implements
		IBzAccountService {

	@Autowired
	private IBzAccountDao bzAccountDao;

	public void doCreate(BzAccount bzAccount) {
		bzAccountDao.save(bzAccount);
	}

	public void doUpdate(BzAccount bzAccount) {
		bzAccountDao.saveOrUpdate(bzAccount);
	}

	public BzAccount getById(Long bzAccountId) {
		return bzAccountDao.getById(bzAccountId);
	}

	public BzAccount getSystemAccount() {
		return bzAccountDao.getById(0L);
	}

}