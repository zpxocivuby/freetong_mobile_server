package itaf.framework.persistence.consumer.dao.impl;

import itaf.framework.domain.consumer.BzUserAddress;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.consumer.dao.IBzUserAddressDao;

import org.springframework.stereotype.Repository;

@Repository("bzUserAddressDaoImpl")
public class BzUserAddressDaoImpl extends
		BaseDaoImpl<BzUserAddress> implements
		IBzUserAddressDao {

}