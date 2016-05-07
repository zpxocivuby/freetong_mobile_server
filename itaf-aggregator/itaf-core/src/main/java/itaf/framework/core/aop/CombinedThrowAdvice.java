package itaf.framework.core.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * <p>
 * Advice interface defines after throwing advice method.
 * 
 */
public interface CombinedThrowAdvice extends ThrowsAdvice {
	/**
	 * <p>
	 * This method is called by AOP framework while those method configured with
	 * AOP method advice called encountered an exception.
	 * 
	 * @param method
	 *            method called by AOP.
	 * @param args
	 *            parameters passed to method.
	 * @param target
	 *            target object advised by AOP.
	 * @param e
	 *            exception throws by method called.
	 * @throws Throwable
	 *             exception while method called.
	 */
	void afterThrowing(Method method, Object[] args, Object target, Exception e)
			throws Throwable;
}
