package itaf.framework.domain.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Transient;

/**
 * 不映射数据库的树信息
 * 
 * @author
 * 
 * @Date 2014年7月23日
 */
public abstract class TransientTreeEntity<T extends TreeEntity> extends
		TreeEntity implements Serializable {

	private static final long serialVersionUID = 4721581696797516325L;
	// 树的父节点
	private T treeParent;
	// 树子节点
	private List<T> treeChildren;
	// 树选中
	private Boolean treeChecked;
	// 树路径
	private String treePath;

	@Transient
	public void addTreeChild(T child) {
		if (treeChildren == null) {
			treeChildren = new ArrayList<T>();
		}
		this.treeChildren.add(child);
		Collections.sort(treeChildren, new Comparator<T>() {
			public int compare(T a, T b) {
				return a.getOrderNo().compareTo(b.getOrderNo());
			}
		});
	}

	@Transient
	public void addTreeChildren(Collection<T> children) {
		if (treeChildren == null) {
			treeChildren = new ArrayList<T>();
		}
		this.treeChildren.addAll(children);
		Collections.sort(treeChildren, new Comparator<T>() {
			public int compare(T a, T b) {
				return a.getOrderNo().compareTo(b.getOrderNo());
			}
		});
	}

	@Transient
	public T getTreeParent() {
		return treeParent;
	}

	@Transient
	public List<T> getTreeChildren() {
		if (treeChildren == null) {
			treeChildren = new ArrayList<T>();
		}
		return treeChildren;
	}

	@Transient
	public Boolean getTreeChecked() {
		if (treeChecked == null) {
			treeChecked = false;
		}
		return treeChecked;
	}

	@Transient
	public String getTreePath() {
		return treePath;
	}

	public void setTreeParent(T treeParent) {
		this.treeParent = treeParent;
	}

	public void setTreeChildren(List<T> treeChildren) {
		this.treeChildren = treeChildren;
	}

	public void setTreeChecked(Boolean treeChecked) {
		this.treeChecked = treeChecked;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

}
