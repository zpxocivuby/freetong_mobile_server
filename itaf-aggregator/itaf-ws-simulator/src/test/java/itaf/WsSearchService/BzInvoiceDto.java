
package itaf.WsSearchService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzInvoiceDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzInvoiceDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.search}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserByBzMerchantIdDto" type="{itaf.framework.ws.server.search}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.search}bzOrderDto" minOccurs="0"/>
 *         &lt;element name="sysUserByBzDistributionCompanyIdDto" type="{itaf.framework.ws.server.search}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzDistributionModelDto" type="{itaf.framework.ws.server.search}bzDistributionModelDto" minOccurs="0"/>
 *         &lt;element name="invoiceSerialNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="invoiceNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="distAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distContactPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distContactNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distPostcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bzInvoiceItemDtos" type="{itaf.framework.ws.server.search}bzInvoiceItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzDistributionOrderDtos" type="{itaf.framework.ws.server.search}bzDistributionOrderDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzInvoiceDto", propOrder = {
    "sysUserByBzMerchantIdDto",
    "bzOrderDto",
    "sysUserByBzDistributionCompanyIdDto",
    "bzDistributionModelDto",
    "invoiceSerialNo",
    "invoiceStatus",
    "invoiceNum",
    "distAddress",
    "distContactPerson",
    "distContactNo",
    "distPostcode",
    "bzInvoiceItemDtos",
    "bzDistributionOrderDtos"
})
public class BzInvoiceDto
    extends BaseDto
{

    protected SysUserDto sysUserByBzMerchantIdDto;
    protected BzOrderDto bzOrderDto;
    protected SysUserDto sysUserByBzDistributionCompanyIdDto;
    protected BzDistributionModelDto bzDistributionModelDto;
    protected String invoiceSerialNo;
    protected Long invoiceStatus;
    protected Long invoiceNum;
    protected String distAddress;
    protected String distContactPerson;
    protected String distContactNo;
    protected String distPostcode;
    @XmlElement(nillable = true)
    protected List<BzInvoiceItemDto> bzInvoiceItemDtos;
    @XmlElement(nillable = true)
    protected List<BzDistributionOrderDto> bzDistributionOrderDtos;

    /**
     * Gets the value of the sysUserByBzMerchantIdDto property.
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserByBzMerchantIdDto() {
        return sysUserByBzMerchantIdDto;
    }

    /**
     * Sets the value of the sysUserByBzMerchantIdDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserByBzMerchantIdDto(SysUserDto value) {
        this.sysUserByBzMerchantIdDto = value;
    }

    /**
     * Gets the value of the bzOrderDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzOrderDto }
     *     
     */
    public BzOrderDto getBzOrderDto() {
        return bzOrderDto;
    }

    /**
     * Sets the value of the bzOrderDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzOrderDto }
     *     
     */
    public void setBzOrderDto(BzOrderDto value) {
        this.bzOrderDto = value;
    }

    /**
     * Gets the value of the sysUserByBzDistributionCompanyIdDto property.
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserByBzDistributionCompanyIdDto() {
        return sysUserByBzDistributionCompanyIdDto;
    }

    /**
     * Sets the value of the sysUserByBzDistributionCompanyIdDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserByBzDistributionCompanyIdDto(SysUserDto value) {
        this.sysUserByBzDistributionCompanyIdDto = value;
    }

    /**
     * Gets the value of the bzDistributionModelDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzDistributionModelDto }
     *     
     */
    public BzDistributionModelDto getBzDistributionModelDto() {
        return bzDistributionModelDto;
    }

    /**
     * Sets the value of the bzDistributionModelDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzDistributionModelDto }
     *     
     */
    public void setBzDistributionModelDto(BzDistributionModelDto value) {
        this.bzDistributionModelDto = value;
    }

    /**
     * Gets the value of the invoiceSerialNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceSerialNo() {
        return invoiceSerialNo;
    }

    /**
     * Sets the value of the invoiceSerialNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceSerialNo(String value) {
        this.invoiceSerialNo = value;
    }

    /**
     * Gets the value of the invoiceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * Sets the value of the invoiceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvoiceStatus(Long value) {
        this.invoiceStatus = value;
    }

    /**
     * Gets the value of the invoiceNum property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvoiceNum() {
        return invoiceNum;
    }

    /**
     * Sets the value of the invoiceNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvoiceNum(Long value) {
        this.invoiceNum = value;
    }

    /**
     * Gets the value of the distAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistAddress() {
        return distAddress;
    }

    /**
     * Sets the value of the distAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistAddress(String value) {
        this.distAddress = value;
    }

    /**
     * Gets the value of the distContactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistContactPerson() {
        return distContactPerson;
    }

    /**
     * Sets the value of the distContactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistContactPerson(String value) {
        this.distContactPerson = value;
    }

    /**
     * Gets the value of the distContactNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistContactNo() {
        return distContactNo;
    }

    /**
     * Sets the value of the distContactNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistContactNo(String value) {
        this.distContactNo = value;
    }

    /**
     * Gets the value of the distPostcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistPostcode() {
        return distPostcode;
    }

    /**
     * Sets the value of the distPostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistPostcode(String value) {
        this.distPostcode = value;
    }

    /**
     * Gets the value of the bzInvoiceItemDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzInvoiceItemDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzInvoiceItemDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzInvoiceItemDto }
     * 
     * 
     */
    public List<BzInvoiceItemDto> getBzInvoiceItemDtos() {
        if (bzInvoiceItemDtos == null) {
            bzInvoiceItemDtos = new ArrayList<BzInvoiceItemDto>();
        }
        return this.bzInvoiceItemDtos;
    }

    /**
     * Gets the value of the bzDistributionOrderDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzDistributionOrderDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzDistributionOrderDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzDistributionOrderDto }
     * 
     * 
     */
    public List<BzDistributionOrderDto> getBzDistributionOrderDtos() {
        if (bzDistributionOrderDtos == null) {
            bzDistributionOrderDtos = new ArrayList<BzDistributionOrderDto>();
        }
        return this.bzDistributionOrderDtos;
    }

}
