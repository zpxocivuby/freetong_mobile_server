package itaf.framework.cache.aop.base.impl;

import itaf.framework.cache.aop.base.ICacheObject;

import java.util.List;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * An abstract {@link ICacheObject} implementor class that use EhCache as
 * back-end cache system.
 * 
 * @author Danne
 * 
 */
@Service("ehCacheObjectImpl")
public class EhCacheObjectImpl<T> implements InitializingBean, ICacheObject<T> {

	protected final Log logger = LogFactory.getLog(getClass());

	private Ehcache cache = null;

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cache, "cache mandatory");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * itaf.framework.cache.IObjectCache#getObjectFromCache(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public T getByKey(Object key) {
		Element element = null;
		try {
			element = cache.get(key);
		} catch (CacheException cacheException) {
			throw new DataRetrievalFailureException("Cache failure: "
					+ cacheException.getMessage());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Cache hit: " + (element != null) + "; key: " + key);
		}

		if (element == null) {
			return null;
		} else {
			return (T) element.getObjectValue();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see itaf.framework.cache.IObjectCache#putObjectInCache(java.lang.Object,
	 * T)
	 */
	public void cacheObject(Object key, T object) {
		Element element = new Element(key, object);

		if (logger.isDebugEnabled()) {
			logger.debug("Cache put: " + element.getObjectKey());
		}

		cache.put(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * itaf.framework.cache.IObjectCache#removeObjectFromCache(java.lang.Object)
	 */
	public void removeByKey(Object key) {
		if (logger.isDebugEnabled()) {
			logger.debug("Cache remove: " + key);
		}
		cache.remove(key);
	}

	@SuppressWarnings("unchecked")
	public void clearByPrefix(String prefix) {
		List<String> keys = cache.getKeys();
		if (keys == null || keys.size() <= 0) {
			return;
		}
		for (String key : keys) {
			if (key.startsWith(prefix)) {
				removeByKey(key);
			}
		}
	}

	public Ehcache getCache() {
		return cache;
	}

	public void setCache(Ehcache cache) {
		this.cache = cache;
	}

}
