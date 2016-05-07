package itaf.WsCollectionOrderService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-19T15:15:43.730+08:00
 * Generated source version: 3.0.1
 * 
 */
@WebService(targetNamespace = "itaf.framework.ws.server.merchant", name = "WsCollectionOrderService")
@XmlSeeAlso({ObjectFactory.class})
public interface WsCollectionOrderService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "confirmCollection", targetNamespace = "itaf.framework.ws.server.merchant", className = "itaf.WsCollectionOrderService.ConfirmCollection")
    @WebMethod
    @ResponseWrapper(localName = "confirmCollectionResponse", targetNamespace = "itaf.framework.ws.server.merchant", className = "itaf.WsCollectionOrderService.ConfirmCollectionResponse")
    public itaf.WsCollectionOrderService.WsPageResult confirmCollection(
        @WebParam(name = "bzCollectionOrderDto", targetNamespace = "")
        itaf.WsCollectionOrderService.BzCollectionOrderDto bzCollectionOrderDto
    );
}
