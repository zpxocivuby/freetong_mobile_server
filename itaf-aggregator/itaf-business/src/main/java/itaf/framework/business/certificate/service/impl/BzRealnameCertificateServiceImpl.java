package itaf.framework.business.certificate.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.certificate.service.IBzRealnameCertificateService;
import itaf.framework.domain.certificate.BzRealnameCertificate;
import itaf.framework.persistence.certificate.dao.IBzRealnameCertificateDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzRealnameCertificateServiceImpl")
public class BzRealnameCertificateServiceImpl extends BaseServiceImpl implements
		IBzRealnameCertificateService {
	@Autowired
	private IBzRealnameCertificateDao bzRealnameCertificateDao;

	public BzRealnameCertificate findByUserId(Long sysUserId) {
		String hql = "from BzRealnameCertificate b where b.sysUserId=:sysUserId and b.markForDelete=:markForDelete order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sysUserId", sysUserId);
		params.put("markForDelete", false);
		List<BzRealnameCertificate> bzRealnameCertificateList = bzRealnameCertificateDao
				.query(hql, params);
		if (bzRealnameCertificateList != null
				&& bzRealnameCertificateList.size() > 0) {
			return bzRealnameCertificateList.get(0);
		}
		return null;
	}
}