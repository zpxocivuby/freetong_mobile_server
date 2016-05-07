package itaf.framework.web.servlet;

import itaf.framework.business.product.service.IBzProductAttachmentService;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.product.BzProductAttachment;
import itaf.framework.web.util.FileUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IBzProductAttachmentService attachmentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadProductServlet() {
		super();
	}

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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		if (attachmentService == null) {
			attachmentService = (IBzProductAttachmentService) SpringContextUtil
					.getBean("bzProductAttachmentServiceImpl");
		}
		BzProductAttachment attachment = attachmentService.getById(Long
				.valueOf(request.getParameter("fileId")));
		Long fileSize = Long.valueOf(request.getParameter("fileSize"));
		try {
			// 得到路径+文件名称
			String fileAbsolutePath = attachmentService.getAbsolutePath(
					attachment.getFileName(), attachment.getFileExt());

			String absolutePath = FileUtil.extractFilePath(fileAbsolutePath);

			String downloadFileName = "";
			if (0 == fileSize) {
				downloadFileName = attachment.getFileName() + "."
						+ attachment.getFileExt();
			} else if (32 == fileSize) {
				downloadFileName = attachment.getFileName() + "@32X32.jpg";
			} else if (64 == fileSize) {
				downloadFileName = attachment.getFileName() + "@64X64.jpg";
			} else if (96 == fileSize) {
				downloadFileName = attachment.getFileName() + "@96X96.jpg";
			}

			File file = new File(absolutePath + File.separator
					+ downloadFileName);
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			response.setHeader("Content-disposition", "attachment;filename="
					+ URLEncoder.encode(attachment.getSrcFileName(), "utf-8"));
			response.setContentLength((int) file.length());
			int bytesReader = 0;
			byte[] buffer = new byte[8192];
			while ((bytesReader = bis.read(buffer, 0, buffer.length)) != -1) {
				bos.write(buffer, 0, bytesReader);
			}
			bos.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (Exception ex) {

			}
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (Exception ex) {

			}
		}
	}
}
