package itaf.framework.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 操作信息（标记为删除）
 *
 *
 * @author
 *
 * @UpdateDate 2014年9月4日
 */
@MappedSuperclass
public abstract class OperateEntity extends AuditEntity {

	private static final long serialVersionUID = -8162996933526124239L;

	private Boolean markForDelete = false;

	@Column(name = "MARK_FOR_DELETE")
	public Boolean getMarkForDelete() {
		return markForDelete;
	}

	public void setMarkForDelete(Boolean markForDelete) {
		this.markForDelete = markForDelete;
	}

}
