package itaf.WsSysUserService;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import itaf.framework.ws.server.platform.impl.WsSysUserService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.0.1 2014-09-23T17:07:50.533+08:00
 * Generated source version: 3.0.1
 * 
 */
public final class WsSysUserService_WsSysUserServiceImplPort_Client {

	private static final QName SERVICE_NAME = new QName(
			"http://impl.platform.server.ws.framework.itaf/",
			"WsSysUserService");

	private WsSysUserService_WsSysUserServiceImplPort_Client() {
	}

	public static void main(String args[]) throws java.lang.Exception {
		URL wsdlURL = WsSysUserService.WSDL_LOCATION;
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

		WsSysUserService ss = new WsSysUserService(wsdlURL, SERVICE_NAME);
		itaf.WsSysUserService.WsSysUserService port = ss
				.getWsSysUserServiceImplPort();

		{
			System.out.println("Invoking findById...");
			java.lang.Long _findById_userId = Long.valueOf(1);
			itaf.WsSysUserService.WsPageResult _findById__return = port
					.findById(_findById_userId);
			System.out.println("findById.result=" + _findById__return);

		}

		System.exit(0);
	}

}
