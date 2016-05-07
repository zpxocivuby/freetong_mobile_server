package itaf.framework.web.json;

import java.util.Set;

import net.sf.json.util.PropertyFilter;

/**
 * 只对列表中的属性名称认为需要包含，其他一概不包含。
 * 
 * @author sherlockq
 *         <p>
 */
public class ExcludeOtherThanPropertyFilter implements PropertyFilter {

	private Set<String> properties = null;

	/**
	 * Constructor
	 * 
	 * @param properties
	 *            需要进行转化的属性名称清单
	 */
	public ExcludeOtherThanPropertyFilter(final Set<String> properties) {
		this.properties = properties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.json.util.PropertyFilter#apply(java.lang.Object,
	 * java.lang.String, java.lang.Object)
	 */
	public boolean apply(Object source, String name, Object value) {
		if (properties.contains(name)) {
			return false;
		} else {
			return true;
		}
	}

}