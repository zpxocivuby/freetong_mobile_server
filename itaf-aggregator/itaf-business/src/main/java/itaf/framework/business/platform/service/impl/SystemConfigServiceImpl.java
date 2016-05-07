package itaf.framework.business.platform.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISystemConfigService;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 系统配置参数实现类
 * 
 * @author XININ
 * 
 * @updateDate 2013年3月13日
 */
@Service("systemConfigServiceImpl")
public class SystemConfigServiceImpl extends BaseServiceImpl implements
		ISystemConfigService {

	private Map<String, String> configs;

	public Map<String, String> getConfigs() {
		return configs;
	}

	public void setConfigs(Map<String, String> configs) {
		this.configs = configs;
	}

	public String getConfigValue(String configKey) {
		if (configs == null) {
			return null;
		}
		return configs.get(configKey);
	}

}
