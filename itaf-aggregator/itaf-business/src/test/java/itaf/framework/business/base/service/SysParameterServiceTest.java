package itaf.framework.business.base.service;

import itaf.framework.business.platform.service.ISysParameterService;
import itaf.framework.test.base.AbstractServiceTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * 系统参数测试类
 * 
 * @author XINXIN
 * 
 */
public class SysParameterServiceTest extends AbstractServiceTest {

	@Autowired
	private ISysParameterService service;

	private Long paramId = 121L;

	@Test
	@Rollback(false)
	public void testDoCreate() {
		// SysParameter tsParameter = new SysParameter();
		// tsParameter.setValue("40000");
		// tsParameter = service.doCreate(tsParameter);
		// Assert.assertNotNull(tsParameter.getId());
	}

	@Test
	public void testDoDelete() {
		// boolean flag = true;
		// try {
		// service.doDelete(service.findById(paramId));
		// } catch (Exception e) {
		// e.printStackTrace();
		// flag = false;
		// }
		// Assert.assertTrue(flag);
	}

	@Test
	public void testFindByCriteria() {
		// QueryCriteria queryCriteria = new QueryCriteria();
		// PageResult<SysParameter> result = null;
		// result = service.findByCriteria(queryCriteria);
		// Assert.assertEquals(5, result.getContent().size());
		// Map<String, Object> condition = queryCriteria.getQueryCondition();
		// condition.put("nameEn","Test");
		// queryCriteria.setQueryCondition(condition);
		// result = service.findByCriteria(queryCriteria);
		// Assert.assertEquals(1, result.getContent().size());
	}

	@Test
	public void testFindByName() {
		// SysParameter tsParameter = null;
		// tsParameter =
		// service.findByType(Constants.PARAM_USER_CUSTOM_PLATE_COUNT);
		// Assert.assertNotNull(tsParameter);
		// tsParameter = service.findByType("用户自定义板块数量");
		// Assert.assertNotNull(tsParameter);
		// tsParameter = service.findByType("名字不会有这个");
		// Assert.assertNull(tsParameter);
		// tsParameter = service.findByType("");
		// Assert.assertNull(tsParameter);
		// tsParameter = service.findByType(null);
		// Assert.assertNull(tsParameter);
	}

}
