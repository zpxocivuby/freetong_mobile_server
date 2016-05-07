package itaf.framework.exception.aop;

import itaf.framework.core.aop.CombinedThrowAdvice;
import itaf.framework.exception.bean.BusinessException;
import itaf.framework.exception.bean.AppException;
import itaf.framework.exception.service.IExceptionMsgService;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.StaleObjectStateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.TransactionException;

/**
 * 异常的切点
 *
 *
 * @author
 *
 * @UpdateDate
 */
public final class ExceptionMsgProcessAdvice implements MethodBeforeAdvice,
		AfterReturningAdvice, CombinedThrowAdvice {

	/* class log */
	private final Log log = LogFactory.getLog(getClass());

	@Autowired
	@Qualifier("appExceptionMsgServiceImpl")
	private IExceptionMsgService systemMsg = null;
	@Autowired
	@Qualifier("businessExceptionMsgServiceImpl")
	private IExceptionMsgService businessMsg = null;

	/* enabled_method trace (before & after) */
	private boolean enabledMethodTrace = false;

	/**
	 * <p>
	 * This method is called by AOP framework before those method configured
	 * with AOP method advice called.
	 * 
	 * @param method
	 *            method called by AOP.
	 * @param args
	 *            parameters passed to method.
	 * @param target
	 *            target object adviced by AOP.
	 * @throws Throwable
	 *             exception while method called.
	 */
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		boolean traceEnabled = log.isDebugEnabled();
		if (isEnabledMethodTrace() && traceEnabled) {
			log.debug(systemMsg.getMessage("SE001",
					new Object[] { target.getClass(), method.getName() }));
		}

	}

	/**
	 * <p>
	 * This method is called by AOP framework after those method configured with
	 * AOP method advice call returned value.
	 * 
	 * @param returnValue
	 *            value returned from method called.
	 * @param method
	 *            method called by AOP.
	 * @param args
	 *            parameters passed to method.
	 * @param target
	 *            target object adviced by AOP.
	 * @throws Throwable
	 *             exception while method called.
	 */
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		boolean traceEnabled = log.isDebugEnabled();
		if (isEnabledMethodTrace() && traceEnabled) {
			log.debug(systemMsg.getMessage("SE002",
					new Object[] { target.getClass(), method.getName() }));
		}
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
		log.error(
				systemMsg.getMessage("SE0013", new Object[] {
						target.getClass().getName(), method.getName() }), e);
		if (e instanceof DataAccessException) {
			e = translateDataAccessException((DataAccessException) e);
		} else if (e instanceof TransactionException) {
			e = new AppException("SE0005");
		} else if (e instanceof HibernateException) {
			e = translateHibernateException(e);
		}

		// Throwable cause = e.getCause();
		log.error(e);
		// localize message.
		if (e instanceof BusinessException) {
			String code = ((BusinessException) e).getCode();
			String[] params = ((BusinessException) e).getParams();
			String message = businessMsg.getMessage(code, params);
			e = new BusinessException(code + ": " + message);
		} else if (e instanceof AppException) {
			String code = ((AppException) e).getCode();
			String[] params = ((AppException) e).getParams();
			String message = systemMsg.getMessage(code, params);
			e = new AppException(code + ": " + message);
		}
		throw e;
	}

	/**
	 * <p>
	 * Translates OR-Mapping hibernate framework exception to system specific
	 * exception.
	 * 
	 * @param e
	 *            exception from hibernate framework.
	 * @return System exception wrapped up hibernate exception.
	 */
	private AppException translateHibernateException(Exception e) {
		AppException se = new AppException("SE0002");
		if (e instanceof ObjectNotFoundException) {
			se = new AppException("SE0003",
					new String[] { ((ObjectNotFoundException) e)
							.getEntityName() });
		}
		return se;
	}

	/**
	 * <p>
	 * Translates data accessing related Spring framework exception to system
	 * specific exception.
	 * 
	 * @param e
	 *            exception from hibernate framework.
	 * @return System exception wrapped up hibernate exception.
	 */
	private AppException translateDataAccessException(DataAccessException e) {
		Throwable cause = e.getCause();
		AppException se = new AppException("SE0002");
		if (cause instanceof ConstraintViolationException) {
			log.debug("Exception with Excuting SQL:"
					+ ((ConstraintViolationException) cause).getSQL());
			se = new AppException("SE0004");
		} else if (cause instanceof StaleObjectStateException) {
			se = new AppException("SE0014");
		} else if (cause instanceof JDBCException) {
			log.debug("Exception with Excuting SQL:"
					+ ((JDBCException) cause).getSQL());
			se = new AppException("SE0002");
		}
		return se;
	}

	public boolean isEnabledMethodTrace() {
		return enabledMethodTrace;
	}

	public void setEnabledMethodTrace(boolean enabled) {
		this.enabledMethodTrace = enabled;
	}

}
