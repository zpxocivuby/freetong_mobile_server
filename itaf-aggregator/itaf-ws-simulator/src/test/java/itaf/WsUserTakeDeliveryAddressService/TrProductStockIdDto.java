
package itaf.WsUserTakeDeliveryAddressService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trProductStockIdDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trProductStockIdDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzProductId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzStockId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="stockNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trProductStockIdDto", propOrder = {
    "bzProductId",
    "bzStockId",
    "stockNum"
})
public class TrProductStockIdDto
    extends BaseDto
{

    protected Long bzProductId;
    protected Long bzStockId;
    protected Long stockNum;

    /**
     * Gets the value of the bzProductId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzProductId() {
        return bzProductId;
    }

    /**
     * Sets the value of the bzProductId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzProductId(Long value) {
        this.bzProductId = value;
    }

    /**
     * Gets the value of the bzStockId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzStockId() {
        return bzStockId;
    }

    /**
     * Sets the value of the bzStockId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzStockId(Long value) {
        this.bzStockId = value;
    }

    /**
     * Gets the value of the stockNum property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStockNum() {
        return stockNum;
    }

    /**
     * Sets the value of the stockNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStockNum(Long value) {
        this.stockNum = value;
    }

}
