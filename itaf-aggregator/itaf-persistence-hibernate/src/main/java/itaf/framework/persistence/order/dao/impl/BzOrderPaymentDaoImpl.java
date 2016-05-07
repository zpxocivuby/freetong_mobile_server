package itaf.framework.persistence.order.dao.impl;

import itaf.framework.domain.order.BzOrderPayment;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.order.dao.IBzOrderPaymentDao;

import org.springframework.stereotype.Repository;

@Repository("bzOrderPaymentDaoImpl")
public class BzOrderPaymentDaoImpl extends BaseDaoImpl<BzOrderPayment>
		implements IBzOrderPaymentDao {

}