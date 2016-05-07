<%@page import="itaf.framework.exception.bean.BusinessException"%>
<%@page import="itaf.framework.exception.bean.AppException"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isErrorPage="true"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", -1);
	response.setDateHeader("max-age", 0);
%>
<%
	String errorMsg = "";
	if (exception instanceof BusinessException) {
		BusinessException be = (BusinessException) exception;
		errorMsg = be.getCode();
	} else if (exception instanceof AppException) {
		AppException se = (AppException) exception;
		errorMsg = se.getCode();
	}
	if (errorMsg != null && errorMsg != "") {
		errorMsg = "系统发生异常,无法执行相应操作.";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>error</title>
<link rel="stylesheet" href="../../css/error.css" type="text/css" />
<script type="text/javascript">
	function showErrorInfoDetail(obj) {
		if (document.getElementById("showDetailId")
				&& document.getElementById("errorMsgImgId")) {
			if ("hidden" == obj.lang) {
				document.getElementById("showDetailId").style.display = "block";
				document.getElementById("errorMsgImgId").src = "../../images/error/icon10.gif";
				obj.lang = "show";
			} else if ("show" == obj.lang) {
				document.getElementById("showDetailId").style.display = "none";
				document.getElementById("errorMsgImgId").src = "../../images/error/icon11.gif";
				obj.lang = "hidden";
			}
		}
	}
</script>
</head>
<body
	style="background: #2E8CBF url(../../images/error/header_bottom.jpg) repeat-x left top;">
	<div class="main1">
		<div class="main1_content1">
			<div class="m1_content_title">
				<div class="m1_content_tltle_r">
					<div class="m1_title_error_msg">
						<h3>错误信息</h3>
					</div>
					<div class="m1_title_icon">
						<span></span> <span></span> <span></span>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="m1_ct1_center">
				<div class="m1_btn1">
					<input type="button" onclick="javascript:history.go(-1);"
						class="m1_button1" value="返回上一步" />
				</div>
				<div class="m1_msg">
					<div class="m1_msg_left">
						<img src="../../images/error/icon3.gif" />
					</div>
					<div class="m1_msg_right">
						<p>
							错误信息: <b><%=errorMsg%></b>
						</p>
					</div>
					<div class="clear"></div>
				</div>
				<div class="m1_msg2">
					<div class="m1_msg2_title">
						<h3>
							<a href="#" onclick="showErrorInfoDetail(this);" lang="hidden">
								<img id="errorMsgImgId" src="../../images/error/icon11.gif" />详细信息
							</a>
						</h3>
					</div>
					<div id="showDetailId" class="m1_msg2_content"
						style="display: none;">
						<pre>
							<%
								exception.printStackTrace(new PrintWriter(out));
							%>
						</pre>
					</div>
				</div>
			</div>
			<div class="m1_ct1_bottom">
				<div class="m1_ct1_bottom_r"></div>
			</div>
		</div>
	</div>
</body>
</html>

