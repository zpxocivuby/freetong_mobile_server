package itaf.framework.web.platform.action;

import itaf.framework.business.log.service.ISysUserAccLogService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.util.DateHelper;
import itaf.framework.domain.log.SysUserAccLog;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * 用户日志管理Action
 * 
 * @author XINXIN
 * 
 */
@ManagedBean(name = "userAccLogAction")
@ViewScoped
public class UserAccLogAction extends
		BaseRichFacesDataGridAction<SysUserAccLog> {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{tlSysUserAccLogServiceImpl}")
	private ISysUserAccLogService tlSysUserAccLogService;

	@Override
	protected void execute() {
		// TODO SAVE OR UPDATE OR DELETE
	}

	@Override
	protected PageResult<SysUserAccLog> getPageContent() {
		processQueryCondiction();
		return tlSysUserAccLogService.findByCriteria(queryCriteria);
	}

	private void processQueryCondiction() {
		queryCriteria.addQueryCondition("usernameLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "username", 3));
		queryCriteria.addQueryCondition("loginTime", ProcessQueryUtil
				.processDate(queryCriteria, "loginTime",
						DateHelper.FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS));
		queryCriteria.addQueryCondition("logoutTime", ProcessQueryUtil
				.processDate(queryCriteria, "logoutTime",
						DateHelper.FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS));
		queryCriteria.setOrderField("id");
		queryCriteria.setOrderDirection("desc");
	}

	public ISysUserAccLogService getSysUserAccLogService() {
		return tlSysUserAccLogService;
	}

	public void setSysUserAccLogService(
			ISysUserAccLogService tlSysUserAccLogService) {
		this.tlSysUserAccLogService = tlSysUserAccLogService;
	}

}
