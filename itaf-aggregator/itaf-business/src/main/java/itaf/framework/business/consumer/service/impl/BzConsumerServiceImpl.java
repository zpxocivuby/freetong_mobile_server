package itaf.framework.business.consumer.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.consumer.service.IBzConsumerService;
import itaf.framework.core.util.EncryptUtil;
import itaf.framework.domain.consumer.BzConsumer;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.persistence.consumer.dao.IBzConsumerDao;
import itaf.framework.persistence.platform.dao.ISysUserDao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("bzConsumerServiceImpl")
public class BzConsumerServiceImpl extends BaseServiceImpl implements
		IBzConsumerService {

	@Autowired
	private ISysUserDao sysUserDao;
	@Autowired
	private IBzConsumerDao bzConsumerDao;

	public void doSaveOrUpdate(BzConsumer bzConsumer) {
		Assert.notNull(bzConsumer);
		if (bzConsumer.getId() == null || bzConsumer.getId() <= 0) {
			bzConsumer.setId(null);
		}
		bzConsumerDao.saveOrUpdate(bzConsumer);
	}

	public BzConsumer getById(Long bzConsumerId) {
		return bzConsumerDao.getById(bzConsumerId);
	}

	public BzConsumer doRegister(String username, String password, String mobile) {
		SysUser sysUser = new SysUser();
		sysUser.setMobile(mobile);
		sysUser.setPassword(EncryptUtil.encodePassword(password));
		sysUser.setType(10L);
		sysUser.setUsername(username);
		sysUser.setRealnameCertificateStatus(-1L);
		sysUserDao.saveOrUpdate(sysUser);

		BzConsumer bzConsumer = new BzConsumer();
		bzConsumer.setId(sysUser.getId());
		bzConsumer.setSysUser(sysUser);
		bzConsumer.setCreatedBy(1l);
		bzConsumer.setCreatedDate(new Date());
		bzConsumer.setMarkForDelete(false);
		bzConsumerDao.save(bzConsumer);

		return bzConsumer;
	}
	
	public void doSaveBzConsumer(BzConsumer bzConsumer) {
		Assert.notNull(bzConsumer);
		if (bzConsumer.getId() == null || bzConsumer.getId() <= 0) {
			bzConsumer.setId(null);
		}
		SysUser sysUser = bzConsumer.getSysUser();
		sysUser.setType(10l);
		sysUser.setPassword(EncryptUtil.encodePassword("1234"));
		sysUser.setRealnameCertificateStatus(2L);
		sysUser.getBzRealnameCertificate().setSysUser(sysUser);
		sysUserDao.save(sysUser);
		bzConsumer.setId(sysUser.getId());
		bzConsumer.setCreatedBy(1l);
		bzConsumerDao.save(bzConsumer);
	}
	
	public void doUpdateBzConsumer(BzConsumer bzConsumer) {
		SysUser sysUser = bzConsumer.getSysUser();
		sysUserDao.saveOrUpdate(sysUser);
	}

}