/**
 * public.js 所有的页面都会引入
 */
// <![CDATA[
Workflow = {
	version : '1.0',
	description : 'ITAF Javascript Library'
};

Workflow.page = {};
var baseUrl = PUBLIC.page.getBaseUrl();
Workflow.page.viewWorkflowPicture = function(processInstanceId) {
	var strLink = baseUrl
			+ "/pages/workflow/view_workflow_picture.xhtml?processInstanceId="
			+ processInstanceId;
	var popTitle = "查看流程图";
	top.popWindowBase.app.popWindow2(strLink, null, popTitle, 900, 230, true);
};

Workflow.page.showForm = function(url, weight, height) {
	var strLink = baseUrl + url;
	var popTitle = "";
	var refreshObj = document.getElementById("qlQueryFormId:queryDataBtnId");
	if (url.indexOf("&processInstanceId") != -1) {
		popTitle = "表单信息";
		refreshObj = null;
	}
	top.popWindowBase.app.popWindow2(strLink, refreshObj, popTitle, weight, height,
			true);
};
