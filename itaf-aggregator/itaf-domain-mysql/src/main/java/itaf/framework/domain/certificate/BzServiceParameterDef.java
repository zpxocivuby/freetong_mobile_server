package itaf.framework.domain.certificate;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * 服务参数定义
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_SERVICE_PARAMETER_DEF", catalog = "itaf")
public class BzServiceParameterDef extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 2094101045657859304L;

	private Long id;
	private BzServiceDef bzServiceDef;
	private String name;
	private String description;
	private String value;
	private Long enable;

	public BzServiceParameterDef() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_SERVICE_PARAMETER_DEF_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_SERVICE_DEF_ID")
	public BzServiceDef getBzServiceDef() {
		return this.bzServiceDef;
	}

	public void setBzServiceDef(BzServiceDef bzServiceDef) {
		this.bzServiceDef = bzServiceDef;
	}

	@Column(name = "NAME", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "VALUE", length = 200)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "ENABLE")
	public Long getEnable() {
		return this.enable;
	}

	public void setEnable(Long enable) {
		this.enable = enable;
	}

}
