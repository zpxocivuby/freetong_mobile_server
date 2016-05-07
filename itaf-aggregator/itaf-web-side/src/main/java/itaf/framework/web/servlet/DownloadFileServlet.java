package itaf.framework.web.servlet;

import itaf.framework.business.common.service.IBzAttachmentService;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.common.BzAttachment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IBzAttachmentService attachmentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadFileServlet() {
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
			attachmentService = (IBzAttachmentService) SpringContextUtil
					.getBean("bzAttachmentServiceImpl");
		}
		BzAttachment attachment = attachmentService.getById(Long
				.valueOf(request.getParameter("fileId")));
		try {
			// 得到路径+文件名称
			String fileAbsolutePath = attachmentService.getAbsolutePath(
					attachment.getFileName(), attachment.getFileExt());
			File file = new File(fileAbsolutePath);
			if (!file.exists()) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>document.write('您下载的文件【"
						+ attachment.getFileName() + "】不存在，请核查！'); </script>");
				out.print("&nbsp;&nbsp;&nbsp;<input type='button' value='返回' onclick='history.back();'>");
				response.getWriter().close();
			}
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
