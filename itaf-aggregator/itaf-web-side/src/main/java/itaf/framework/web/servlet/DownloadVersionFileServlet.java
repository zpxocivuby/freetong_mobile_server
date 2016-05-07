package itaf.framework.web.servlet;

import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.platform.SysAttachment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadVersionFileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ISysAttachmentService attachmentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadVersionFileServlet() {
		super();
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
			attachmentService = (ISysAttachmentService) SpringContextUtil
					.getBean("sysAttachmentServiceImpl");
		}
		SysAttachment attachment = attachmentService.getById(Long
				.valueOf(request.getParameter("fileId")));
		Long type = Long.valueOf(request.getParameter("type"));
		try {
			// 得到路径+文件名称
			String fileAbsolutePath = attachmentService.getAbsolutePath(
					attachment.getFileName(), attachment.getFileExt());
			if (21 == type || 23 == type) {
				fileAbsolutePath = fileAbsolutePath.substring(0,
						fileAbsolutePath.lastIndexOf("/") + 1) + "ios.plist";
			}
			File file = new File(fileAbsolutePath);
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			if (11 == type) {
				response.setContentType("application/vnd.android.package-archive");
			}
			if (21 == type || 23 == type) {
				response.setHeader("Content-disposition",
						"attachment;filename=ios.plist");
			} else {
				response.setHeader(
						"Content-disposition",
						"attachment;filename="
								+ URLEncoder.encode(attachment.getSrcFileName()
										+ "." + attachment.getFileExt(),
										"utf-8"));
			}
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
