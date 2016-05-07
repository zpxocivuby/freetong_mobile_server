package itaf.framework.core.constant;

/**
 * 定义常量公共类：存放公共的常量
 * 
 * @author XINXIN
 * 
 * @update 2013-6-4
 */
public class CommonConstants {

	/**
	 * 以ROLE_开头字符串
	 */
	public static final String START_ROLE = "ROLE_";

	/**
	 * 以ROLE_开头字符串
	 */
	public static final String JSF_URL_PATTERN = ".xhtml";

	/**
	 * Error Key
	 */
	public static final String ERROR_KEY = "SYS001";

	/* 信息类型级别 */
	public static final int MESSAGE_LEVEL_SYS_SEVERE = 0;
	public static final int MESSAGE_LEVEL_BIZ_SEVERE = 1;
	public static final int MESSAGE_LEVEL_WARNING = 2;
	public static final int MESSAGE_LEVEL_NOTICE = 3;

	/**
	 * User session key.
	 */
	public static final String USER_KEY = "_user_";

	/**
	 * Anonymous User Name
	 */

	public static final String ANONYMOUS_USER_NAME = "anonymousUser";

	/**
	 * Approve constants.
	 */
	public static final int ACCEPT = 1;
	public static final int REJECT = 2;

	public static final int PAGE_SIZE = 20;

	public static final int COLUMN_COUNT = 3;

	/* 表新增动作标志 */
	public static final String JSF_ACTION_TYPE_ADD = "add";
	/* 表修改动作标志 */
	public static final String JSF_ACTION_TYPE_EDIT = "edit";
	/* 所有jsf之间操作参数统一用action字串 */
	public static final String JSF_PARAM_NAME_ACTION = "action";
	public static final String JSF_PARAM_NAME_ID = "id";
}
