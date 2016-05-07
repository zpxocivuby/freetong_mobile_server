package itaf.framework.ws.server.product.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.product.service.IBzProductCategoryService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.product.BzProductCategory;
import itaf.framework.product.dto.BzProductCategoryDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.product.WsSyncProductCategoryService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsSyncProductCategoryServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.product.WsSyncProductCategoryService", serviceName = "WsSyncProductCategoryService")
public class WsSyncProductCategoryServiceImpl extends
		WsBaseImpl<BzProductCategoryDto> implements
		WsSyncProductCategoryService {

	@Autowired
	private IBzProductCategoryService bzProductCategoryService;

	@Override
	public WsPageResult<BzProductCategoryDto> syncPager2Client(
			int currentIndex, int pageSize) {
		WsPageResult<BzProductCategoryDto> pr = new WsPageResult<BzProductCategoryDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			criteria.setOrderField("pc.categoryCode");
			criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_ASC);
			PageResult<BzProductCategory> pageResult = bzProductCategoryService
					.findByCriteria(criteria);
			List<BzProductCategoryDto> bzProductCategoryDtos = new ArrayList<BzProductCategoryDto>();
			List<BzProductCategory> bzProductCategorys = (List<BzProductCategory>) pageResult
					.getContent();
			for (BzProductCategory bzProductCategory : bzProductCategorys) {
				BzProductCategoryDto bzProductCategoryDto = CopyPropertiesCglibHelper
						.copyProperties(BzProductCategoryDto.class,
								bzProductCategory);
				bzProductCategoryDto.setParentId(bzProductCategory
						.getParentId());
				bzProductCategoryDtos.add(bzProductCategoryDto);
			}
			pr.setContent(bzProductCategoryDtos);
			pr.setTotalCount(pageResult.getTotalCount());
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzProductCategoryDto getObject() {
		return new BzProductCategoryDto();
	}

}
