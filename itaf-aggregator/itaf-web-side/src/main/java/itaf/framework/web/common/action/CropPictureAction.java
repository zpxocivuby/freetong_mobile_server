package itaf.framework.web.common.action;

import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.platform.SysAttachment;
import itaf.framework.web.base.action.BaseAction;
import itaf.framework.web.util.ImageCut;
import itaf.framework.web.util.ProcessQueryUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * 剪切图片
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月18日
 */
@ManagedBean(name = "cropPictureAction")
@ViewScoped
public class CropPictureAction extends BaseAction {

	private static final long serialVersionUID = 4069016133027194031L;

	@ManagedProperty(value = "#{bsAttachmentServiceImpl}")
	private ISysAttachmentService bsAttachmentService;

	private Long attachId;

	private String attachName;

	// js回调的方法名字
	private String jsCallback;

	public String getImagePath() {
		if (getAttachId() == null || getAttachId() == 0) {
			return "";
		}
		return bsAttachmentService.getPathById(Long.valueOf(attachId));
	}

	public String saveCropPic() {
		try {
			Integer x = Integer.parseInt(ProcessQueryUtil.getValueOfForm("x"));
			Integer y = Integer.parseInt(ProcessQueryUtil.getValueOfForm("y"));
			Integer w = Integer.parseInt(ProcessQueryUtil.getValueOfForm("w"));
			Integer h = Integer.parseInt(ProcessQueryUtil.getValueOfForm("h"));
			SysAttachment bsAttachment = bsAttachmentService
					.findById(getAttachId());
			String oldFilePath = bsAttachmentService.getAbsolutePath(
					bsAttachment.getFileName(), bsAttachment.getFileExt());
			ImageCut.abscutscale(oldFilePath, oldFilePath, x, y, w, h, 100, 100);
			bsAttachmentService.doMarkForValid(getAttachId());
			this.setAttachName(bsAttachment.getSrcFileName() + "."
					+ bsAttachment.getFileExt());
			this.setActionMsg(ACTION_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			this.setActionMsg(ACTION_ERROR);
		}
		return null;
	}

	public Long getAttachId() {
		String attachIdStr = ProcessQueryUtil.getValueOfForm("attachId");
		if (StringHelper.isNotEmpty(attachIdStr)) {
			attachId = Long.valueOf(attachIdStr);
		}
		return attachId;
	}

	public void setAttachId(Long attachId) {
		this.attachId = attachId;
	}

	public String getJsCallback() {
		jsCallback = ProcessQueryUtil.getValueOfForm("jsCallback");
		return jsCallback;
	}

	public void setJsCallback(String jsCallback) {
		this.jsCallback = jsCallback;
	}

	public ISysAttachmentService getSysAttachmentService() {
		return bsAttachmentService;
	}

	public void setSysAttachmentService(ISysAttachmentService bsAttachmentService) {
		this.bsAttachmentService = bsAttachmentService;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

}
