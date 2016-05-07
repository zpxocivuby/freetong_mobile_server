package itaf.framework.consumer.dto;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import itaf.framework.base.dto.BaseDto;
import itaf.framework.platform.dto.SysUserDto;
import itaf.framework.position.dto.BzPositionDto;

/**
 * 
 * 收货地址
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
public class BzUserAddressDto extends BaseDto {

	private static final long serialVersionUID = -8595998451271607384L;

	private Long sysUserId;
	private SysUserDto sysUserDto;
	private Long bzPositionId;
	private BzPositionDto bzPositionDto;
	private String addressTag;
	private String address;
	private String contactPerson;
	private String contactNo;
	private String postcode;

	public BzUserAddressDto() {
	}

	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public SysUserDto getSysUserDto() {
		return sysUserDto;
	}

	public void setSysUserDto(SysUserDto sysUserDto) {
		this.sysUserDto = sysUserDto;
	}

	public Long getBzPositionId() {
		return bzPositionId;
	}

	public void setBzPositionId(Long bzPositionId) {
		this.bzPositionId = bzPositionId;
	}

	public BzPositionDto getBzPositionDto() {
		return bzPositionDto;
	}

	public void setBzPositionDto(BzPositionDto bzPositionDto) {
		this.bzPositionDto = bzPositionDto;
	}

	public String getAddressTag() {
		return this.addressTag;
	}

	public void setAddressTag(String addressTag) {
		this.addressTag = addressTag;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
