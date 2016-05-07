package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzCollectionOrder;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzCollectionOrderDao;

import org.springframework.stereotype.Repository;

@Repository("bzCollectionOrderDaoImpl")
public class BzCollectionOrderDaoImpl extends BaseDaoImpl<BzCollectionOrder>
		implements IBzCollectionOrderDao {

}