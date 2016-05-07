/**
 * 
 */
package itaf.framework.im.server.xmpp.utils;

import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.im.server.xmpp.XmppConnectionManager;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.packet.VCard;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiaoly
 * 
 */
public class XmppAccountManager {

	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private XmppConnectionManager connectionManager;


	public XmppConnectionManager getConnectionManager() {
		if (connectionManager == null) {
			connectionManager = (XmppConnectionManager) SpringContextUtil
					.getBean("xmppConnectionManager");
		}
		return connectionManager;
	}


	public void setConnectionManager(XmppConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}


	/**
	 * 
	 * @param currentUser
	 * @param username
	 * @param password
	 * @param attributes
	 *            are as follows:
	 *            <ul>
	 *            <li>name -- the user's name.
	 *            <li>first -- the user's first name.
	 *            <li>last -- the user's last name.
	 *            <li>email -- the user's email address.
	 *            <li>city -- the user's city.
	 *            <li>state -- the user's state.
	 *            <li>zip -- the user's ZIP code.
	 *            <li>phone -- the user's phone number.
	 *            <li>url -- the user's website.
	 *            <li>date -- the date the registration took place.
	 *            <li>misc -- other miscellaneous information to associate with
	 *            the account.
	 *            <li>text -- textual information to associate with the account.
	 *            <li>remove -- empty flag to remove account.
	 *            </ul>
	 *            <p>
	 * 
	 * @return
	 */
	public boolean createIMAccount(String currentUser, String username,
			String password, Map<String, String> attributes) {
		boolean createResult = false;
		XMPPConnection xmppConnection = connectionManager.getConnection(currentUser);

		AccountManager accountManager = xmppConnection.getAccountManager();
		
		try {
			accountManager.createAccount(username, password, attributes);
			
			VCard vCard = new VCard();
			vCard.setJabberId(username+"@"+connectionManager.getXmppServiceName());
			if(attributes.get("IM_NAMEZH")!=null && !attributes.get("IM_NAMEZH").equals("")){
				vCard.setNickName(attributes.get("IM_NAMEZH"));
			}else{
				vCard.setNickName(attributes.get("IM_NAMEEN"));
			}
			
			xmppConnection.login(username, password);
			vCard.save(xmppConnection);
			
			createResult = true;
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage(), e);
			createResult = false;
		} catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage(), e);
			createResult = false;
		}

		return createResult;
	}
}
