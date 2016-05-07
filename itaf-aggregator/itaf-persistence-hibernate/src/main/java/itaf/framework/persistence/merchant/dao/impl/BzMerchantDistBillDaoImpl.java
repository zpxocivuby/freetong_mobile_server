package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzMerchantDistBill;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzMerchantDistBillDao;

import org.springframework.stereotype.Repository;

@Repository("bzMerchantDistBillDaoImpl")
public class BzMerchantDistBillDaoImpl extends BaseDaoImpl<BzMerchantDistBill>
		implements IBzMerchantDistBillDao {

}