package itaf.framework.im.server.xmpp.utils;

import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.im.server.xmpp.XmppConnectionManager;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.springframework.beans.factory.annotation.Autowired;

public class XmppMessageUtils {
	
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
	 * 发送即时消息的工具类,通过该类可以发送给指定用户消息信息
	 * 
	 * @param xmppConnection
	 * 
	 * @param userName
	 * @param message
	 * @return
	 */
	public boolean sendMessageToUser(XMPPConnection xmppConnection,
			String userName, String message) {
		// 处理username，判断名是否是带有@的，如果没有，加上@以及serviceName
		if (!userName.contains("@")) {
			userName = userName + "@" + connectionManager.getXmppServiceName();
		}
		ChatManager chatManager = xmppConnection.getChatManager();
		Chat chat = chatManager.createChat(userName, null);
		try {
			chat.sendMessage(message);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

	public boolean sendMessageToUser(String currentUserName, String toUserName,
			String message,String subject) {
		// 处理username，判断名是否是带有@的，如果没有，加上@以及serviceName
		if (!toUserName.contains("@")) {
			toUserName = toUserName + "@"
					+ connectionManager.getXmppServiceName();
		}
		
		/*if(connectionManager.getConnection(
				currentUserName)!=null && (!connectionManager.getConnection(
						currentUserName).isAuthenticated())){
			connectionManager.doLogon(currentUserName, "1234");
		}*/
		
		ChatManager chatManager = connectionManager.getConnection(
				currentUserName).getChatManager();
		Chat chat = chatManager.createChat(toUserName, null);
		try {
			Message message2 = new Message();

			message2.setBody(message);
			message2.setSubject(subject);
			chat.sendMessage(message2);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
