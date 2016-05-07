package itaf.framework.business.product.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.business.product.service.IBzProductFavoriteService;
import itaf.framework.business.product.service.IBzProductService;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.product.BzProductFavorite;
import itaf.framework.persistence.product.dao.IBzProductFavoriteDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzProductFavoriteServiceImpl")
public class BzProductFavoriteServiceImpl extends BaseServiceImpl implements
		IBzProductFavoriteService {

	@Autowired
	private IBzProductFavoriteDao bzProductFavoriteDao;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private IBzProductService bzProductService;

	public PageResult<BzProductFavorite> findPager(Long bzConsumerId,
			int currentIndex, int pageSize) {
		String hql = "from BzProductFavorite b where b.bzConsumerId=:bzConsumerId order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzConsumerId", bzConsumerId);
		PageResult<BzProductFavorite> result = bzProductFavoriteDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, currentIndex,
				pageSize);
		return result;
	}

	public BzProductFavorite findByBzConsumerIdAndBzProductId(
			Long bzConsumerId, Long bzProductId) {
		String hql = "from BzProductFavorite b where b.bzConsumerId=:bzConsumerId and b.bzProductId=:bzProductId order by b.id desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bzConsumerId", bzConsumerId);
		params.put("bzProductId", bzProductId);
		List<BzProductFavorite> result = bzProductFavoriteDao
				.query(hql, params);
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public void doProductFavorite(Long bzConsumerId, Long bzProductId) {
		BzProductFavorite bzProductFavorite = new BzProductFavorite();
		bzProductFavorite.setBzConsumerId(bzConsumerId);
		bzProductFavorite.setBzProductId(bzProductId);
		bzProductFavoriteDao.saveOrUpdate(bzProductFavorite);
	}

	public void doCancelProductFavorite(Long bzConsumerId, Long bzProductId) {
		BzProductFavorite bzProductFavorite = findByBzConsumerIdAndBzProductId(
				bzConsumerId, bzProductId);
		if (bzProductFavorite != null) {
			bzProductFavoriteDao.remove(bzProductFavorite);
		}
	}

}