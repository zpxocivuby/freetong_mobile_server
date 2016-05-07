package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysClientPublishService;
import itaf.framework.business.platform.service.ISysClientVersionService;
import itaf.framework.business.platform.service.ISysCodeListService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.util.DateHelper;
import itaf.framework.domain.platform.SysClientPublish;
import itaf.framework.domain.platform.SysClientVersion;
import itaf.framework.domain.platform.SysCodeList;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.exception.bean.BusinessException;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

@ManagedBean(name = "clientVersionAction")
@ViewScoped
public class ClientVersionAction extends
		BaseRichFacesDataGridAction<SysClientVersion> {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysCodeListServiceImpl}")
	private ISysCodeListService sysCodeListService; // clientPublicOperationStateCode
	@ManagedProperty(value = "#{sysClientVersionServiceImpl}")
	private ISysClientVersionService sysClientVersionService;
	@ManagedProperty(value = "#{sysClientPublishServiceImpl}")
	private ISysClientPublishService sysClientPublishService;
	@ManagedProperty(value = "#{sysUserServiceImpl}")
	private ISysUserService sysUserService;

	public ISysCodeListService getSysCodeListService() {
		return sysCodeListService;
	}

	public void setSysCodeListService(ISysCodeListService sysCodeListService) {
		this.sysCodeListService = sysCodeListService;
	}

	public ISysClientVersionService getSysClientVersionService() {
		return sysClientVersionService;
	}

	public void setSysClientVersionService(
			ISysClientVersionService sysClientVersionService) {
		this.sysClientVersionService = sysClientVersionService;
	}

	public ISysClientPublishService getSysClientPublishService() {
		return sysClientPublishService;
	}

	public void setSysClientPublishService(
			ISysClientPublishService sysClientPublishService) {
		this.sysClientPublishService = sysClientPublishService;
	}

	public ISysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	private String currentUser = "";
	private SysClientVersion sysClientVersion;
	private SelectItem[] statusSelects;
	private SelectItem[] typeSelects;
	private String versionNo;
	private String createDate;

	public String getCreateDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		createDate = df.format(date);
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getVersionNo() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd.hhmm.ss");
		versionNo = "MSApp_" + df.format(date);
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public SelectItem[] getStatusSelects() {
		if (statusSelects != null && statusSelects.length > 0) {
			return statusSelects;
		}
		List<SysCodeList> codeList = sysCodeListService
				.findByType("clientVersionStateCode");

		if (codeList == null || codeList.isEmpty()) {
			return null;
		}
		statusSelects = new SelectItem[codeList.size() + 1];
		for (int i = 0; i < codeList.size(); i++) {
			SysCodeList tcCodeList = codeList.get(i);
			statusSelects[0] = new SelectItem(null, "全部");
			statusSelects[i + 1] = new SelectItem(tcCodeList.getCodeValue(),
					tcCodeList.getNameZh());
		}
		return statusSelects;
	}

	public SelectItem[] getTypeSelects() {
		if (typeSelects != null && typeSelects.length > 0) {
			return typeSelects;
		}
		typeSelects = new SelectItem[3];
		typeSelects[0] = new SelectItem(null, "全部");
		typeSelects[1] = new SelectItem(1, "andriod");
		typeSelects[2] = new SelectItem(2, "ios");
		return typeSelects;
	}

	public void setTypeSelects(SelectItem[] typeSelects) {
		this.typeSelects = typeSelects;
	}

	public void setStatusSelects(SelectItem[] statusSelects) {
		this.statusSelects = statusSelects;
	}

	public SysClientVersion getSysClientVersion() {
		if (sysClientVersion == null) {
			String versionId = ProcessQueryUtil.getValueOfForm("versionId");
			if (StringUtils.trimToNull(versionId) != null) {
				sysClientVersion = sysClientVersionService.findById(Long
						.valueOf(versionId));
			}
		}
		if (sysClientVersion == null) {
			sysClientVersion = new SysClientVersion();
		}
		return sysClientVersion;
	}

	public void setSysClientVersion(SysClientVersion clientPublicVersion) {
		this.sysClientVersion = clientPublicVersion;
	}

	public String getCurrentUser() {
		SysUser user = sysUserService.findById(this.getCurrUserId());
		return user.getUsername();
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	protected PageResult<SysClientVersion> getPageContent() {
		processQueryCondiction();
		return sysClientVersionService.findByCriteria(queryCriteria);
	}

	private void processQueryCondiction() {
		Map<String, Object> condition = queryCriteria.getQueryCondition();
		condition.put("versionNo", ProcessQueryUtil.processStirngLike(
				queryCriteria, "versionNo", 3));
		condition.put("type",
				ProcessQueryUtil.processString(queryCriteria, "type"));
		condition.put("status",
				ProcessQueryUtil.processString(queryCriteria, "status"));
		condition.put("startTime", ProcessQueryUtil.processDate(queryCriteria,
				"startTime", DateHelper.FORMAT_DATE_YYYY_MM_DD));
		condition.put("endTime", ProcessQueryUtil.processDate(queryCriteria,
				"endTime", DateHelper.FORMAT_DATE_YYYY_MM_DD));
		queryCriteria.setOrderDirection("desc");
		queryCriteria.setOrderField("b.id");
		queryCriteria.setQueryCondition(condition);
	}

	public void save() {
		String versionNo = ProcessQueryUtil.getValueOfForm("versionNo");
		String type = ProcessQueryUtil.getValueOfForm("type");
		SysClientVersion sysClientVersion = new SysClientVersion();
		sysClientVersion.setVersionNo(versionNo);
		sysClientVersion.setStatus(SysClientVersion.NEW);
		sysClientVersion.setType(type);
		sysClientVersionService.doSaveOrUpdate(sysClientVersion);
	}

	public void on() {
		String versionId = ProcessQueryUtil.getValueOfForm("versionId");
		SysClientVersion sysClientVersion = sysClientVersionService
				.findById(Long.valueOf(versionId));
		if (sysClientVersion.getStatus().equals(SysClientVersion.ON)
				|| sysClientVersion.getStatus().equals(SysClientVersion.OFF)) {
			this.setActionMsg("只有新建状态才可以上线");
			return;
		}
		sysClientVersion.setStatus(SysClientVersion.ON);
		sysClientVersionService.doSaveOrUpdate(sysClientVersion);
	}

	public void off() {
		String versionId = ProcessQueryUtil.getValueOfForm("versionId");
		SysClientVersion sysClientVersion = sysClientVersionService
				.findById(Long.valueOf(versionId));
		if (!sysClientVersion.getStatus().equals(SysClientVersion.ON)) {
			this.setActionMsg("只有上线状态才可以失效!");
			return;
		}
		for (SysClientPublish sysClientPublish : sysClientVersion
				.getSysClientPublishs()) {
			/*
			 * if(!clientPublicOpInfo.getStatus().equals(SysClientPublish.
			 * ABANDONED)){ this.operateStatus = "只有此数据的版本信息全为下架的条件下，此版本才能失效!";
			 * return; }
			 */
			if (sysClientPublish.getPublishStatus().equals(
					SysClientPublish.PUBLISHED)) {
				this.setActionMsg("只有此数据的版本信息没有发布状态的，此版本才能失效!");
				return;
			}
		}

		sysClientVersion.setStatus(SysClientVersion.OFF);
		sysClientVersionService.doSaveOrUpdate(sysClientVersion);
	}

	public static void main(String[] args) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd.hhmm.ss");
		System.out.print(df.format(date));
	}

	@Override
	protected void execute() {
		if (METHOD_SAVE.equals(this.getMethodType())) {
			this.save();
		} else if ("on".equals(this.getMethodType())) {
			this.on();
		} else if ("off".equals(this.getMethodType())) {
			this.off();
		}
	}

}
