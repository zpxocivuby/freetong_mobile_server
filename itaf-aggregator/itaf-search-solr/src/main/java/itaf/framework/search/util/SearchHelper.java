package itaf.framework.search.util;

import itaf.framework.search.bean.SearchEngineObject;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("rawtypes")
public class SearchHelper {

	public static final String TEXT = "TEXT";
	public static final String FIELD_TEXT = "FIELDTEXT";
	public static final String SORT = "SORT";

	// 用户名权限字段
	public static final String USER_ID = "AUTH_USER_ID";
	// 用户组权限字段
	public static final String ROLE_ID = "AUTH_ROLE_ID";
	// 每次删除的数据量
	public static final int DELETE_NUM = 1000;

	// 空格
	public static final String BLANK = " ";

	/**
	 * 根据对象返回保存提交字符串
	 * 
	 * @param searchEngineObject
	 * @return
	 */
	public static String convertSearchEngineObjectToSaveData(
			SearchEngineObject searchEngineObject, String dbName) {
		StringBuffer sb = new StringBuffer();
		if (searchEngineObject == null) {
			return "";
		}
		String reference = "";
		Collection<String> collection = searchEngineObject.getFieldNames();
		for (String key : collection) {
			if (searchEngineObject.getFieldValue(key) == null) {
				continue;
			}
			if (searchEngineObject.getFieldValue(key) instanceof Collection) {

				for (Object str : (Collection) searchEngineObject
						.getFieldValue(key)) {
					sb.append("#DREFIELD " + key + "=\"" + str + "\"\n");
				}
			} else {
				if (key.equals("DREREFERENCE")) {
					reference = "#DREREFERENCE "
							+ searchEngineObject.getFieldValue(key) + "\n";
				} else if (key.equals("DRETITLE")) {
					sb.append("#DRETITLE\n"
							+ searchEngineObject.getFieldValue(key) + "\n");
				} else if (key.equals("DRECONTENT")) {
					sb.append("#DRECONTENT\n"
							+ searchEngineObject.getFieldValue(key) + "\n");
				} else if (key.equals("DREDATE")) {
					sb.append("#DREDATE "
							+ searchEngineObject.getFieldValue(key) + "\n");
				} else {
					sb.append("#DREFIELD " + key + "=\""
							+ searchEngineObject.getFieldValue(key) + "\"\n");
				}
			}
		}
		sb.append("#DREDBNAME " + dbName + "\n");
		sb.append("#DREENDDOC\n" + "#DREENDDATAREFERENCE\n\n");
		return reference + sb.toString();
	}

	/**
	 * 根据对象集合返回保存提交数据串
	 * 
	 * @param listSearchEngineObject
	 * @return
	 */
	public static String convertSearchEngineObjectToSaveData(
			List<SearchEngineObject> listSearchEngineObject, String dbName) {
		StringBuffer allBuffer = new StringBuffer();
		if (listSearchEngineObject != null) {
			for (SearchEngineObject searchEngineObject : listSearchEngineObject) {
				StringBuffer sb = new StringBuffer();
				String reference = "";
				Collection<String> collection = searchEngineObject
						.getFieldNames();
				for (String key : collection) {

					if (searchEngineObject.getFieldValue(key) == null) {
						continue;
					}
					if (searchEngineObject.getFieldValue(key) instanceof Collection) {

						for (Object str : (Collection) searchEngineObject
								.getFieldValue(key)) {
							sb.append("#DREFIELD " + key + "=\"" + str + "\"\n");
						}
					} else {
						if (key.equals("DREREFERENCE")) {
							reference = "#DREREFERENCE "
									+ searchEngineObject.getFieldValue(key)
									+ "\n";
						} else if (key.equals("DRETITLE")) {
							sb.append("#DRETITLE\n"
									+ searchEngineObject.getFieldValue(key)
									+ "\n");
						} else if (key.equals("DRECONTENT")) {
							sb.append("#DRECONTENT\n"
									+ searchEngineObject.getFieldValue(key)
									+ "\n");
						} else if (key.equals("DREDATE")) {
							sb.append("#DREDATE "
									+ searchEngineObject.getFieldValue(key)
									+ "\n");
						} else {
							sb.append("#DREFIELD " + key + "=\""
									+ searchEngineObject.getFieldValue(key)
									+ "\"\n");
						}
					}
				}
				sb.append("#DREDBNAME " + dbName + "\n");
				sb.append("#DREENDDOC\n");
				allBuffer.append(reference + sb.toString());
			}

			allBuffer.append("#DREENDDATAREFERENCE\n\n");
		}
		return allBuffer.toString();
	}

