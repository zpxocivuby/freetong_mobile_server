package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzUserDeliveryAddress;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzUserDeliveryAddressDao;

import org.springframework.stereotype.Repository;

@Repository("bzUserDeliveryAddressDaoImpl")
public class BzUserDeliveryAddressDaoImpl extends
		BaseDaoImpl<BzUserDeliveryAddress> implements IBzUserDeliveryAddressDao {

}