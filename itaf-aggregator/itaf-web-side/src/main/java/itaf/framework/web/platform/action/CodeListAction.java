package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysCodeListService;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.platform.SysCodeList;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author LIUBING
 * 
 */
@ManagedBean(name = "codeListAction")
@ViewScoped
public class CodeListAction extends BaseRichFacesDataGridAction<SysCodeList> {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{sysCodeListServiceImpl}")
	private ISysCodeListService sysCodeListService;

	private Log log = LogFactory.getLog(CodeListAction.class);

	private SysCodeList sysCodeList;
	private Long codeTypeId = null;
	private Long codeListId = null;
	private String operateMsg;

	protected PageResult<SysCodeList> getPageContent() {
		Long codeTypeId = this.getCodeTypeId();
		PageResult<SysCodeList> results = new PageResult<SysCodeList>();
		if (codeTypeId != null) {
			processQueryCondiction(codeTypeId);
			results = sysCodeListService.findByCriteria(queryCriteria);
		}
		return results;
	}

	public String save() {
		try {
			SysCodeList tcCodeList = this.getSysCodeList();
			Long id = tcCodeList.getId();
			if (id == null || id <= 0) {
				sysCodeListService.doCreate(tcCodeList);
			} else {
				sysCodeListService.doUpdate(tcCodeList);
			}
			this.setOperateMsg("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("添加编码常量错误！");
			this.setOperateMsg("error");
		}
		return null;
	}

	public String delete() {
		try {
			Long codeListId = this.getCodeListId();
			if (codeListId != null && codeListId > 0) {
				SysCodeList tcCodeList = sysCodeListService.getById(codeListId);
				sysCodeListService.doDelete(tcCodeList);
				this.setOperateMsg("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除编码常量错误！");
			this.setOperateMsg("error");
		}
		return null;
	}

	public Long getCodeTypeId() {
		String codeTypeIdStr = ProcessQueryUtil.getValueOfForm("codeTypeId");
		if (StringUtils.isNotEmpty(codeTypeIdStr)) {
			codeTypeId = Long.valueOf(codeTypeIdStr);
		}
		return codeTypeId;
	}

	public SysCodeList getSysCodeList() {
		Long codeListId = this.getCodeListId();
		Long codeTypeId = this.getCodeTypeId();
		if (sysCodeList == null && codeListId != null) {
			sysCodeList = sysCodeListService.getById(codeListId);
		}
		if (sysCodeList == null) {
			sysCodeList = new SysCodeList();
		}
		System.out.println("codeListId:" + codeListId + ", codeTypeId:"
				+ codeTypeId);
		sysCodeList.setSysCodeTypeId(codeTypeId);
		return sysCodeList;
	}

	public Long getCodeListId() {
		String codeListIdStr = ProcessQueryUtil.getValueOfForm("codeListId");
		if (StringUtils.isNotEmpty(codeListIdStr)) {
			codeListId = Long.valueOf(codeListIdStr);
		}
		return codeListId;
	}

	public void setSysCodeList(SysCodeList tcCodeList) {
		this.sysCodeList = tcCodeList;
	}

	public ISysCodeListService getSysCodeListService() {
		return sysCodeListService;
	}

	public void setSysCodeListService(ISysCodeListService sysCodeListService) {
		this.sysCodeListService = sysCodeListService;
	}

	public void setCodeTypeId(Long codeTypeId) {
		this.codeTypeId = codeTypeId;
	}

	public void setCodeListId(Long codeListId) {
		this.codeListId = codeListId;
	}

	public String getOperateMsg() {
		return operateMsg;
	}

	public void setOperateMsg(String operateMsg) {
		this.operateMsg = operateMsg;
	}

	private void processQueryCondiction(Long codeTypeId) {
		Map<String, Object> condition = queryCriteria.getQueryCondition();
		condition.put("codeTypeId", codeTypeId);
		queryCriteria.setOrderField("sortNo");
		queryCriteria.setOrderDirection("asc");
		queryCriteria.setQueryCondition(condition);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

}
