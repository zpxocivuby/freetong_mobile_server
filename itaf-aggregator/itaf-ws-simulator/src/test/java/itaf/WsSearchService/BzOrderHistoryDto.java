
package itaf.WsSearchService;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for bzOrderHistoryDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzOrderHistoryDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.search}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.search}bzOrderDto" minOccurs="0"/>
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
    extends BaseDto
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
     * Gets the value of the archiveDate property.
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
     * Sets the value of the archiveDate property.
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
     * Gets the value of the bzConsumerId property.
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
     * Sets the value of the bzConsumerId property.
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
     * Gets the value of the bzConsumerTdaId property.
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
     * Sets the value of the bzConsumerTdaId property.
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
     * Gets the value of the bzMerchantId property.
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
     * Sets the value of the bzMerchantId property.
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
     * Gets the value of the orderCode property.
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
     * Sets the value of the orderCode property.
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
     * Gets the value of the orderDiscount property.
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
     * Sets the value of the orderDiscount property.
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
     * Gets the value of the orderPreferential property.
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
     * Sets the value of the orderPreferential property.
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
     * Gets the value of the orderPrice property.
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
     * Sets the value of the orderPrice property.
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
