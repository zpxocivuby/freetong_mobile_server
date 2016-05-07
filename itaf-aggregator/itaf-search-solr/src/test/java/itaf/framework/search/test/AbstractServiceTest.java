package itaf.framework.search.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/applicationContext-annotation.xml",
		"/applicationContext-transaction.xml",
		"/applicationContext-hibernate.xml", "/applicationContext-se.xml" })
public abstract class AbstractServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {

}
