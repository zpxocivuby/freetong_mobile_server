package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysParameterService;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.platform.SysParameter;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

/**
 * 系统参数
 * 
 * 
 * @author XINXIN
 * 
 * @UpdateDate 2014年8月5日
 */
@ManagedBean(name = "parameterAction")
@ViewScoped
public class ParameterAction extends BaseRichFacesDataGridAction<SysParameter> {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysParameterServiceImpl}")
	private ISysParameterService sysParameterService;

	private SysParameter sysParameter;

	@Override
	protected void execute() {
		if (METHOD_SAVE.equals(this.getMethodType())) {
			this.save();
		} else if (METHOD_DELETE.equals(this.getMethodType())) {
			this.delete();
		}
	}

	private void save() {
		SysParameter paramObj = this.sysParameter;
		sysParameterService.doCreate(paramObj);
	}

	private void delete() {
		SysParameter paramObj = this.sysParameter;
		sysParameterService.doDelete(paramObj);
	}

	@Override
	protected PageResult<SysParameter> getPageContent() {
		processQueryCondiction();
		return sysParameterService.findByCriteria(queryCriteria);
	}

	private void processQueryCondiction() {
		queryCriteria.addQueryCondition("nameEnLike",
				ProcessQueryUtil.processStirngLike(queryCriteria, "nameEn", 3));
		queryCriteria.addQueryCondition("nameZhLike",
				ProcessQueryUtil.processStirngLike(queryCriteria, "nameZh", 3));
	}

	public SysParameter getSysParameter() {
		String paramId = ProcessQueryUtil.getValueOfForm("paramId");
		if (sysParameter == null && StringUtils.trimToNull(paramId) != null) {
			sysParameter = sysParameterService.findById(Long.valueOf(paramId));
		}
		if (sysParameter == null) {
			sysParameter = new SysParameter();
		}
		return sysParameter;
	}

	public ISysParameterService getSysParameterService() {
		return sysParameterService;
	}

	public void setSysParameterService(ISysParameterService sysParameterService) {
		this.sysParameterService = sysParameterService;
	}

	public void setSysParameter(SysParameter tsParameter) {
		this.sysParameter = tsParameter;
	}

}
