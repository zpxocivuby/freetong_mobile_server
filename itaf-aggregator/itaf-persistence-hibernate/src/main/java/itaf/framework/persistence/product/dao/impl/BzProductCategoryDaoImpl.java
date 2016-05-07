package itaf.framework.persistence.product.dao.impl;

import itaf.framework.domain.product.BzProductCategory;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.product.dao.IBzProductCategoryDao;

import org.springframework.stereotype.Repository;

@Repository("bzProductCategoryDaoImpl")
public class BzProductCategoryDaoImpl extends BaseDaoImpl<BzProductCategory>
		implements IBzProductCategoryDao {

}
