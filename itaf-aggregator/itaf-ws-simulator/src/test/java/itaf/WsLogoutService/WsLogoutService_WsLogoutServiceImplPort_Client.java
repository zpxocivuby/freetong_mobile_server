package itaf.WsLogoutService;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import itaf.framework.ws.server.platform.impl.WsLogoutService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.0.1 2014-09-23T11:04:17.600+08:00
 * Generated source version: 3.0.1
 * 
 */
public final class WsLogoutService_WsLogoutServiceImplPort_Client {

	private static final QName SERVICE_NAME = new QName(
			"http://impl.platform.server.ws.framework.itaf/", "WsLogoutService");

	private WsLogoutService_WsLogoutServiceImplPort_Client() {
	}

	public static void main(String args[]) throws java.lang.Exception {
		URL wsdlURL = WsLogoutService.WSDL_LOCATION;
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

		WsLogoutService ss = new WsLogoutService(wsdlURL, SERVICE_NAME);
		itaf.WsLogoutService.WsLogoutService port = ss
				.getWsLogoutServiceImplPort();

		{
			System.out.println("Invoking logout...");
			java.lang.Long _logout_userId = Long.valueOf(1l);
			itaf.WsLogoutService.WsPageResult _logout__return = port
					.logout(_logout_userId);
			System.out.println("logout.result=" + _logout__return);

		}

		System.exit(0);
	}

}