package itaf.framework.persistence.product.dao.impl;

import itaf.framework.domain.product.BzProductBrand;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.product.dao.IBzProductBrandDao;

import org.springframework.stereotype.Repository;

@Repository("bzProductBrandDaoImpl")
public class BzProductBrandDaoImpl extends BaseDaoImpl<BzProductBrand>
		implements IBzProductBrandDao {

}