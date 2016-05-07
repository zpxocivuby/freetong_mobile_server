
package itaf.WsMerchantFavoriteService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itaf.WsMerchantFavoriteService package. 
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

    private static final QName _FindPagerByUserId_QNAME = new QName("itaf.framework.ws.server.merchant", "findPagerByUserId");
    private static final QName _FindPagerByUserIdResponse_QNAME = new QName("itaf.framework.ws.server.merchant", "findPagerByUserIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itaf.WsMerchantFavoriteService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindPagerByUserIdResponse }
     * 
     */
    public FindPagerByUserIdResponse createFindPagerByUserIdResponse() {
        return new FindPagerByUserIdResponse();
    }

    /**
     * Create an instance of {@link FindPagerByUserId }
     * 
     */
    public FindPagerByUserId createFindPagerByUserId() {
        return new FindPagerByUserId();
    }

    /**
     * Create an instance of {@link BzMerchantFavoriteDto }
     * 
     */
    public BzMerchantFavoriteDto createBzMerchantFavoriteDto() {
        return new BzMerchantFavoriteDto();
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
     * Create an instance of {@link SysUserDto }
     * 
     */
    public SysUserDto createSysUserDto() {
        return new SysUserDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPagerByUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.merchant", name = "findPagerByUserId")
    public JAXBElement<FindPagerByUserId> createFindPagerByUserId(FindPagerByUserId value) {
        return new JAXBElement<FindPagerByUserId>(_FindPagerByUserId_QNAME, FindPagerByUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPagerByUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "itaf.framework.ws.server.merchant", name = "findPagerByUserIdResponse")
    public JAXBElement<FindPagerByUserIdResponse> createFindPagerByUserIdResponse(FindPagerByUserIdResponse value) {
        return new JAXBElement<FindPagerByUserIdResponse>(_FindPagerByUserIdResponse_QNAME, FindPagerByUserIdResponse.class, null, value);
    }

}
