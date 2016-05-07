package itaf.framework.business.account.service;

import itaf.framework.domain.account.BzAccount;

public interface IBzAccountService {

	void doCreate(BzAccount bzAccount);

	void doUpdate(BzAccount bzAccount);

	BzAccount getById(Long bzAccountId);

	BzAccount getSystemAccount();

}
