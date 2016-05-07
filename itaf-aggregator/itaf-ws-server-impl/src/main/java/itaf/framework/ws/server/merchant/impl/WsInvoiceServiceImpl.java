package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzInvoiceService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzInvoice;
import itaf.framework.merchant.dto.BzDistCompanyDto;
import itaf.framework.merchant.dto.BzDistOrderDto;
import itaf.framework.merchant.dto.BzInvoiceDto;
import itaf.framework.merchant.dto.BzInvoiceItemDto;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsInvoiceService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsInvoiceServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsInvoiceService", serviceName = "WsInvoiceService")
public class WsInvoiceServiceImpl extends WsBaseImpl<BzInvoice> implements
		WsInvoiceService {

	@Autowired
	private IBzInvoiceService bzInvoiceService;

	private BzInvoiceDto entity2Dto(BzInvoice bzInvoice) {
		BzInvoiceDto bzInvoiceDto = CopyPropertiesCglibHelper.copyProperties(
				BzInvoiceDto.class, bzInvoice);
		bzInvoiceDto.setBzMerchantDto(CopyPropertiesCglibHelper.copyProperties(
				BzMerchantDto.class, bzInvoice.getBzMerchant()));
		bzInvoiceDto.setBzDistCompanyDto(CopyPropertiesCglibHelper
				.copyProperties(BzDistCompanyDto.class,
						bzInvoice.getBzDistCompany()));
		bzInvoiceDto
				.setBzInvoiceItemDtos((List<BzInvoiceItemDto>) CopyPropertiesCglibHelper
						.copyProperties(BzInvoiceItemDto.class,
								bzInvoice.getBzInvoiceItems()));
		bzInvoiceDto.setBzDistOrderDto(CopyPropertiesCglibHelper
				.copyProperties(BzDistOrderDto.class,
						bzInvoice.getBzDistOrder()));
		return bzInvoiceDto;
	}

	public WsPageResult<BzInvoiceDto> findPager(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzDistCompanyName") String bzDistCompanyName,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzInvoiceDto> pr = new WsPageResult<BzInvoiceDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("bzMerchantId", 1L);
			queryMap.put("bzDistCompanyName",
					processStirngLike(bzDistCompanyName, 3));
			queryMap.put("markForDelete", false);
			criteria.setQueryCondition(queryMap);
			PageResult<BzInvoice> pageResult = bzInvoiceService
					.findByCriteria(criteria);
			List<BzInvoice> bzInvoices = (List<BzInvoice>) pageResult
					.getContent();
			for (BzInvoice bzInvoice : bzInvoices) {
				pr.getContent().add(entity2Dto(bzInvoice));
			}
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public WsPageResult<BzInvoiceDto> getById(
			@WebParam(name = "bzOrderId") Long bzOrderId) {
		WsPageResult<BzInvoiceDto> pr = new WsPageResult<BzInvoiceDto>();
		try {
			pr.getContent()
					.add(entity2Dto(bzInvoiceService.getById(bzOrderId)));
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> invoice(
			@WebParam(name = "bzOrderId") Long bzOrderId,
			@WebParam(name = "bzDistCompanyId") Long bzDistCompanyId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzInvoiceService.doInvoice(bzOrderId, bzDistCompanyId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzInvoice getObject() {
		return new BzInvoice();
	}

}
