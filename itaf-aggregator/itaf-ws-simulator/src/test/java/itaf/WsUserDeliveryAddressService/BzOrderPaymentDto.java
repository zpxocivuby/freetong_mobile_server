
package itaf.WsUserDeliveryAddressService;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzOrderPaymentDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzOrderPaymentDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzPaymentTypeDto" type="{itaf.framework.ws.server.merchant}bzPaymentTypeDto" minOccurs="0"/>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.merchant}bzOrderDto" minOccurs="0"/>
 *         &lt;element name="payStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="payAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzOrderPaymentDto", propOrder = {
    "bzPaymentTypeDto",
    "bzOrderDto",
    "payStatus",
    "payAmount"
})
public class BzOrderPaymentDto
    extends BaseDto
{

    protected BzPaymentTypeDto bzPaymentTypeDto;
    protected BzOrderDto bzOrderDto;
    protected Long payStatus;
    protected BigDecimal payAmount;

    /**
     * Gets the value of the bzPaymentTypeDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzPaymentTypeDto }
     *     
     */
    public BzPaymentTypeDto getBzPaymentTypeDto() {
        return bzPaymentTypeDto;
    }

    /**
     * Sets the value of the bzPaymentTypeDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzPaymentTypeDto }
     *     
     */
    public void setBzPaymentTypeDto(BzPaymentTypeDto value) {
        this.bzPaymentTypeDto = value;
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
     * Gets the value of the payStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPayStatus() {
        return payStatus;
    }

    /**
     * Sets the value of the payStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPayStatus(Long value) {
        this.payStatus = value;
    }

    /**
     * Gets the value of the payAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * Sets the value of the payAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayAmount(BigDecimal value) {
        this.payAmount = value;
    }

}
