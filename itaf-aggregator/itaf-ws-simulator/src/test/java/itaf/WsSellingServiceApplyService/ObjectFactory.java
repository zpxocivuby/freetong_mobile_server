
package itaf.WsSellingServiceApplyService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itaf.WsSellingServiceApplyService package. 
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

    private static final QName _CreateResponse_QNAME = new QName("itaf.framework.ws.server.certificate", "createResponse");
    private static final QName _FindCertificatedResponse_QNAME = new QName("itaf.framework.ws.server.certificate", "findCertificatedResponse");
    private static final QName _FindCertificating_QNAME = new QName("itaf.framework.ws.server.certificate", "findCertificating");
    private static final QName _Create_QNAME = new QName("itaf.framework.ws.server.certificate", "create");
    private static final QName _FindCertificated_QNAME = new QName("itaf.framework.ws.server.certificate", "findCertificated");
    private static final QName _FindCertificatingResponse_QNAME = new QName("itaf.framework.ws.server.certificate", "findCertificatingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itaf.WsSellingServiceApplyService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindCertificatingResponse }
     * 
     */
    public FindCertificatingResponse createFindCertificatingResponse() {
        return new FindCertificatingResponse();
    }

    /**
     * Create an instance of {@link FindCertificated }
     * 
     */
    public FindCertificated createFindCertificated() {
        return new FindCertificated();
    }

    /**
     * Create an instance of {@link FindCertificating }
     * 
     */
    public FindCertificating createFindCertificating() {
        return new FindCertificating();
    }

    /**
     * Create an instance of {@link FindCertificatedResponse }
     * 
     */
    public FindCertificatedResponse createFindCertificatedResponse() {
        return new FindCertificatedResponse();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link SysRoleDto }
     * 
     */
    public SysRoleDto createSysRoleDto() {
        return new SysRoleDto();
    }

    /**
     * Create an instance of {@link WsPageResult }
     * 
     */
    public WsPageResult createWsPageResult() {
        return new WsPageResult();
    }

    /**
     * Create an instance of {@link BzMerchantCertificateDto }
     * 
     */
    public BzMerchantCertificateDto createBzMerchantCertificateDto() {
        return new BzMerchantCertificateDto();
    }

    /**
     * Create an instance of {@link BzDistServiceApplyDto }
     * 
     */
    public BzDistServiceApplyDto createBzDistServiceApplyDto() {
        return new BzDistServiceApplyDto();
    }

    /**
     * Create an instance of {@link BzSellingServiceApplyDto }
     * 
     */
    public BzSellingServiceApplyDto createBzSellingServiceApplyDto() {
        return new BzSellingServiceApplyDto();
    }

    /**
     * Create an instance of {@link SysResourceDto }
     * 
     */
    public SysResourceDto createSysResourceDto() {
        return new SysResourceDto();
    }

    /**
     * Create an instance of {@link SysUserDto }
     * 
     */
    public SysUserDto createSysUserDto() {
        return new SysUserDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.certificate", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCertificatedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.certificate", name = "findCertificatedResponse")
    public JAXBElement<FindCertificatedResponse> createFindCertificatedResponse(FindCertificatedResponse value) {
        return new JAXBElement<FindCertificatedResponse>(_FindCertificatedResponse_QNAME, FindCertificatedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCertificating }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.certificate", name = "findCertificating")
    public JAXBElement<FindCertificating> createFindCertificating(FindCertificating value) {
        return new JAXBElement<FindCertificating>(_FindCertificating_QNAME, FindCertificating.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.certificate", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCertificated }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.certificate", name = "findCertificated")
    public JAXBElement<FindCertificated> createFindCertificated(FindCertificated value) {
        return new JAXBElement<FindCertificated>(_FindCertificated_QNAME, FindCertificated.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCertificatingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.certificate", name = "findCertificatingResponse")
    public JAXBElement<FindCertificatingResponse> createFindCertificatingResponse(FindCertificatingResponse value) {
        return new JAXBElement<FindCertificatingResponse>(_FindCertificatingResponse_QNAME, FindCertificatingResponse.class, null, value);
    }

}
