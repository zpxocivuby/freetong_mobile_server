package itaf.framework.business.base.service;

import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.test.base.AbstractServiceTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class AttachmentServiceTest extends AbstractServiceTest {

	@Autowired
	private ISysAttachmentService attachmentService;

	@Test
	public void testGetFileName() {
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// int c = 0;
		// for (int i = 0; i < 20; i++) {
		// String actual = attachmentService.generateUniqueFileName(1L, "rm");
		// if (map.get(actual) == null) {
		// map.put(actual, 1);
		// } else {
		// System.out.println(++c + ": " + actual);
		// }
		// }
		// Assert.assertTrue(actual.length() == 25);
		// Assert.assertTrue(actual.startsWith("video"));
		// int mathNumber = Integer
		// .parseInt(actual.substring(actual.length() - 4));
		// Assert.assertTrue(1000 <= mathNumber && mathNumber <= 9999);
	}

	@Test
	@Rollback(false)
	public void testDoCreate() {
		// SysAttachment attachment = new SysAttachment();
		// attachment.setFileType(1L);
		// attachment.setFileExt("avi");
		// attachment.setSrcFileName("新闻联播");
		// attachment.setFileName(attachmentService.generateUniqueFileName(1L,
		// "avi"));
		// attachmentService.doCreate(attachment, 1040292L);
	}

	@Test
	public void testFindById() {
	}

	@Test
	public void testFindByClueId() {
		// List<SysAttachment> attachments = attachmentService
		// .findByClueId(1040292L);
		// for (SysAttachment attachment : attachments) {
		// System.out.println(attachment.getFileName());
		// Assert.assertNotNull(attachment.getFileName());
		// }
	}

	@Test
	@Rollback(false)
	public void testDoDelete() {
		// attachmentService.doDelete(1000L);
	}

	@Test
	@Rollback(false)
	public void testDoDeleteByClueId() {
		// attachmentService.doDeleteByClueId(1040292L);
	}

}
