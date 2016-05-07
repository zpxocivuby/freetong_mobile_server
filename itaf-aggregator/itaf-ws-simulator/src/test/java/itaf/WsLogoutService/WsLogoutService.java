package itaf.WsLogoutService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-23T11:04:17.678+08:00
 * Generated source version: 3.0.1
 * 
 */
@WebService(targetNamespace = "itaf.framework.ws.server.platform", name = "WsLogoutService")
@XmlSeeAlso({ObjectFactory.class})
public interface WsLogoutService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "logout", targetNamespace = "itaf.framework.ws.server.platform", className = "itaf.WsLogoutService.Logout")
    @WebMethod
    @ResponseWrapper(localName = "logoutResponse", targetNamespace = "itaf.framework.ws.server.platform", className = "itaf.WsLogoutService.LogoutResponse")
    public itaf.WsLogoutService.WsPageResult logout(
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.Long userId
    );
}