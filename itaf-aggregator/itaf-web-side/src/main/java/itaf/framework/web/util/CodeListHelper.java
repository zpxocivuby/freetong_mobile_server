package itaf.framework.web.util;

import itaf.framework.business.platform.service.ISysCodeListService;
import itaf.framework.cache.business.service.ICacheCodeListService;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.platform.SysCodeList;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

/**
 * Web系统工具类
 * 
 * 用来获取系统中的数据常量（即数据字段）
 * 
 * @author XINXIN
 * 
 */
public class CodeListHelper {

	/**
	 * 根据codeType初始化下拉数组并插入默认显示值
	 * 
	 * @param codeType
	 *            数据常量类型
	 * @return SelectItem[]
	 */
	public static SelectItem[] initItems(String codeType) {
		List<SysCodeList> tcCodeLists = getCacheService()
				.getCacheListByType(codeType);
		if (tcCodeLists == null || tcCodeLists.isEmpty()) {
			return new SelectItem[0];
		}
		SelectItem[] selectItems = new SelectItem[tcCodeLists.size()];
		for (int i = 0; i < tcCodeLists.size(); i++) {
			SysCodeList tcCodeList = (SysCodeList) tcCodeLists.get(i);
			selectItems[i] = new SelectItem(tcCodeList.getCodeValue(),
					getName(tcCodeList));
		}
		return selectItems;
	}

	private static ICacheCodeListService getCacheService() {
		ICacheCodeListService cacheCodeListService = (ICacheCodeListService) SpringContextUtil
				.getBean("ehCacheCodeListServiceImpl");
		return cacheCodeListService;
	}

	/**
	 * 根据codeType初始化checkbox框默认显示值
	 * 
	 * @param codeType
	 *            数据常量类型
	 * @return Map
	 */
	public static List<SelectItem> initCheckBox(String codeType) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<SysCodeList> tcCodeLists = getCacheService()
				.getCacheListByType(codeType);
		if (tcCodeLists == null || tcCodeLists.isEmpty()) {
			return items;
		}
		for (int i = 0; i < tcCodeLists.size(); i++) {
			SysCodeList tcCodeList = (SysCodeList) tcCodeLists.get(i);
			items.add(new SelectItem(tcCodeList.getCodeValue(),
					getName(tcCodeList)));
		}
		return items;
	}

	/**
	 * 获取CodeValue对应的名称
	 * 
	 * @param codeType
	 *            类型
	 * @param codeValue
	 *            值
	 * @return 值对应的名称
	 */
	public static String getNameByCodeValue(String codeType, String codeValue) {
		if (StringUtils.isNotEmpty(codeType)
				&& StringUtils.isNotEmpty(codeValue)) {
			SysCodeList tcCodeList = getCacheService().getCacheByTypeAndValue(
					codeType + "," + codeValue);
			if (tcCodeList != null) {
				return getName(tcCodeList);
			}
		}
		return "";
	}

	/**
	 * 获取名称对应的值
	 * 
	 * @param codeType
	 *            类型
	 * @param name
	 *            名称，同时查看中文名称和英文名称
	 * @return 返回名称对应的值
	 */
	public static String getCodeValueByName(String codeType, String name) {
		if (StringUtils.isNotEmpty(codeType) && StringUtils.isNotEmpty(name)) {
			ISysCodeListService codeListService = (ISysCodeListService) SpringContextUtil
					.getBean("codeListServiceImpl");
			SysCodeList tcCodeList = codeListService.findByName(codeType, name);
			if (tcCodeList != null) {
				return tcCodeList.getCodeValue();
			}
		}
		return "";
	}

	private static String getName(SysCodeList tcCodeList) {
		if (LocalLanguageHelper.isLocalEn()) {
			return tcCodeList.getNameEn();
		} else {
			return tcCodeList.getNameZh();
		}
	}
}
