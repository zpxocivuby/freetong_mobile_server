package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzDistStatementService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzDistStatement;
import itaf.framework.domain.merchant.BzDistStatementItem;
import itaf.framework.merchant.dto.BzDistCompanyDto;
import itaf.framework.merchant.dto.BzDistStatementDto;
import itaf.framework.merchant.dto.BzDistStatementItemDto;
import itaf.framework.merchant.dto.BzDistStatementSummaryDto;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsDistStatementService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsDistStatementServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsDistStatementService", serviceName = "WsDistStatementService")
public class WsDistStatementServiceImpl extends WsBaseImpl<BzDistStatementDto>
		implements WsDistStatementService {

	@Autowired
	private IBzDistStatementService bzDistStatementService;

	private BzDistStatementDto entity2Dto(BzDistStatement bzDistStatement) {
		BzDistStatementDto bzDistStatementDto = CopyPropertiesCglibHelper
				.copyProperties(BzDistStatementDto.class, bzDistStatement);
		bzDistStatementDto.setBzMerchantDto(CopyPropertiesCglibHelper
				.copyProperties(BzMerchantDto.class,
						bzDistStatement.getBzMerchant()));
		bzDistStatementDto.setBzDistCompanyDto(CopyPropertiesCglibHelper
				.copyProperties(BzDistCompanyDto.class,
						bzDistStatement.getBzDistCompany()));
		return bzDistStatementDto;
	}

	@SuppressWarnings("unchecked")
	public WsPageResult<BzDistStatementDto> findPager(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzDistStatementDto> pr = new WsPageResult<BzDistStatementDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			Map<String, Object> queryMap = (Map<String, Object>) decodeBase64(queryMapString);
			queryMap.put("markForDelete", false);
			criteria.setQueryCondition(queryMap);
			criteria.setOrderField("b.id");
			criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
			PageResult<BzDistStatement> pageResult = bzDistStatementService
					.findByCriteria(criteria);
			for (BzDistStatement bzDistStatement : pageResult.getContent()) {
				pr.getContent().add(entity2Dto(bzDistStatement));
			}
			Long statementStatus = (Long) queryMap.get("statementStatus");
			Map<String, Object> params = new HashMap<String, Object>();
			if (2 == statementStatus) {
				params.put("receivableAmount", bzDistStatementService
						.getReceivableAmount(
								(Long) queryMap.get("bzDistCompanyId"), 2L));
				params.put(
						"refundAmount",
						bzDistStatementService.getRefundAmount(
								(Long) queryMap.get("bzDistCompanyId"), 2L));
			} else if (3 == statementStatus) {
				params.put("receivableAmount", bzDistStatementService
						.getReceivedAmount((Long) queryMap
								.get("bzDistCompanyId")));
				params.put("refundAmount", new BigDecimal(0));
			}
			pr.setParamsString(encodeBase64(params));
			pr.setTotalCount(pageResult.getTotalCount());
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> startDistStatement(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId,
			@WebParam(name = "bzDistStatementItemIds") String bzDistStatementItemIds) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzDistStatementService.doStartDistStatement(bzMerchantId,
					bzDistCompanyId, bzDistStatementItemIds);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg(e.getMessage());
		}
		return pr;
	}

	public WsPageResult<String> acceptDistStatement(
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId,
			@WebParam(name = "bzDistStatementId") Long bzDistStatementId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzDistStatementService.doAcceptDistStatement(bzDistCompanyId,
					bzDistStatementId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg(e.getMessage());
		}
		return pr;
	}

	public WsPageResult<String> rejectDistStatement(
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId,
			@WebParam(name = "bzDistStatementId") Long bzDistStatementId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzDistStatementService.doRejectDistStatement(bzDistCompanyId,
					bzDistStatementId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg(e.getMessage());
		}
		return pr;
	}

	public WsPageResult<BzDistStatementDto> getById(
			@WebParam(name = "bzDistStatementId") Long bzDistStatementId) {
		WsPageResult<BzDistStatementDto> pr = new WsPageResult<BzDistStatementDto>();
		try {
			BzDistStatement bzDistStatement = bzDistStatementService
					.getById(bzDistStatementId);
			BzDistStatementDto bzDistStatementDto = entity2Dto(bzDistStatement);
			for (BzDistStatementItem bzDistStatementItem : bzDistStatement
					.getBzDistStatementItems()) {
				bzDistStatementDto.getBzDistStatementItemDtos().add(
						CopyPropertiesCglibHelper.copyProperties(
								BzDistStatementItemDto.class,
								bzDistStatementItem));
			}
			pr.getContent().add(bzDistStatementDto);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzDistStatementSummaryDto> getBzDistStatementSummaryDto(
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId) {
		WsPageResult<BzDistStatementSummaryDto> pr = new WsPageResult<BzDistStatementSummaryDto>();
		try {
			BzDistStatementSummaryDto bzDistStatementSummaryDto = new BzDistStatementSummaryDto();
			bzDistStatementSummaryDto
					.setUnprocessedReceivableAmount(bzDistStatementService
							.getReceivableAmount(bzDistCompanyId, 1L));
			bzDistStatementSummaryDto
					.setUnprocessedRefundAmount(bzDistStatementService
							.getRefundAmount(bzDistCompanyId, 1L));
			bzDistStatementSummaryDto
					.setProcessingReceivableAmount(bzDistStatementService
							.getReceivableAmount(bzDistCompanyId, 2L));
			bzDistStatementSummaryDto
					.setProcessingRefundAmount(bzDistStatementService
							.getRefundAmount(bzDistCompanyId, 2L));
			bzDistStatementSummaryDto.setProcessedAmount(bzDistStatementService
					.getReceivedAmount(bzDistCompanyId));
			pr.getContent().add(bzDistStatementSummaryDto);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzDistStatementDto getObject() {
		return new BzDistStatementDto();
	}

}
