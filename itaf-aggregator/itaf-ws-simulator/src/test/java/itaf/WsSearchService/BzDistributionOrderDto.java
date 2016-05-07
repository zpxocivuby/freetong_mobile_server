
package itaf.WsSearchService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for bzDistributionOrderDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzDistributionOrderDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.search}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserByBzMerchantIdDto" type="{itaf.framework.ws.server.search}sysUserDto" minOccurs="0"/>
 *         &lt;element name="sysUserByBzDistributionCompanyIdDto" type="{itaf.framework.ws.server.search}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzInvoiceDto" type="{itaf.framework.ws.server.search}bzInvoiceDto" minOccurs="0"/>
 *         &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderDistance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderDirection" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderSerialNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderEdc" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="bzCollectionOrderDtos" type="{itaf.framework.ws.server.search}bzCollectionOrderDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzDistributionOrderDto", propOrder = {
    "sysUserByBzMerchantIdDto",
    "sysUserByBzDistributionCompanyIdDto",
    "bzInvoiceDto",
    "orderStatus",
    "orderDistance",
    "orderDirection",
    "orderSerialNo",
    "orderEdc",
    "bzCollectionOrderDtos"
})
public class BzDistributionOrderDto
    extends BaseDto
{

    protected SysUserDto sysUserByBzMerchantIdDto;
    protected SysUserDto sysUserByBzDistributionCompanyIdDto;
    protected BzInvoiceDto bzInvoiceDto;
    protected Long orderStatus;
    protected BigDecimal orderDistance;
    protected Long orderDirection;
    protected String orderSerialNo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderEdc;
    @XmlElement(nillable = true)
    protected List<BzCollectionOrderDto> bzCollectionOrderDtos;

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
     * Gets the value of the bzInvoiceDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzInvoiceDto }
     *     
     */
    public BzInvoiceDto getBzInvoiceDto() {
        return bzInvoiceDto;
    }

    /**
     * Sets the value of the bzInvoiceDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzInvoiceDto }
     *     
     */
    public void setBzInvoiceDto(BzInvoiceDto value) {
        this.bzInvoiceDto = value;
    }

    /**
     * Gets the value of the orderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrderStatus(Long value) {
        this.orderStatus = value;
    }

    /**
     * Gets the value of the orderDistance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderDistance() {
        return orderDistance;
    }

    /**
     * Sets the value of the orderDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderDistance(BigDecimal value) {
        this.orderDistance = value;
    }

    /**
     * Gets the value of the orderDirection property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrderDirection() {
        return orderDirection;
    }

    /**
     * Sets the value of the orderDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrderDirection(Long value) {
        this.orderDirection = value;
    }

    /**
     * Gets the value of the orderSerialNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderSerialNo() {
        return orderSerialNo;
    }

    /**
     * Sets the value of the orderSerialNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderSerialNo(String value) {
        this.orderSerialNo = value;
    }

    /**
     * Gets the value of the orderEdc property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderEdc() {
        return orderEdc;
    }

    /**
     * Sets the value of the orderEdc property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderEdc(XMLGregorianCalendar value) {
        this.orderEdc = value;
    }

    /**
     * Gets the value of the bzCollectionOrderDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzCollectionOrderDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzCollectionOrderDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzCollectionOrderDto }
     * 
     * 
     */
    public List<BzCollectionOrderDto> getBzCollectionOrderDtos() {
        if (bzCollectionOrderDtos == null) {
            bzCollectionOrderDtos = new ArrayList<BzCollectionOrderDto>();
        }
        return this.bzCollectionOrderDtos;
    }

}
