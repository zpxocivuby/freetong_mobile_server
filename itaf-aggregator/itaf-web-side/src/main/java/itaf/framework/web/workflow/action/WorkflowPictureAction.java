package itaf.framework.web.workflow.action;

import itaf.framework.web.base.action.BaseAction;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.workflow.service.WorkflowProcessService;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.imageio.ImageIO;

/**
 * 获取流程图
 * 
 * @author XINXIN
 * 
 * @update 2013年1月31日
 */
@ManagedBean(name = "workflowPictureAction")
@SessionScoped
public class WorkflowPictureAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String processInstanceId;

	@ManagedProperty(value = "#{workflowProcessServiceImpl}")
	private WorkflowProcessService workflowProcessService;

	public WorkflowProcessService getWorkflowProcessService() {
		return workflowProcessService;
	}

	public void setWorkflowProcessService(
			WorkflowProcessService workflowProcessService) {
		this.workflowProcessService = workflowProcessService;
	}

	public void loadByProcessInstance(OutputStream out, Object data)
			throws Exception {
		String processInstanceId = ProcessQueryUtil
				.getValueOfForm("processInstanceId");
		InputStream resourceAsStream = workflowProcessService
				.getWorkflowPicture(processInstanceId);
		BufferedImage image = ImageIO.read(resourceAsStream);
		ImageIO.write(image, "png", out);
	}

	public String getProcessInstanceId() {
		//if (StringUtils.isEmpty(processInstanceId)) {
			processInstanceId = ProcessQueryUtil
					.getValueOfForm("processInstanceId");
		//}
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

}
