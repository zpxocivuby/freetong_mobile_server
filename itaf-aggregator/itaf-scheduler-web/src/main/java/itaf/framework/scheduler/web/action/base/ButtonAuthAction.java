package itaf.framework.scheduler.web.action.base;

import itaf.framework.business.platform.service.ISysResourceService;
import itaf.framework.core.constant.CodeListConstant;
import itaf.framework.domain.platform.SysResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

/**
 * 按钮权限管理
 * 
 * @author XINXIN 如果添加新的按钮，需要在此Action中添加一个属性
 *         <p>
 *         10024 首页 10027 搜索结果 10140 线索聚合板块(更多) 10160 编辑推荐板块线索查看 10025 我的工作台
 *         10026 人工录入 10031 线索推荐板块管理 10120 板块查看-要闻 10760 INDEX
 *         </p>
 */
@ManagedBean(name = "buttonAuthAction")
@ViewScoped
public class ButtonAuthAction extends AbstractPageAction {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysResourceServiceImpl}")
	private ISysResourceService resourceService;

	private static Map<String, Map<String, Long>> buttonAuthBuffer;

	public boolean showButton(String pageId, String btnName) {
		return getButtonAuth(pageId, btnName);
	}

	public void refreshButtonAuthBuffer() {
		buttonAuthBuffer = new HashMap<String, Map<String, Long>>();
		List<SysResource> sysResources = resourceService
				.findByType(CodeListConstant.ITAF_MENU_ACTION);
		if (sysResources != null && sysResources.size() > 0) {
			for (SysResource sysResource : sysResources) {
				String pid = sysResource.getParentId().toString();
				if (buttonAuthBuffer.containsKey(pid)) {
					buttonAuthBuffer.get(pid).put(sysResource.getNameEn(),
							sysResource.getId());
				} else {
					Map<String, Long> subMap = new HashMap<String, Long>();
					subMap.put(sysResource.getNameEn(), sysResource.getId());
					buttonAuthBuffer.put(pid, subMap);
				}
			}
		}
	}

	private boolean getButtonAuth(String pageId, String key) {
		if (StringUtils.isEmpty(pageId)) {
			return false;
		}
		if (buttonAuthBuffer == null) {
			refreshButtonAuthBuffer();
		}
		boolean bool = false;
		Map<String, Long> valueMap = buttonAuthBuffer.get(pageId);
		if (valueMap != null) {
			Long resourceId = valueMap.get(key);
			bool = resourceService.isHasButtonAuth(getCurrentUserId(),
					resourceId);
		}
		return bool;
	}

	public ISysResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ISysResourceService resourceService) {
		this.resourceService = resourceService;
	}

}
