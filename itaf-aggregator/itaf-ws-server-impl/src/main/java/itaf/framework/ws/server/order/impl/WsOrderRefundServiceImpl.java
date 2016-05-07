package itaf.framework.ws.server.order.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.order.service.IBzOrderRefundService;
import itaf.framework.consumer.dto.BzConsumerDto;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.order.BzOrderRefund;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.order.dto.BzOrderDto;
import itaf.framework.order.dto.BzOrderRefundDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.order.WsOrderRefundService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsOrderRefundServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.order.WsOrderRefundService", serviceName = "WsOrderRefundService")
public class WsOrderRefundServiceImpl extends WsBaseImpl<BzOrderRefundDto>
		implements WsOrderRefundService {

	@Autowired
	private IBzOrderRefundService bzOrderRefundService;

	private BzOrderRefundDto entity2Dto(BzOrderRefund bzOrderRefund) {
		BzOrderRefundDto bzOrderRefundDto = CopyPropertiesCglibHelper
				.copyProperties(BzOrderRefundDto.class, bzOrderRefund);
		bzOrderRefundDto.setBzOrderDto(CopyPropertiesCglibHelper
				.copyProperties(BzOrderDto.class, bzOrderRefund.getBzOrder()));
		bzOrderRefundDto.setBzConsumerDto(CopyPropertiesCglibHelper
				.copyProperties(BzConsumerDto.class,
						bzOrderRefund.getBzConsumer()));
		bzOrderRefundDto.setBzMerchantDto(CopyPropertiesCglibHelper
				.copyProperties(BzMerchantDto.class,
						bzOrderRefund.getBzMerchant()));
		return bzOrderRefundDto;
	}

	public WsPageResult<BzOrderRefundDto> findPager(
			@WebParam(name = "roleType") String roleType,
			@WebParam(name = "roleTypeValue") Long roleTypeValue,
			@WebParam(name = "refundStatus") Long refundStatus,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzOrderRefundDto> pr = new WsPageResult<BzOrderRefundDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.getQueryCondition().put(roleType, roleTypeValue);
			if (refundStatus != null
					&& BzOrderRefundDto.STATUS_ACCEPT_REJECT
							.equals(refundStatus)) {
				criteria.getQueryCondition().put("unRefundStatus",
						BzOrderRefundDto.STATUS_AYYLY);
			} else {
				criteria.getQueryCondition().put("refundStatus", refundStatus);
			}
			criteria.getQueryCondition().put("markForDelete", false);
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			criteria.setOrderField("b.id");
			criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
			PageResult<BzOrderRefund> pageResult = bzOrderRefundService
					.findByCriteria(criteria);
			for (BzOrderRefund bzOrderRefund : pageResult.getContent()) {
				pr.getContent().add(entity2Dto(bzOrderRefund));
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

	public WsPageResult<String> applyRefund(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzOrderId") Long bzOrderId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzOrderRefundService.doApplyRefund(bzConsumerId, bzOrderId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> cancelRefund(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzOrderRefundId") Long bzOrderRefundId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzOrderRefundService.doCancelRefund(bzConsumerId, bzOrderRefundId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> acceptRefund(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzOrderRefundId") Long bzOrderRefundId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzOrderRefundService.doAcceptRefund(bzMerchantId, bzOrderRefundId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg(e.getMessage());
		}
		return pr;
	}

	public WsPageResult<String> rejectRefund(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzOrderRefundId") Long bzOrderRefundId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzOrderRefundService.doRejectRefund(bzMerchantId, bzOrderRefundId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzOrderRefundDto getObject() {
		return new BzOrderRefundDto();
	}

}
