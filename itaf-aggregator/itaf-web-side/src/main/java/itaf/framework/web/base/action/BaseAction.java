package itaf.framework.web.base.action;

import itaf.framework.core.util.StringHelper;
import itaf.framework.exception.bean.AppException;
import itaf.framework.exception.bean.BusinessException;
import itaf.framework.web.util.ProcessQueryUtil;

/**
 * action基础类
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月25日
 */
public abstract class BaseAction extends AbstractPageAction {

	private static final long serialVersionUID = 7581219928294281336L;

	protected static final String METHOD_SAVE = "save";
	protected static final String METHOD_UPDATE = "update";
	protected static final String METHOD_DELETE = "delete";
	// action级别的方法类型
	private String methodType;

	public String actionExecute() {
		getLog().info(
				"-------xecute className=:" + getClass().getName()
						+ " and execute actionType=" + this.getActionMsg());
		try {
			this.setActionMsg(ACTION_SUCCESS);
			execute();
		} catch (BusinessException be) {
			be.printStackTrace();
			this.setActionMsg(be.getCode());
			this.getLog().error(be.getMessage());
		} catch (AppException se) {
			se.printStackTrace();
			this.setActionMsg(se.getCode());
			this.getLog().error(se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			this.getLog().error(e);
			this.setActionMsg(ACTION_ERROR);
		}
		return null;
	}

	protected abstract void execute();

	public String getMethodType() {
		methodType = ProcessQueryUtil.getValueOfForm("methodType");
		if (StringHelper.isEmpty(methodType)) {
			this.getLog().error("methodType不能为null");
			throw new BusinessException("methodType不能为null");
		}
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

}
