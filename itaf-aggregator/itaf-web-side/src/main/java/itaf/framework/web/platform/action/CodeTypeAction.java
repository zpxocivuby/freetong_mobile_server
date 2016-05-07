package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysCodeTypeService;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.platform.SysCodeType;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * 通用编码维护
 * 
 * @author XINXIN
 */
@ManagedBean(name = "codeTypeAction")
@ViewScoped
public class CodeTypeAction extends BaseRichFacesDataGridAction<SysCodeType> {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysCodeTypeServiceImpl}")
	private ISysCodeTypeService sysCodeTypeService;

	protected PageResult<SysCodeType> getPageContent() {
		processQueryCondiction();
		return getSysCodeTypeService().findByCriteria(queryCriteria);
	}

	private void processQueryCondiction() {
		queryCriteria.addQueryCondition("typeLike",
				ProcessQueryUtil.processStirngLike(queryCriteria, "type", 3));
		queryCriteria.addQueryCondition("nameZhLike",
				ProcessQueryUtil.processStirngLike(queryCriteria, "nameZh", 3));
	}

	public ISysCodeTypeService getSysCodeTypeService() {
		return sysCodeTypeService;
	}

	public void setSysCodeTypeService(ISysCodeTypeService sysCodeTypeService) {
		this.sysCodeTypeService = sysCodeTypeService;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

}
