package itaf.framework.persistence.product.dao.impl;

import itaf.framework.domain.product.BzProduct;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.product.dao.IBzProductDao;

import org.springframework.stereotype.Repository;

@Repository("bzProductDaoImpl")
public class BzProductDaoImpl extends BaseDaoImpl<BzProduct> implements
		IBzProductDao {

}