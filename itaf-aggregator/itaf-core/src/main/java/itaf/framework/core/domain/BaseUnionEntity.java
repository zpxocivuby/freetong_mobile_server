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
public abstract class BaseUnionEntity<T> extends BaseObjectEntity implements
		Serializable {

	private static final long serialVersionUID = 4327325007976895036L;

	public abstract T getUnionId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getUnionId() == null) ? 0 : getUnionId().hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseUnionEntity<T> other = (BaseUnionEntity<T>) obj;
		if (getUnionId() == null) {
			if (other.getUnionId() != null)
				return false;
		} else if (!getUnionId().equals(other.getUnionId()))
			return false;
		return true;
	}

}
