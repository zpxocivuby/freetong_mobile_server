package itaf.framework.core.constant;

public class CodeListConstant {

	/** A key for the map contains code data array. */
	public static final String MAP_KEY_CODES = "MAP_KEY_CODES";

	/** A key for the map contains description data array. */
	public static final String MAP_KEY_DESCRIPTIONS = "MAP_KEY_DESCRIPTIONS";

	/** A key for the map contains label data array. */
	public static final String MAP_KEY_LABELS = "MAP_KEY_LABELS";

	/** RESTYPE作为识别资源分类的编码类型 */
	public static final String RESTYPE = "RESTYPE";

	/** 资源类型间层级关系以此分隔符分隔 */
	public static final String RESTYPE_LEVEL_SEPARATOR = "_";

	/**
	 * 资源类型中"分类"的识别字符窜， 凡是以此结尾的资源类型均属于分类层， 通常分类可以上下嵌套，形成树型资源类型数据。
	 */
	public static final String RESTYPE_CATEGORY = "category";

	/**
	 * 资源类型中具体条目类型，通常处于分类层级的下一级
	 */
	public static final String RESTYPE_ITEM = "item";

	/**
	 * 资源类型中的动作类型，通常处于具体条目层级的下一级
	 */
	public static final String RESTYPE_ACTION = "action";

	/** Application 作为资源类型的根 */
	public static final String RESTYPE_APPLICATION = "application";

	/** OOMS资源类型 */
	public static final String ITAF_MENU = "itaf";
	public static final String ITAF_MENU_CATEGORY = ITAF_MENU
			+ RESTYPE_LEVEL_SEPARATOR + RESTYPE_CATEGORY;
	public static final String ITAF_MENU_ITEM = ITAF_MENU_CATEGORY
			+ RESTYPE_LEVEL_SEPARATOR + RESTYPE_ITEM;
	/** 功能按钮 */
	public static final String ITAF_MENU_ACTION = ITAF_MENU_ITEM
			+ RESTYPE_LEVEL_SEPARATOR + RESTYPE_ACTION;

	/** (聘用类型) */
	public static final String CODE_HIRE_TYPE = "hireTypeCode";
	/** (岗位类型) */
	public static final String CODE_POST_TYPE = "postTypeCode";
	/** (在任状态) */
	public static final String CODE_IN_ANY_STATE = "inAnyStateCode";
	/** (工作状态) */
	public static final String CODE_WORKING_STATE = "workingStateCode";
	/** (性别) */
	public static final String CODE_SEX = "sexCode";
	/** (职称等级) */
	public static final String CODE_PROFESSIONAL_QUALIFICATIONS = "professionalQualificationsCode";
	/** (职称系列) */
	public static final String CODE_TITLE_SERIES = "titleSeriesCode";
	/** (婚姻状况) */
	public static final String CODE_MARITAL_STATUS = "maritalStatusCode";
	/** (行政级别) */
	public static final String CODE_ADMINISTRATOR_LEVEL = "administratorLevelCode";
	/** (民族) */
	public static final String CODE_NATIONALITY = "nationalityCode";
	/** (政治面貌) */
	public static final String CODE_POLITICAL_STATUS = "politicalStatusCode";
	/** (语种) */
	public static final String CODE_LANGUAGE_NATIVE = "languageNativeCode";

	/** (职称管理 任务状态) */
	public static final String CODE_TITLE_MANAGE_TASK_STATUS = "titleManageTaskStatusCode";
	/** (获奖单位) */
	public static final String CODE_AWARD_UNIT = "awardUnitCode";
	/** (获奖等级) */
	public static final String CODE_AWARD_LEVEL = "awardLevelCode";
	/** (评定结果) */
	public static final String CODE_EVALUATE_RESULT = "evaluateResultCode";
	/** (督办任务 任务状态) */
	public static final String CODE_OVERSEE_TASK_STATUS = "overSeeTaskStatusCode";
	/** (督办任务 任务类型) */
	public static final String CODE_OVERSEE_TASK_TYPE = "overSeeTaskTypeCode";

	/** (阅读状态) */
	public static final String MES_READSTATE = "readState";
	/** (人员合同类型) */
	public static final String CODE_STAFF_CONTRACT_TYPE = "staffContractTypeCode";
	/** (劳动关系类型) */
	public static final String CODE_LABOR_RELATION_TYPE = "laborRelationTypeCode";
	/** (续签情况) */
	public static final String CODE_RENEW_TYPE = "renewTypeCode";

