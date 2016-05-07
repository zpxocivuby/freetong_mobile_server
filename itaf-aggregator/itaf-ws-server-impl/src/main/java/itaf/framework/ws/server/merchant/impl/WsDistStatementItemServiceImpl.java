package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzDistStatementItemService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzDistStatementItem;
import itaf.framework.merchant.dto.BzDistCompanyDto;
import itaf.framework.merchant.dto.BzDistStatementItemDto;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsDistStatementItemService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsDistStatementItemServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsDistStatementItemService", serviceName = "WsDistStatementItemService")
public class WsDistStatementItemServiceImpl extends
		WsBaseImpl<BzDistStatementItemDto> implements
		WsDistStatementItemService {

	@Autowired
	private IBzDistStatementItemService bzDistStatementItemService;

	private BzDistStatementItemDto entity2Dto(
			BzDistStatementItem bzDistStatementItem) {
		BzDistStatementItemDto bzDistStatementItemDto = CopyPropertiesCglibHelper
				.copyProperties(BzDistStatementItemDto.class,
						bzDistStatementItem);
		bzDistStatementItemDto.setBzMerchantDto(CopyPropertiesCglibHelper
				.copyProperties(BzMerchantDto.class,
						bzDistStatementItem.getBzMerchant()));
		bzDistStatementItemDto.setBzDistCompanyDto(CopyPropertiesCglibHelper
				.copyProperties(BzDistCompanyDto.class,
						bzDistStatementItem.getBzDistCompany()));
		return bzDistStatementItemDto;
	}

	@SuppressWarnings("unchecked")
	public WsPageResult<BzDistStatementItemDto> findPager(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzDistStatementItemDto> pr = new WsPageResult<BzDistStatementItemDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			Map<String, Object> queryMap = (Map<String, Object>) decodeBase64(queryMapString);
			queryMap.put("markForDelete", false);
			criteria.setQueryCondition(queryMap);
			criteria.setOrderField("b.id");
			criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
			PageResult<BzDistStatementItem> pageResult = bzDistStatementItemService
					.findByCriteria(criteria);
			for (BzDistStatementItem bzDistStatementItem : pageResult
					.getContent()) {
				pr.getContent().add(entity2Dto(bzDistStatementItem));
			}
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
	public BzDistStatementItemDto getObject() {
		return new BzDistStatementItemDto();
	}

}
