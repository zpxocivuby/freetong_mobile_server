
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package itaf.WsStockOrderService;

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
 * 2014-09-24T18:01:30.999+08:00
 * Generated source version: 3.0.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "WsStockOrderService",
                      portName = "WsStockOrderServiceImplPort",
                      targetNamespace = "http://impl.merchant.server.ws.framework.itaf/",
                      wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsStockOrderService?wsdl",
                      endpointInterface = "itaf.WsStockOrderService.WsStockOrderService")
                      
public class WsStockOrderServiceImplPortImpl implements WsStockOrderService {

    private static final Logger LOG = Logger.getLogger(WsStockOrderServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see itaf.WsStockOrderService.WsStockOrderService#create(java.lang.String  orderIds ,)java.lang.Long  merchantId )*
     */
    public itaf.WsStockOrderService.WsPageResult create(java.lang.String orderIds,java.lang.Long merchantId) { 
        LOG.info("Executing operation create");
        System.out.println(orderIds);
        System.out.println(merchantId);
        try {
            itaf.WsStockOrderService.WsPageResult _return = new itaf.WsStockOrderService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(335050806);
            _return.setCurrentPage(-412285460);
            _return.setPageSize(1011287941);
            _return.setStatus("Status704888761");
            _return.setStatusCode("StatusCode478533699");
            _return.setTotalCount(-1750243933);
            _return.setTotalPage(1452378751);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
