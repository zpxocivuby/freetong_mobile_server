package itaf.framework.persistence.position.dao.impl;

import itaf.framework.domain.position.BzPosition;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.position.dao.IBzPositionDao;

import org.springframework.stereotype.Repository;

@Repository("bzPositionDaoImpl")
public class BzPositionDaoImpl extends BaseDaoImpl<BzPosition> implements
		IBzPositionDao {

}