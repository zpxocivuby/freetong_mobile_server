package itaf.framework.test.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * 基础测试类
 * 
 * @author XINXIN
 * 
 * @Date 2014年6月5日
 */
@ContextConfiguration(locations = { "/applicationContext-annotation.xml",
		"/applicationContext-transaction.xml",
		"/applicationContext-hibernate.xml",
		"/applicationContext-especial-bean.xml",
		"/applicationContext-config.xml" })
public abstract class AbstractServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {

}
