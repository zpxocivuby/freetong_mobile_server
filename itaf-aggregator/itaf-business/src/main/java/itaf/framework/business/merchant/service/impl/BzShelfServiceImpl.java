package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzShelfService;
import itaf.framework.domain.merchant.BzShelf;
import itaf.framework.persistence.merchant.dao.IBzShelfDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzShelfServiceImpl")
public class BzShelfServiceImpl extends BaseServiceImpl implements
		IBzShelfService {

	@Autowired
	private IBzShelfDao bzShelfDao;

	public void doSaveOrUpdate(BzShelf bzShelf) {
		bzShelfDao.saveOrUpdate(bzShelf);
	}

	public BzShelf findByBzProductId(Long bzProductId) {
		String hql = "from BzShelf b where b.bzProductId=:bzProductId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzProductId", bzProductId);
		List<BzShelf> result = bzShelfDao.query(hql, params);
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public BzShelf findEmptyByMerchantId(Long bzMerchantId) {
		String hql = "from BzShelf b where b.bzMerchant.id=:bzMerchantId and b.bzProduct is null";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzMerchantId", bzMerchantId);
		List<BzShelf> result = bzShelfDao.query(hql, params);
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public List<BzShelf> findByMerchantId(Long bzMerchantId) {
		String hql = "from BzShelf b where b.bzMerchant.id=:bzMerchantId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzMerchantId", bzMerchantId);
		return bzShelfDao.query(hql, params);
	}

}