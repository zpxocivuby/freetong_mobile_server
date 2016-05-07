package itaf.framework.business.order.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.order.service.IBzOrderPaymentService;
import itaf.framework.domain.order.BzOrderPayment;
import itaf.framework.persistence.order.dao.IBzOrderPaymentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzOrderPaymentServiceImpl")
public class BzOrderPaymentServiceImpl extends BaseServiceImpl implements
		IBzOrderPaymentService {

	@Autowired
	private IBzOrderPaymentDao bzOrderPaymentDao;

	public void saveOrUpdate(BzOrderPayment bzOrderPayment) {
		bzOrderPaymentDao.saveOrUpdate(bzOrderPayment);
	}

}