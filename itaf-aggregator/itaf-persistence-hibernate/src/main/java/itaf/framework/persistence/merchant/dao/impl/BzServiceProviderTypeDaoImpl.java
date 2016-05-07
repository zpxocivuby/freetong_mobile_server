package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzServiceProviderType;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzServiceProviderTypeDao;

import org.springframework.stereotype.Repository;

@Repository("bzServiceProviderTypeDaoImpl")
public class BzServiceProviderTypeDaoImpl extends
		BaseDaoImpl<BzServiceProviderType> implements IBzServiceProviderTypeDao {

}