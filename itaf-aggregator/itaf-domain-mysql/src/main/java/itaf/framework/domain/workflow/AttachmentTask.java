package itaf.framework.domain.workflow;

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.core.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BZ_TASK_ATTACHMENT")
public class AttachmentTask extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long bsAttachmentId;
	private String taskId;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_TASK_ATTACHMENT_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BZ_ATTACHMENT_ID")
	public Long getBsAttachmentId() {
		return bsAttachmentId;
	}

	public void setBsAttachmentId(Long bsAttachmentId) {
		this.bsAttachmentId = bsAttachmentId;
	}

	@Column(name = "BZ_TASK_ID", length = 64)
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

}
