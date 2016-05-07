package itaf.framework.business.account.service.impl;

import itaf.framework.business.account.service.IBzAccountRechargeService;
import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.domain.account.BzAccountRecharge;
import itaf.framework.persistence.account.dao.IBzAccountRechargeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzAccountRechargeServiceImpl")
public class BzAccountRechargeServiceImpl extends BaseServiceImpl implements
		IBzAccountRechargeService {

	@Autowired
	private IBzAccountRechargeDao bzAccountRechargeDao;

	public BzAccountRecharge getById(Long bzAccountRechargeId) {
		return bzAccountRechargeDao.getById(bzAccountRechargeId);
	}

}