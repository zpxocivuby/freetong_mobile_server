
package itaf.WsProductCategoryService;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import itaf.framework.ws.server.product.impl.WsProductCategoryService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-18T11:13:10.419+08:00
 * Generated source version: 3.0.1
 * 
 */
public final class WsProductCategoryService_WsProductCategoryServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.product.server.ws.framework.itaf/", "WsProductCategoryService");

    private WsProductCategoryService_WsProductCategoryServiceImplPort_Client() { 
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WsProductCategoryService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        WsProductCategoryService ss = new WsProductCategoryService(wsdlURL, SERVICE_NAME);
        itaf.WsProductCategoryService.WsProductCategoryService port = ss.getWsProductCategoryServiceImplPort();  
        
        {
        System.out.println("Invoking syncToClient...");
        java.lang.String _syncToClient_updateTime = "2001-03-05 12:00:00.001";
        itaf.WsProductCategoryService.WsPageResult _syncToClient__return = port.syncToClient(_syncToClient_updateTime);
        System.out.println("syncToClient.result=" + _syncToClient__return);


        }

        System.exit(0);
    }

}
