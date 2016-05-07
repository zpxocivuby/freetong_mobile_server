package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzStock;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzStockDao;

import org.springframework.stereotype.Repository;

@Repository("bzStockDaoImpl")
public class BzStockDaoImpl extends BaseDaoImpl<BzStock> implements IBzStockDao {

}