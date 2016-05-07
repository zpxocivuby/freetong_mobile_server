package itaf.framework.business.product.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.domain.product.BzProductFavorite;

public interface IBzProductFavoriteService {

	public PageResult<BzProductFavorite> findPager(Long bzConsumerId,
			int currentIndex, int pageSize);

	public BzProductFavorite findByBzConsumerIdAndBzProductId(
			Long bzConsumerId, Long bzProductId);

	public void doProductFavorite(Long bzConsumerId, Long bzProductId);

	public void doCancelProductFavorite(Long bzConsumerId, Long bzProductId);

}
