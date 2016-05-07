package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzDistCompanyService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.core.util.EncryptUtil;
import itaf.framework.domain.certificate.BzMerchantCertificate;
import itaf.framework.domain.merchant.BzDistCompany;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.persistence.certificate.dao.IBzMerchantCertificateDao;
import itaf.framework.persistence.merchant.dao.IBzDistCompanyDao;
import itaf.framework.persistence.platform.dao.ISysUserDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("bzDistCompanyServiceImpl")
public class BzDistCompanyServiceImpl extends BaseServiceImpl implements
		IBzDistCompanyService {

	@Autowired
	IBzDistCompanyDao bzDistCompanyDao;

	@Autowired
	private ISysUserDao sysUserDao;

	@Autowired
	private IBzMerchantCertificateDao bzMerchantCertificateDao;

	public PageResult<BzDistCompany> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select b";
		String[] whereBodies = new String[] {
				"b.sysUser.username like :username",
				"b.sysUser.mobile=:mobile", "b.sysUser.type=:type",
				"b.sysUser.email=:email", "b.sysUser.nickname like :nickname",
				"b.companyName=:companyName",
				"b.serviceCoverage=:serviceCoverage",
				"b.bzServiceProviderType.typeName=:typeName",
				"b.bzServiceProviderType.typeCode=:typeCode",
				"b.markForDelete=:markForDelete", null, null, null, null, null,
				null };
		String fromJoinSubClause = "from BzDistCompany b";
		Map<String, Object> params = criteria.getQueryCondition();
		// params.put("type", 3L);
		if (params.containsKey("positionX") && params.containsKey("positionY")) {
			whereBodies[8] = "uda.sysUserId=b.id";
			whereBodies[9] = "uda.bzPositionId=p.id";
			whereBodies[10] = "p.x+b.serviceCoverage/111.31955>=:positionX";
			whereBodies[11] = "p.x-b.serviceCoverage/111.31955<=:positionX";
			whereBodies[12] = "p.y+b.serviceCoverage/1.8553258>=:positionY";
			whereBodies[13] = "p.y-b.serviceCoverage/1.8553258<=:positionY";
			fromJoinSubClause = "from BzDistCompany b,BzUserDeliveryAddress uda,BzPosition p";
		}
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<BzDistCompany> result = bzDistCompanyDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public void doSaveOrUpdate(BzDistCompany bzDistCompany) {
		Assert.notNull(bzDistCompany);
		if (bzDistCompany.getId() == null || bzDistCompany.getId() <= 0) {
			bzDistCompany.setId(null);
		}
		bzDistCompanyDao.saveOrUpdate(bzDistCompany);
	}

	public void doSave(BzDistCompany bzDistCompany) {
		Assert.notNull(bzDistCompany);
		if (bzDistCompany.getId() == null || bzDistCompany.getId() <= 0) {
			bzDistCompany.setId(null);
		}
		bzDistCompanyDao.save(bzDistCompany);
	}

	public BzDistCompany findById(Long bzDistCompanyId) {
		return bzDistCompanyDao.findById(bzDistCompanyId);
	}

	public BzDistCompany getById(Long bzDistCompanyId) {
		return bzDistCompanyDao.getById(bzDistCompanyId);
	}

	public void doSaveBzDistCompany(BzDistCompany bzDistCompany) {
		Assert.notNull(bzDistCompany);
		if (bzDistCompany.getId() == null || bzDistCompany.getId() <= 0) {
			bzDistCompany.setId(null);
		}
		SysUser sysUser = bzDistCompany.getSysUser();
		sysUser.setType(30l);
		sysUser.setPassword(EncryptUtil.encodePassword("1234"));
		sysUser.setRealnameCertificateStatus(2L);
		sysUser.getBzRealnameCertificate().setSysUser(sysUser);
		sysUserDao.save(sysUser);
		bzDistCompany.setId(sysUser.getId());
		bzDistCompany.setCreatedBy(1l);
		bzDistCompany.setCertificateStatus(2l);
		BzMerchantCertificate bzMerchantCertificate = new BzMerchantCertificate();
		bzMerchantCertificate.setSysUser(sysUser);
		bzMerchantCertificate.setCompanyAddress(bzDistCompany
				.getCompanyAddress());
		bzMerchantCertificate.setCompanyName(bzDistCompany.getCompanyName());
		bzMerchantCertificateDao.save(bzMerchantCertificate);
		bzDistCompanyDao.save(bzDistCompany);
	}

	public void doUpdateBzDistCompany(BzDistCompany bzDistCompany) {
		SysUser sysUser = bzDistCompany.getSysUser();
		sysUserDao.saveOrUpdate(sysUser);
		BzMerchantCertificate bzMerchantCertificate = sysUser
				.getBzMerchantCertificate();
		bzMerchantCertificateDao.saveOrUpdate(bzMerchantCertificate);
		bzDistCompanyDao.saveOrUpdate(bzDistCompany);
	}

}