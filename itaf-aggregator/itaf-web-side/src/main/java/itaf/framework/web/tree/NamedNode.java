package itaf.framework.web.tree;

/**
 * 名称节点
 * 
 * @authorXINXIN
 * 
 * @Update 2014年5月26日
 */
public class NamedNode {

	private Long id;
	private String name;
	private String path;
	private String href;
	private String type;
	private Boolean checked;
	private Boolean checkedAbled;
	private Boolean expanded;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	public Boolean getCheckedAbled() {
		return checkedAbled;
	}

	public void setCheckedAbled(Boolean checkedAbled) {
		this.checkedAbled = checkedAbled;
	}

}
