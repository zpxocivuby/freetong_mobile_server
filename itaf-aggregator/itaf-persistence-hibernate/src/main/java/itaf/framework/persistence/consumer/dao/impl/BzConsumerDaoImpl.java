package itaf.framework.persistence.consumer.dao.impl;

import itaf.framework.domain.consumer.BzConsumer;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.consumer.dao.IBzConsumerDao;

import org.springframework.stereotype.Repository;

@Repository("bzConsumerDaoImpl")
public class BzConsumerDaoImpl extends BaseDaoImpl<BzConsumer> implements
		IBzConsumerDao {

}