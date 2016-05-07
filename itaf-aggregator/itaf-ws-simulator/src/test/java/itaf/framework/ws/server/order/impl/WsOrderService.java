package itaf.framework.ws.server.order.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-10-10T09:30:22.540+08:00
 * Generated source version: 3.0.1
 * 
 */
@WebServiceClient(name = "WsOrderService", 
                  wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsOrderService?wsdl",
                  targetNamespace = "http://impl.order.server.ws.framework.itaf/") 
public class WsOrderService extends Service {

    public static final URL WSDL_LOCATION;

    public static final QName SERVICE = new QName("http://impl.order.server.ws.framework.itaf/", "WsOrderService");
    public static final QName WsOrderServiceImplPort = new QName("http://impl.order.server.ws.framework.itaf/", "WsOrderServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/itaf-web-side/service/WsOrderService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WsOrderService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/itaf-web-side/service/WsOrderService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WsOrderService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WsOrderService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsOrderService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WsOrderService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WsOrderService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WsOrderService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns WsOrderService
     */
    @WebEndpoint(name = "WsOrderServiceImplPort")
    public itaf.WsOrderService.WsOrderService getWsOrderServiceImplPort() {
        return super.getPort(WsOrderServiceImplPort, itaf.WsOrderService.WsOrderService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsOrderService
     */
    @WebEndpoint(name = "WsOrderServiceImplPort")
    public itaf.WsOrderService.WsOrderService getWsOrderServiceImplPort(WebServiceFeature... features) {
        return super.getPort(WsOrderServiceImplPort, itaf.WsOrderService.WsOrderService.class, features);
    }

}