package itaf.framework.business.base.service.impl;

import itaf.framework.core.common.QueryCriteria;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * 加入公共方法
 *
 * @author
 *
 * @UpdateDate 2014年9月5日
 */
public abstract class BaseServiceImpl {

	protected final Log log = LogFactory.getLog(getClass());

	protected String getStringFromCriteria(QueryCriteria criteria, String target) {
		String result = null;
		if (StringUtils.isNotEmpty(target)) {
			Object obj = criteria.getQueryCondition().get(target);
			if (obj != null) {
				result = (String) obj;
			}
		}
		return result;
	}

	protected Boolean getBoolenFromCriteria(QueryCriteria criteria,
			String target) {
		Boolean result = null;
		if (StringUtils.isNotEmpty(target)) {
			Object obj = criteria.getQueryCondition().get(target);
			if (obj != null) {
				result = (Boolean) obj;
			}
		}
		return result;
	}

	protected Long getLongFromCriteria(QueryCriteria criteria, String target) {
		Long result = null;
		if (StringUtils.isNotEmpty(target)) {
			Object obj = criteria.getQueryCondition().get(target);
			if (obj != null) {
				result = (Long) obj;
			}
		}
		return result;
	}

	protected Object bytesToDtoObject(byte[] buf) {
		Object obj = null;
		ByteArrayInputStream bi = new ByteArrayInputStream(buf);
		ObjectInputStream oi;
		try {
			oi = new ObjectInputStream(bi);
			obj = oi.readObject();
			bi.close();
			oi.close();
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

}