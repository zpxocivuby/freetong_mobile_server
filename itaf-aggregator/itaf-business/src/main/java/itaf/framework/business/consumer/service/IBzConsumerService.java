package itaf.framework.business.consumer.service;

import itaf.framework.domain.consumer.BzConsumer;

public interface IBzConsumerService {

	public void doSaveOrUpdate(BzConsumer bzConsumer);

	public BzConsumer getById(Long bzConsumerId);

	public BzConsumer doRegister(String username, String password, String mobile);
	
	public void doSaveBzConsumer(BzConsumer bzConsumer);
	
	public void doUpdateBzConsumer(BzConsumer bzConsumer);

}
