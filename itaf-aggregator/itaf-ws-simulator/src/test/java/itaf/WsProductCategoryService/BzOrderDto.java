
package itaf.WsProductCategoryService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzOrderDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzOrderDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}operateDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserByBzConsumerIdDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="sysUserByBzMerchantIdDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzUserTakeDeliveryAddressDto" type="{itaf.framework.ws.server.product}bzUserTakeDeliveryAddressDto" minOccurs="0"/>
 *         &lt;element name="orderSerialNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderPreferential" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="bzConsumerCreditEvalDtos" type="{itaf.framework.ws.server.product}bzConsumerCreditEvalDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzOrderHistorieDtos" type="{itaf.framework.ws.server.product}bzOrderHistoryDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzDistComCreditEvalDtos" type="{itaf.framework.ws.server.product}bzDistComCreditEvalDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzOrderPaymentDtos" type="{itaf.framework.ws.server.product}bzOrderPaymentDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzMerchantCreditEvalDtos" type="{itaf.framework.ws.server.product}bzMerchantCreditEvalDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzInvoiceDtos" type="{itaf.framework.ws.server.product}bzInvoiceDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzOrderItemDtos" type="{itaf.framework.ws.server.product}bzOrderItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzOrderDto", propOrder = {
    "sysUserByBzConsumerIdDto",
    "sysUserByBzMerchantIdDto",
    "bzUserTakeDeliveryAddressDto",
    "orderSerialNo",
    "orderStatus",
    "orderDiscount",
    "orderPreferential",
    "orderAmount",
    "bzConsumerCreditEvalDtos",
    "bzOrderHistorieDtos",
    "bzDistComCreditEvalDtos",
    "bzOrderPaymentDtos",
    "bzMerchantCreditEvalDtos",
    "bzInvoiceDtos",
    "bzOrderItemDtos"
})
public class BzOrderDto
    extends OperateDto
{

    protected SysUserDto sysUserByBzConsumerIdDto;
    protected SysUserDto sysUserByBzMerchantIdDto;
    protected BzUserTakeDeliveryAddressDto bzUserTakeDeliveryAddressDto;
    protected String orderSerialNo;
    protected Long orderStatus;
    protected BigDecimal orderDiscount;
    protected BigDecimal orderPreferential;
    protected BigDecimal orderAmount;
    @XmlElement(nillable = true)
    protected List<BzConsumerCreditEvalDto> bzConsumerCreditEvalDtos;
    @XmlElement(nillable = true)
    protected List<BzOrderHistoryDto> bzOrderHistorieDtos;
    @XmlElement(nillable = true)
    protected List<BzDistComCreditEvalDto> bzDistComCreditEvalDtos;
    @XmlElement(nillable = true)
    protected List<BzOrderPaymentDto> bzOrderPaymentDtos;
    @XmlElement(nillable = true)
    protected List<BzMerchantCreditEvalDto> bzMerchantCreditEvalDtos;
    @XmlElement(nillable = true)
    protected List<BzInvoiceDto> bzInvoiceDtos;
    @XmlElement(nillable = true)
    protected List<BzOrderItemDto> bzOrderItemDtos;

    /**
     * 获取sysUserByBzConsumerIdDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserByBzConsumerIdDto() {
        return sysUserByBzConsumerIdDto;
    }

    /**
     * 设置sysUserByBzConsumerIdDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserByBzConsumerIdDto(SysUserDto value) {
        this.sysUserByBzConsumerIdDto = value;
    }

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
     * 获取bzUserTakeDeliveryAddressDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzUserTakeDeliveryAddressDto }
     *     
     */
    public BzUserTakeDeliveryAddressDto getBzUserTakeDeliveryAddressDto() {
        return bzUserTakeDeliveryAddressDto;
    }

    /**
     * 设置bzUserTakeDeliveryAddressDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzUserTakeDeliveryAddressDto }
     *     
     */
    public void setBzUserTakeDeliveryAddressDto(BzUserTakeDeliveryAddressDto value) {
        this.bzUserTakeDeliveryAddressDto = value;
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
     * 获取orderDiscount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderDiscount() {
        return orderDiscount;
    }

    /**
     * 设置orderDiscount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderDiscount(BigDecimal value) {
        this.orderDiscount = value;
    }

    /**
     * 获取orderPreferential属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderPreferential() {
        return orderPreferential;
    }

    /**
     * 设置orderPreferential属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderPreferential(BigDecimal value) {
        this.orderPreferential = value;
    }

    /**
     * 获取orderAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置orderAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderAmount(BigDecimal value) {
        this.orderAmount = value;
    }

    /**
     * Gets the value of the bzConsumerCreditEvalDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzConsumerCreditEvalDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzConsumerCreditEvalDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzConsumerCreditEvalDto }
     * 
     * 
     */
    public List<BzConsumerCreditEvalDto> getBzConsumerCreditEvalDtos() {
        if (bzConsumerCreditEvalDtos == null) {
            bzConsumerCreditEvalDtos = new ArrayList<BzConsumerCreditEvalDto>();
        }
        return this.bzConsumerCreditEvalDtos;
    }

    /**
     * Gets the value of the bzOrderHistorieDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzOrderHistorieDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzOrderHistorieDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzOrderHistoryDto }
     * 
     * 
     */
    public List<BzOrderHistoryDto> getBzOrderHistorieDtos() {
        if (bzOrderHistorieDtos == null) {
            bzOrderHistorieDtos = new ArrayList<BzOrderHistoryDto>();
        }
        return this.bzOrderHistorieDtos;
    }

    /**
     * Gets the value of the bzDistComCreditEvalDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzDistComCreditEvalDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzDistComCreditEvalDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzDistComCreditEvalDto }
     * 
     * 
     */
    public List<BzDistComCreditEvalDto> getBzDistComCreditEvalDtos() {
        if (bzDistComCreditEvalDtos == null) {
            bzDistComCreditEvalDtos = new ArrayList<BzDistComCreditEvalDto>();
        }
        return this.bzDistComCreditEvalDtos;
    }

    /**
     * Gets the value of the bzOrderPaymentDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzOrderPaymentDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzOrderPaymentDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzOrderPaymentDto }
     * 
     * 
     */
    public List<BzOrderPaymentDto> getBzOrderPaymentDtos() {
        if (bzOrderPaymentDtos == null) {
            bzOrderPaymentDtos = new ArrayList<BzOrderPaymentDto>();
        }
        return this.bzOrderPaymentDtos;
    }

    /**
     * Gets the value of the bzMerchantCreditEvalDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzMerchantCreditEvalDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzMerchantCreditEvalDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzMerchantCreditEvalDto }
     * 
     * 
     */
    public List<BzMerchantCreditEvalDto> getBzMerchantCreditEvalDtos() {
        if (bzMerchantCreditEvalDtos == null) {
            bzMerchantCreditEvalDtos = new ArrayList<BzMerchantCreditEvalDto>();
        }
        return this.bzMerchantCreditEvalDtos;
    }

    /**
     * Gets the value of the bzInvoiceDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzInvoiceDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzInvoiceDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzInvoiceDto }
     * 
     * 
     */
    public List<BzInvoiceDto> getBzInvoiceDtos() {
        if (bzInvoiceDtos == null) {
            bzInvoiceDtos = new ArrayList<BzInvoiceDto>();
        }
        return this.bzInvoiceDtos;
    }

    /**
     * Gets the value of the bzOrderItemDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzOrderItemDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzOrderItemDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzOrderItemDto }
     * 
     * 
     */
    public List<BzOrderItemDto> getBzOrderItemDtos() {
        if (bzOrderItemDtos == null) {
            bzOrderItemDtos = new ArrayList<BzOrderItemDto>();
        }
        return this.bzOrderItemDtos;
    }

}
