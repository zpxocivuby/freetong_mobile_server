/**
 * public.js 所有的页面都会引入
 */
// <![CDATA[
PUBLIC = {
	version : '1.0',
	description : 'ITAF Javascript Library'
};
PUBLIC.page = {};

PUBLIC.page.queryAjaxStart = function() {
	var queryBuffer = "正在查询，请稍后...";
	if (document.getElementById("common_queryBuffer")) {
		queryBuffer = document.getElementById("common_queryBuffer").value;
	}
	Ext.MessageBox.wait(queryBuffer);
};
PUBLIC.page.operateAjaxStart = function() {
	var operateBuffer = "正在执行，请稍后...";
	if (document.getElementById("common_operateBuffer")) {
		operateBuffer = document.getElementById("common_operateBuffer").value;
	}
	Ext.MessageBox.wait(operateBuffer);
};
// 关闭查询等待
PUBLIC.page.ajaxEnd = function() {
	if (Ext.MessageBox.wait()) {
		Ext.MessageBox.hide();
	}
};

PUBLIC.page.showActionMsg = function(actionMsg, closeWin) {
	if (actionMsg == null || actionMsg.trim().length <= 0 || "undefined" == actionMsg) {
		return false;
	}
	var operateSuccess = "操作成功";
	if (Ext.get("common_operateSuccess")) {
		alertNotice = Ext.get("common_operateSuccess").getValue();
	}
	var operateError = "操作发生错误";
	if (Ext.get("common_operateError")) {
		alertNotice = Ext.get("common_operateError").getValue();
	}
	if ("success" == actionMsg) {
		Ext.MessageBox.alert(PUBLIC.page.getAlertNotice(), operateSuccess,
				function() {
					if (closeWin) {
						top.popWindowBase.app.exitWindow();
					}
				});
		return true;
	} else if ("error" == actionMsg) {
		Ext.MessageBox.alert(PUBLIC.page.getAlertNotice(), operateError);
		return false;
	} else {
		Ext.MessageBox.alert(PUBLIC.page.getAlertNotice(), actionMsg);
		return false;
	}
};

PUBLIC.page.checkedAll = function(_sPublicCheckAll, _sPublicCheck) {
	var sPublicCheckAll = "." + (_sPublicCheckAll || "publicCheckAll");
	var sPublicCheck = "." + (_sPublicCheck || "publicCheck");
	var checkAllArray = Ext.query(sPublicCheckAll);
	var checkOnlyArray = Ext.query(sPublicCheck);
	if (checkAllArray[0].checked) {
		for (var i = 0; i < checkOnlyArray.length; i++) {
			checkOnlyArray[i].checked = true;
			if (checkOnlyArray[i].disabled) {
				checkOnlyArray[i].checked = false;
			}
		}
	} else {
		for (var i = 0; i < checkOnlyArray.length; i++) {
			checkOnlyArray[i].checked = false;
		}
	}
};

PUBLIC.page.checkedOnly = function(_sPublicCheckAll, _sPublicCheck) {
	var sPublicCheckAll = "." + (_sPublicCheckAll || "publicCheckAll");
	var sPublicCheck = "." + (_sPublicCheck || "publicCheck");
	var checkAllArray = Ext.query(sPublicCheckAll);
	var checkOnlyArray = Ext.query(sPublicCheck);
	var flag = 1;
	for (var i = 0; i < checkOnlyArray.length; i++) {
		if (!checkOnlyArray[i].checked) {
			checkAllArray[0].checked = false;
			flag++;
			break;
		}
	}

	if (flag == 1) {
		checkAllArray[0].checked = true;
	}
};

PUBLIC.page.getCheckedLang = function(_sPublicCheck) {
	var sPublicCheck = "." + (_sPublicCheck || "publicCheck");
	var checkOnlyArray = Ext.query(sPublicCheck);
	var result = "";
	for (var i = 0; i < checkOnlyArray.length; i++) {
		if (checkOnlyArray[i].checked) {
			if (checkOnlyArray[i].hasAttribute("lang")) {
				result += checkOnlyArray[i].getAttribute("lang") + ",";
			} else if (checkOnlyArray[i].hasAttribute("xml:lang")) {
				result += checkOnlyArray[i].getAttribute("xml:lang") + ",";
			}
		}
	}
	if (result.length > 0) {
		result = result.substring(0, result.length - 1);
	}
	return result;
};

PUBLIC.page.downLoadFile = function(objId) {
	var alertNotice = PUBLIC.page.getAlertNotice();
	var result = PUBLIC.page.getCheckedLang();
	if (result.length <= 0) {
		Ext.Msg.alert(alertNotice, document
				.getElementById("common_selectOneOrMore").value);
		return false;
	}
	if (document.getElementById(objId)) {
		document.getElementById(objId).value = result;
	} else {
		Ext.Msg.alert(alertNotice, document
				.getElementById("common_operateError").value);
		return false;
	}
	return true;
};

PUBLIC.page.getAlertNotice = function() {
	var alertNotice = "提示";
	if (Ext.get("common_alertNoticeId")) {
		alertNotice = Ext.get("common_alertNoticeId").getValue();
	}
	return alertNotice;
};

// 获取EmptyTemplate.xhtml中的session中的URL
PUBLIC.page.getBaseUrl = function() {
	var baseUrl = "/itaf-web-side";
	if (document.getElementById("common_baseUrlId")) {
		baseUrl = document.getElementById("common_baseUrlId").value;
	}
	return baseUrl;
};

PUBLIC.page.confirmDelete = function() {
	var confirmDeleteTitle = "确定要删除吗？";
	if (Ext.get("common_confirmDelete")) {
		confirmDeleteTitle = Ext.get("common_confirmDelete").getValue();
	}
	if (confirm(confirmDeleteTitle)) {
		return true;
	}
	return false;
};

// ]]>
