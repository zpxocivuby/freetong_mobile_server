package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzShelf;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzShelfDao;

import org.springframework.stereotype.Repository;

@Repository("bzShelfDaoImpl")
public class BzShelfDaoImpl extends BaseDaoImpl<BzShelf> implements IBzShelfDao {

}