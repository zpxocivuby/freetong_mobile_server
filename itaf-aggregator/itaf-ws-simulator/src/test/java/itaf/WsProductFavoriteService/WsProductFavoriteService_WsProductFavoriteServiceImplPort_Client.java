
package itaf.WsProductFavoriteService;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import itaf.framework.ws.server.product.impl.WsProductFavoriteService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-24T10:50:20.577+08:00
 * Generated source version: 3.0.1
 * 
 */
public final class WsProductFavoriteService_WsProductFavoriteServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.product.server.ws.framework.itaf/", "WsProductFavoriteService");

    private WsProductFavoriteService_WsProductFavoriteServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WsProductFavoriteService.WSDL_LOCATION;
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
      
        WsProductFavoriteService ss = new WsProductFavoriteService(wsdlURL, SERVICE_NAME);
        itaf.WsProductFavoriteService.WsProductFavoriteService port = ss.getWsProductFavoriteServiceImplPort();  
        
        {
        System.out.println("Invoking findPagerByUserId...");
        java.lang.Long _findPagerByUserId_userId = Long.valueOf(1l);
        int _findPagerByUserId_currentIndex = 0;
        int _findPagerByUserId_pageSize = 1;
        itaf.WsProductFavoriteService.WsPageResult _findPagerByUserId__return = port.findPagerByUserId(_findPagerByUserId_userId, _findPagerByUserId_currentIndex, _findPagerByUserId_pageSize);
        System.out.println("findPagerByUserId.result=" + _findPagerByUserId__return);


        }

        System.exit(0);
    }

}
