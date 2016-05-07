package itaf.framework.web.servlet;

import itaf.framework.business.product.service.IBzProductAttachmentService;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.product.BzProductAttachment;
import itaf.framework.web.util.FileUtil;
import itaf.framework.web.util.ImageCut;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IBzProductAttachmentService attachmentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadProductServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (attachmentService == null) {
			attachmentService = (IBzProductAttachmentService) SpringContextUtil
					.getBean("bzProductAttachmentServiceImpl");
		}
		// 创建一个磁盘文件的工厂，然后将它 传递到servletFileUplaod的实例中
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(
				diskFileItemFactory);
		// 根据request对象获取所有的文件集合，这里包括input标签输入的值也属于FileInput
		try {
			List<FileItem> fileItemList = servletFileUpload
					.parseRequest(request);
			Long fileType = 1L;
			for (FileItem fileItem : fileItemList) {
				// 文件名
				String srcFileName = fileItem.getName();
				// 得到扩展名
				String fileExt = srcFileName.substring(
						srcFileName.lastIndexOf(".") + 1).toLowerCase();
				String fileName = attachmentService.generateUniqueFileName(
						fileType, fileExt);
				// 得到路径+文件名称
				String fileAbsolutePath = attachmentService.getAbsolutePath(
						fileName, fileExt);
				// 写入文件
				fileItem.write(new File(fileAbsolutePath)); // 将文件写入磁盘中

				String absolutePath = FileUtil
						.extractFilePath(fileAbsolutePath);
				ImageCut.scale(fileAbsolutePath, absolutePath + File.separator
						+ fileName + "@64X64.jpg", 64, 64);
				ImageCut.scale(fileAbsolutePath, absolutePath + File.separator
						+ fileName + "@96X96.jpg", 96, 96);

				BzProductAttachment attachment = new BzProductAttachment();
				attachment.setSrcFileName(srcFileName);
				attachment.setFileName(fileName);
				attachment.setFileType(fileType);
				attachment.setFileExt(fileExt);
				attachment.setMarkForDelete(true);
				attachmentService.doSaveOrUpdate(attachment);

				PrintWriter out = response.getWriter();
				out.print(attachment.getId());
				out.close();
			}
		} catch (FileUploadException ex) {
			response.setStatus(-200);
			ex.printStackTrace();
		} catch (Exception ex) {
			response.setStatus(-200);
			ex.printStackTrace();
		}
	}

}
