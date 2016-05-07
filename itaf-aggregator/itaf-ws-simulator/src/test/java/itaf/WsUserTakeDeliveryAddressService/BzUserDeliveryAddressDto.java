
package itaf.WsUserTakeDeliveryAddressService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzUserDeliveryAddressDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzUserDeliveryAddressDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.consumer}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzPositionDto" type="{itaf.framework.ws.server.consumer}bzPositionDto" minOccurs="0"/>
 *         &lt;element name="addressTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzUserDeliveryAddressDto", propOrder = {
    "sysUserDto",
    "bzPositionDto",
    "addressTag",
    "address",
    "contactPerson",
    "contactNo",
    "postcode"
})
public class BzUserDeliveryAddressDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected BzPositionDto bzPositionDto;
    protected String addressTag;
    protected String address;
    protected String contactPerson;
    protected String contactNo;
    protected String postcode;

    /**
     * Gets the value of the sysUserDto property.
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserDto() {
        return sysUserDto;
    }

    /**
     * Sets the value of the sysUserDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserDto(SysUserDto value) {
        this.sysUserDto = value;
    }

    /**
     * Gets the value of the bzPositionDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzPositionDto }
     *     
     */
    public BzPositionDto getBzPositionDto() {
        return bzPositionDto;
    }

    /**
     * Sets the value of the bzPositionDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzPositionDto }
     *     
     */
    public void setBzPositionDto(BzPositionDto value) {
        this.bzPositionDto = value;
    }

    /**
     * Gets the value of the addressTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressTag() {
        return addressTag;
    }

    /**
     * Sets the value of the addressTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressTag(String value) {
        this.addressTag = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the contactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * Sets the value of the contactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPerson(String value) {
        this.contactPerson = value;
    }

    /**
     * Gets the value of the contactNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * Sets the value of the contactNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactNo(String value) {
        this.contactNo = value;
    }

    /**
     * Gets the value of the postcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the value of the postcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcode(String value) {
        this.postcode = value;
    }

}
