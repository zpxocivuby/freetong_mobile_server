package itaf.framework.business.merchant.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.domain.merchant.BzMerchantFavorite;

public interface IBzMerchantFavoriteService {

	public PageResult<BzMerchantFavorite> findPager(Long bzConsumerId,
			int currentIndex, int pageSize);

	public BzMerchantFavorite findByBzConsumerIdAndBzMerchantId(
			Long bzConsumerId, Long bzMerchantId);

	public void doMerchantFavorite(Long bzConsumerId, Long bzMerchantId);

	public void doCancelMerchantFavorite(Long bzConsumerId, Long bzMerchantId);

}
