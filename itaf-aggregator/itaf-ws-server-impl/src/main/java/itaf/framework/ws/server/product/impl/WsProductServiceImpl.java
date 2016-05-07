package itaf.framework.ws.server.product.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.business.merchant.service.IBzStockService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.business.product.service.IBzProductAttachmentService;
import itaf.framework.business.product.service.IBzProductBrandService;
import itaf.framework.business.product.service.IBzProductCategoryService;
import itaf.framework.business.product.service.IBzProductFavoriteService;
import itaf.framework.business.product.service.IBzProductService;
import itaf.framework.domain.merchant.BzShelf;
import itaf.framework.domain.merchant.BzStock;
import itaf.framework.domain.product.BzProduct;
import itaf.framework.domain.product.BzProductAttachment;
import itaf.framework.domain.product.BzProductCategory;
import itaf.framework.merchant.dto.BzMerchantDto;
import itaf.framework.product.dto.BzProductDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.product.WsProductService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsProductServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.product.WsProductService", serviceName = "WsProductService")
public class WsProductServiceImpl extends WsBaseImpl<BzProductDto> implements
		WsProductService {

	@Autowired
	private IBzProductService bzProductService;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private IBzProductCategoryService bzProductCategoryService;
	@Autowired
	private IBzProductAttachmentService bzProductAttachmentService;
	@Autowired
	private IBzProductBrandService bzProductBrandService;
	@Autowired
	private IBzMerchantService bzMerchantService;
	@Autowired
	private IBzStockService bzStockService;
	@Autowired
	private IBzProductFavoriteService bzProductFavoriteService;

	public WsPageResult<BzProductDto> getById(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzProductId") Long bzProductId) {
		WsPageResult<BzProductDto> pr = new WsPageResult<BzProductDto>();
		try {
			BzProduct bzProduct = bzProductService.getById(bzProductId);
			List<BzProductDto> bzProductDtos = new ArrayList<BzProductDto>();
			if (bzProduct != null) {
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
				if (bzConsumerId == null
						|| bzConsumerId <= 0
						|| bzProductFavoriteService
								.findByBzConsumerIdAndBzProductId(bzConsumerId,
										bzProductId) == null) {
					bzProductDto.setIsFavorited(false);
				} else {
					bzProductDto.setIsFavorited(true);
				}
				bzProductDtos.add(bzProductDto);
			}
			pr.setContent(bzProductDtos);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.debug(e.toString());
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> createOrUpdate(
			@WebParam(name = "dtoString") String dtoString) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			BzProductDto dto = (BzProductDto) decodeBase64(dtoString);
			BzProduct bzProduct = null;
			if (dto.getId() != null && dto.getId() > 0) {
				bzProduct = bzProductService.getById(dto.getId());
			} else {
				bzProduct = new BzProduct();
				bzProduct.setBzMerchantId(dto.getBzMerchantId());
				bzProduct.setProductOnSale(dto.getProductOnSale());
			}
			bzProduct.setProductName(dto.getProductName());
			bzProduct.setProductPrice(dto.getProductPrice());
			bzProduct.setProductPurchasePrice(dto.getProductPurchasePrice());
			bzProduct.setProductColor(dto.getProductColor());
			bzProduct.setProductDescription(dto.getProductDescription());

			if (dto.getBzProductCategoryIds() != null
					&& dto.getBzProductCategoryIds().size() > 0) {
				bzProduct
						.setBzProductCategories(new HashSet<BzProductCategory>(
								bzProductCategoryService.getByIds(dto
										.getBzProductCategoryIds())));
			}

			if (dto.getBzProductAttachmentIds() != null
					&& dto.getBzProductAttachmentIds().size() > 0) {
				bzProduct
						.setBzProductAttachments(new HashSet<BzProductAttachment>(
								bzProductAttachmentService.getByIds(dto
										.getBzProductAttachmentIds())));
			}

			bzProductService.doSaveOrUpdate(bzProduct, dto.getShelfNum(),
					dto.getStockNum());
		} catch (Exception e) {
			log.debug(e.toString());
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> deleteById(
			@WebParam(name = "bzProductId") Long bzProductId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzProductService.doMarkForDeleteById(bzProductId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.debug(e.toString());
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> putProductOnShelf(
			@WebParam(name = "bzProductId") Long bzProductId,
			@WebParam(name = "onShelfNumber") Long onShelfNumber) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzProductService.doPutProductOnShelf(bzProductId, onShelfNumber);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.debug(e.toString());
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<String> removeProductFromShelf(
			@WebParam(name = "bzProductId") Long bzProductId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			bzProductService.doRemoveProductFromShelf(bzProductId);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.debug(e.toString());
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzProductDto getObject() {
		return new BzProductDto();
	}

}
