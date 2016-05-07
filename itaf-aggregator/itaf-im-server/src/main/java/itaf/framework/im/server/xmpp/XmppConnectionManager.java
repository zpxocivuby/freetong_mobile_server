package itaf.framework.im.server.xmpp;

import itaf.framework.im.server.xmpp.utils.DummySSLSocketFactory;

import java.io.Serializable;
import java.util.HashMap;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;

/**
 * 即时消息的链接管理器
 * 
 * @author xiaoly
 * 
 */

public class XmppConnectionManager implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2161267515637533659L;
	
	private String connectIMServerAdd = "";
	private int connectIMServerPort = 0;
	private String xmppServiceName = "";
	
	private static XmppConnectionManager connectionManager = null;
	private static HashMap<String, XMPPConnection> connectionsthreadLocal = new HashMap<String, XMPPConnection>();;

	public String getConnectIMServerAdd() {
		return connectIMServerAdd;
	}

	public void setConnectIMServerAdd(String connectIMServerAdd) {
		this.connectIMServerAdd = connectIMServerAdd;
	}

	public int getConnectIMServerPort() {
		return connectIMServerPort;
	}

	public void setConnectIMServerPort(int connectIMServerPort) {
		this.connectIMServerPort = connectIMServerPort;
	}

	public String getXmppServiceName() {
		return xmppServiceName;
	}

	public void setXmppServiceName(String xmppServiceName) {
		this.xmppServiceName = xmppServiceName;
	}

	public XmppConnectionManager() {
		
	}
	
	public static XmppConnectionManager getInstance(){
		if(connectionManager==null){
			connectionManager = new XmppConnectionManager();
		}
		return connectionManager;
	}
	
	public XMPPConnection getConnection(String userName) {
		if (XmppConnectionManager.connectionsthreadLocal.get(userName) == null) {
			System.out.print("================================");
		}

		XMPPConnection xmppConnection = XmppConnectionManager.connectionsthreadLocal.get(userName);
		if (xmppConnection == null) {
			ConnectionConfiguration config = new ConnectionConfiguration(
					connectIMServerAdd, connectIMServerPort);
			config.setReconnectionAllowed(true);
			config.setSecurityMode(ConnectionConfiguration.SecurityMode.enabled);
			config.setSASLAuthenticationEnabled(true);
			config.setSocketFactory(new DummySSLSocketFactory());

			xmppConnection = new XMPPConnection(config);
			try {
				xmppConnection.connect();
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			XmppConnectionManager.connectionsthreadLocal.put(userName, xmppConnection);
		}
		return xmppConnection;
	}

	public boolean doLogout(String userName, String reason) {
		XMPPConnection connection = getConnection(userName);
		if (!connection.isConnected()) {
			try {
				connection.connect();
			} catch (XMPPException e) {

				e.printStackTrace();
			}
		}
		connection.addConnectionListener(connectionListener);

		try {
			Presence unavailablePresence = new Presence(
					Presence.Type.unavailable);
			connection.disconnect(unavailablePresence);
			connectionsthreadLocal.remove(userName);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
	}

	public boolean doLogon(String userName, String passWD) {
		XMPPConnection connection = getConnection(userName);
		if (!connection.isConnected()) {
			try {
				connection.connect();
			} catch (XMPPException e) {

				e.printStackTrace();
			}
		}

		connection.addConnectionListener(connectionListener);

		try {
			connection.login(userName, passWD);

		} catch (XMPPException e) {

			e.printStackTrace();
		}
		return true;

	}

	/**
	 * 设置连接断开之后所有联系人状态为offline
	 */
	public void setAllContactsOffline() {

	}

	private ConnectionListener connectionListener = new ConnectionListener() {

		public void connectionClosed() {
			setAllContactsOffline();
		}

		public void connectionClosedOnError(Exception e) {
			setAllContactsOffline();
		}

		public void reconnectingIn(int seconds) {
			// TODO Auto-generated method stub

		}

		public void reconnectionFailed(Exception e) {
			// TODO Auto-generated method stub

		}

		public void reconnectionSuccessful() {
			// TODO Auto-generated method stub

		}

	};
}
