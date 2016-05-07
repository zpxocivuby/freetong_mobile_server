
package itaf.WsProductCategoryService;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>bzOrderHistoryDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzOrderHistoryDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}operateDto">
 *       &lt;sequence>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.product}bzOrderDto" minOccurs="0"/>
 *         &lt;element name="archiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="bzConsumerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzConsumerTdaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzMerchantId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderPreferential" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzOrderHistoryDto", propOrder = {
    "bzOrderDto",
    "archiveDate",
    "bzConsumerId",
    "bzConsumerTdaId",
    "bzMerchantId",
    "orderCode",
    "orderStatus",
    "orderDiscount",
    "orderPreferential",
    "orderPrice"
})
public class BzOrderHistoryDto
    extends OperateDto
{

    protected BzOrderDto bzOrderDto;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar archiveDate;
    protected Long bzConsumerId;
    protected Long bzConsumerTdaId;
    protected Long bzMerchantId;
    protected String orderCode;
    protected Long orderStatus;
    protected BigDecimal orderDiscount;
    protected BigDecimal orderPreferential;
    protected BigDecimal orderPrice;

    /**
     * 获取bzOrderDto属性的值。
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
     * 设置bzOrderDto属性的值。
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
     * 获取archiveDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArchiveDate() {
        return archiveDate;
    }

    /**
     * 设置archiveDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArchiveDate(XMLGregorianCalendar value) {
        this.archiveDate = value;
    }

    /**
     * 获取bzConsumerId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzConsumerId() {
        return bzConsumerId;
    }

    /**
     * 设置bzConsumerId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzConsumerId(Long value) {
        this.bzConsumerId = value;
    }

    /**
     * 获取bzConsumerTdaId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzConsumerTdaId() {
        return bzConsumerTdaId;
    }

    /**
     * 设置bzConsumerTdaId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzConsumerTdaId(Long value) {
        this.bzConsumerTdaId = value;
    }

    /**
     * 获取bzMerchantId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzMerchantId() {
        return bzMerchantId;
    }

    /**
     * 设置bzMerchantId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzMerchantId(Long value) {
        this.bzMerchantId = value;
    }

    /**
     * 获取orderCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置orderCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderCode(String value) {
        this.orderCode = value;
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
     * 获取orderPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * 设置orderPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderPrice(BigDecimal value) {
        this.orderPrice = value;
    }

}
