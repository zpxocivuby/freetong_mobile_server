package itaf.framework.ws.server.merchant.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-24T18:01:31.019+08:00
 * Generated source version: 3.0.1
 * 
 */
@WebServiceClient(name = "WsStockOrderService", 
                  wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsStockOrderService?wsdl",
                  targetNamespace = "http://impl.merchant.server.ws.framework.itaf/") 
public class WsStockOrderService extends Service {

    public static final URL WSDL_LOCATION;

    public static final QName SERVICE = new QName("http://impl.merchant.server.ws.framework.itaf/", "WsStockOrderService");
    public static final QName WsStockOrderServiceImplPort = new QName("http://impl.merchant.server.ws.framework.itaf/", "WsStockOrderServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/itaf-web-side/service/WsStockOrderService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WsStockOrderService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/itaf-web-side/service/WsStockOrderService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WsStockOrderService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WsStockOrderService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsStockOrderService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WsStockOrderService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WsStockOrderService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WsStockOrderService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns WsStockOrderService
     */
    @WebEndpoint(name = "WsStockOrderServiceImplPort")
    public itaf.WsStockOrderService.WsStockOrderService getWsStockOrderServiceImplPort() {
        return super.getPort(WsStockOrderServiceImplPort, itaf.WsStockOrderService.WsStockOrderService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsStockOrderService
     */
    @WebEndpoint(name = "WsStockOrderServiceImplPort")
    public itaf.WsStockOrderService.WsStockOrderService getWsStockOrderServiceImplPort(WebServiceFeature... features) {
        return super.getPort(WsStockOrderServiceImplPort, itaf.WsStockOrderService.WsStockOrderService.class, features);
    }

}
