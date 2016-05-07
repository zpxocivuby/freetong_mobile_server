
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package itaf.WsOrderService;

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
 * 2014-10-10T09:30:22.509+08:00
 * Generated source version: 3.0.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "WsOrderService",
                      portName = "WsOrderServiceImplPort",
                      targetNamespace = "http://impl.order.server.ws.framework.itaf/",
                      wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsOrderService?wsdl",
                      endpointInterface = "itaf.WsOrderService.WsOrderService")
                      
public class WsOrderServiceImplPortImpl implements WsOrderService {

    private static final Logger LOG = Logger.getLogger(WsOrderServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see itaf.WsOrderService.WsOrderService#findPager(java.lang.Long  userId ,)int  orderStatus ,)int  currentIndex ,)int  pageSize )*
     */
    public itaf.WsOrderService.WsPageResult findPager(java.lang.Long userId,int orderStatus,int currentIndex,int pageSize) { 
        LOG.info("Executing operation findPager");
        System.out.println(userId);
        System.out.println(orderStatus);
        System.out.println(currentIndex);
        System.out.println(pageSize);
        try {
            itaf.WsOrderService.WsPageResult _return = new itaf.WsOrderService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(-559307015);
            _return.setCurrentPage(723463913);
            _return.setPageSize(146652928);
            _return.setStatus("Status-897494888");
            _return.setStatusCode("StatusCode466688041");
            _return.setTotalCount(1458854993);
            _return.setTotalPage(156816332);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see itaf.WsOrderService.WsOrderService#payment(java.lang.String  cartIds )*
     */
    public itaf.WsOrderService.WsPageResult payment(java.lang.String cartIds) { 
        LOG.info("Executing operation payment");
        System.out.println(cartIds);
        try {
            itaf.WsOrderService.WsPageResult _return = new itaf.WsOrderService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(1548706192);
            _return.setCurrentPage(-712772765);
            _return.setPageSize(780587311);
            _return.setStatus("Status171006402");
            _return.setStatusCode("StatusCode603788608");
            _return.setTotalCount(-788645716);
            _return.setTotalPage(-445929558);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see itaf.WsOrderService.WsOrderService#confirmReceived(java.lang.Long  id )*
     */
    public itaf.WsOrderService.WsPageResult confirmReceived(java.lang.Long id) { 
        LOG.info("Executing operation confirmReceived");
        System.out.println(id);
        try {
            itaf.WsOrderService.WsPageResult _return = new itaf.WsOrderService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(99946370);
            _return.setCurrentPage(1445671672);
            _return.setPageSize(-467479577);
            _return.setStatus("Status1824344114");
            _return.setStatusCode("StatusCode-1600713854");
            _return.setTotalCount(-1947310653);
            _return.setTotalPage(-1660152235);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
