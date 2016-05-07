package itaf.framework.business.base.service;

import itaf.framework.business.platform.service.ISysCodeListService;
import itaf.framework.business.platform.service.ISysCodeTypeService;
import itaf.framework.core.constant.CodeListConstant;
import itaf.framework.domain.platform.SysCodeList;
import itaf.framework.domain.platform.SysCodeType;
import itaf.framework.test.base.AbstractServiceTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * 
 * @author XINXIN 1，测试UserDemoTestServiceImpl的增删改查 2，添加测试数据
 */
public class SysCodeListServiceTest extends AbstractServiceTest {

	@Autowired
	private ISysCodeListService service;

	@Autowired
	private ISysCodeTypeService codeTypeService;

	private Long codeTypeId = 10360L;
	private Long codeListId = 11373L;

	@Test
	public void testDoDelete() {
//		boolean flag = true;
//		try {
//			service.doDelete(service.getById(codeListId));
//		} catch (Exception e) {
//			e.printStackTrace();
//			flag = false;
//		}
//		Assert.assertTrue(flag);
//		try {
//			service.doDelete(service.getById(0L));
//		} catch (Exception e) {
//			e.printStackTrace();
//			flag = false;
//		}
//		Assert.assertFalse(flag);
	}

	@Test
	public void testFindById() {
//		SysCodeList result = service.getById(codeListId);
//		Assert.assertNotNull(result);
//		Assert.assertEquals("test", result.getNameEn());
	}

	@Test
	public void testFindByType() {
		// List<SysCodeList> tcCodeLists = service
		// .findByType(CodeListConstant.CODE_ORDER_CONDITION);
		// Assert.assertEquals(2, tcCodeLists.size());
	}

	@Test
	public void testFindByCodeValue() {
		// SysCodeList result =
		// service.findByCodeValue(CodeListConstant.CODE_ORDER_CONDITION,
		// "asc");
		// Assert.assertEquals("正序", result.getNameZh());
	}

	@Test
	public void testFindByName() {
		// SysCodeList result =
		// service.findByName(CodeListConstant.CODE_ORDER_CONDITION, "正序");
		// Assert.assertEquals("asc", result.getCodeValue());
	}

	@Test
	public void testFindByCriteria() {
		// QueryCriteria queryCriteria = new QueryCriteria();
		// Map<String, Object> condition = queryCriteria.getQueryCondition();
		// condition.put("codeTypeId", codeTypeId);
		// queryCriteria.setOrderField("sortNo");
		// queryCriteria.setOrderDirection("asc");
		// queryCriteria.setQueryCondition(condition);
		// PageResult<SysCodeList> result = null;
		// result = service.findByCriteria(queryCriteria);
		// Assert.assertEquals(3, result.getContent().size());
		// condition.put("nameZh", "test");
		// result = service.findByCriteria(queryCriteria);
		// Assert.assertEquals(1, result.getContent().size());
	}

	@Test
	@Rollback(false)
	public void testDoCreate() {

		SysCodeType sysCodeType14 = new SysCodeType();
		sysCodeType14.setNameEn("processDefinition");
		sysCodeType14.setNameZh("工作流表单类型");
		sysCodeType14.setCodeType(CodeListConstant.PROCESSDEFINITION);
		codeTypeService.doCreate(sysCodeType14);
		
		SysCodeList tcCodeList141 = new SysCodeList();
		tcCodeList141.setCodeValue("realname");// 分钟
		tcCodeList141.setNameEn("realname");
		tcCodeList141.setNameZh("实名认证");
		tcCodeList141.setSortNo(1l);
		tcCodeList141.setSysCodeTypeId(sysCodeType14.getId());
		service.doCreate(tcCodeList141);
		
		SysCodeList tcCodeList142 = new SysCodeList();
		tcCodeList142.setCodeValue("consumer");
		tcCodeList142.setNameEn("consumer");
		tcCodeList142.setNameZh("商家");
		tcCodeList142.setSortNo(2l);
		tcCodeList142.setSysCodeTypeId(sysCodeType14.getId());
		service.doCreate(tcCodeList142);
		
		SysCodeList tcCodeList143 = new SysCodeList();
		tcCodeList143.setCodeValue("merchant");
		tcCodeList143.setNameEn("merchant");
		tcCodeList143.setNameZh("配送商");
		tcCodeList143.setSortNo(3l);
		tcCodeList143.setSysCodeTypeId(sysCodeType14.getId());
		service.doCreate(tcCodeList143);
		
		/*SysCodeList tcCodeList144 = new SysCodeList();
		tcCodeList144.setCodeValue("30");
		tcCodeList144.setNameEn("typeDist" );
		tcCodeList144.setNameZh("配送商");
		tcCodeList144.setSortNo(4l);
		tcCodeList144.setSysCodeTypeId(sysCodeType14.getId());
		service.doCreate(tcCodeList144);
		
		SysCodeList tcCodeList145 = new SysCodeList();
		tcCodeList145.setCodeValue("2030");
		tcCodeList145.setNameEn("typeMerchantDist" );
		tcCodeList145.setNameZh("商户配送商");
		tcCodeList145.setSortNo(5l);
		tcCodeList145.setSysCodeTypeId(sysCodeType14.getId());
		service.doCreate(tcCodeList145);*/

	}

}
