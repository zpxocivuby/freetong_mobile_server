
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package itaf.WsRealnameCertificateApplyService;

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
 * 2014-09-28T13:13:59.556+08:00
 * Generated source version: 3.0.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "WsRealnameCertificateApplyService",
                      portName = "WsRealnameCertificateApplyServiceImplPort",
                      targetNamespace = "http://impl.certificate.server.ws.framework.itaf/",
                      wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsRealnameCertificateApplyService?wsdl",
                      endpointInterface = "itaf.WsRealnameCertificateApplyService.WsRealnameCertificateApplyService")
                      
public class WsRealnameCertificateApplyServiceImplPortImpl implements WsRealnameCertificateApplyService {

    private static final Logger LOG = Logger.getLogger(WsRealnameCertificateApplyServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see itaf.WsRealnameCertificateApplyService.WsRealnameCertificateApplyService#create(itaf.WsRealnameCertificateApplyService.BzRealnameCertificateApplyDto  dto )*
     */
    public itaf.WsRealnameCertificateApplyService.WsPageResult create(itaf.WsRealnameCertificateApplyService.BzRealnameCertificateApplyDto dto) { 
        LOG.info("Executing operation create");
        System.out.println(dto);
        try {
            itaf.WsRealnameCertificateApplyService.WsPageResult _return = new itaf.WsRealnameCertificateApplyService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(-401913050);
            _return.setCurrentPage(-1693011632);
            _return.setPageSize(-42552884);
            _return.setStatus("Status-657831678");
            _return.setStatusCode("StatusCode-2144883843");
            _return.setTotalCount(-2048290450);
            _return.setTotalPage(-1686006806);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}