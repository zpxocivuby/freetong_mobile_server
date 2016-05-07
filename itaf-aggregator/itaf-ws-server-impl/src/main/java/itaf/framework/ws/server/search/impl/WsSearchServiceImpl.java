package itaf.framework.ws.server.search.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzDistCompanyService;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.business.product.service.IBzProductService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzDistCompany;
import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.domain.merchant.BzMerchantRate;
import itaf.framework.domain.merchant.BzShelf;
import itaf.framework.domain.merchant.BzStock;
import itaf.framework.domain.merchant.BzUserDeliveryAddress;
import itaf.framework.domain.product.BzProduct;
import itaf.framework.domain.product.BzProductAttachment;
import itaf.framework.domain.product.BzProductCategory;
import itaf.framework.merchant.dto.BzDistCompanyDto;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.merchant.dto.BzServiceProviderTypeDto;
import itaf.framework.position.dto.BzPositionDto;
import itaf.framework.product.dto.BzProductDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.search.WsSearchService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsSearchServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.search.WsSearchService", serviceName = "WsSearchService")
public class WsSearchServiceImpl extends WsBaseImpl<String> implements
		WsSearchService {

	@Autowired
	private IBzProductService bzProductService;
	@Autowired
	private IBzMerchantService bzMerchantService;
	@Autowired
	private IBzDistCompanyService bzDistCompanyService;

	@SuppressWarnings("unchecked")
	public WsPageResult<BzProductDto> searchProducts(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzProductDto> pr = new WsPageResult<BzProductDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			Map<String, Object> queryMap = (Map<String, Object>) decodeBase64(queryMapString);
			queryMap.put("markForDelete", false);
			criteria.setQueryCondition(queryMap);
			criteria.setOrderField("b.id");
			criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
			PageResult<BzProduct> pageResult = bzProductService
					.findByCriteria(criteria);
			for (BzProduct bzProduct : pageResult.getContent()) {
				BzProductDto bzProductDto = CopyPropertiesCglibHelper
						.copyProperties(BzProductDto.class, bzProduct);
				BzMerchantDto bzMerchantDto = CopyPropertiesCglibHelper
						.copyProperties(BzMerchantDto.class,
								bzProduct.getBzMerchant());
				bzMerchantDto.setUsername(bzProduct.getBzMerchant()
						.getUsername());
				bzMerchantDto.setNickname(bzProduct.getBzMerchant()
						.getNickname());
				bzProductDto.setBzMerchantDto(bzMerchantDto);
				BzShelf bzShelf = bzProduct.getBzShelf();
				if (bzShelf != null) {
					bzProductDto.setShelfNum(bzShelf.getStockNum());
				} else {
					bzProductDto.setShelfNum(0L);
				}
				BzStock bzStock = bzProduct.getBzStock();
				if (bzStock != null) {
					bzProductDto.setStockNum(bzStock.getStockNum());
				} else {
					bzProductDto.setStockNum(0L);
				}
				List<Long> bzProductCategoryIds = new ArrayList<Long>();
				for (BzProductCategory bzProductCategory : bzProduct
						.getBzProductCategories()) {
					bzProductCategoryIds.add(bzProductCategory.getId());
				}
				bzProductDto.setBzProductCategoryIds(bzProductCategoryIds);
				List<Long> bzProductAttachmentIds = new ArrayList<Long>();
				for (BzProductAttachment bzProductAttachment : bzProduct
						.getBzProductAttachments()) {
					bzProductAttachmentIds.add(bzProductAttachment.getId());
				}
				bzProductDto.setBzProductAttachmentIds(bzProductAttachmentIds);
				pr.getContent().add(bzProductDto);
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

	@SuppressWarnings("unchecked")
	public WsPageResult<BzMerchantDto> searchMerchants(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzMerchantDto> pr = new WsPageResult<BzMerchantDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			Map<String, Object> queryMap = (Map<String, Object>) decodeBase64(queryMapString);
			queryMap.put("markForDelete", false);
			// criteria.setOrderField("b.id");
			// criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
			criteria.setQueryCondition(queryMap);
			PageResult<BzMerchant> pageResult = bzMerchantService
					.findByCriteria(criteria);
			for (BzMerchant bzMerchant : pageResult.getContent()) {
				BzMerchantDto bzMerchantDto = CopyPropertiesCglibHelper
						.copyProperties(BzMerchantDto.class, bzMerchant);
				bzMerchantDto.setUsername(bzMerchant.getUsername());
				bzMerchantDto.setHeadIco(bzMerchant.getSysUser().getHeadIco());
				BzMerchantRate bzMerchantRate = bzMerchant.getBzMerchantRate();
				if (bzMerchantRate != null) {
					bzMerchantDto
							.setRatingScore((bzMerchantRate
									.getDescriptionScore()
									+ bzMerchantRate.getAttitudeScore()
									+ bzMerchantRate.getDeliveryScore() + bzMerchantRate
										.getLogisticsScore())
									/ (bzMerchantRate.getRatingNumber() * 4.0F));
				}
				List<BzUserDeliveryAddress> bzUserDeliveryAddress = bzMerchant
						.getSysUser().getBzUserDeliveryAddress();
				if (bzUserDeliveryAddress != null
						&& bzUserDeliveryAddress.size() > 0) {
					bzMerchantDto.setBzPositionDto(CopyPropertiesCglibHelper
							.copyProperties(BzPositionDto.class,
									bzUserDeliveryAddress.get(0)
											.getBzPosition()));
				}
				pr.getContent().add(bzMerchantDto);
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

	@SuppressWarnings("unchecked")
	public WsPageResult<BzDistCompanyDto> searchDistCompanys(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize) {
		WsPageResult<BzDistCompanyDto> pr = new WsPageResult<BzDistCompanyDto>();
		try {
			QueryCriteria criteria = new QueryCriteria();
			criteria.setStartIndex(currentIndex);
			criteria.setPageSize(pageSize);
			Map<String, Object> queryMap = (Map<String, Object>) decodeBase64(queryMapString);
			queryMap.put("markForDelete", false);
			Long orderType = (Long) queryMap.get("orderType");
			if (orderType != null) {
				if (1 == orderType) {
					// criteria.setOrderField("b.id");
					// criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
				} else if (2 == orderType) {
					// criteria.setOrderField("b.id");
					// criteria.setOrderDirection(QueryCriteria.SORT_DIRECTION_DESC);
				}
			}
			criteria.setQueryCondition(queryMap);
			PageResult<BzDistCompany> pageResult = bzDistCompanyService
					.findByCriteria(criteria);
			for (BzDistCompany bzDistCompany : pageResult.getContent()) {
				BzDistCompanyDto bzDistCompanyDto = CopyPropertiesCglibHelper
						.copyProperties(BzDistCompanyDto.class, bzDistCompany);
				bzDistCompanyDto
						.setBzServiceProviderTypeDto(CopyPropertiesCglibHelper
								.copyProperties(BzServiceProviderTypeDto.class,
										bzDistCompany
												.getBzServiceProviderType()));
				bzDistCompanyDto.setUsername(bzDistCompany.getUsername());
				bzDistCompanyDto.setNickname(bzDistCompany.getNickname());
				List<BzUserDeliveryAddress> bzUserDeliveryAddress = bzDistCompany
						.getSysUser().getBzUserDeliveryAddress();
				if (bzUserDeliveryAddress != null
						&& bzUserDeliveryAddress.size() > 0) {
					bzDistCompanyDto.setBzPositionDto(CopyPropertiesCglibHelper
							.copyProperties(BzPositionDto.class,
									bzUserDeliveryAddress.get(0)
											.getBzPosition()));
				}
				pr.getContent().add(bzDistCompanyDto);
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
	public String getObject() {
		return new String();
	}

	public BzProductDto getBzProductDtoObject() {
		return new BzProductDto();
	}

	public BzMerchantDto getBzMerchantDtoObject() {
		return new BzMerchantDto();
	}

	public BzDistCompanyDto getBzDistCompanyDtoObject() {
		return new BzDistCompanyDto();
	}

}