	/**
	 * 根据对象返回更新提交字符串
	 * 
	 * @param searchEngineObject
	 * @return
	 */
	public static String convertSearchEngineObjectToUpdateData(
			List<SearchEngineObject> listSearchEngineObject) {
		StringBuffer allBuffer = new StringBuffer();
		if (listSearchEngineObject != null) {
			for (SearchEngineObject searchEngineObject : listSearchEngineObject) {
				StringBuffer sb = new StringBuffer();
				String reference = "";
				Collection<String> collection = searchEngineObject
						.getFieldNames();
				for (String key : collection) {
					if (searchEngineObject.getFieldValue(key) instanceof Collection) {
						for (Object str : (Collection) searchEngineObject
								.getFieldValue(key)) {
							sb.append("#DREFIELDNAME " + key + "\n"
									+ "#DREFIELDVALUE " + str + "\n");
						}
					} else {
						if (key.equals("DREREFERENCE")) {
							reference += "#DREDOCREF "
									+ searchEngineObject.getFieldValue(key)
									+ "\n";
						} else {
							sb.append("#DREFIELDNAME " + key + "\n"
									+ "#DREFIELDVALUE "
									+ searchEngineObject.getFieldValue(key)
									+ "\n");
						}
					}
				}
				allBuffer.append(reference + sb.toString());
			}
			allBuffer.append("#DREENDDATANOOP\n\n");
		}
		return allBuffer.toString();
	}

	/**
	 * 根据对象返回更新提交字符串
	 * 
	 * @param searchEngineObject
	 * @return
	 */
	public static String convertSearchEngineObjectToUpdateData(
			SearchEngineObject searchEngineObject) {
		StringBuffer sb = new StringBuffer();
		if (searchEngineObject == null) {
			return "";
		}
		String reference = "";
		Collection<String> collection = searchEngineObject.getFieldNames();
		for (String key : collection) {
			if (searchEngineObject.getFieldValue(key) == null) {
				continue;
			}

			if (searchEngineObject.getFieldValue(key) instanceof Collection) {
				for (Object str : (Collection) searchEngineObject
						.getFieldValue(key)) {
					sb.append("#DREFIELDNAME " + key + "\n" + "#DREFIELDVALUE "
							+ str + "\n");
				}
			} else {
				if (key.equals("DREREFERENCE")) {
					reference += "#DREDOCREF "
							+ searchEngineObject.getFieldValue(key) + "\n";
				} else {
					sb.append("#DREFIELDNAME " + key + "\n" + "#DREFIELDVALUE "
							+ searchEngineObject.getFieldValue(key) + "\n");
				}
			}
		}
		sb.append("#DREENDDATANOOP\n\n");
		return reference + sb.toString();
	}

	// 处理为负数的整数
	public static int filterNumber(int num) {
		if (num < 0) {
			num = 1;
		}
		return num;
	}

	/**
	 * 处理数据库字段到IDOL字段的映射关系
	 * 
	 * @param name
	 * @return
	 */
	public static String filterName(String name) {
		String idolName = "";
		if (name == null || "".equals(name)) {
			return idolName;
		}
		name = name.trim();
		if (name.equals("TITLE")) {
			idolName = "DRETITLE";
		} else if (name.equals("TEXT")) {
			idolName = "DRECONTENT";
		} else if (name.equals("INDEX_TIME")) {
			idolName = "DREDATE";
		} else if (name.equals("ID")) {
			idolName = "DREREFERENCE";
		} else {
			idolName = name;
		}
		return idolName;

	}
}
