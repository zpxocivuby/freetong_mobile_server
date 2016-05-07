/**
 * 
 */
package itaf.framework.search.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author zhangkd
 * 
 */
public class SearchEngineObject {

	private Map<String, String> _systemFields;
	private Map<String, Object> _fields;

	public static final String DEFAULT_SEPARATOR = ";";

	public SearchEngineObject() {
		_systemFields = new HashMap<String, String>();
		_fields = new LinkedHashMap<String, Object>();
	}

	public String getSystemFieldValue(String fieldname) {
		String key = fieldname.toUpperCase();
		return _systemFields.get(key);
	}

	public void setSystemField(String fieldname, String value) {
		String key = fieldname.toUpperCase();
		_systemFields.put(key, value);
	}

	public boolean removeSystemField(String fieldname) {
		String key = fieldname.toUpperCase();
		return _systemFields.remove(key) == null;
	}

	/**
	 * @return a list of fields defined in this document
	 */
	public Collection<String> getFieldNames() {
		return _fields.keySet();
	}

	/**
	 * Remove all fields from the document
	 */
	public void clear() {
		_fields.clear();
	}

	/**
	 * Remove field with the name
	 */
	public boolean removeField(String name) {
		return _fields.remove(name) != null;
	}

	/**
	 * Set a field with the given object. If the object is an Array, it will set
	 * multiple fields with the included contents. This will replace any
	 * existing field with the given name
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setField(String name, Object value) {
		if (value instanceof Object[]) {
			value = new ArrayList(Arrays.asList((Object[]) value));
		} else if (value instanceof Collection) {
			// nothing
		} else if (value instanceof Iterable) {
			ArrayList<Object> lst = new ArrayList<Object>();
			for (Object o : (Iterable) value) {
				lst.add(o);
			}
			value = lst;
		}
		_fields.put(name, value);
	}

	/**
	 * This will add a field to the document. If fields already exist with this
	 * name it will append the collection
	 */
	@SuppressWarnings("unchecked")
	public void addField(String name, Object value) {
		Object existing = _fields.get(name);
		if (existing == null) {
			this.setField(name, value);
			return;
		}

		Collection<Object> vals = null;
		if (existing instanceof Collection) {
			vals = (Collection<Object>) existing;
		} else {
			vals = new ArrayList<Object>(3);
			vals.add(existing);
		}

		// Add the values to the collection
		if (value instanceof Iterable) {
			for (Object o : (Iterable<Object>) value) {
				vals.add(o);
			}
		} else if (value instanceof Object[]) {
			for (Object o : (Object[]) value) {
				vals.add(o);
			}
		} else {
			vals.add(value);
		}
		_fields.put(name, vals);
	}

	/**
	 * returns the first value for a field
	 */
	@SuppressWarnings("rawtypes")
	public Object getFirstValue(String name) {
		Object v = _fields.get(name);
		if (v == null || !(v instanceof Collection))
			return v;
		Collection c = (Collection) v;
		if (c.size() > 0) {
			return c.iterator().next();
		}
		return null;
	}

	/**
	 * Get the value or collection of values for a given field.
	 */
	public Object getFieldValue(String name) {
		return _fields.get(name);
	}

	/**
	 * Get a collection of values for a given field name
	 */
	@SuppressWarnings("unchecked")
	public Collection<Object> getFieldValues(String name) {
		Object v = _fields.get(name);
		if (v instanceof Collection) {
			return (Collection<Object>) v;
		}
		if (v != null) {
			ArrayList<Object> arr = new ArrayList<Object>(1);
			arr.add(v);
			return arr;
		}
		return null;
	}

	/**
	 * Iterate of String->Object keys
	 */
	public Iterator<Entry<String, Object>> iterator() {
		return _fields.entrySet().iterator();
	}

	// ---------------------------------------------------
	// MAP interface
	// ---------------------------------------------------

	public boolean containsKey(Object key) {
		return _fields.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return _fields.containsValue(value);
	}

