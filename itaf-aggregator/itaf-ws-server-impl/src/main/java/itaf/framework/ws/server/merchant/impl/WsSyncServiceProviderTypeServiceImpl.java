package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzServiceProviderTypeService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzServiceProviderType;
import itaf.framework.merchant.dto.BzServiceProviderTypeDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsSyncServiceProviderTypeService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wsSyncServiceProviderTypeServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsSyncServiceProviderTypeService", serviceName = "WsSyncServiceProviderTypeService")
public class WsSyncServiceProviderTypeServiceImpl extends
		WsBaseImpl<BzServiceProviderType> implements
		WsSyncServiceProviderTypeService {

	@Autowired
	private IBzServiceProviderTypeService bzServiceProviderTypeService;

	@Override
	public WsPageResult<BzServiceProviderTypeDto> syncPager2Client(
			int currentIndex, int pageSize) {
		WsPageResult<BzServiceProviderTypeDto> pr = new WsPageResult<BzServiceProviderTypeDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			criteria.setOrderField("spt.typeCode");
			criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_ASC);
			PageResult<BzServiceProviderType> pageResult = bzServiceProviderTypeService
					.findByCriteria(criteria);
			List<BzServiceProviderTypeDto> bzServiceProviderTypeDtos = new ArrayList<BzServiceProviderTypeDto>();
			List<BzServiceProviderType> bzServiceProviderTypes = (List<BzServiceProviderType>) pageResult
					.getContent();
			for (BzServiceProviderType bzServiceProviderType : bzServiceProviderTypes) {
				BzServiceProviderTypeDto bzServiceProviderTypeDto = CopyPropertiesCglibHelper
						.copyProperties(BzServiceProviderTypeDto.class,
								bzServiceProviderType);
				bzServiceProviderTypeDto.setParentDto(CopyPropertiesCglibHelper
						.copyProperties(BzServiceProviderTypeDto.class,
								bzServiceProviderType
										.getBzServiceProviderType()));
				bzServiceProviderTypeDtos.add(bzServiceProviderTypeDto);
			}
			pr.setContent(bzServiceProviderTypeDtos);
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
	public BzServiceProviderType getObject() {
		return new BzServiceProviderType();
	}

}
