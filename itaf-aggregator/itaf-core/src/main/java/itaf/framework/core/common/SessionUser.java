package itaf.framework.core.common;

import java.util.Locale;

/**
 * user Information
 * 
 * @author yurb
 * 
 */
public class SessionUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 登录Username
	 */
	private String username;

	/**
	 * 用户 Id
	 */
	private Long id;

	/**
	 * 用户 Name
	 */
	private String realName;

	/**
	 * 用户的语言偏好
	 */
	private Locale preferredLocale = null;

	/**
	 * 用户password;
	 */
	private String password;

	/**
	 * 用户的每页显示多少条数据
	 */
	private int pageSize = 20;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return realName;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLoginId(String loginId) {
		this.username = loginId;
	}

	public void setName(String name) {
		this.realName = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the preferredLocale
	 */
	public Locale getPreferredLocale() {
		return preferredLocale;
	}

	/**
	 * @param preferredLocale
	 *            the preferredLocale to set
	 */
	public void setPreferredLocale(Locale preferredLocale) {
		this.preferredLocale = preferredLocale;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
