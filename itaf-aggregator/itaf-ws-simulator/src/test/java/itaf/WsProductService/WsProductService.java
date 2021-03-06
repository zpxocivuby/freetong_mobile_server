package itaf.WsProductService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-18T14:17:59.366+08:00
 * Generated source version: 3.0.1
 * 
 */
@WebService(targetNamespace = "itaf.framework.ws.server.product", name = "WsProductService")
@XmlSeeAlso({ObjectFactory.class})
public interface WsProductService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deleteByIds", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.DeleteByIds")
    @WebMethod
    @ResponseWrapper(localName = "deleteByIdsResponse", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.DeleteByIdsResponse")
    public itaf.WsProductService.WsPageResult deleteByIds(
        @WebParam(name = "ids", targetNamespace = "")
        java.lang.String ids
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "removeProductsFromShelf", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.RemoveProductsFromShelf")
    @WebMethod
    @ResponseWrapper(localName = "removeProductsFromShelfResponse", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.RemoveProductsFromShelfResponse")
    public itaf.WsProductService.WsPageResult removeProductsFromShelf(
        @WebParam(name = "ids", targetNamespace = "")
        java.lang.String ids
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getById", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.GetById")
    @WebMethod
    @ResponseWrapper(localName = "getByIdResponse", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.GetByIdResponse")
    public itaf.WsProductService.WsPageResult getById(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.Long id
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createOrUpdate", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.CreateOrUpdate")
    @WebMethod
    @ResponseWrapper(localName = "createOrUpdateResponse", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.CreateOrUpdateResponse")
    public itaf.WsProductService.WsPageResult createOrUpdate(
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.Long userId,
        @WebParam(name = "dto", targetNamespace = "")
        itaf.WsProductService.BzProductDto dto
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "putProductsOnShelf", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.PutProductsOnShelf")
    @WebMethod
    @ResponseWrapper(localName = "putProductsOnShelfResponse", targetNamespace = "itaf.framework.ws.server.product", className = "itaf.WsProductService.PutProductsOnShelfResponse")
    public itaf.WsProductService.WsPageResult putProductsOnShelf(
        @WebParam(name = "ids", targetNamespace = "")
        java.lang.String ids
    );
}
