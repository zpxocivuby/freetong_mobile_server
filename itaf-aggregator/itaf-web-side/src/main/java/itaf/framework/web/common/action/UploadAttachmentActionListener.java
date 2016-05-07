package itaf.framework.web.common.action;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.VariableResolver;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class UploadAttachmentActionListener implements ActionListener {

	public void processAction(ActionEvent event) throws AbortProcessingException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
        UIComponent component = event.getComponent();

        VariableResolver vr = facesContext.getApplication().getVariableResolver();
        UploadAttachmentAction form = (UploadAttachmentAction)vr.resolveVariable(facesContext, "uploadAttachmentAction");
        

        
		String filename = form.getAtachmentFile().getName();
		System.out.println("atachmentFilename="+filename);
		// TODO Auto-generated method stub
		
	}
}
