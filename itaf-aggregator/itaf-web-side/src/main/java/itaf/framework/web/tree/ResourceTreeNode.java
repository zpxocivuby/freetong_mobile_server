package itaf.framework.web.tree;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

import com.google.common.collect.Iterators;

/**
 * 资源树节点对象
 * 
 * @authorXINXIN
 * 
 * @Update 2014年5月26日
 */
public class ResourceTreeNode extends NamedNode implements TreeNode {

	private String nameZh;
	private String nameEn;
	private String description;
	private Long orderNo;

	private List<TreeNode> treeNodes = new ArrayList<TreeNode>();

	@Override
	public TreeNode getChildAt(int childIndex) {
		return treeNodes.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return treeNodes.size();
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
		return treeNodes.indexOf(node);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return treeNodes.isEmpty();
	}

	@Override
	public Enumeration<TreeNode> children() {
		return Iterators.asEnumeration(treeNodes.iterator());
	}

	public List<TreeNode> getTreeNodes() {
		return treeNodes;
	}

	public void setTreeNodes(List<TreeNode> treeNodes) {
		this.treeNodes = treeNodes;
	}

	public String getNameZh() {
		return nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

}
