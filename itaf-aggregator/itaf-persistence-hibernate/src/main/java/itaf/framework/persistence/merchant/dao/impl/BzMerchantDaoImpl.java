package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzMerchantDao;

import org.springframework.stereotype.Repository;

@Repository("bzMerchantDaoImpl")
public class BzMerchantDaoImpl extends BaseDaoImpl<BzMerchant> implements
		IBzMerchantDao {

}