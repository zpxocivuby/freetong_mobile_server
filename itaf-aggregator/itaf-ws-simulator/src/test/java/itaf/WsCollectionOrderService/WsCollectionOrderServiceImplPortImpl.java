
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package itaf.WsCollectionOrderService;

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
 * 2014-09-19T15:15:43.714+08:00
 * Generated source version: 3.0.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "WsCollectionOrderService",
                      portName = "WsCollectionOrderServiceImplPort",
                      targetNamespace = "http://impl.merchant.server.ws.framework.itaf/",
                      wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsCollectionOrderService?wsdl",
                      endpointInterface = "itaf.WsCollectionOrderService.WsCollectionOrderService")
                      
public class WsCollectionOrderServiceImplPortImpl implements WsCollectionOrderService {

    private static final Logger LOG = Logger.getLogger(WsCollectionOrderServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see itaf.WsCollectionOrderService.WsCollectionOrderService#confirmCollection(itaf.WsCollectionOrderService.BzCollectionOrderDto  bzCollectionOrderDto )*
     */
    public itaf.WsCollectionOrderService.WsPageResult confirmCollection(itaf.WsCollectionOrderService.BzCollectionOrderDto bzCollectionOrderDto) { 
        LOG.info("Executing operation confirmCollection");
        System.out.println(bzCollectionOrderDto);
        try {
            itaf.WsCollectionOrderService.WsPageResult _return = new itaf.WsCollectionOrderService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(-434065338);
            _return.setCurrentPage(-111685058);
            _return.setPageSize(1429499776);
            _return.setStatus("Status-824925649");
            _return.setStatusCode("StatusCode1463777923");
            _return.setTotalCount(190395127);
            _return.setTotalPage(-937510158);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
