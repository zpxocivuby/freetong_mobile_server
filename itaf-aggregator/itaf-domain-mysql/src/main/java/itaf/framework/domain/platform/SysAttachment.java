package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 附件
 *
 * @author
 *
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_ATTACHMENT", catalog = "itaf")
public class SysAttachment extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -6471202608090452615L;

	private Long id;
	private String srcFileName;
	private String fileName;
	private Long fileType;
	private String fileExt;

	public SysAttachment() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_ATTACHMENT_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SRC_FILE_NAME", length = 300)
	public String getSrcFileName() {
		return this.srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	@Column(name = "FILE_NAME", length = 100)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "FILE_TYPE")
	public Long getFileType() {
		return this.fileType;
	}

	public void setFileType(Long fileType) {
		this.fileType = fileType;
	}

	@Column(name = "FILE_EXT", length = 10)
	public String getFileExt() {
		return this.fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

}
