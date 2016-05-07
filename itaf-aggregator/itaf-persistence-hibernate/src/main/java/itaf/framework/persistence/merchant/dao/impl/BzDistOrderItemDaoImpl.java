package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzDistOrderItem;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzDistOrderItemDao;

import org.springframework.stereotype.Repository;

@Repository("bzDistOrderItemDaoImpl")
public class BzDistOrderItemDaoImpl extends BaseDaoImpl<BzDistOrderItem>
		implements IBzDistOrderItemDao {

}