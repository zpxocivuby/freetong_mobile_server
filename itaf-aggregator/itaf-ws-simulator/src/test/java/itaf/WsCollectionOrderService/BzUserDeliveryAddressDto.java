
package itaf.WsCollectionOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzUserDeliveryAddressDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzUserDeliveryAddressDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}operateDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.merchant}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzPositionDto" type="{itaf.framework.ws.server.merchant}bzPositionDto" minOccurs="0"/>
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
    extends OperateDto
{

    protected SysUserDto sysUserDto;
    protected BzPositionDto bzPositionDto;
    protected String addressTag;
    protected String address;
    protected String contactPerson;
    protected String contactNo;
    protected String postcode;

    /**
     * ��ȡsysUserDto���Ե�ֵ��
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
     * ����sysUserDto���Ե�ֵ��
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
     * ��ȡbzPositionDto���Ե�ֵ��
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
     * ����bzPositionDto���Ե�ֵ��
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
     * ��ȡaddressTag���Ե�ֵ��
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
     * ����addressTag���Ե�ֵ��
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
     * ��ȡaddress���Ե�ֵ��
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
     * ����address���Ե�ֵ��
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
     * ��ȡcontactPerson���Ե�ֵ��
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
     * ����contactPerson���Ե�ֵ��
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
     * ��ȡcontactNo���Ե�ֵ��
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
     * ����contactNo���Ե�ֵ��
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
     * ��ȡpostcode���Ե�ֵ��
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
     * ����postcode���Ե�ֵ��
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
