package itaf.WsUserTakeDeliveryAddressService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-25T10:48:09.959+08:00
 * Generated source version: 3.0.1
 * 
 */
@WebService(targetNamespace = "itaf.framework.ws.server.consumer", name = "WsUserTakeDeliveryAddressService")
@XmlSeeAlso({ObjectFactory.class})
public interface WsUserTakeDeliveryAddressService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findListByUserId", targetNamespace = "itaf.framework.ws.server.consumer", className = "itaf.WsUserTakeDeliveryAddressService.FindListByUserId")
    @WebMethod
    @ResponseWrapper(localName = "findListByUserIdResponse", targetNamespace = "itaf.framework.ws.server.consumer", className = "itaf.WsUserTakeDeliveryAddressService.FindListByUserIdResponse")
    public itaf.WsUserTakeDeliveryAddressService.WsPageResult findListByUserId(
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.Long userId
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getById", targetNamespace = "itaf.framework.ws.server.consumer", className = "itaf.WsUserTakeDeliveryAddressService.GetById")
    @WebMethod
    @ResponseWrapper(localName = "getByIdResponse", targetNamespace = "itaf.framework.ws.server.consumer", className = "itaf.WsUserTakeDeliveryAddressService.GetByIdResponse")
    public itaf.WsUserTakeDeliveryAddressService.WsPageResult getById(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.Long id
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "saveOrUpdate", targetNamespace = "itaf.framework.ws.server.consumer", className = "itaf.WsUserTakeDeliveryAddressService.SaveOrUpdate")
    @WebMethod
    @ResponseWrapper(localName = "saveOrUpdateResponse", targetNamespace = "itaf.framework.ws.server.consumer", className = "itaf.WsUserTakeDeliveryAddressService.SaveOrUpdateResponse")
    public itaf.WsUserTakeDeliveryAddressService.WsPageResult saveOrUpdate(
        @WebParam(name = "dto", targetNamespace = "")
        itaf.WsUserTakeDeliveryAddressService.BzUserTakeDeliveryAddressDto dto
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deleteById", targetNamespace = "itaf.framework.ws.server.consumer", className = "itaf.WsUserTakeDeliveryAddressService.DeleteById")
    @WebMethod
    @ResponseWrapper(localName = "deleteByIdResponse", targetNamespace = "itaf.framework.ws.server.consumer", className = "itaf.WsUserTakeDeliveryAddressService.DeleteByIdResponse")
    public itaf.WsUserTakeDeliveryAddressService.WsPageResult deleteById(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.Long id
    );
}
