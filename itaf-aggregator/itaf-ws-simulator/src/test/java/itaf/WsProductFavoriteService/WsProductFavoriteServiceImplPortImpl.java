
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package itaf.WsProductFavoriteService;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-24T10:50:20.624+08:00
 * Generated source version: 3.0.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "WsProductFavoriteService",
                      portName = "WsProductFavoriteServiceImplPort",
                      targetNamespace = "http://impl.product.server.ws.framework.itaf/",
                      wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsProductFavoriteService?wsdl",
                      endpointInterface = "itaf.WsProductFavoriteService.WsProductFavoriteService")
                      
public class WsProductFavoriteServiceImplPortImpl implements WsProductFavoriteService {

    private static final Logger LOG = Logger.getLogger(WsProductFavoriteServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see itaf.WsProductFavoriteService.WsProductFavoriteService#findPagerByUserId(java.lang.Long  userId ,)int  currentIndex ,)int  pageSize )*
     */
    public itaf.WsProductFavoriteService.WsPageResult findPagerByUserId(java.lang.Long userId,int currentIndex,int pageSize) { 
        LOG.info("Executing operation findPagerByUserId");
        System.out.println(userId);
        System.out.println(currentIndex);
        System.out.println(pageSize);
        try {
            itaf.WsProductFavoriteService.WsPageResult _return = new itaf.WsProductFavoriteService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(-1018042173);
            _return.setCurrentPage(463516939);
            _return.setPageSize(526116301);
            _return.setStatus("Status42297071");
            _return.setStatusCode("StatusCode-1347866177");
            _return.setTotalCount(410424999);
            _return.setTotalPage(-1889497771);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
