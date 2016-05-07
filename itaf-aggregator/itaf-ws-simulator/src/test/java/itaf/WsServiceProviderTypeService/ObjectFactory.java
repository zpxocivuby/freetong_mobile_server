
package itaf.WsServiceProviderTypeService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itaf.WsServiceProviderTypeService package. 
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

    private static final QName _SyncToClient_QNAME = new QName("itaf.framework.ws.server.merchant", "syncToClient");
    private static final QName _SyncToClientResponse_QNAME = new QName("itaf.framework.ws.server.merchant", "syncToClientResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itaf.WsServiceProviderTypeService
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
     * Create an instance of {@link BzMerchantDto }
     * 
     */
    public BzMerchantDto createBzMerchantDto() {
        return new BzMerchantDto();
    }

    /**
     * Create an instance of {@link BzDistributionCompanyDto }
     * 
     */
    public BzDistributionCompanyDto createBzDistributionCompanyDto() {
        return new BzDistributionCompanyDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncToClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.merchant", name = "syncToClient")
    public JAXBElement<SyncToClient> createSyncToClient(SyncToClient value) {
        return new JAXBElement<SyncToClient>(_SyncToClient_QNAME, SyncToClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncToClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.merchant", name = "syncToClientResponse")
    public JAXBElement<SyncToClientResponse> createSyncToClientResponse(SyncToClientResponse value) {
        return new JAXBElement<SyncToClientResponse>(_SyncToClientResponse_QNAME, SyncToClientResponse.class, null, value);
    }

}
