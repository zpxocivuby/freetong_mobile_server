package itaf.framework.log.aop;

import itaf.framework.core.aop.CombinedThrowAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * <p>
 * 该类是用于对切面层进行日志记录的操作类。
 * <P>
 * 该类可以记录方法开始，方法结束，以及异常抛出的日志信息
 * <P>
 * 主要的参数有:
 * <ul>
 * <li>切面的名称</li>
 * <li>是否进行方法开始的日志记录,default=true;</li>
 * <li>是否进行方法结束的日志记录,default=true;</li>
 * <li>是否进行方法异常输出的日志记录,default=true;</li>
 * <li>是否方法名记录,default=true;</li>
 * <li>是否方法参数记录,default=true;</li>
 * <li>是否返回参数记录,default=true;</li>
 */
public class MethodLogAdvice implements MethodBeforeAdvice,
		AfterReturningAdvice, CombinedThrowAdvice {

	/**
	 * 是否进行方法开始的日志记录,default=true;
	 */
	private Boolean isLogBeforeMethod = true;
	/**
	 * 是否进行方法结束的日志记录,default=true;
	 */
	private Boolean isLogEndMethod = true;
	/**
	 * 是否方法名记录,default=true;
	 */
	private Boolean isLogMethodName = true;
	/**
	 * 是否方法参数记录,default=true;
	 */
	private Boolean isLogMethodParam = true;
	/**
	 * 是否返回参数记录,default=true;
	 */
	private Boolean isLogReturnParam = true;
	/**
	 * 是否进行方法异常输出的日志记录,default=true;
	 */
	private Boolean isLogThrow = true;

	private String pointcutName = "";

	/**
	 * Callback after a given method successfully returned.
	 * 
	 * @param returnValue
	 *            the value returned by the method, if any
	 * @param method
	 *            method being invoked
	 * @param args
	 *            arguments to the method
	 * @param target
	 *            target of the method invocation. May be <code>null</code>.
	 * @throws Throwable
	 *             if this object wishes to abort the call. Any exception thrown
	 *             will be returned to the caller if it's allowed by the method
	 *             signature. Otherwise the exception will be wrapped as a
	 *             runtime exception.
	 */
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {

	}

	/**
	 * <p>
	 * This method is called by AOP framework while those method configured with
	 * AOP method advice called encounterred an exception.
	 * 
	 * @param method
	 *            method called by AOP.
	 * @param args
	 *            parameters passed to method.
	 * @param target
	 *            target object adviced by AOP.
	 * @param e
	 *            exception throws by method called.
	 * @throws Throwable
	 *             exception while method called.
	 */
	public void afterThrowing(Method method, Object[] args, Object target,
			Exception e) throws Throwable {

	}

	/**
	 * Callback before a given method is invoked.
	 * 
	 * @param method
	 *            method being invoked
	 * @param args
	 *            arguments to the method
	 * @param target
	 *            target of the method invocation. May be <code>null</code>.
	 * @throws Throwable
	 *             if this object wishes to abort the call. Any exception thrown
	 *             will be returned to the caller if it's allowed by the method
	 *             signature. Otherwise the exception will be wrapped as a
	 *             runtime exception.
	 */
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {

	}

	/**
	 * @return the isLogBeforeMethod
	 */
	public Boolean getIsLogBeforeMethod() {
		return isLogBeforeMethod;
	}

	/**
	 * @return the isLogEndMethod
	 */
	public Boolean getIsLogEndMethod() {
		return isLogEndMethod;
	}

	/**
	 * @return the isLogMethodName
	 */
	public Boolean getIsLogMethodName() {
		return isLogMethodName;
	}

	/**
	 * @return the isLogMethodParam
	 */
	public Boolean getIsLogMethodParam() {
		return isLogMethodParam;
	}

	/**
	 * @return the isLogReturnParam
	 */
	public Boolean getIsLogReturnParam() {
		return isLogReturnParam;
	}

	/**
	 * @return the isLogThrow
	 */
	public Boolean getIsLogThrow() {
		return isLogThrow;
	}

	/**
	 * @return the pointcutName
	 */
	public String getPointcutName() {
		return pointcutName;
	}

	/**
	 * @param isLogBeforeMethod
	 *            the isLogBeforeMethod to set
	 */
	public void setIsLogBeforeMethod(Boolean isLogBeforeMethod) {
		this.isLogBeforeMethod = isLogBeforeMethod;
	}

	/**
	 * @param isLogEndMethod
	 *            the isLogEndMethod to set
	 */
	public void setIsLogEndMethod(Boolean isLogEndMethod) {
		this.isLogEndMethod = isLogEndMethod;
	}

	/**
	 * @param isLogMethodName
	 *            the isLogMethodName to set
	 */
	public void setIsLogMethodName(Boolean isLogMethodName) {
		this.isLogMethodName = isLogMethodName;
	}

	/**
	 * @param isLogMethodParam
	 *            the isLogMethodParam to set
	 */
	public void setIsLogMethodParam(Boolean isLogMethodParam) {
		this.isLogMethodParam = isLogMethodParam;
	}

	/**
	 * @param isLogReturnParam
	 *            the isLogReturnParam to set
	 */
	public void setIsLogReturnParam(Boolean isLogReturnParam) {
		this.isLogReturnParam = isLogReturnParam;
	}

	/**
	 * @param isLogThrow
	 *            the isLogThrow to set
	 */
	public void setIsLogThrow(Boolean isLogThrow) {
		this.isLogThrow = isLogThrow;
	}

	/**
	 * @param pointcutName
	 *            the pointcutName to set
	 */
	public void setPointcutName(String pointcutName) {
		this.pointcutName = pointcutName;
	}

}
