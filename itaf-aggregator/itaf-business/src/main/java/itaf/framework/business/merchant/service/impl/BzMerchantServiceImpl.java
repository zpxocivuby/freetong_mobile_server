package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.core.util.EncryptUtil;
import itaf.framework.domain.certificate.BzMerchantCertificate;
import itaf.framework.domain.merchant.BzDistCompany;
import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.persistence.certificate.dao.IBzMerchantCertificateDao;
import itaf.framework.persistence.merchant.dao.IBzDistCompanyDao;
import itaf.framework.persistence.merchant.dao.IBzMerchantDao;
import itaf.framework.persistence.platform.dao.ISysUserDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("bzMerchantServiceImpl")
public class BzMerchantServiceImpl extends BaseServiceImpl implements
		IBzMerchantService {

	@Autowired
	private IBzMerchantDao bzMerchantDao;
	@Autowired
	private ISysUserDao sysUserDao;
	@Autowired
	private IBzDistCompanyDao bzDistCompanyDao;
	@Autowired
	private IBzMerchantCertificateDao bzMerchantCertificateDao;

	public PageResult<BzMerchant> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] {
				"b.sysUser.username like :username",
				"b.sysUser.mobile=:mobile", "b.sysUser.type=:type",
				"b.sysUser.email=:email", "b.sysUser.nickname like :nickname",
				"b.companyName=:companyName",
				"b.serviceCoverage=:serviceCoverage",
				"b.merchantCategory=:merchantCategory",
				"b.bzServiceProviderType.typeName=:typeName",
				"b.bzServiceProviderType.typeCode=:typeCode",
				"b.markForDelete=:markForDelete", null, null, null, null, null,
				null };
		String fromJoinSubClause = "from BzMerchant b";
		Map<String, Object> params = criteria.getQueryCondition();
		// params.put("type", 2L);
		if (params.containsKey("positionX") && params.containsKey("positionY")) {
			whereBodies[8] = "uda.sysUserId=b.id";
			whereBodies[9] = "uda.bzPositionId=p.id";
			whereBodies[10] = "p.x+b.serviceCoverage/111.31955>=:positionX";
			whereBodies[11] = "p.x-b.serviceCoverage/111.31955<=:positionX";
			whereBodies[12] = "p.y+b.serviceCoverage/1.8553258>=:positionY";
			whereBodies[13] = "p.y-b.serviceCoverage/1.8553258<=:positionY";
			fromJoinSubClause = "from BzMerchant b,BzUserDeliveryAddress uda,BzPosition p";
		}
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzMerchant> result = bzMerchantDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public void doSaveOrUpdate(BzMerchant bzMerchant) {
		Assert.notNull(bzMerchant);
		if (bzMerchant.getId() == null || bzMerchant.getId() <= 0) {
			bzMerchant.setId(null);
		}
		bzMerchantDao.saveOrUpdate(bzMerchant);
	}

	public void doSave(BzMerchant bzMerchant) {
		Assert.notNull(bzMerchant);
		if (bzMerchant.getId() == null || bzMerchant.getId() <= 0) {
			bzMerchant.setId(null);
		}
		bzMerchantDao.save(bzMerchant);
	}

	public BzMerchant findById(Long bzMerchantId) {
		return bzMerchantDao.findById(bzMerchantId);
	}

	public BzMerchant getById(Long bzMerchantId) {
		return bzMerchantDao.getById(bzMerchantId);
	}

	public void doMarkForDelete(BzMerchant bzMerchant) {
		bzMerchant.setMarkForDelete(true);
		bzMerchantDao.saveOrUpdate(bzMerchant);
	}

	public void doMarkForDeleteById(Long bzMerchantId) {
		this.doMarkForDelete(this.findById(bzMerchantId));
	}

	public void doSaveBzMerchant(BzMerchant bzMerchant) {
		Assert.notNull(bzMerchant);
		if (bzMerchant.getId() == null || bzMerchant.getId() <= 0) {
			bzMerchant.setId(null);
		}
		SysUser sysUser = bzMerchant.getSysUser();
		sysUser.setType(20l);
		sysUser.setPassword(EncryptUtil.encodePassword("1234"));
		sysUser.setRealnameCertificateStatus(2L);
		sysUser.getBzRealnameCertificate().setSysUser(sysUser);
		sysUserDao.save(sysUser);
		bzMerchant.setId(sysUser.getId());
		bzMerchant.setCreatedBy(1l);
		bzMerchant.setCertificateStatus(2l);
		bzMerchantDao.save(bzMerchant);
		BzMerchantCertificate bzMerchantCertificate = new BzMerchantCertificate();
		bzMerchantCertificate.setSysUser(sysUser);
		bzMerchantCertificate.setCompanyAddress(bzMerchant.getCompanyAddress());
		bzMerchantCertificate.setCompanyName(bzMerchant.getCompanyName());
		bzMerchantCertificateDao.save(bzMerchantCertificate);

	}

	public void doSaveDistMerchant(BzMerchant bzMerchant) {
		Assert.notNull(bzMerchant);
		if (bzMerchant.getId() == null || bzMerchant.getId() <= 0) {
			bzMerchant.setId(null);
		}
		SysUser sysUser = bzMerchant.getSysUser();
		sysUser.setType(2030l);
		sysUser.setPassword(EncryptUtil.encodePassword("1234"));
		sysUser.setRealnameCertificateStatus(2L);
		sysUser.getBzRealnameCertificate().setSysUser(sysUser);
		sysUserDao.save(sysUser);
		bzMerchant.setId(sysUser.getId());
		bzMerchant.setCreatedBy(1l);
		bzMerchant.setCertificateStatus(2l);
		bzMerchantDao.save(bzMerchant);
		BzMerchantCertificate bzMerchantCertificate = new BzMerchantCertificate();
		bzMerchantCertificate.setSysUser(sysUser);
		bzMerchantCertificate.setCompanyAddress(bzMerchant.getCompanyAddress());
		bzMerchantCertificate.setCompanyName(bzMerchant.getCompanyName());
		bzMerchantCertificateDao.save(bzMerchantCertificate);
		BzDistCompany bzDistCompany = new BzDistCompany();
		bzDistCompany.setId(sysUser.getId());
		bzDistCompany.setCreatedBy(1l);
		bzDistCompany.setCertificateStatus(2l);
		bzDistCompany.setSysUser(sysUser);
		bzDistCompany.setCompanyAddress(bzMerchant.getCompanyAddress());
		bzDistCompany.setCompanyName(bzMerchant.getCompanyName());
		bzDistCompanyDao.save(bzDistCompany);
	}

	public void doUpdateBzMerchant(BzMerchant bzMerchant) {
		SysUser sysUser = bzMerchant.getSysUser();
		sysUserDao.saveOrUpdate(sysUser);
		BzMerchantCertificate bzMerchantCertificate = sysUser
				.getBzMerchantCertificate();
		bzMerchantCertificateDao.saveOrUpdate(bzMerchantCertificate);
		bzMerchantDao.saveOrUpdate(bzMerchant);
	}

	public void doUpdateDistMerchant(BzMerchant bzMerchant) {
		SysUser sysUser = bzMerchant.getSysUser();
		sysUserDao.saveOrUpdate(sysUser);
		BzMerchantCertificate bzMerchantCertificate = sysUser
				.getBzMerchantCertificate();
		bzMerchantCertificateDao.saveOrUpdate(bzMerchantCertificate);
		bzMerchantDao.saveOrUpdate(bzMerchant);
	}

}