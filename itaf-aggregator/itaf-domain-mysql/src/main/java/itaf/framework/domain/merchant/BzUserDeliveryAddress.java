package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.domain.position.BzPosition;

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
 * 用户发货地址
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_USER_DELIVERY_ADDRESS", catalog = "itaf")
public class BzUserDeliveryAddress extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 2001702535405413123L;

	private Long id;
	private Long sysUserId;
	private SysUser sysUser;
	private Long bzPositionId;
	private BzPosition bzPosition;
	private String addressTag;
	private String address;
	private String contactPerson;
	private String contactNo;
	private String postcode;

	public BzUserDeliveryAddress() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_USER_DELIVERY_ADDRESS_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SYS_USER_ID", nullable = false)
	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_USER_ID", nullable = false, updatable = false, insertable = false)
	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Column(name = "BZ_POSITION_ID", nullable = false)
	public Long getBzPositionId() {
		return bzPositionId;
	}

	public void setBzPositionId(Long bzPositionId) {
		this.bzPositionId = bzPositionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_POSITION_ID", nullable = false, updatable = false, insertable = false)
	public BzPosition getBzPosition() {
		return this.bzPosition;
	}

	public void setBzPosition(BzPosition bzPosition) {
		this.bzPosition = bzPosition;
	}

	@Column(name = "ADDRESS_TAG", length = 200)
	public String getAddressTag() {
		return this.addressTag;
	}

	public void setAddressTag(String addressTag) {
		this.addressTag = addressTag;
	}

	@Column(name = "ADDRESS", length = 1000)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "CONTACT_PERSON", length = 50)
	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "CONTACT_NO", length = 50)
	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "POSTCODE", length = 20)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
