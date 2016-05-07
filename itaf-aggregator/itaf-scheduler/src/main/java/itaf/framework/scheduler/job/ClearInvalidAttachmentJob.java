package itaf.framework.scheduler.job;

import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.core.util.SpringContextUtil;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 清理无效的附件
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月14日
 */
public class ClearInvalidAttachmentJob extends AbstractSchedulerJob {

	private ISysAttachmentService bsAttachmentService;

	@Override
	protected void executeBzInternal(JobExecutionContext context)
			throws JobExecutionException {
		getSysAttachmentService().doClearInvalidAttachments();
	}

	public ISysAttachmentService getSysAttachmentService() {
		if (bsAttachmentService == null) {
			bsAttachmentService = (ISysAttachmentService) SpringContextUtil
					.getBean(getServiceName());
		}
		return bsAttachmentService;
	}

}
