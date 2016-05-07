package itaf.framework.domain.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 * 树信息
 * 
 * @author
 * 
 * @Date 2014年7月23日
 */
@MappedSuperclass
public abstract class TreeEntity extends OperateEntity implements Serializable {

	private static final long serialVersionUID = -2202672908472026262L;
	// 父ID
	private Long parentId;
	// 排序号
	private Long orderNo;
	// 是否为叶子节点
	private Boolean isLeaf;

	@Column(name = "PARENT_ID", precision = 10, scale = 0)
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "ORDER_NO", precision = 10, scale = 0)
	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	@Column(name = "IS_LEAF", precision = 10, scale = 0)
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
