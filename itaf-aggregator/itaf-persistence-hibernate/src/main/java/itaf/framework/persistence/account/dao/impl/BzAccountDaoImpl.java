package itaf.framework.persistence.account.dao.impl;

import itaf.framework.domain.account.BzAccount;
import itaf.framework.persistence.account.dao.IBzAccountDao;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("bzAccountDaoImpl")
public class BzAccountDaoImpl extends BaseDaoImpl<BzAccount> implements
		IBzAccountDao {

}