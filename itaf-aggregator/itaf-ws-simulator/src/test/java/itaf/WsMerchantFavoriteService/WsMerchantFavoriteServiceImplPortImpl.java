
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package itaf.WsMerchantFavoriteService;

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
 * 2014-09-23T14:10:15.670+08:00
 * Generated source version: 3.0.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "wsMerchantFavoriteService",
                      portName = "WsMerchantFavoriteServiceImplPort",
                      targetNamespace = "http://impl.merchant.server.ws.framework.itaf/",
                      wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsMerchantFavoriteService?wsdl",
                      endpointInterface = "itaf.WsMerchantFavoriteService.WsMerchantFavoriteService")
                      
public class WsMerchantFavoriteServiceImplPortImpl implements WsMerchantFavoriteService {

    private static final Logger LOG = Logger.getLogger(WsMerchantFavoriteServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see itaf.WsMerchantFavoriteService.WsMerchantFavoriteService#findPagerByUserId(java.lang.Long  userId ,)int  currentIndex ,)int  pageSize )*
     */
    public itaf.WsMerchantFavoriteService.WsPageResult findPagerByUserId(java.lang.Long userId,int currentIndex,int pageSize) { 
        LOG.info("Executing operation findPagerByUserId");
        System.out.println(userId);
        System.out.println(currentIndex);
        System.out.println(pageSize);
        try {
            itaf.WsMerchantFavoriteService.WsPageResult _return = new itaf.WsMerchantFavoriteService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(-1940826675);
            _return.setCurrentPage(-176198944);
            _return.setPageSize(1415877742);
            _return.setStatus("Status-1216997857");
            _return.setStatusCode("StatusCode-1815110436");
            _return.setTotalCount(2018553551);
            _return.setTotalPage(-456977820);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
