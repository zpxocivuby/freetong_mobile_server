
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package itaf.WsDistributionServiceApplyService;

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
 * 2014-10-09T09:54:21.673+08:00
 * Generated source version: 3.0.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "WsDistributionServiceApplyService",
                      portName = "WsDistributionServiceApplyServiceImplPort",
                      targetNamespace = "http://impl.certificate.server.ws.framework.itaf/",
                      wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsDistributionServiceApplyService?wsdl",
                      endpointInterface = "itaf.WsDistributionServiceApplyService.WsDistributionServiceApplyService")
                      
public class WsDistributionServiceApplyServiceImplPortImpl implements WsDistributionServiceApplyService {

    private static final Logger LOG = Logger.getLogger(WsDistributionServiceApplyServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see itaf.WsDistributionServiceApplyService.WsDistributionServiceApplyService#create(itaf.WsDistributionServiceApplyService.BzDistServiceApplyDto  dto )*
     */
    public itaf.WsDistributionServiceApplyService.WsPageResult create(itaf.WsDistributionServiceApplyService.BzDistServiceApplyDto dto) { 
        LOG.info("Executing operation create");
        System.out.println(dto);
        try {
            itaf.WsDistributionServiceApplyService.WsPageResult _return = new itaf.WsDistributionServiceApplyService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(-688089553);
            _return.setCurrentPage(1385023529);
            _return.setPageSize(2050433662);
            _return.setStatus("Status1568981576");
            _return.setStatusCode("StatusCode706987749");
            _return.setTotalCount(548592388);
            _return.setTotalPage(1015450088);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see itaf.WsDistributionServiceApplyService.WsDistributionServiceApplyService#findCertificated(java.lang.Long  userId )*
     */
    public itaf.WsDistributionServiceApplyService.WsPageResult findCertificated(java.lang.Long userId) { 
        LOG.info("Executing operation findCertificated");
        System.out.println(userId);
        try {
            itaf.WsDistributionServiceApplyService.WsPageResult _return = new itaf.WsDistributionServiceApplyService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(1473223241);
            _return.setCurrentPage(1979813613);
            _return.setPageSize(-199786771);
            _return.setStatus("Status-1661668326");
            _return.setStatusCode("StatusCode-1477258245");
            _return.setTotalCount(-966276974);
            _return.setTotalPage(-122404812);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see itaf.WsDistributionServiceApplyService.WsDistributionServiceApplyService#findCertificating(java.lang.Long  userId )*
     */
    public itaf.WsDistributionServiceApplyService.WsPageResult findCertificating(java.lang.Long userId) { 
        LOG.info("Executing operation findCertificating");
        System.out.println(userId);
        try {
            itaf.WsDistributionServiceApplyService.WsPageResult _return = new itaf.WsDistributionServiceApplyService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(796872588);
            _return.setCurrentPage(-2085053018);
            _return.setPageSize(-2093716467);
            _return.setStatus("Status-1063363193");
            _return.setStatusCode("StatusCode889072214");
            _return.setTotalCount(1241513144);
            _return.setTotalPage(-871483588);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
