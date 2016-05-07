package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzMerchantRate;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzMerchantRateDao;

import org.springframework.stereotype.Repository;

@Repository("bzMerchantRateDaoImpl")
public class BzMerchantRateDaoImpl extends BaseDaoImpl<BzMerchantRate>
		implements IBzMerchantRateDao {

}