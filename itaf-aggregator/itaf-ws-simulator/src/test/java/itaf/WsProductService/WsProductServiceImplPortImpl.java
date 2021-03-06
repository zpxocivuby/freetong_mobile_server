
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package itaf.WsProductService;

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
 * 2014-09-18T14:17:59.350+08:00
 * Generated source version: 3.0.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "WsProductService",
                      portName = "WsProductServiceImplPort",
                      targetNamespace = "http://impl.product.server.ws.framework.itaf/",
                      wsdlLocation = "http://localhost:8080/itaf-web-side/service/WsProductService?wsdl",
                      endpointInterface = "itaf.WsProductService.WsProductService")
                      
public class WsProductServiceImplPortImpl implements WsProductService {

    private static final Logger LOG = Logger.getLogger(WsProductServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see itaf.WsProductService.WsProductService#deleteByIds(java.lang.String  ids )*
     */
    public itaf.WsProductService.WsPageResult deleteByIds(java.lang.String ids) { 
        LOG.info("Executing operation deleteByIds");
        System.out.println(ids);
        try {
            itaf.WsProductService.WsPageResult _return = new itaf.WsProductService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(-1888411352);
            _return.setCurrentPage(1540427047);
            _return.setPageSize(910084345);
            _return.setStatus("Status-795028821");
            _return.setStatusCode("StatusCode1492123296");
            _return.setTotalCount(-735358389);
            _return.setTotalPage(1033957939);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see itaf.WsProductService.WsProductService#removeProductsFromShelf(java.lang.String  ids )*
     */
    public itaf.WsProductService.WsPageResult removeProductsFromShelf(java.lang.String ids) { 
        LOG.info("Executing operation removeProductsFromShelf");
        System.out.println(ids);
        try {
            itaf.WsProductService.WsPageResult _return = new itaf.WsProductService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(1441064818);
            _return.setCurrentPage(-23010298);
            _return.setPageSize(-1306915348);
            _return.setStatus("Status-81089877");
            _return.setStatusCode("StatusCode-1126822723");
            _return.setTotalCount(-1629771201);
            _return.setTotalPage(244255921);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see itaf.WsProductService.WsProductService#getById(java.lang.Long  id )*
     */
    public itaf.WsProductService.WsPageResult getById(java.lang.Long id) { 
        LOG.info("Executing operation getById");
        System.out.println(id);
        try {
            itaf.WsProductService.WsPageResult _return = new itaf.WsProductService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(-829143476);
            _return.setCurrentPage(-1170391447);
            _return.setPageSize(138767562);
            _return.setStatus("Status-2085503050");
            _return.setStatusCode("StatusCode-136802304");
            _return.setTotalCount(-2098432383);
            _return.setTotalPage(-1239151015);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see itaf.WsProductService.WsProductService#createOrUpdate(java.lang.Long  userId ,)itaf.WsProductService.BzProductDto  dto )*
     */
    public itaf.WsProductService.WsPageResult createOrUpdate(java.lang.Long userId,itaf.WsProductService.BzProductDto dto) { 
        LOG.info("Executing operation createOrUpdate");
        System.out.println(userId);
        System.out.println(dto);
        try {
            itaf.WsProductService.WsPageResult _return = new itaf.WsProductService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(905684879);
            _return.setCurrentPage(539226726);
            _return.setPageSize(-1777288733);
            _return.setStatus("Status629994147");
            _return.setStatusCode("StatusCode998370188");
            _return.setTotalCount(-591333439);
            _return.setTotalPage(-2083927262);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see itaf.WsProductService.WsProductService#putProductsOnShelf(java.lang.String  ids )*
     */
    public itaf.WsProductService.WsPageResult putProductsOnShelf(java.lang.String ids) { 
        LOG.info("Executing operation putProductsOnShelf");
        System.out.println(ids);
        try {
            itaf.WsProductService.WsPageResult _return = new itaf.WsProductService.WsPageResult();
            java.util.List<java.lang.Object> _returnContent = new java.util.ArrayList<java.lang.Object>();
            java.lang.Object _returnContentVal1 = null;
            _returnContent.add(_returnContentVal1);
            _return.getContent().addAll(_returnContent);
            _return.setCurrentIndex(1357185400);
            _return.setCurrentPage(1655349566);
            _return.setPageSize(-1908910797);
            _return.setStatus("Status600811438");
            _return.setStatusCode("StatusCode938821397");
            _return.setTotalCount(1349552186);
            _return.setTotalPage(780793130);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
