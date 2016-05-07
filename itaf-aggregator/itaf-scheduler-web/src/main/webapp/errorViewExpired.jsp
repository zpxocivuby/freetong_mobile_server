<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isErrorPage="true"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", -1);
	response.setDateHeader("max-age", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>error</title>
<link rel="stylesheet" href="../../css/error.css" type="text/css" />
</head>
<body  style="background:#2E8CBF url(../../images/error/header_bottom.jpg) repeat-x left top;">
	<div class="main1">
		<div class="main1_content1">
			<div class="m1_content_title">
				<div class="m1_content_tltle_r">
					<div class="m1_title_error_msg">
						<h3>错误信息</h3>
					</div>
					<div class="m1_title_icon">
						<span></span> 
						<span></span> 
						<span></span>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="m1_ct1_center">
				<div class="m1_btn1">
					<input type="button" onclick="javascript:history.go(-1);" class="m1_button1" value="返回上一步" />
				</div>
				<div class="m1_msg">
					<div class="m1_msg_left">
						<img src="../../images/error/icon3.gif" />
					</div>
					<div class="m1_msg_right">
						<p>
							错误代码: 408
							<br />
							错误详细: <b>抱歉，您请求的页面已经超时，请重新打开！</b>
						</p>	
					</div>
					<div class="clear"></div>
				</div>
				<div class="m1_msg2">
					<div class="m1_msg2_title">
						<h3>
							详细信息
						</h3>
					</div>
					<div class="m1_msg2_content"><b>抱歉，您请求的页面已经超时，请刷新后重新登录！</b></div>
				</div>
			</div>
			<div class="m1_ct1_bottom">
				<div class="m1_ct1_bottom_r"></div>
			</div>
		</div>
	</div>
</body>
</html>

