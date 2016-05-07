package itaf.framework.persistence.consumer.dao.impl;

import itaf.framework.domain.consumer.BzShoppingGuide;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.consumer.dao.IBzShoppingGuideDao;

import org.springframework.stereotype.Repository;

@Repository("bzShoppingGuideDaoImpl")
public class BzShoppingGuideDaoImpl extends BaseDaoImpl<BzShoppingGuide>
		implements IBzShoppingGuideDao {

}