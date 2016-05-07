package itaf.framework.base.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseTreeDto", propOrder = { "parentId", "orderNo", "isLeaf" })
public abstract class BaseTreeDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 677069556104941115L;

	private Long parentId;
	private Long orderNo;
	private Boolean isLeaf;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Boolean getIsLeaf() {
		if (isLeaf == null) {
			isLeaf = true;
		}
		return this.isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}
