package itaf.framework.web.util;

import itaf.framework.core.constant.CodeListConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Danne
 */
public class ResourceTypeUtil {

	/**
	 * <p>
	 * Returns a map contains an array of codes and an array of names for
	 * drop-down list.
	 * <p>
	 * Resource type is designed as a hierarchy structure, client must use this
	 * method to determine what kind of children resource types are allowed
	 * according to parent resource type.
	 * 
	 * @param resourceType
	 *            resource type.
	 * @return current children of parent resource type.
	 * 
	 * @see CodeListConstant#MAP_KEY_CODES
	 * @see CodeListConstant#MAP_KEY_LABELS
	 * @see CodeListConstant#MAP_KEY_DESCRIPTIONS
	 */
	public static Map<String, String[]> getAllowedResourceType(
			Map<String, String[]> typeMaps, String resourceType) {
		Assert.notNull(resourceType);
		String[] codes = typeMaps.get(CodeListConstant.MAP_KEY_CODES);
		String[] labels = typeMaps.get(CodeListConstant.MAP_KEY_LABELS);
		String[] descriptions = typeMaps
				.get(CodeListConstant.MAP_KEY_DESCRIPTIONS);
		ArrayList<String> listCodes = new ArrayList<String>();
		ArrayList<String> listlabels = new ArrayList<String>();
		ArrayList<String> listdescriptions = new ArrayList<String>();
		if (CodeListConstant.RESTYPE_APPLICATION.equals(resourceType)) {
			for (int i = 0; i < codes.length; i++) {
				String code = codes[i];
				if (code.lastIndexOf(CodeListConstant.RESTYPE_LEVEL_SEPARATOR) < 0) {
					listCodes.add(code);
					listlabels.add(labels[i]);
					listdescriptions.add(descriptions[i]);
				}
			}
		} else {
			for (int i = 0; i < codes.length; i++) {
				String code = codes[i];
				if (code.startsWith(resourceType)) {
					int lastIndexOf = code.substring(resourceType.length())
							.lastIndexOf(
									CodeListConstant.RESTYPE_LEVEL_SEPARATOR);
					if (lastIndexOf <= 0) {
						listCodes.add(code);
						listlabels.add(labels[i]);
						listdescriptions.add(descriptions[i]);
					}
				}
			}
		}
		Map<String, String[]> temps = new HashMap<String, String[]>();
		temps.put(CodeListConstant.MAP_KEY_CODES, listCodes
				.toArray(new String[0]));
		temps.put(CodeListConstant.MAP_KEY_LABELS, listlabels
				.toArray(new String[0]));
		temps.put(CodeListConstant.MAP_KEY_DESCRIPTIONS, listdescriptions
				.toArray(new String[0]));
		return temps;
	}

	/**
	 * Determines whether specified resource type can be nested each other.
	 * 
	 * @param parentResourceType
	 *            parent resource type.
	 * @param childResourceType
	 *            child resource type.
	 * @return true if child resource type can be as a child node of parent
	 *         resource type.
	 */
	public static boolean isTypeCanBeNested(String parentResourceType,
			String childResourceType) {
		Assert.notNull(parentResourceType);
		Assert.notNull(childResourceType);
		if (childResourceType.equals(parentResourceType)) {
			// child type equals parent type, check if can be nested .
			if (childResourceType.endsWith(CodeListConstant.RESTYPE_CATEGORY)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	/**
	 * Determines if the given resource type is the leaf node of any specific
	 * resource type. A leaf node usually is an item or action. 
	 * 
	 * @param resourceType type of the resource
	 * @return true for a leaf node, otherwise false.
	 */
	public static boolean isLeafNode(String resourceType) {
		Assert.notNull(resourceType);
		if (resourceType.endsWith(CodeListConstant.RESTYPE_ITEM)
				|| resourceType.endsWith(CodeListConstant.RESTYPE_ACTION)) {
			return true;
		} else {
			return false;
		}
	}
}
