package itaf.framework.cache.aop.base;

/**
 * This interface defines the contract for those object that can be retrieved
 * from, put into cache.
 * 
 * @author Danne
 * 
 * @param <T>
 */
public interface ICacheObject<T> {

	T getByKey(Object key);

	void cacheObject(Object key, T value);

	void removeByKey(Object key);

	void clearByPrefix(String prefix);

}