	public Set<Entry<String, Object>> entrySet() {
		return _fields.entrySet();
	}

	public Object get(Object key) {
		return _fields.get(key);
	}

	public boolean isEmpty() {
		return _fields.isEmpty();
	}

	public Set<String> keySet() {
		return _fields.keySet();
	}

	public Object put(String key, Object value) {
		return _fields.put(key, value);
	}

	public void putAll(Map<? extends String, ? extends Object> t) {
		_fields.putAll(t);
	}

	public Object remove(Object key) {
		return _fields.remove(key);
	}

	public int size() {
		return _fields.size();
	}

	public Collection<Object> values() {
		return _fields.values();
	}

	// Add Multi-valued
	public void addMultialuedField(String name, String value, String separator) {
		if (value == null) {
			return;
		}
		if (separator == null) {
			separator = DEFAULT_SEPARATOR;
		}
		String[] vals = value.split(separator);
		for (String val : vals) {
			addField(name, val);
		}
	}

	public void addMultialuedField(String name, String value) {
		addMultialuedField(name, value, DEFAULT_SEPARATOR);
	}

	public boolean removeFieldValue(String name, String value) {
		if (_fields.containsKey(name)) {
			Collection<Object> vals = getFieldValues(name);
			return vals.remove(value);
		}
		return false;
	}

	public String getFieldValueAsString(String name, String separator) {
		Collection<Object> vals = getFieldValues(name);
		if (vals == null) {
			return null;
		}
		if (separator == null) {
			separator = DEFAULT_SEPARATOR;
		}
		StringBuffer result = new StringBuffer();
		for (Iterator<Object> it = vals.iterator(); it.hasNext();) {
			if (result.length() > 0)
				result.append(separator);
			result.append(it.next());
		}
		return result.toString();
	}

	public String getFieldValueAsString(String name) {
		return getFieldValueAsString(name, DEFAULT_SEPARATOR);
	}

	public void addCatalogField(String name, String value) {
		if (value == null) {
			return;
		}
		String[] vals = value.split(DEFAULT_SEPARATOR);
		for (String val : vals) {
			if (!val.endsWith("/"))
				val += "/";
			addField(name, val);
		}
	}

	public String getCatalogFieldValueAsString(String name) {
		Collection<Object> vals = getFieldValues(name);
		if (vals == null) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		for (Iterator<Object> it = vals.iterator(); it.hasNext();) {
			String val = (String) it.next();
			if (val == null)
				continue;
			if (val.endsWith("/"))
				val = val.substring(0, val.length() - 1);
			if (result.length() > 0)
				result.append(DEFAULT_SEPARATOR);
			result.append(val);
		}
		return result.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Iterator<String> it = _systemFields.keySet().iterator(); it
				.hasNext();) {
			String key = it.next();
			String val = getSystemFieldValue(key);
			buffer.append("\n#SYSTEM FIELD ");
			buffer.append(key.toUpperCase());
			buffer.append(": ");
			buffer.append(val);
		}
		for (Iterator<String> it = _fields.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			String vals = getFieldValueAsString(key, DEFAULT_SEPARATOR);
			if (vals == null)
				continue;
			buffer.append("\n#FIELD ");
			buffer.append(key.toUpperCase());
			buffer.append(": ");
			buffer.append(vals);
		}
		buffer.append("\n");
		return buffer.toString();
	}

	public String getFieldValuesAsJsonForICA() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		int c = 0;
		for (Iterator<String> it = _fields.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			String vals = getFieldValueAsString(key.toUpperCase(),
					DEFAULT_SEPARATOR);
			if (vals == null)
				continue;
			if (c > 0)
				buffer.append(", ");
			buffer.append("\"").append(key).append("\"");
			buffer.append(":");
			buffer.append("\"").append(vals.replaceAll("\"", "\\\\\""))
					.append("\"");
			++c;
		}
		buffer.append("}");
		return buffer.toString();
	}
}
