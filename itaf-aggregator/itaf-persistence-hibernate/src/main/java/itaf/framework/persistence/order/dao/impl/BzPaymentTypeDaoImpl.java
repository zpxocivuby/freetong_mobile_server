package itaf.framework.persistence.order.dao.impl;

import itaf.framework.domain.order.BzPaymentType;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.order.dao.IBzPaymentTypeDao;

import org.springframework.stereotype.Repository;

@Repository("bzPaymentTypeDaoImpl")
public class BzPaymentTypeDaoImpl extends BaseDaoImpl<BzPaymentType> implements
		IBzPaymentTypeDao {

}