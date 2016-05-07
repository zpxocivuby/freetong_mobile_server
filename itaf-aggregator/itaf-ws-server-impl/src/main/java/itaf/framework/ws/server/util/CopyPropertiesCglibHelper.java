package itaf.framework.ws.server.util;

import itaf.framework.exception.bean.AppException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 使用Cglib拷贝属性
 *
 *
 * @author XINXIN
 *
 * @UpdateDate 2014年8月21日
 */
public class CopyPropertiesCglibHelper {

	protected static final Log log = LogFactory
			.getLog(CopyPropertiesCglibHelper.class);

	private static void cgLibBeanCopyier(Object source, Object target) {
		BeanCopier copier = BeanCopier.create(source.getClass(),
				target.getClass(), false);
		copier.copy(source, target, null);
	}

	@SuppressWarnings("unchecked")
	public static <T> Collection<T> copyProperties(Class<T> toClazz,
			Collection<?> froms) {
		if (froms == null) {
			return null;
		}
		Collection<T> toList = null;
		try {
			toList = froms.getClass().newInstance();
			if (froms instanceof List) {
				toList = new ArrayList<T>();
			} else if (froms instanceof Set) {
				toList = new HashSet<T>();
			}

			for (Object obj : froms) {
				T to = copyProperties(toClazz, obj);
				toList.add(to);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toList;
	}

	public static <T> T copyProperties(Class<T> toClazz, Object from) {
		if (from == null) {
			return null;
		}
		T to = null;
		try {
			to = toClazz.newInstance();
		} catch (Exception e) {
			log.error(e);
			throw new AppException("SE0015");
		}
		copyProperties(to, from);
		return to;
	}

	public static <T> Collection<T> copyProperties(Class<T> toClazz,
			Object[] froms) {
		if (froms == null) {
			return null;
		}
		ArrayList<T> toList = new ArrayList<T>();
		for (Object obj : froms) {
			T to = copyProperties(toClazz, obj);
			toList.add(to);
		}
		return toList;
	}

	public static void copyProperties(Object to, Object from) {
		if (from == null) {
			return;
		}
		cgLibBeanCopyier(from, to);
	}

}
