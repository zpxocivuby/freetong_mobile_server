package itaf.framework.exception.service.impl;

import itaf.framework.exception.service.IExceptionMsgService;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * <p>
 * system mesages.
 * 
 * @author Danne
 */
@Component("appExceptionMsgServiceImpl")
public class AppExceptionMsgServiceImpl extends ResourceBundleMessageSource
		implements IExceptionMsgService {

	/* bundle name */
	private static final String BUNDLE_NAME = "app-exception";

	/* message source accessor */
	private static MessageSourceAccessor accessor = null;

	/**
	 * Default constructor.
	 * 
	 */
	public AppExceptionMsgServiceImpl() {
		this(AppExceptionMsgServiceImpl.class.getPackage().getName() + "."
				+ BUNDLE_NAME);
	}

	/**
	 * Constructs a system message with specified resource bundle name.
	 * 
	 * @param bundleName
	 *            system resource bundle name.
	 */
	protected AppExceptionMsgServiceImpl(String bundleName) {
		setBasename(bundleName);
		setUseCodeAsDefaultMessage(true);
	}

	/**
	 * <p>
	 * Returns the message source accessor connected to the resource bundle.
	 * 
	 * @return singleton instance of MessageSourceAccessor.
	 */
	private MessageSourceAccessor getAccessor() {
		if (accessor == null) {
			accessor = new MessageSourceAccessor(this);
		}
		return accessor;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see itaf.framework.IExceptionMsgService.IMessageResource#getMessage(java.lang.String)
	 */
	public String getMessage(String code) {
		return getAccessor().getMessage(code);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see itaf.framework.IExceptionMsgService.IMessageResource#getMessage(java.lang.String,
	 *      java.lang.Object[])
	 */
	public String getMessage(String code, Object[] args) {
		return getAccessor().getMessage(code, args);
	}

}
