package itaf.framework.persistence.account.dao.impl;

import itaf.framework.domain.account.BzAccountRecharge;
import itaf.framework.persistence.account.dao.IBzAccountRechargeDao;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("bzAccountRechargeDaoImpl")
public class BzAccountRechargeDaoImpl extends BaseDaoImpl<BzAccountRecharge>
		implements IBzAccountRechargeDao {

}