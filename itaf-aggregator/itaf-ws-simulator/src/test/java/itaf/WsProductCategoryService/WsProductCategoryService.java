package itaf.WsProductCategoryService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-18T11:13:10.481+08:00
 * Generated source version: 3.0.1
 * 
 */
@WebService(targetNamespace = "itaf.framework.ws.server.product", name = "WsProductCategoryService")
@XmlSeeAlso({ObjectFactory.class})
public interface WsProductCategoryService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "syncToClient", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductCategoryService.SyncToClient")
    @WebMethod
    @ResponseWrapper(localName = "syncToClientResponse", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductCategoryService.SyncToClientResponse")
    public itaf.WsProductCategoryService.WsPageResult syncToClient(
        @WebParam(name = "updateTime", targetNamespace = "")
        java.lang.String updateTime
    );
}
