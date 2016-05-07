package itaf.framework.business.base.service;

import itaf.framework.business.platform.service.ISysCodeTypeService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.platform.SysCodeType;
import itaf.framework.test.base.AbstractServiceTest;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class SysCodeTypeServiceTest extends AbstractServiceTest {

	@Autowired
	private ISysCodeTypeService service;

	private Long codeTypeId = 10360L;

	@Test
	public void testFindById() {
//		SysCodeType result = service.findById(codeTypeId);
//		Assert.assertNotNull(result);
//		Assert.assertEquals("testCode", result.getCodeType());
	}

	@Test
	public void testFindByCriteria() {
//		QueryCriteria queryCriteria = new QueryCriteria();
//		PageResult<SysCodeType> result = null;
//		result = service.findByCriteria(queryCriteria);
//		Assert.assertEquals(10, result.getContent().size());
//
//		Map<String, Object> condition = queryCriteria.getQueryCondition();
//		condition.put("type", "testCode");
//		queryCriteria.setQueryCondition(condition);
//		result = service.findByCriteria(queryCriteria);
		// Assert.assertEquals("testCode",
		// result.getContent().get(0).getType());
	}

	@Test
	@Rollback(false)
	public void testDoCreate() {
		/*
		 * //添加 聘用类型 SysCodeType sysCodeType1 = new SysCodeType();
		 * sysCodeType1.setNameEn("Hire Type"); sysCodeType1.setNameZh("聘用类型");
		 * sysCodeType1.setType(CodeListConstant.CODE_HIRE_TYPE);
		 * service.doCreate(sysCodeType1); //添加 岗位类型 SysCodeType sysCodeType2 = new
		 * SysCodeType(); sysCodeType2.setNameEn("Post Type");
		 * sysCodeType2.setNameZh("岗位类型");
		 * sysCodeType2.setType(CodeListConstant.CODE_POST_TYPE);
		 * service.doCreate(sysCodeType2); //添加 在任状态 SysCodeType sysCodeType3 = new
		 * SysCodeType(); sysCodeType3.setNameEn("In any State");
		 * sysCodeType3.setNameZh("在任状态");
		 * sysCodeType3.setType(CodeListConstant.CODE_IN_ANY_STATE);
		 * service.doCreate(sysCodeType3); //添加 工作状态 SysCodeType sysCodeType4 = new
		 * SysCodeType(); sysCodeType4.setNameEn("Working State");
		 * sysCodeType4.setNameZh("工作状态");
		 * sysCodeType4.setType(CodeListConstant.CODE_WORKING_STATE);
		 * service.doCreate(sysCodeType4); //添加 性别 SysCodeType sysCodeType5 = new
		 * SysCodeType(); sysCodeType5.setNameEn("Sex");
		 * sysCodeType5.setNameZh("性别");
		 * sysCodeType5.setType(CodeListConstant.CODE_SEX);
		 * service.doCreate(sysCodeType5); //添加 职称等级 SysCodeType sysCodeType6 = new
		 * SysCodeType(); sysCodeType6.setNameEn("Professional Qualifications");
		 * sysCodeType6.setNameZh("职称等级");
		 * sysCodeType6.setType(CodeListConstant.CODE_PROFESSIONAL_QUALIFICATIONS
		 * ); service.doCreate(sysCodeType6); //添加 职称系列 SysCodeType sysCodeType7 =
		 * new SysCodeType(); sysCodeType7.setNameEn("Title Series");
		 * sysCodeType7.setNameZh("职称系列");
		 * sysCodeType7.setType(CodeListConstant.CODE_TITLE_SERIES);
		 * service.doCreate(sysCodeType7); //添加 婚姻状况 SysCodeType sysCodeType8 = new
		 * SysCodeType(); sysCodeType8.setNameEn("marital Status");
		 * sysCodeType8.setNameZh("婚姻状况");
		 * sysCodeType8.setType(CodeListConstant.CODE_MARITAL_STATUS);
		 * service.doCreate(sysCodeType8); //添加 行政级别 SysCodeType sysCodeType9 = new
		 * SysCodeType(); sysCodeType9.setNameEn("Administrator Level");
		 * sysCodeType9.setNameZh("行政级别");
		 * sysCodeType9.setType(CodeListConstant.CODE_ADMINISTRATOR_LEVEL);
		 * service.doCreate(sysCodeType9);
		 */
		// //添加 民族
		// SysCodeType sysCodeType10 = new SysCodeType();
		// sysCodeType10.setNameEn("Code Nationality");
		// sysCodeType10.setNameZh("民族");
		// sysCodeType10.setType(CodeListConstant.CODE_NATIONALITY);
		// service.doCreate(sysCodeType10);
		// //添加 政治面貌
		// SysCodeType sysCodeType11 = new SysCodeType();
		// sysCodeType11.setNameEn("Code Political_status");
		// sysCodeType11.setNameZh("政治面貌");
		// sysCodeType11.setType(CodeListConstant.CODE_POLITICAL_STATUS);
		// service.doCreate(sysCodeType11);
		// //添加 语种
		// SysCodeType sysCodeType12 = new SysCodeType();
		// sysCodeType12.setNameEn("Code Language_native");
		// sysCodeType12.setNameZh("语种");
		// sysCodeType12.setType(CodeListConstant.CODE_LANGUAGE_NATIVE);
		// service.doCreate(sysCodeType12);
		//
		/*
		 * SysCodeType sysCodeType13 = new SysCodeType();
		 * sysCodeType13.setNameEn("Code titleManageTaskStatus");
		 * sysCodeType13.setNameZh("职称评定任务状态");
		 * sysCodeType13.setType(CodeListConstant.CODE_TITLE_MANAGE_TASK_STATUS);
		 * service.doCreate(sysCodeType13);
		 */
		/*
		 * //获奖单位 SysCodeType sysCodeType14 = new SysCodeType();
		 * sysCodeType14.setNameEn("Award Unit"); sysCodeType14.setNameZh("获奖单位");
		 * sysCodeType14.setType(CodeListConstant.CODE_AWARD_UNIT);
		 * service.doCreate(sysCodeType14);
		 */
		// 获奖等级
		/*
		 * SysCodeType sysCodeType15 = new SysCodeType();
		 * sysCodeType15.setNameEn("Award Level");
		 * sysCodeType15.setNameZh("获奖等级");
		 * sysCodeType15.setType(CodeListConstant.CODE_AWARD_LEVEL);
		 * service.doCreate(sysCodeType15);
		 */
		/*
		 * SysCodeType sysCodeType16 = new SysCodeType();
		 * sysCodeType16.setNameEn("contractType");
		 * sysCodeType16.setNameZh("合同类型");
		 * sysCodeType16.setType(CodeListConstant.CODE_CONTRACT_TYPE);
		 * service.doCreate(sysCodeType16); SysCodeType sysCodeType17 = new
		 * SysCodeType(); sysCodeType17.setNameEn("laborRelationType");
		 * sysCodeType17.setNameZh("劳动关系类型");
		 * sysCodeType17.setType(CodeListConstant.CODE_LABOR_RELATION_TYPE);
		 * service.doCreate(sysCodeType17);
		 */
		/*
		 * SysCodeType sysCodeType18 = new SysCodeType();
		 * sysCodeType18.setNameEn("renew"); sysCodeType18.setNameZh("续签情况");
		 * sysCodeType18.setType(CodeListConstant.CODE_RENEW_TYPE);
		 * service.doCreate(sysCodeType18); SysCodeType sysCodeType19 = new
		 * SysCodeType(); sysCodeType19.setNameEn("staffRelationship");
		 * sysCodeType19.setNameZh("与职员关系");
		 * sysCodeType19.setType(CodeListConstant.CODE_STAFF_RELATIONSHIP);
		 * service.doCreate(sysCodeType19); SysCodeType sysCodeType20 = new
		 * SysCodeType(); sysCodeType20.setNameEn("commonCodeIsORNot");
		 * sysCodeType20.setNameZh("公用是否类型");
		 * sysCodeType20.setType(CodeListConstant.CODE_COMMON_YESORNOT);
		 * service.doCreate(sysCodeType20);
		 */
		/*
		 * SysCodeType sysCodeType21 = new SysCodeType();
		 * sysCodeType21.setNameEn("staffCertType");
		 * sysCodeType21.setNameZh("人员证件类型");
		 * sysCodeType21.setType(CodeListConstant.CODE_STAFF_CERT_TYPE);
		 * service.doCreate(sysCodeType21); SysCodeType sysCodeType22 = new
		 * SysCodeType(); sysCodeType22.setNameEn("staffCertState");
		 * sysCodeType22.setNameZh("人员证件状态");
		 * sysCodeType22.setType(CodeListConstant.CODE_STAFF_CERT_STATE);
		 * service.doCreate(sysCodeType22); SysCodeType sysCodeType23 = new
		 * SysCodeType(); sysCodeType23.setNameEn("entryTimeCode");
		 * sysCodeType23.setNameZh("入境时间段");
		 * sysCodeType23.setType(CodeListConstant.CODE_ENTRY_TIME);
		 * service.doCreate(sysCodeType23);
		 * 
		 * SysCodeType sysCodeType24 = new SysCodeType();
		 * sysCodeType24.setNameEn("exitTimeCode");
		 * sysCodeType24.setNameZh("出境时间段");
		 * sysCodeType24.setType(CodeListConstant.CODE_EXIT_TIME);
		 * service.doCreate(sysCodeType24);
		 * 
		 * SysCodeType sysCodeType25 = new SysCodeType();
		 * sysCodeType25.setNameEn("returnTypeCode");
		 * sysCodeType25.setNameZh("归国类型");
		 * sysCodeType25.setType(CodeListConstant.CODE_RETURN_TYPE);
		 * service.doCreate(sysCodeType25);
		 */

		/*
		 * SysCodeType sysCodeType27 = new SysCodeType();
		 * sysCodeType27.setNameEn("remindType"); sysCodeType27.setNameZh("提醒类型");
		 * sysCodeType27.setType(CodeListConstant.REMIND_TYPE);
		 * service.doCreate(sysCodeType27);
		 * 
		 * SysCodeType sysCodeType28 = new SysCodeType();
		 * sysCodeType28.setNameEn("remindState");
		 * sysCodeType28.setNameZh("提醒状态");
		 * sysCodeType28.setType(CodeListConstant.REMIND_STATE);
		 * service.doCreate(sysCodeType28);
		 * 
		 * SysCodeType sysCodeType29 = new SysCodeType();
		 * sysCodeType29.setNameEn("remindHaveSecondaryTask");
		 * sysCodeType29.setNameZh("有辅助任务的");
		 * sysCodeType29.setType(CodeListConstant.REMIND_HAVE_SECONDARY_TASK);
		 * service.doCreate(sysCodeType29);
		 * 
		 * SysCodeType sysCodeType30 = new SysCodeType();
		 * sysCodeType30.setNameEn("remindTime"); sysCodeType30.setNameZh("提醒时间");
		 * sysCodeType30.setType(CodeListConstant.REMIND_TIME);
		 * service.doCreate(sysCodeType30); SysCodeType sysCodeType31 = new
		 * SysCodeType(); sysCodeType31.setNameEn("overSeeTaskStatusCode");
		 * sysCodeType31.setNameZh("督办任务状态");
		 * sysCodeType31.setType(CodeListConstant.CODE_OVERSEE_TASK_STATUS);
		 * service.doCreate(sysCodeType31);
		 * 
		 * SysCodeType sysCodeType32 = new SysCodeType();
		 * sysCodeType32.setNameEn("overSeeTaskTypeCode");
		 * sysCodeType32.setNameZh("督办任务类型");
		 * sysCodeType32.setType(CodeListConstant.CODE_OVERSEE_TASK_TYPE);
		 * service.doCreate(sysCodeType32);
		 * 
		 * SysCodeType sysCodeType32 = new SysCodeType();
		 * sysCodeType32.setNameEn("taskExportType");
		 * sysCodeType32.setNameZh("导出任务类型");
		 * sysCodeType32.setType(CodeListConstant.CODE_TASK_EXPORT_TYPE);
		 * service.doCreate(sysCodeType32);
		 */

		/*
		 * SysCodeType sysCodeType32 = new SysCodeType();
		 * sysCodeType32.setNameEn("overseasWorkstate");
		 * sysCodeType32.setNameZh("特约报道员工作状态");
		 * sysCodeType32.setType(CodeListConstant.OVERSEAS_WORKSTATE);
		 * service.doCreate(sysCodeType32);
		 * 
		 * 
		 * SysCodeType sysCodeType33 = new SysCodeType();
		 * sysCodeType33.setNameEn("overseasPosition");
		 * sysCodeType33.setNameZh("特约报道员职位");
		 * sysCodeType33.setType(CodeListConstant.OVERSEAS_POSITION);
		 * service.doCreate(sysCodeType33);
		 */

		/*
		 * SysCodeType sysCodeType27 = new SysCodeType();
		 * sysCodeType27.setNameEn("overseasPaymentType");
		 * sysCodeType27.setNameZh("对象类型");
		 * sysCodeType27.setType(CodeListConstant.OVERSEAS_PAYMENT_TYPE);
		 * service.doCreate(sysCodeType27);
		 * 
		 * SysCodeType sysCodeType28 = new SysCodeType();
		 * sysCodeType28.setNameEn("overseasPaymentState");
		 * sysCodeType28.setNameZh("状态");
		 * sysCodeType28.setType(CodeListConstant.OVERSEAS_PAYMENT_STATE);
		 * service.doCreate(sysCodeType28);
		 * 
		 * SysCodeType sysCodeType29 = new SysCodeType();
		 * sysCodeType29.setNameEn("overseasPaymentCurrency");
		 * sysCodeType29.setNameZh("支付货币");
		 * sysCodeType29.setType(CodeListConstant.OVERSEAS_PAYMENT_CURRENCY);
		 * service.doCreate(sysCodeType29);
		 */
		// SysCodeType sysCodeType28 = new SysCodeType();
		// sysCodeType28.setNameEn("overseasPaymentModeCode");
		// sysCodeType28.setNameZh("薪酬模式编码");
		// sysCodeType28.setType(CodeListConstant.OVERSEAS_PAYMENT_MODE_CODE);
		// service.doCreate(sysCodeType28);
		
		

	}

}
