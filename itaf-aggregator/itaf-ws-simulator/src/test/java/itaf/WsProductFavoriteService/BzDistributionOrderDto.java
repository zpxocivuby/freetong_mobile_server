
package itaf.WsProductFavoriteService;

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
 * <p>bzDistributionOrderDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzDistributionOrderDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserByBzMerchantIdDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="sysUserByBzDistributionCompanyIdDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzInvoiceDto" type="{itaf.framework.ws.server.product}bzInvoiceDto" minOccurs="0"/>
 *         &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderDistance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderDirection" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderSerialNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderEdc" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="bzCollectionOrderDtos" type="{itaf.framework.ws.server.product}bzCollectionOrderDto" maxOccurs="unbounded" minOccurs="0"/>
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
     * 获取sysUserByBzMerchantIdDto属性的值。
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
     * 设置sysUserByBzMerchantIdDto属性的值。
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
     * 获取sysUserByBzDistributionCompanyIdDto属性的值。
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
     * 设置sysUserByBzDistributionCompanyIdDto属性的值。
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
     * 获取bzInvoiceDto属性的值。
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
     * 设置bzInvoiceDto属性的值。
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
     * 获取orderStatus属性的值。
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
     * 设置orderStatus属性的值。
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
     * 获取orderDistance属性的值。
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
     * 设置orderDistance属性的值。
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
     * 获取orderDirection属性的值。
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
     * 设置orderDirection属性的值。
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
     * 获取orderSerialNo属性的值。
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
     * 设置orderSerialNo属性的值。
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
     * 获取orderEdc属性的值。
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
     * 设置orderEdc属性的值。
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
