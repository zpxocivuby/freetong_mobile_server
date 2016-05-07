
package itaf.WsMerchantService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itaf.WsMerchantService package. 
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

    private static final QName _GetById_QNAME = new QName("itaf.framework.ws.server.merchant", "getById");
    private static final QName _GetByIdResponse_QNAME = new QName("itaf.framework.ws.server.merchant", "getByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itaf.WsMerchantService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetById }
     * 
     */
    public GetById createGetById() {
        return new GetById();
    }

    /**
     * Create an instance of {@link GetByIdResponse }
     * 
     */
    public GetByIdResponse createGetByIdResponse() {
        return new GetByIdResponse();
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
     * Create an instance of {@link BzDistributionCompanyDto }
     * 
     */
    public BzDistributionCompanyDto createBzDistributionCompanyDto() {
        return new BzDistributionCompanyDto();
    }

    /**
     * Create an instance of {@link BzMerchantDto }
     * 
     */
    public BzMerchantDto createBzMerchantDto() {
        return new BzMerchantDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.merchant", name = "getById")
    public JAXBElement<GetById> createGetById(GetById value) {
        return new JAXBElement<GetById>(_GetById_QNAME, GetById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.merchant", name = "getByIdResponse")
    public JAXBElement<GetByIdResponse> createGetByIdResponse(GetByIdResponse value) {
        return new JAXBElement<GetByIdResponse>(_GetByIdResponse_QNAME, GetByIdResponse.class, null, value);
    }

}
