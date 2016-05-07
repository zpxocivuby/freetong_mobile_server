package itaf.framework.business.platform.service;

/**
 * 系统配置参数服务类
 * 
 * @author XININ
 * 
 * @updateDate 2013年3月13日
 */
public interface ISystemConfigService {

	/**
	 * 获取配置文件的总value
	 * 
	 * @param configKey
	 *            配置文件中的name
	 * @return configValue
	 */
	String getConfigValue(String configKey);

}