	/** (合同类型) */
	public static final String CODE_CONTRACT_TYPE = "contractTypeCode";
	/** (合同状态) */
	public static final String CODE_CONTRACT_STATE = "contractStateCode";
	/** (合同金额) */
	public static final String CODE_CONTRACT_AMOUNT = "contractAmountCode";
	/** (合同付款类型) */
	public static final String CODE_CONTRACT_PAYTYPE = "contractPaytypeCode";
	/** (合同付款币种) */
	public static final String CODE_CONTRACT_PAY_CURRENCY = "contractPayCurrencyCode";
	/** (合同付款操作类型) */
	public static final String CODE_CONTRACT_PAY_OPERATE_TYPE = "contractPayOperateTypeCode";

	/** (提醒类型) */
	public static final String CODE_CONTRACT_REMIND_TYPE = "contractRemindTypeCode";
	/** (与职员关系) */
	public static final String CODE_STAFF_RELATIONSHIP = "staffRelationshipCode";
	/** (公用 是 否) */
	public static final String CODE_COMMON_YESORNOT = "commonYesOrNotCode";
	/** (人员证件类型) */
	public static final String CODE_STAFF_CERT_TYPE = "staffCertTypeCode";
	/** (人员证件状态) */
	public static final String CODE_STAFF_CERT_STATE = "staffCertStateCode";

	public static final String REMIND_TYPE = "remindType";

	public static final String REMIND_STATE = "remindState";

	public static final String REMIND_HAVE_SECONDARY_TASK = "remindHaveSecondaryTask";

	public static final String REMIND_TIME = "remindTime";

	/** (入境时间段) */
	public static final String CODE_ENTRY_TIME = "entryTimeCode";
	/** (出境时间段) */
	public static final String CODE_EXIT_TIME = "exitTimeCode";
	/** (归国类型) */
	public static final String CODE_RETURN_TYPE = "returnTypeCode";

	/** 导出任务类型 */
	public static final String CODE_TASK_EXPORT_TYPE = "taskExportType";

	/** 导出任务类型 */
	public static final String CODE_TASK_EXPORT_STATE = "taskExportState";

	/** 导入任务类型 */
	public static final String CODE_TASK_IMPORT_TYPE = "taskImportType";

	/** 导入任务类型 */
	public static final String CODE_TASK_IMPORT_STATE = "taskImportState";

	/** 服务类型 */
	public static final String SERVICETYPE = "SERVICETYPE";
	/** 付款类型 */
	public static final String PAYTYPE = "PAYTYPE";
	/** 部署区域 */
	public static final String DEPLOYREGION = "DEPLOYREGION";

	/** 币种 */
	public static final String PAYSTATEMENTPAYCURRENCY = "PAYSTATEMENTPAYCURRENCY";
	/** 处理状态 */
	public static final String PAYSTATEMENTSTATE = "PAYSTATEMENTSTATE";

	/** 对象类型 */
	public static final String OSPAYSTATEMENTTYPE = "OSPAYSTATEMENTTYPE";
	/** 工作状态 */
	public static final String OVERSEAS_WORKSTATE = "overseasWorkstate";
	/** 职位 */
	public static final String OVERSEAS_POSITION = "overseasPosition";

	/** 工资确认状态 */
	public static final String SALARYSTATE = "SALARYSTATE";

	/** 报销审批状态 */
	public static final String EXPENSESTATE = "EXPENSESTATE";

	/** 对象类型 */
	public static final String OVERSEAS_PAYMENT_TYPE = "overseasPaymentType";
	/** 状态 */
	public static final String OVERSEAS_PAYMENT_STATE = "overseasPaymentState";
	/** 支付货币 */
	public static final String OVERSEAS_PAYMENT_CURRENCY = "overseasPaymentCurrency";

	/** WORKFLOW */
	public static final String OTR_YES_NO = "otrYesNo";
	public static final String OTR_RETURNCOUNTRYTYPE = "otrReturnCountryType";
	public static final String OTR_APPROVALSTATE = "otrApprovalState";
	public static final String OTR_AGREE = "otrAgree";
	public static final String PROCESSDEFINITION = "processDefinition";

	/** MYCOLLECTION */
	public static final String COLLECTION_TYPE = "collectionType";

	/** 薪酬模式编码 */
	public static final String OVERSEAS_PAYMENT_MODE_CODE = "overseasPaymentModeCode";

	/** im */
	public static final String IM_PERSONALSIGN = "IM_PERSONALSIGN";

	public static final String IM_NAMEZH = "IM_NAMEZH";

	public static final String IM_NAMEEN = "IM_NAMEEN";
	
	public static final String SYS_USER_TYPE = "sysUserType";
	
	/**用戶分類*/
	public static final String SIDE_SYS_USER_TYPE = "sideSysUserType";
	
	public static final String SIDE_SYS_USER_SEX = "sideSysUserSex";
	
	public static final String SIDE_SYS_USER_IDTYPE = "sideSysUserIdType";
}
