
package itaf.WsSearchService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itaf.WsSearchService package. 
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

    private static final QName _SearchDistributionCompanysResponse_QNAME = new QName("itaf.framework.ws.server.search", "searchDistributionCompanysResponse");
    private static final QName _SearchProducts_QNAME = new QName("itaf.framework.ws.server.search", "searchProducts");
    private static final QName _GetBzDistributionCompanyDtoObjectResponse_QNAME = new QName("itaf.framework.ws.server.search", "getBzDistributionCompanyDtoObjectResponse");
    private static final QName _GetBzMerchantDtoObjectResponse_QNAME = new QName("itaf.framework.ws.server.search", "getBzMerchantDtoObjectResponse");
    private static final QName _GetBzProductDtoObject_QNAME = new QName("itaf.framework.ws.server.search", "getBzProductDtoObject");
    private static final QName _GetBzMerchantDtoObject_QNAME = new QName("itaf.framework.ws.server.search", "getBzMerchantDtoObject");
    private static final QName _SearchDistributionCompanys_QNAME = new QName("itaf.framework.ws.server.search", "searchDistributionCompanys");
    private static final QName _SearchProductsResponse_QNAME = new QName("itaf.framework.ws.server.search", "searchProductsResponse");
    private static final QName _GetBzProductDtoObjectResponse_QNAME = new QName("itaf.framework.ws.server.search", "getBzProductDtoObjectResponse");
    private static final QName _SearchMerchants_QNAME = new QName("itaf.framework.ws.server.search", "searchMerchants");
    private static final QName _GetBzDistributionCompanyDtoObject_QNAME = new QName("itaf.framework.ws.server.search", "getBzDistributionCompanyDtoObject");
    private static final QName _SearchMerchantsResponse_QNAME = new QName("itaf.framework.ws.server.search", "searchMerchantsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itaf.WsSearchService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchProducts }
     * 
     */
    public SearchProducts createSearchProducts() {
        return new SearchProducts();
    }

    /**
     * Create an instance of {@link SearchProducts.QueryMap }
     * 
     */
    public SearchProducts.QueryMap createSearchProductsQueryMap() {
        return new SearchProducts.QueryMap();
    }

    /**
     * Create an instance of {@link SearchMerchants }
     * 
     */
    public SearchMerchants createSearchMerchants() {
        return new SearchMerchants();
    }

    /**
     * Create an instance of {@link SearchMerchants.QueryMap }
     * 
     */
    public SearchMerchants.QueryMap createSearchMerchantsQueryMap() {
        return new SearchMerchants.QueryMap();
    }

    /**
     * Create an instance of {@link SearchDistributionCompanys }
     * 
     */
    public SearchDistributionCompanys createSearchDistributionCompanys() {
        return new SearchDistributionCompanys();
    }

    /**
     * Create an instance of {@link SearchDistributionCompanys.QueryMap }
     * 
     */
    public SearchDistributionCompanys.QueryMap createSearchDistributionCompanysQueryMap() {
        return new SearchDistributionCompanys.QueryMap();
    }

    /**
     * Create an instance of {@link SearchProductsResponse }
     * 
     */
    public SearchProductsResponse createSearchProductsResponse() {
        return new SearchProductsResponse();
    }

    /**
     * Create an instance of {@link GetBzProductDtoObjectResponse }
     * 
     */
    public GetBzProductDtoObjectResponse createGetBzProductDtoObjectResponse() {
        return new GetBzProductDtoObjectResponse();
    }

    /**
     * Create an instance of {@link SearchMerchantsResponse }
     * 
     */
    public SearchMerchantsResponse createSearchMerchantsResponse() {
        return new SearchMerchantsResponse();
    }

    /**
     * Create an instance of {@link GetBzDistributionCompanyDtoObject }
     * 
     */
    public GetBzDistributionCompanyDtoObject createGetBzDistributionCompanyDtoObject() {
        return new GetBzDistributionCompanyDtoObject();
    }

    /**
     * Create an instance of {@link SearchDistributionCompanysResponse }
     * 
     */
    public SearchDistributionCompanysResponse createSearchDistributionCompanysResponse() {
        return new SearchDistributionCompanysResponse();
    }

    /**
     * Create an instance of {@link GetBzProductDtoObject }
     * 
     */
    public GetBzProductDtoObject createGetBzProductDtoObject() {
        return new GetBzProductDtoObject();
    }

    /**
     * Create an instance of {@link GetBzMerchantDtoObjectResponse }
     * 
     */
    public GetBzMerchantDtoObjectResponse createGetBzMerchantDtoObjectResponse() {
        return new GetBzMerchantDtoObjectResponse();
    }

    /**
     * Create an instance of {@link GetBzDistributionCompanyDtoObjectResponse }
     * 
     */
    public GetBzDistributionCompanyDtoObjectResponse createGetBzDistributionCompanyDtoObjectResponse() {
        return new GetBzDistributionCompanyDtoObjectResponse();
    }

    /**
     * Create an instance of {@link GetBzMerchantDtoObject }
     * 
     */
    public GetBzMerchantDtoObject createGetBzMerchantDtoObject() {
        return new GetBzMerchantDtoObject();
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
     * Create an instance of {@link BzUserDeliveryAddressDto }
     * 
     */
    public BzUserDeliveryAddressDto createBzUserDeliveryAddressDto() {
        return new BzUserDeliveryAddressDto();
    }

    /**
     * Create an instance of {@link BzProductEvaluationDto }
     * 
     */
    public BzProductEvaluationDto createBzProductEvaluationDto() {
        return new BzProductEvaluationDto();
    }

    /**
     * Create an instance of {@link BzProductDto }
     * 
     */
    public BzProductDto createBzProductDto() {
        return new BzProductDto();
    }

    /**
     * Create an instance of {@link BzConsumerCreditEvalDto }
     * 
     */
    public BzConsumerCreditEvalDto createBzConsumerCreditEvalDto() {
        return new BzConsumerCreditEvalDto();
    }

    /**
     * Create an instance of {@link BzProductFavoriteDto }
     * 
     */
    public BzProductFavoriteDto createBzProductFavoriteDto() {
        return new BzProductFavoriteDto();
    }

    /**
     * Create an instance of {@link BzCollectionOrderDto }
     * 
     */
    public BzCollectionOrderDto createBzCollectionOrderDto() {
        return new BzCollectionOrderDto();
    }

    /**
     * Create an instance of {@link BzMerchantDto }
     * 
     */
    public BzMerchantDto createBzMerchantDto() {
        return new BzMerchantDto();
    }

    /**
     * Create an instance of {@link BzShelfDto }
     * 
     */
    public BzShelfDto createBzShelfDto() {
        return new BzShelfDto();
    }

    /**
     * Create an instance of {@link SysResourceDto }
     * 
     */
    public SysResourceDto createSysResourceDto() {
        return new SysResourceDto();
    }

    /**
     * Create an instance of {@link BzDistributionCompanyDto }
     * 
     */
    public BzDistributionCompanyDto createBzDistributionCompanyDto() {
        return new BzDistributionCompanyDto();
    }

    /**
     * Create an instance of {@link TrProductStockDto }
     * 
     */
    public TrProductStockDto createTrProductStockDto() {
        return new TrProductStockDto();
    }

    /**
     * Create an instance of {@link BzUserPositionDto }
     * 
     */
    public BzUserPositionDto createBzUserPositionDto() {
        return new BzUserPositionDto();
    }

    /**
     * Create an instance of {@link BzConsumerCreditDto }
     * 
     */
    public BzConsumerCreditDto createBzConsumerCreditDto() {
        return new BzConsumerCreditDto();
    }

    /**
     * Create an instance of {@link BzServiceProviderTypeDto }
     * 
     */
    public BzServiceProviderTypeDto createBzServiceProviderTypeDto() {
        return new BzServiceProviderTypeDto();
    }

    /**
     * Create an instance of {@link WsPageResult }
     * 
     */
    public WsPageResult createWsPageResult() {
        return new WsPageResult();
    }

    /**
     * Create an instance of {@link BzOrderPaymentDto }
     * 
     */
    public BzOrderPaymentDto createBzOrderPaymentDto() {
        return new BzOrderPaymentDto();
    }

    /**
     * Create an instance of {@link BzStockOrderDto }
     * 
     */
    public BzStockOrderDto createBzStockOrderDto() {
        return new BzStockOrderDto();
    }

    /**
     * Create an instance of {@link BzProductCategoryDto }
     * 
     */
    public BzProductCategoryDto createBzProductCategoryDto() {
        return new BzProductCategoryDto();
    }

    /**
     * Create an instance of {@link BzMerchantCreditEvalDto }
     * 
     */
    public BzMerchantCreditEvalDto createBzMerchantCreditEvalDto() {
        return new BzMerchantCreditEvalDto();
    }

    /**
     * Create an instance of {@link BzOrderDto }
     * 
     */
    public BzOrderDto createBzOrderDto() {
        return new BzOrderDto();
    }

    /**
     * Create an instance of {@link BzMerchantCreditDto }
     * 
     */
    public BzMerchantCreditDto createBzMerchantCreditDto() {
        return new BzMerchantCreditDto();
    }

    /**
     * Create an instance of {@link BzPaymentTypeDto }
     * 
     */
    public BzPaymentTypeDto createBzPaymentTypeDto() {
        return new BzPaymentTypeDto();
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
     * Create an instance of {@link BzStockOrderItemDto }
     * 
     */
    public BzStockOrderItemDto createBzStockOrderItemDto() {
        return new BzStockOrderItemDto();
    }

    /**
     * Create an instance of {@link TrProductStockIdDto }
     * 
     */
    public TrProductStockIdDto createTrProductStockIdDto() {
        return new TrProductStockIdDto();
    }

    /**
     * Create an instance of {@link BzDistributionModelDto }
     * 
     */
    public BzDistributionModelDto createBzDistributionModelDto() {
        return new BzDistributionModelDto();
    }

    /**
     * Create an instance of {@link BzOrderItemDto }
     * 
     */
    public BzOrderItemDto createBzOrderItemDto() {
        return new BzOrderItemDto();
    }

    /**
     * Create an instance of {@link BzCartItemDto }
     * 
     */
    public BzCartItemDto createBzCartItemDto() {
        return new BzCartItemDto();
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
     * Create an instance of {@link BzProductAttachmentDto }
     * 
     */
    public BzProductAttachmentDto createBzProductAttachmentDto() {
        return new BzProductAttachmentDto();
    }

    /**
     * Create an instance of {@link BzProductBrandDto }
     * 
     */
    public BzProductBrandDto createBzProductBrandDto() {
        return new BzProductBrandDto();
    }

    /**
     * Create an instance of {@link BzUserTakeDeliveryAddressDto }
     * 
     */
    public BzUserTakeDeliveryAddressDto createBzUserTakeDeliveryAddressDto() {
        return new BzUserTakeDeliveryAddressDto();
    }

    /**
     * Create an instance of {@link BzDistComCreditEvalDto }
     * 
     */
    public BzDistComCreditEvalDto createBzDistComCreditEvalDto() {
        return new BzDistComCreditEvalDto();
    }

    /**
     * Create an instance of {@link SearchProducts.QueryMap.Entry }
     * 
     */
    public SearchProducts.QueryMap.Entry createSearchProductsQueryMapEntry() {
        return new SearchProducts.QueryMap.Entry();
    }

    /**
     * Create an instance of {@link SearchMerchants.QueryMap.Entry }
     * 
     */
    public SearchMerchants.QueryMap.Entry createSearchMerchantsQueryMapEntry() {
        return new SearchMerchants.QueryMap.Entry();
    }

    /**
     * Create an instance of {@link SearchDistributionCompanys.QueryMap.Entry }
     * 
     */
    public SearchDistributionCompanys.QueryMap.Entry createSearchDistributionCompanysQueryMapEntry() {
        return new SearchDistributionCompanys.QueryMap.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchDistributionCompanysResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "searchDistributionCompanysResponse")
    public JAXBElement<SearchDistributionCompanysResponse> createSearchDistributionCompanysResponse(SearchDistributionCompanysResponse value) {
        return new JAXBElement<SearchDistributionCompanysResponse>(_SearchDistributionCompanysResponse_QNAME, SearchDistributionCompanysResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "searchProducts")
    public JAXBElement<SearchProducts> createSearchProducts(SearchProducts value) {
        return new JAXBElement<SearchProducts>(_SearchProducts_QNAME, SearchProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBzDistributionCompanyDtoObjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "getBzDistributionCompanyDtoObjectResponse")
    public JAXBElement<GetBzDistributionCompanyDtoObjectResponse> createGetBzDistributionCompanyDtoObjectResponse(GetBzDistributionCompanyDtoObjectResponse value) {
        return new JAXBElement<GetBzDistributionCompanyDtoObjectResponse>(_GetBzDistributionCompanyDtoObjectResponse_QNAME, GetBzDistributionCompanyDtoObjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBzMerchantDtoObjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "getBzMerchantDtoObjectResponse")
    public JAXBElement<GetBzMerchantDtoObjectResponse> createGetBzMerchantDtoObjectResponse(GetBzMerchantDtoObjectResponse value) {
        return new JAXBElement<GetBzMerchantDtoObjectResponse>(_GetBzMerchantDtoObjectResponse_QNAME, GetBzMerchantDtoObjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBzProductDtoObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "getBzProductDtoObject")
    public JAXBElement<GetBzProductDtoObject> createGetBzProductDtoObject(GetBzProductDtoObject value) {
        return new JAXBElement<GetBzProductDtoObject>(_GetBzProductDtoObject_QNAME, GetBzProductDtoObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBzMerchantDtoObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "getBzMerchantDtoObject")
    public JAXBElement<GetBzMerchantDtoObject> createGetBzMerchantDtoObject(GetBzMerchantDtoObject value) {
        return new JAXBElement<GetBzMerchantDtoObject>(_GetBzMerchantDtoObject_QNAME, GetBzMerchantDtoObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchDistributionCompanys }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "searchDistributionCompanys")
    public JAXBElement<SearchDistributionCompanys> createSearchDistributionCompanys(SearchDistributionCompanys value) {
        return new JAXBElement<SearchDistributionCompanys>(_SearchDistributionCompanys_QNAME, SearchDistributionCompanys.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "searchProductsResponse")
    public JAXBElement<SearchProductsResponse> createSearchProductsResponse(SearchProductsResponse value) {
        return new JAXBElement<SearchProductsResponse>(_SearchProductsResponse_QNAME, SearchProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBzProductDtoObjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "getBzProductDtoObjectResponse")
    public JAXBElement<GetBzProductDtoObjectResponse> createGetBzProductDtoObjectResponse(GetBzProductDtoObjectResponse value) {
        return new JAXBElement<GetBzProductDtoObjectResponse>(_GetBzProductDtoObjectResponse_QNAME, GetBzProductDtoObjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchMerchants }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "searchMerchants")
    public JAXBElement<SearchMerchants> createSearchMerchants(SearchMerchants value) {
        return new JAXBElement<SearchMerchants>(_SearchMerchants_QNAME, SearchMerchants.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBzDistributionCompanyDtoObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "getBzDistributionCompanyDtoObject")
    public JAXBElement<GetBzDistributionCompanyDtoObject> createGetBzDistributionCompanyDtoObject(GetBzDistributionCompanyDtoObject value) {
        return new JAXBElement<GetBzDistributionCompanyDtoObject>(_GetBzDistributionCompanyDtoObject_QNAME, GetBzDistributionCompanyDtoObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchMerchantsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.search", name = "searchMerchantsResponse")
    public JAXBElement<SearchMerchantsResponse> createSearchMerchantsResponse(SearchMerchantsResponse value) {
        return new JAXBElement<SearchMerchantsResponse>(_SearchMerchantsResponse_QNAME, SearchMerchantsResponse.class, null, value);
    }

}
