
package itaf.WsRealnameCertificateApplyService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itaf.WsRealnameCertificateApplyService package. 
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
    private static final QName _Create_QNAME = new QName("itaf.framework.ws.server.certificate", "create");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itaf.WsRealnameCertificateApplyService
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link SysResourceDto }
     * 
     */
    public SysResourceDto createSysResourceDto() {
        return new SysResourceDto();
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
     * Create an instance of {@link BzRealnameCertificateApplyDto }
     * 
     */
    public BzRealnameCertificateApplyDto createBzRealnameCertificateApplyDto() {
        return new BzRealnameCertificateApplyDto();
    }

    /**
     * Create an instance of {@link SysUserDto }
     * 
     */
    public SysUserDto createSysUserDto() {
        return new SysUserDto();
    }

    /**
     * Create an instance of {@link BzRealnameCertificateDto }
     * 
     */
    public BzRealnameCertificateDto createBzRealnameCertificateDto() {
        return new BzRealnameCertificateDto();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.certificate", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

}
