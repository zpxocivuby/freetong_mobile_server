
package itaf.WsProductCategoryService;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itaf.WsProductCategoryService package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _SyncToClient_QNAME = new QName("itaf.framework.ws.server.product", "syncToClient");
    private static final QName _SyncToClientResponse_QNAME = new QName("itaf.framework.ws.server.product", "syncToClientResponse");
    private static final QName _BzShelfDtoId_QNAME = new QName("", "id");
    private static final QName _BzShelfDtoStockNum_QNAME = new QName("", "stockNum");
    private static final QName _BzShelfDtoBzStockOrderItemDtos_QNAME = new QName("", "bzStockOrderItemDtos");
    private static final QName _BzShelfDtoSysUserDto_QNAME = new QName("", "sysUserDto");
    private static final QName _BzShelfDtoSoldNum_QNAME = new QName("", "soldNum");
    private static final QName _BzShelfDtoBzProductId_QNAME = new QName("", "bzProductId");
    private static final QName _BzStockDtoStockLocation_QNAME = new QName("", "stockLocation");
    private static final QName _BzStockDtoStockType_QNAME = new QName("", "stockType");
    private static final QName _BzStockDtoTrProductStockDtos_QNAME = new QName("", "trProductStockDtos");
    private static final QName _BzStockDtoDeductionNum_QNAME = new QName("", "deductionNum");
    private static final QName _BzStockDtoInTransitNum_QNAME = new QName("", "inTransitNum");
    private static final QName _BzProductDtoBzProductBrandDtos_QNAME = new QName("", "bzProductBrandDtos");
    private static final QName _BzProductDtoProductDescription_QNAME = new QName("", "productDescription");
    private static final QName _BzProductDtoBzProductAttachmentDtos_QNAME = new QName("", "bzProductAttachmentDtos");
    private static final QName _BzProductDtoIsStockLimitless_QNAME = new QName("", "isStockLimitless");
    private static final QName _BzProductDtoProductPurchasePrice_QNAME = new QName("", "productPurchasePrice");
    private static final QName _BzProductDtoIsShelfLimitless_QNAME = new QName("", "isShelfLimitless");
    private static final QName _BzProductDtoBzInvoiceItemDtos_QNAME = new QName("", "bzInvoiceItemDtos");
    private static final QName _BzProductDtoProductOnSale_QNAME = new QName("", "productOnSale");
    private static final QName _BzProductDtoProductColor_QNAME = new QName("", "productColor");
    private static final QName _BzProductDtoBzPositionDtos_QNAME = new QName("", "bzPositionDtos");
    private static final QName _BzProductDtoIsShelfSupport_QNAME = new QName("", "isShelfSupport");
    private static final QName _BzProductDtoBzOrderItemDtos_QNAME = new QName("", "bzOrderItemDtos");
    private static final QName _BzProductDtoIsStockSupport_QNAME = new QName("", "isStockSupport");
    private static final QName _BzProductDtoBzCartDtos_QNAME = new QName("", "bzCartDtos");
    private static final QName _BzProductDtoBzProductCategorieDtos_QNAME = new QName("", "bzProductCategorieDtos");
    private static final QName _BzProductDtoBzProductEvaluationDtos_QNAME = new QName("", "bzProductEvaluationDtos");
    private static final QName _BzProductDtoProductName_QNAME = new QName("", "productName");
    private static final QName _BzProductDtoProductPrice_QNAME = new QName("", "productPrice");
    private static final QName _BzProductDtoBzProductFavoriteDtos_QNAME = new QName("", "bzProductFavoriteDtos");
    private static final QName _BzProductFavoriteDtoBzProductDto_QNAME = new QName("", "bzProductDto");
    private static final QName _BzProductFavoriteDtoType_QNAME = new QName("", "type");
    private static final QName _BzUserPositionDtoServiceCoverage_QNAME = new QName("", "serviceCoverage");
    private static final QName _BzUserPositionDtoBzPosition_QNAME = new QName("", "bzPosition");
    private static final QName _BzPositionDtoBzUserTakeDeliveryAddresseDtos_QNAME = new QName("", "bzUserTakeDeliveryAddresseDtos");
    private static final QName _BzPositionDtoBzProductDtos_QNAME = new QName("", "bzProductDtos");
    private static final QName _BzPositionDtoBzUserPositionDtos_QNAME = new QName("", "bzUserPositionDtos");
    private static final QName _BzPositionDtoZ_QNAME = new QName("", "z");
    private static final QName _BzPositionDtoY_QNAME = new QName("", "y");
    private static final QName _BzPositionDtoBzUserDeliveryAddresseDtos_QNAME = new QName("", "bzUserDeliveryAddresseDtos");
    private static final QName _BzPositionDtoX_QNAME = new QName("", "x");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itaf.WsProductCategoryService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SyncToClientResponse }
     * 
     */
    public SyncToClientResponse createSyncToClientResponse() {
        return new SyncToClientResponse();
    }

    /**
     * Create an instance of {@link SyncToClient }
     * 
     */
    public SyncToClient createSyncToClient() {
        return new SyncToClient();
    }

    /**
     * Create an instance of {@link BzInvoiceItemDto }
     * 
     */
    public BzInvoiceItemDto createBzInvoiceItemDto() {
        return new BzInvoiceItemDto();
    }

    /**
     * Create an instance of {@link SysRoleDto }
     * 
     */
    public SysRoleDto createSysRoleDto() {
        return new SysRoleDto();
    }

    /**
     * Create an instance of {@link BzStockOrderDto }
     * 
     */
    public BzStockOrderDto createBzStockOrderDto() {
        return new BzStockOrderDto();
    }

    /**
     * Create an instance of {@link BzOrderPaymentDto }
     * 
     */
    public BzOrderPaymentDto createBzOrderPaymentDto() {
        return new BzOrderPaymentDto();
    }

    /**
     * Create an instance of {@link WsPageResult }
     * 
     */
    public WsPageResult createWsPageResult() {
        return new WsPageResult();
    }

    /**
     * Create an instance of {@link BzUserDeliveryAddressDto }
     * 
     */
    public BzUserDeliveryAddressDto createBzUserDeliveryAddressDto() {
        return new BzUserDeliveryAddressDto();
    }

    /**
     * Create an instance of {@link BzProductCategoryDto }
     * 
     */
    public BzProductCategoryDto createBzProductCategoryDto() {
        return new BzProductCategoryDto();
    }

    /**
     * Create an instance of {@link BzProductEvaluationDto }
     * 
     */
    public BzProductEvaluationDto createBzProductEvaluationDto() {
        return new BzProductEvaluationDto();
    }

    /**
     * Create an instance of {@link BzMerchantCreditEvalDto }
     * 
     */
    public BzMerchantCreditEvalDto createBzMerchantCreditEvalDto() {
        return new BzMerchantCreditEvalDto();
    }

    /**
     * Create an instance of {@link BzProductDto }
     * 
     */
    public BzProductDto createBzProductDto() {
        return new BzProductDto();
    }

    /**
     * Create an instance of {@link BzMerchantCreditDto }
     * 
     */
    public BzMerchantCreditDto createBzMerchantCreditDto() {
        return new BzMerchantCreditDto();
    }

    /**
     * Create an instance of {@link BzOrderDto }
     * 
     */
    public BzOrderDto createBzOrderDto() {
        return new BzOrderDto();
    }

    /**
     * Create an instance of {@link BzPaymentTypeDto }
     * 
     */
    public BzPaymentTypeDto createBzPaymentTypeDto() {
        return new BzPaymentTypeDto();
    }

    /**
     * Create an instance of {@link BzConsumerCreditEvalDto }
     * 
     */
    public BzConsumerCreditEvalDto createBzConsumerCreditEvalDto() {
        return new BzConsumerCreditEvalDto();
    }

    /**
     * Create an instance of {@link BzInvoiceDto }
     * 
     */
    public BzInvoiceDto createBzInvoiceDto() {
        return new BzInvoiceDto();
    }

    /**
     * Create an instance of {@link SysUserDto }
     * 
     */
    public SysUserDto createSysUserDto() {
        return new SysUserDto();
    }

    /**
     * Create an instance of {@link BzProductFavoriteDto }
     * 
     */
    public BzProductFavoriteDto createBzProductFavoriteDto() {
        return new BzProductFavoriteDto();
    }

    /**
     * Create an instance of {@link BzPositionDto }
     * 
     */
    public BzPositionDto createBzPositionDto() {
        return new BzPositionDto();
    }

    /**
     * Create an instance of {@link BzStockDto }
     * 
     */
    public BzStockDto createBzStockDto() {
        return new BzStockDto();
    }

    /**
     * Create an instance of {@link BzDistComCreditDto }
     * 
     */
    public BzDistComCreditDto createBzDistComCreditDto() {
        return new BzDistComCreditDto();
    }

    /**
     * Create an instance of {@link BzCollectionOrderDto }
     * 
     */
    public BzCollectionOrderDto createBzCollectionOrderDto() {
        return new BzCollectionOrderDto();
    }

    /**
     * Create an instance of {@link BzStockOrderItemDto }
     * 
     */
    public BzStockOrderItemDto createBzStockOrderItemDto() {
        return new BzStockOrderItemDto();
    }

    /**
     * Create an instance of {@link BzDistributionModelDto }
     * 
     */
    public BzDistributionModelDto createBzDistributionModelDto() {
        return new BzDistributionModelDto();
    }

    /**
     * Create an instance of {@link TrProductStockIdDto }
     * 
     */
    public TrProductStockIdDto createTrProductStockIdDto() {
        return new TrProductStockIdDto();
    }

    /**
     * Create an instance of {@link BzOrderItemDto }
     * 
     */
    public BzOrderItemDto createBzOrderItemDto() {
        return new BzOrderItemDto();
    }

    /**
     * Create an instance of {@link BzShelfDto }
     * 
     */
    public BzShelfDto createBzShelfDto() {
        return new BzShelfDto();
    }

    /**
     * Create an instance of {@link BzCartItemDto }
     * 
     */
    public BzCartItemDto createBzCartItemDto() {
        return new BzCartItemDto();
    }

    /**
     * Create an instance of {@link SysResourceDto }
     * 
     */
    public SysResourceDto createSysResourceDto() {
        return new SysResourceDto();
    }

    /**
     * Create an instance of {@link BzDistributionOrderDto }
     * 
     */
    public BzDistributionOrderDto createBzDistributionOrderDto() {
        return new BzDistributionOrderDto();
    }

    /**
     * Create an instance of {@link BzOrderHistoryDto }
     * 
     */
    public BzOrderHistoryDto createBzOrderHistoryDto() {
        return new BzOrderHistoryDto();
    }

    /**
     * Create an instance of {@link BzProductBrandDto }
     * 
     */
    public BzProductBrandDto createBzProductBrandDto() {
        return new BzProductBrandDto();
    }

    /**
     * Create an instance of {@link BzProductAttachmentDto }
     * 
     */
    public BzProductAttachmentDto createBzProductAttachmentDto() {
        return new BzProductAttachmentDto();
    }

    /**
     * Create an instance of {@link BzConsumerCreditDto }
     * 
     */
    public BzConsumerCreditDto createBzConsumerCreditDto() {
        return new BzConsumerCreditDto();
    }

    /**
     * Create an instance of {@link TrProductStockDto }
     * 
     */
    public TrProductStockDto createTrProductStockDto() {
        return new TrProductStockDto();
    }

    /**
     * Create an instance of {@link BzUserTakeDeliveryAddressDto }
     * 
     */
    public BzUserTakeDeliveryAddressDto createBzUserTakeDeliveryAddressDto() {
        return new BzUserTakeDeliveryAddressDto();
    }

    /**
     * Create an instance of {@link BzUserPositionDto }
     * 
     */
    public BzUserPositionDto createBzUserPositionDto() {
        return new BzUserPositionDto();
    }

    /**
     * Create an instance of {@link BzDistComCreditEvalDto }
     * 
     */
    public BzDistComCreditEvalDto createBzDistComCreditEvalDto() {
        return new BzDistComCreditEvalDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncToClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.product", name = "syncToClient")
    public JAXBElement<SyncToClient> createSyncToClient(SyncToClient value) {
        return new JAXBElement<SyncToClient>(_SyncToClient_QNAME, SyncToClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncToClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.product", name = "syncToClientResponse")
    public JAXBElement<SyncToClientResponse> createSyncToClientResponse(SyncToClientResponse value) {
        return new JAXBElement<SyncToClientResponse>(_SyncToClientResponse_QNAME, SyncToClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = BzShelfDto.class)
    public JAXBElement<Long> createBzShelfDtoId(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoId_QNAME, Long.class, BzShelfDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "stockNum", scope = BzShelfDto.class)
    public JAXBElement<Long> createBzShelfDtoStockNum(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoStockNum_QNAME, Long.class, BzShelfDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzStockOrderItemDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzStockOrderItemDtos", scope = BzShelfDto.class)
    public JAXBElement<BzStockOrderItemDto> createBzShelfDtoBzStockOrderItemDtos(BzStockOrderItemDto value) {
        return new JAXBElement<BzStockOrderItemDto>(_BzShelfDtoBzStockOrderItemDtos_QNAME, BzStockOrderItemDto.class, BzShelfDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SysUserDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sysUserDto", scope = BzShelfDto.class)
    public JAXBElement<SysUserDto> createBzShelfDtoSysUserDto(SysUserDto value) {
        return new JAXBElement<SysUserDto>(_BzShelfDtoSysUserDto_QNAME, SysUserDto.class, BzShelfDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "soldNum", scope = BzShelfDto.class)
    public JAXBElement<Long> createBzShelfDtoSoldNum(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoSoldNum_QNAME, Long.class, BzShelfDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzProductId", scope = BzShelfDto.class)
    public JAXBElement<Long> createBzShelfDtoBzProductId(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoBzProductId_QNAME, Long.class, BzShelfDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "stockLocation", scope = BzStockDto.class)
    public JAXBElement<String> createBzStockDtoStockLocation(String value) {
        return new JAXBElement<String>(_BzStockDtoStockLocation_QNAME, String.class, BzStockDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = BzStockDto.class)
    public JAXBElement<Long> createBzStockDtoId(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoId_QNAME, Long.class, BzStockDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "stockType", scope = BzStockDto.class)
    public JAXBElement<Long> createBzStockDtoStockType(Long value) {
        return new JAXBElement<Long>(_BzStockDtoStockType_QNAME, Long.class, BzStockDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrProductStockDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "trProductStockDtos", scope = BzStockDto.class)
    public JAXBElement<TrProductStockDto> createBzStockDtoTrProductStockDtos(TrProductStockDto value) {
        return new JAXBElement<TrProductStockDto>(_BzStockDtoTrProductStockDtos_QNAME, TrProductStockDto.class, BzStockDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "deductionNum", scope = BzStockDto.class)
    public JAXBElement<Long> createBzStockDtoDeductionNum(Long value) {
        return new JAXBElement<Long>(_BzStockDtoDeductionNum_QNAME, Long.class, BzStockDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "stockNum", scope = BzStockDto.class)
    public JAXBElement<Long> createBzStockDtoStockNum(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoStockNum_QNAME, Long.class, BzStockDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "inTransitNum", scope = BzStockDto.class)
    public JAXBElement<Long> createBzStockDtoInTransitNum(Long value) {
        return new JAXBElement<Long>(_BzStockDtoInTransitNum_QNAME, Long.class, BzStockDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SysUserDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sysUserDto", scope = BzStockDto.class)
    public JAXBElement<SysUserDto> createBzStockDtoSysUserDto(SysUserDto value) {
        return new JAXBElement<SysUserDto>(_BzShelfDtoSysUserDto_QNAME, SysUserDto.class, BzStockDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzProductBrandDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzProductBrandDtos", scope = BzProductDto.class)
    public JAXBElement<BzProductBrandDto> createBzProductDtoBzProductBrandDtos(BzProductBrandDto value) {
        return new JAXBElement<BzProductBrandDto>(_BzProductDtoBzProductBrandDtos_QNAME, BzProductBrandDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "productDescription", scope = BzProductDto.class)
    public JAXBElement<String> createBzProductDtoProductDescription(String value) {
        return new JAXBElement<String>(_BzProductDtoProductDescription_QNAME, String.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzProductAttachmentDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzProductAttachmentDtos", scope = BzProductDto.class)
    public JAXBElement<BzProductAttachmentDto> createBzProductDtoBzProductAttachmentDtos(BzProductAttachmentDto value) {
        return new JAXBElement<BzProductAttachmentDto>(_BzProductDtoBzProductAttachmentDtos_QNAME, BzProductAttachmentDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "isStockLimitless", scope = BzProductDto.class)
    public JAXBElement<Long> createBzProductDtoIsStockLimitless(Long value) {
        return new JAXBElement<Long>(_BzProductDtoIsStockLimitless_QNAME, Long.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "productPurchasePrice", scope = BzProductDto.class)
    public JAXBElement<BigDecimal> createBzProductDtoProductPurchasePrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_BzProductDtoProductPurchasePrice_QNAME, BigDecimal.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "isShelfLimitless", scope = BzProductDto.class)
    public JAXBElement<Long> createBzProductDtoIsShelfLimitless(Long value) {
        return new JAXBElement<Long>(_BzProductDtoIsShelfLimitless_QNAME, Long.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzStockOrderItemDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzStockOrderItemDtos", scope = BzProductDto.class)
    public JAXBElement<BzStockOrderItemDto> createBzProductDtoBzStockOrderItemDtos(BzStockOrderItemDto value) {
        return new JAXBElement<BzStockOrderItemDto>(_BzShelfDtoBzStockOrderItemDtos_QNAME, BzStockOrderItemDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzInvoiceItemDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzInvoiceItemDtos", scope = BzProductDto.class)
    public JAXBElement<BzInvoiceItemDto> createBzProductDtoBzInvoiceItemDtos(BzInvoiceItemDto value) {
        return new JAXBElement<BzInvoiceItemDto>(_BzProductDtoBzInvoiceItemDtos_QNAME, BzInvoiceItemDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "productOnSale", scope = BzProductDto.class)
    public JAXBElement<Long> createBzProductDtoProductOnSale(Long value) {
        return new JAXBElement<Long>(_BzProductDtoProductOnSale_QNAME, Long.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = BzProductDto.class)
    public JAXBElement<Long> createBzProductDtoId(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoId_QNAME, Long.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "productColor", scope = BzProductDto.class)
    public JAXBElement<String> createBzProductDtoProductColor(String value) {
        return new JAXBElement<String>(_BzProductDtoProductColor_QNAME, String.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzPositionDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzPositionDtos", scope = BzProductDto.class)
    public JAXBElement<BzPositionDto> createBzProductDtoBzPositionDtos(BzPositionDto value) {
        return new JAXBElement<BzPositionDto>(_BzProductDtoBzPositionDtos_QNAME, BzPositionDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "isShelfSupport", scope = BzProductDto.class)
    public JAXBElement<Long> createBzProductDtoIsShelfSupport(Long value) {
        return new JAXBElement<Long>(_BzProductDtoIsShelfSupport_QNAME, Long.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzOrderItemDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzOrderItemDtos", scope = BzProductDto.class)
    public JAXBElement<BzOrderItemDto> createBzProductDtoBzOrderItemDtos(BzOrderItemDto value) {
        return new JAXBElement<BzOrderItemDto>(_BzProductDtoBzOrderItemDtos_QNAME, BzOrderItemDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrProductStockDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "trProductStockDtos", scope = BzProductDto.class)
    public JAXBElement<TrProductStockDto> createBzProductDtoTrProductStockDtos(TrProductStockDto value) {
        return new JAXBElement<TrProductStockDto>(_BzStockDtoTrProductStockDtos_QNAME, TrProductStockDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "isStockSupport", scope = BzProductDto.class)
    public JAXBElement<Long> createBzProductDtoIsStockSupport(Long value) {
        return new JAXBElement<Long>(_BzProductDtoIsStockSupport_QNAME, Long.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzCartItemDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzCartDtos", scope = BzProductDto.class)
    public JAXBElement<BzCartItemDto> createBzProductDtoBzCartDtos(BzCartItemDto value) {
        return new JAXBElement<BzCartItemDto>(_BzProductDtoBzCartDtos_QNAME, BzCartItemDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzProductCategoryDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzProductCategorieDtos", scope = BzProductDto.class)
    public JAXBElement<BzProductCategoryDto> createBzProductDtoBzProductCategorieDtos(BzProductCategoryDto value) {
        return new JAXBElement<BzProductCategoryDto>(_BzProductDtoBzProductCategorieDtos_QNAME, BzProductCategoryDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzProductEvaluationDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzProductEvaluationDtos", scope = BzProductDto.class)
    public JAXBElement<BzProductEvaluationDto> createBzProductDtoBzProductEvaluationDtos(BzProductEvaluationDto value) {
        return new JAXBElement<BzProductEvaluationDto>(_BzProductDtoBzProductEvaluationDtos_QNAME, BzProductEvaluationDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SysUserDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sysUserDto", scope = BzProductDto.class)
    public JAXBElement<SysUserDto> createBzProductDtoSysUserDto(SysUserDto value) {
        return new JAXBElement<SysUserDto>(_BzShelfDtoSysUserDto_QNAME, SysUserDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "productName", scope = BzProductDto.class)
    public JAXBElement<String> createBzProductDtoProductName(String value) {
        return new JAXBElement<String>(_BzProductDtoProductName_QNAME, String.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "productPrice", scope = BzProductDto.class)
    public JAXBElement<BigDecimal> createBzProductDtoProductPrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_BzProductDtoProductPrice_QNAME, BigDecimal.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzProductFavoriteDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzProductFavoriteDtos", scope = BzProductDto.class)
    public JAXBElement<BzProductFavoriteDto> createBzProductDtoBzProductFavoriteDtos(BzProductFavoriteDto value) {
        return new JAXBElement<BzProductFavoriteDto>(_BzProductDtoBzProductFavoriteDtos_QNAME, BzProductFavoriteDto.class, BzProductDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = BzProductFavoriteDto.class)
    public JAXBElement<Long> createBzProductFavoriteDtoId(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoId_QNAME, Long.class, BzProductFavoriteDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzProductDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzProductDto", scope = BzProductFavoriteDto.class)
    public JAXBElement<BzProductDto> createBzProductFavoriteDtoBzProductDto(BzProductDto value) {
        return new JAXBElement<BzProductDto>(_BzProductFavoriteDtoBzProductDto_QNAME, BzProductDto.class, BzProductFavoriteDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "type", scope = BzProductFavoriteDto.class)
    public JAXBElement<String> createBzProductFavoriteDtoType(String value) {
        return new JAXBElement<String>(_BzProductFavoriteDtoType_QNAME, String.class, BzProductFavoriteDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SysUserDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sysUserDto", scope = BzProductFavoriteDto.class)
    public JAXBElement<SysUserDto> createBzProductFavoriteDtoSysUserDto(SysUserDto value) {
        return new JAXBElement<SysUserDto>(_BzShelfDtoSysUserDto_QNAME, SysUserDto.class, BzProductFavoriteDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = BzUserPositionDto.class)
    public JAXBElement<Long> createBzUserPositionDtoId(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoId_QNAME, Long.class, BzUserPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "serviceCoverage", scope = BzUserPositionDto.class)
    public JAXBElement<Long> createBzUserPositionDtoServiceCoverage(Long value) {
        return new JAXBElement<Long>(_BzUserPositionDtoServiceCoverage_QNAME, Long.class, BzUserPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzPositionDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzPosition", scope = BzUserPositionDto.class)
    public JAXBElement<BzPositionDto> createBzUserPositionDtoBzPosition(BzPositionDto value) {
        return new JAXBElement<BzPositionDto>(_BzUserPositionDtoBzPosition_QNAME, BzPositionDto.class, BzUserPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SysUserDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sysUserDto", scope = BzUserPositionDto.class)
    public JAXBElement<SysUserDto> createBzUserPositionDtoSysUserDto(SysUserDto value) {
        return new JAXBElement<SysUserDto>(_BzShelfDtoSysUserDto_QNAME, SysUserDto.class, BzUserPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = BzPositionDto.class)
    public JAXBElement<Long> createBzPositionDtoId(Long value) {
        return new JAXBElement<Long>(_BzShelfDtoId_QNAME, Long.class, BzPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzUserTakeDeliveryAddressDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzUserTakeDeliveryAddresseDtos", scope = BzPositionDto.class)
    public JAXBElement<BzUserTakeDeliveryAddressDto> createBzPositionDtoBzUserTakeDeliveryAddresseDtos(BzUserTakeDeliveryAddressDto value) {
        return new JAXBElement<BzUserTakeDeliveryAddressDto>(_BzPositionDtoBzUserTakeDeliveryAddresseDtos_QNAME, BzUserTakeDeliveryAddressDto.class, BzPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzProductDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzProductDtos", scope = BzPositionDto.class)
    public JAXBElement<BzProductDto> createBzPositionDtoBzProductDtos(BzProductDto value) {
        return new JAXBElement<BzProductDto>(_BzPositionDtoBzProductDtos_QNAME, BzProductDto.class, BzPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzUserPositionDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzUserPositionDtos", scope = BzPositionDto.class)
    public JAXBElement<BzUserPositionDto> createBzPositionDtoBzUserPositionDtos(BzUserPositionDto value) {
        return new JAXBElement<BzUserPositionDto>(_BzPositionDtoBzUserPositionDtos_QNAME, BzUserPositionDto.class, BzPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "z", scope = BzPositionDto.class)
    public JAXBElement<BigDecimal> createBzPositionDtoZ(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_BzPositionDtoZ_QNAME, BigDecimal.class, BzPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "y", scope = BzPositionDto.class)
    public JAXBElement<BigDecimal> createBzPositionDtoY(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_BzPositionDtoY_QNAME, BigDecimal.class, BzPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BzUserDeliveryAddressDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bzUserDeliveryAddresseDtos", scope = BzPositionDto.class)
    public JAXBElement<BzUserDeliveryAddressDto> createBzPositionDtoBzUserDeliveryAddresseDtos(BzUserDeliveryAddressDto value) {
        return new JAXBElement<BzUserDeliveryAddressDto>(_BzPositionDtoBzUserDeliveryAddresseDtos_QNAME, BzUserDeliveryAddressDto.class, BzPositionDto.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "x", scope = BzPositionDto.class)
    public JAXBElement<BigDecimal> createBzPositionDtoX(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_BzPositionDtoX_QNAME, BigDecimal.class, BzPositionDto.class, value);
    }

}
