/**********************************************************************
 * FILE : BaseEntity.java
 * CREATE DATE : Jan 5, 2009
 * DESCRIPTION :
 *		所有数据库记录对象的基类
 * CHANGE HISTORY LOG
 *---------------------------------------------------------------------
 * NO.|    DATE    |     NAME     |     REASON     | DESCRIPTION
 *---------------------------------------------------------------------
 *  1    2009-1-5    LiuYanLu      Draft Create
 **********************************************************************
 */
package itaf.framework.core.domain;

import java.io.Serializable;

/**
 * An entity is a java object represents a row data of data store.
 * <p>
 * This class defines a property "id" with {@link java.lang.Long} type for
 * holding a primary key of data row.
 * 
 * @author Danne
 * 
 */
public abstract class BaseEntity extends BaseObjectEntity implements Serializable {

	private static final long serialVersionUID = 4327325007976895036L;

	public abstract Long getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
