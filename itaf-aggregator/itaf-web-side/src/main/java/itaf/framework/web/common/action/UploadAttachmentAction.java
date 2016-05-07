package itaf.framework.web.common.action;

import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.core.common.PageResult;
import itaf.framework.domain.platform.SysAttachment;
import itaf.framework.web.base.action.BaseDataGridAction;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.model.UploadedFile;

/**
 * 附件信息
 * 
 * @author XINXIN
 * 
 */
@ManagedBean(name = "uploadAttachmentAction")
@ViewScoped
public class UploadAttachmentAction extends BaseDataGridAction<SysAttachment>  {

	private UploadedFile atachmentFile;

	public UploadedFile getAtachmentFile() {
		return atachmentFile;
	}

	public void setAtachmentFile(UploadedFile atachmentFile) {
		this.atachmentFile = atachmentFile;
	}

	private static final long serialVersionUID = 1718646817124003820L;

	private static final Log log = LogFactory
			.getLog(UploadAttachmentAction.class);

	@ManagedProperty(value = "#{sysAttachmentServiceImpl}")
	private ISysAttachmentService attachmentService;

	public String uploadedfile() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			// 在控制台输出上传文件的文件名，和文件大小
			FacesMessage message = new FacesMessage(
					"Successfully uploaded file" + atachmentFile.getName()
							+ "(" + atachmentFile.getSize() + "bytes)");
			context.addMessage(null, message);

			InputStream stream;
			stream = new BufferedInputStream(atachmentFile.getInputStream());
			byte[] bytes = new byte[1024 * 1024];// 设定文件大小
			@SuppressWarnings("unused")
			int count;
			count = stream.read(bytes);
			stream.close();// 关闭流
			context.getResponseWriter().write("ddddddd");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected PageResult getPageContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	

}
