package itaf.framework.workflow.service.impl;

import org.apache.commons.lang3.StringUtils;

import itaf.framework.core.domain.BaseEntity;
import itaf.framework.domain.workflow.BzFormEntity;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年2月5日
 */
public abstract class BaseFormValidate {

	protected String validateMsg = "";

	public String validate(BaseEntity baseEntity) {
		BzFormEntity formEntity = (BzFormEntity) baseEntity;
		if (formEntity.getPageUrl() != null
				&& formEntity.getPageUrl().indexOf(".jsf") != -1) {
			setValidateMsg("pageUrl:不能为空!");
		}
		return validateMsg;
	}

	public String getValidateMsg() {
		return validateMsg;
	}

	public void setValidateMsg(String validateMsg) {
		if (StringUtils.isEmpty(this.validateMsg)) {
			this.validateMsg = validateMsg;
		} else {
			this.validateMsg = this.validateMsg + "<br/>" + validateMsg;
		}
	}

}
