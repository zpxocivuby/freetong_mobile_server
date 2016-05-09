package itaf.framework.exception.service;
/**
 * <p>
 * Interface defines the contract for retrieve resource message string from
 * system resource buldle.
 * 
 * @author Danne
 */
public interface IExceptionMsgService {

	/**
	 * <p>
	 * Returns a message string from resource bundle with specified resource
	 * key.
	 * 
	 * @param key
	 *            unique key of message string.
	 * @return message string from specified resource bundle.
	 */
	String getMessage(String key);

	/**
	 * <p>
	 * Returns a message string from resource bundle with specified resource
	 * key, and binding paramters value.
	 * 
	 * @param key
	 *            unique key of message string.
	 * @param params
	 *            parameters value for binding.
	 * @return message string from specified resource bundle.
	 */
	String getMessage(String key, Object[] params);

}
