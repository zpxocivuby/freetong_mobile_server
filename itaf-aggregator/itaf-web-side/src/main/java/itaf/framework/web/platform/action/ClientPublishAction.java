package itaf.framework.web.platform.action;

import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.business.platform.service.ISysClientPublishService;
import itaf.framework.business.platform.service.ISysClientVersionService;
import itaf.framework.business.platform.service.ISysCodeListService;
import itaf.framework.business.platform.service.ISysParameterService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.util.DateHelper;
import itaf.framework.domain.platform.SysAttachment;
import itaf.framework.domain.platform.SysClientPublish;
import itaf.framework.domain.platform.SysClientVersion;
import itaf.framework.domain.platform.SysCodeList;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

@ManagedBean(name = "clientPublishAction")
@ViewScoped
public class ClientPublishAction extends
		BaseRichFacesDataGridAction<SysClientPublish> {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysCodeListServiceImpl}")
	private ISysCodeListService sysCodeListService; // clientPublicOperationStateCode
	@ManagedProperty(value = "#{sysClientVersionServiceImpl}")
	private ISysClientVersionService sysClientVersionService;
	@ManagedProperty(value = "#{sysClientPublishServiceImpl}")
	private ISysClientPublishService sysClientPublishService;
	@ManagedProperty(value = "#{sysAttachmentServiceImpl}")
	private ISysAttachmentService sysAttachmentService;
	@ManagedProperty(value = "#{sysUserServiceImpl}")
	private ISysUserService sysUserService;
	@ManagedProperty(value = "#{sysParameterServiceImpl}")
	private ISysParameterService sysParameterService;

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

	public ISysAttachmentService getSysAttachmentService() {
		return sysAttachmentService;
	}

	public void setSysAttachmentService(
			ISysAttachmentService sysAttachmentService) {
		this.sysAttachmentService = sysAttachmentService;
	}

	public ISysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public ISysParameterService getSysParameterService() {
		return sysParameterService;
	}

	public void setSysParameterService(ISysParameterService sysParameterService) {
		this.sysParameterService = sysParameterService;
	}

	private SelectItem[] statusSelects;
	private SelectItem[] versionSelects;

	private SysClientPublish sysClientPublish;

	public String getIosDownloadPath() throws Exception {
		String path = "#";
		String iosBaseUrl = sysParameterService.findByType("IOS_BASEURL")
				.getValue();
		SysClientVersion sysClientVersion = sysClientVersionService
				.getNewVesion("2");
		Long fileId = null;
		if (sysClientVersion != null) {
			for (SysClientPublish sysClientPublish : sysClientVersion
					.getSysClientPublishs()) {
				if (sysClientPublish.getPublishStatus().equals("published")) {
					fileId = sysClientPublish.getSysAttachment().getId();
					break;
				}
			}
		}
		if (fileId != null) {
			path = "itms-services://?action=download-manifest&url="
					+ iosBaseUrl + this.getContextPath()
					+ "/wsServlet/DownloadVersionFileServlet?fileId=" + fileId
					+ "&type=21";
		}
		return path;
	}

	public String getIosDownloadPath71() {
		return sysParameterService.findByType("IOS_URL71").getValue();
	}

	public String getAndriodDownloadPath() {
		String path = "";
		SysClientVersion sysClientVersion = sysClientVersionService
				.getNewVesion("1");
		Long fileId = null;
		if (sysClientVersion != null) {
			for (SysClientPublish sysClientPublish : sysClientVersion
					.getSysClientPublishs()) {
				if (sysClientPublish.getPublishStatus().equals("published")) {
					fileId = sysClientPublish.getSysAttachment().getId();
					break;
				}
			}
		}
		if (fileId != null) {
			path = this.getContextPath()
					+ "/wsServlet/DownloadVersionFileServlet?fileId=" + fileId
					+ "&type=11";
		}
		return path;
	}

	public SysClientPublish getSysClientPublish() {
		if (sysClientPublish == null) {
			String clientPublishId = ProcessQueryUtil
					.getValueOfForm("clientPublishId");
			if (StringUtils.trimToNull(clientPublishId) != null) {
				sysClientPublish = sysClientPublishService.findById(Long
						.valueOf(clientPublishId));
				sysClientPublish.setFileId(String.valueOf(sysClientPublish
						.getSysAttachment().getId()));
				sysClientPublish.setFileName(sysClientPublish
						.getSysAttachment().getSrcFileName()
						+ "."
						+ sysClientPublish.getSysAttachment().getFileExt());
			}
		}
		if (sysClientPublish == null) {
			sysClientPublish = new SysClientPublish();
		}
		return sysClientPublish;
	}

	public void setSysClientPublish(SysClientPublish clientPublicOpInfo) {
		this.sysClientPublish = clientPublicOpInfo;
	}

	public SelectItem[] getVersionSelects() {
		if (versionSelects != null && versionSelects.length > 0) {
			return versionSelects;
		}
		List<SysClientVersion> sysClientVersions = sysClientVersionService
				.findByStatus(SysClientVersion.ON);

		if (sysClientVersions == null || sysClientVersions.isEmpty()) {
			return null;
		}

		versionSelects = new SelectItem[sysClientVersions.size() + 1];
		for (int i = 0; i < sysClientVersions.size(); i++) {
			SysClientVersion sysClientVersion = sysClientVersions.get(i);
			versionSelects[0] = new SelectItem(null, "请选择");
			String value = sysClientVersion.getVersionNo();
			if (sysClientVersion.getType() != null
					&& !sysClientVersion.getType().equals("")) {
				String type = "";
				if (sysClientVersion.getType().equals("1")) {
					type = "andriod";
				} else {
					type = "ios";
				}
				value = value + "(" + type + ")";
			}
			versionSelects[i + 1] = new SelectItem(sysClientVersion.getId(),
					value);
		}
		return versionSelects;
	}

	public SelectItem[] getStatusSelects() {
		if (statusSelects != null && statusSelects.length > 0) {
			return statusSelects;
		}
		List<SysCodeList> codeList = sysCodeListService
				.findByType("sysClientPublishStateCode");

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

	@Override
	protected PageResult<SysClientPublish> getPageContent() {
		processQueryCondiction();
		return sysClientPublishService.findByCriteria(queryCriteria);
	}

	private void processQueryCondiction() {
		Map<String, Object> condition = queryCriteria.getQueryCondition();

		condition.put("publishNo", ProcessQueryUtil.processStirngLike(
				queryCriteria, "publishNo", 3));
		condition.put("publishStatus",
				ProcessQueryUtil.processString(queryCriteria, "publishStatus"));
		condition.put("type",
				ProcessQueryUtil.processString(queryCriteria, "type"));
		condition.put("startTime", ProcessQueryUtil.processDate(queryCriteria,
				"startTime", DateHelper.FORMAT_DATE_YYYY_MM_DD));
		condition.put("endTime", ProcessQueryUtil.processDate(queryCriteria,
				"endTime", DateHelper.FORMAT_DATE_YYYY_MM_DD));

		queryCriteria.setOrderDirection("desc");
		queryCriteria.setOrderField("b.id");
		queryCriteria.setQueryCondition(condition);
	}

	public void publish() {
		String clientPublishId = ProcessQueryUtil
				.getValueOfForm("clientPublishId");
		SysClientPublish clientPublicOpInfo = sysClientPublishService
				.findById(Long.valueOf(clientPublishId));
		if (clientPublicOpInfo.getFilePath() == null
				|| clientPublicOpInfo.getFilePath().equals("")) {
			this.setActionMsg("请上传附件后再发布!");
		}

		if (clientPublicOpInfo.getPublishStatus().equals(
				SysClientPublish.ABANDONED)
				|| clientPublicOpInfo.getPublishStatus().equals(
						SysClientPublish.UPLOADED)) {
			sysClientPublishService.doPublish(clientPublicOpInfo);
			this.setActionMsg("操作成功!");
		} else {
			this.setActionMsg("只能发布上传成功或下线的数据!");
		}
	}

	public void abandon() {
		String clientPublishId = ProcessQueryUtil
				.getValueOfForm("clientPublishId");
		SysClientPublish clientPublicOpInfo = sysClientPublishService
				.findById(Long.valueOf(clientPublishId));
		if (clientPublicOpInfo.getPublishStatus().equals(
				SysClientPublish.PUBLISHED)) {
			sysClientPublishService.doAbandon(clientPublicOpInfo);
			this.setActionMsg("操作成功!");
		} else {
			this.setActionMsg("只能下架已发布的数据!");
		}
	}

	public void save() {
		String publishNo = ProcessQueryUtil.getValueOfForm("publishNo");
		String updateMsg = ProcessQueryUtil.getValueOfForm("updateMsg");
		String fileId = ProcessQueryUtil.getValueOfForm("fileId");

		SysClientVersion sysClientVersion = sysClientVersionService
				.findById(Long.valueOf(publishNo));

		SysClientPublish sysClientPublish = new SysClientPublish();
		sysClientPublish.setSysClientVersion(sysClientVersion);
		sysClientPublish.setPublishStatus(SysClientPublish.CREATED);
		sysClientPublish.setPublishUser(this.getCurrUserId());
		sysClientPublish.setUpdateMsg(updateMsg);
		int opInfoNo = 1;
		if (sysClientVersion.getSysClientPublishs() != null
				&& sysClientVersion.getSysClientPublishs().size() > 0) {
			opInfoNo = sysClientVersion.getSysClientPublishs().size() + 1;
		}
		sysClientPublish.setPublishNo(String.valueOf(opInfoNo));

		if (fileId != null && !fileId.equals("")) {
			sysClientPublish.setSysAttachment(sysAttachmentService
					.findById(Long.valueOf(fileId)));
			sysClientPublish.setPublishStatus(SysClientPublish.UPLOADED);
			// 创建IOSplist文件
			if (sysClientPublish.getSysClientVersion().getType().equals("2")) {
				createIosPlist(fileId, sysClientPublish.getSysClientVersion()
						.getVersionNo());
			}
		}
		sysClientPublishService.doSaveOrUpdate(sysClientPublish);
	}

	public void newPublish() {
		String publishNo = ProcessQueryUtil.getValueOfForm("publishNo");
		String updateMsg = ProcessQueryUtil.getValueOfForm("updateMsg");
		String fileId = ProcessQueryUtil.getValueOfForm("fileId");

		SysClientVersion sysClientVersion = sysClientVersionService
				.findById(Long.valueOf(publishNo));
		SysClientPublish sysClientPublish = new SysClientPublish();
		sysClientPublish.setSysClientVersion(sysClientVersion);
		sysClientPublish.setPublishStatus(SysClientPublish.PUBLISHED);
		sysClientPublish.setPublishUser(this.getCurrUserId());
		sysClientPublish.setPublishTime(new Date());
		sysClientPublish.setUpdateMsg(updateMsg);
		int opInfoNo = 1;
		if (sysClientVersion.getSysClientPublishs() != null
				&& sysClientVersion.getSysClientPublishs().size() > 0) {
			opInfoNo = sysClientVersion.getSysClientPublishs().size() + 1;
		}
		sysClientPublish.setPublishNo(String.valueOf(opInfoNo));

		if (fileId != null && !fileId.equals("")) {
			sysClientPublish.setSysAttachment(sysAttachmentService
					.findById(Long.valueOf(fileId)));
			// 创建IOSplist文件
			if (sysClientPublish.getSysClientVersion().getType().equals("2")) {
				createIosPlist(fileId, sysClientPublish.getSysClientVersion()
						.getVersionNo());
			}
		}

		for (SysClientPublish temp : sysClientVersion.getSysClientPublishs()) {
			if (temp.getPublishStatus().equals(SysClientPublish.PUBLISHED)) {
				temp.setPublishStatus(SysClientPublish.ABANDONED);
				sysClientPublishService.doSaveOrUpdate(temp);
			}
		}

		sysClientPublishService.doSaveOrUpdate(sysClientPublish);
		sysClientVersion.setPublishStatus(SysClientPublish.PUBLISHED);
		sysClientVersionService.doSaveOrUpdate(sysClientVersion);
	}

	public void editPublish() {
		String clientPublishId = ProcessQueryUtil
				.getValueOfForm("clientPublishId");
		String fileId = ProcessQueryUtil.getValueOfForm("fileId");
		String updateMsg = ProcessQueryUtil.getValueOfForm("updateMsg");

		SysClientPublish sysClientPublish = sysClientPublishService
				.findById(Long.valueOf(clientPublishId));
		SysClientVersion sysClientVersion = sysClientPublish
				.getSysClientVersion();
		sysClientVersion.setPublishTime(new Date());
		sysClientVersionService.doSaveOrUpdate(sysClientVersion);

		sysClientPublish.setSysAttachment(sysAttachmentService.findById(Long
				.valueOf(fileId)));
		sysClientPublish.setPublishTime(new Date());
		sysClientPublish.setUpdateMsg(updateMsg);
		// 创建IOSplist文件
		if (sysClientPublish.getSysClientVersion().getType().equals("2")) {
			createIosPlist(fileId, sysClientPublish.getSysClientVersion()
					.getVersionNo());
		}

		sysClientPublishService.doPublish(sysClientPublish);
	}

	private void createIosPlist(String fileId, String publishNo) {

		SysAttachment sysAttachment = sysAttachmentService.getById(Long
				.valueOf(fileId));

		String filePath = sysAttachmentService.getAbsolutePath(
				sysAttachment.getFileName(), sysAttachment.getFileExt());

		String iosBaseUrl = sysParameterService.findByType("IOS_BASEURL")
				.getValue();

		try {
			File ioPath = new File(filePath.substring(0,
					filePath.lastIndexOf("/"))
					+ "/ios.plist");
			if (!ioPath.exists()) {
				ioPath.createNewFile();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(ioPath));
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\"><plist version=\"1.0\"><dict><key>items</key><array><dict><key>assets</key><array>");
			sb.append("<dict><key>kind</key><string>software-package</string><key>url</key><string>"
					+ iosBaseUrl
					+ this.getContextPath()
					+ "/wsServlet/DownloadVersionFileServlet?fileId="
					+ fileId
					+ "&type=22</string></dict>");
			sb.append("<dict><key>kind</key><string>full-size-image</string><key>needs-shine</key><true/><key>url</key><string>"
					+ iosBaseUrl
					+ "iosbaseupload/largeImage.jpg"
					+ "</string></dict>");
			sb.append("<dict><key>kind</key><string>display-image</string><key>needs-shine</key><true/><key>url</key><string>"
					+ iosBaseUrl
					+ "iosbaseupload/smallImage.jpg"
					+ "</string></dict>");
			sb.append("</array>");
			sb.append("<key>metadata</key>");
			sb.append("<dict><key>bundle-identifier</key><string>WSIOS.com.webside.www</string><key>bundle-version</key><string>"
					+ publishNo
					+ "</string><key>kind</key><string>software</string><key>subtitle</key><string>ios</string><key>title</key><string>News</string></dict>");
			sb.append("</dict></array></dict></plist>");
			output.write(sb.toString());
			output.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void execute() {
		if (METHOD_SAVE.equals(this.getMethodType())) {
			this.save();
		} else if ("newPublish".equals(this.getMethodType())) {
			this.newPublish();
		} else if ("editPublish".equals(this.getMethodType())) {
			this.editPublish();
		} else if ("publish".equals(this.getMethodType())) {
			this.publish();
		} else if ("abandon".equals(this.getMethodType())) {
			this.abandon();
		}
	}
}
