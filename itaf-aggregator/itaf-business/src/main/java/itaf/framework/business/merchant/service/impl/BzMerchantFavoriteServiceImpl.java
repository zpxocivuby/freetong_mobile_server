package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzMerchantFavoriteService;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.merchant.BzMerchantFavorite;
import itaf.framework.persistence.merchant.dao.IBzMerchantFavoriteDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzMerchantFavoriteServiceImpl")
public class BzMerchantFavoriteServiceImpl extends BaseServiceImpl implements
		IBzMerchantFavoriteService {

	@Autowired
	private IBzMerchantFavoriteDao bzMerchantFavoriteDao;

	public PageResult<BzMerchantFavorite> findPager(Long bzConsumerId,
			int currentIndex, int pageSize) {
		String hql = "from BzMerchantFavorite b where b.bzConsumerId=:bzConsumerId order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzConsumerId", bzConsumerId);
		PageResult<BzMerchantFavorite> result = bzMerchantFavoriteDao.query(
				hql, HqlUtils.generateCountHql(hql, null), params,
				currentIndex, pageSize);
		return result;
	}

	public BzMerchantFavorite findByBzConsumerIdAndBzMerchantId(
			Long bzConsumerId, Long bzMerchantId) {
		String hql = "from BzMerchantFavorite b where b.bzConsumerId=:bzConsumerId and b.bzMerchantId=:bzMerchantId order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzConsumerId", bzConsumerId);
		params.put("bzMerchantId", bzMerchantId);
		List<BzMerchantFavorite> result = bzMerchantFavoriteDao.query(hql,
				params);
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public void doMerchantFavorite(Long bzConsumerId, Long bzMerchantId) {
		BzMerchantFavorite bzMerchantFavorite = new BzMerchantFavorite();
		bzMerchantFavorite.setBzConsumerId(bzConsumerId);
		bzMerchantFavorite.setBzMerchantId(bzMerchantId);
		bzMerchantFavoriteDao.saveOrUpdate(bzMerchantFavorite);
	}

	public void doCancelMerchantFavorite(Long bzConsumerId, Long bzMerchantId) {
		BzMerchantFavorite bzMerchantFavorite = findByBzConsumerIdAndBzMerchantId(
				bzConsumerId, bzMerchantId);
		if (bzMerchantFavorite != null) {
			bzMerchantFavoriteDao.remove(bzMerchantFavorite);
		}
	}

}