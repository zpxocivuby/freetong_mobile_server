
package itaf.WsUserTakeDeliveryAddressService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzStockOrderItemDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzStockOrderItemDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzStockOrderDto" type="{itaf.framework.ws.server.consumer}bzStockOrderDto" minOccurs="0"/>
 *         &lt;element name="bzShelfDto" type="{itaf.framework.ws.server.consumer}bzShelfDto" minOccurs="0"/>
 *         &lt;element name="bzProductDto" type="{itaf.framework.ws.server.consumer}bzProductDto" minOccurs="0"/>
 *         &lt;element name="itemStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="itemNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzStockOrderItemDto", propOrder = {
    "bzStockOrderDto",
    "bzShelfDto",
    "bzProductDto",
    "itemStatus",
    "itemNum"
})
public class BzStockOrderItemDto
    extends BaseDto
{

    protected BzStockOrderDto bzStockOrderDto;
    protected BzShelfDto bzShelfDto;
    protected BzProductDto bzProductDto;
    protected Long itemStatus;
    protected Long itemNum;

    /**
     * Gets the value of the bzStockOrderDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzStockOrderDto }
     *     
     */
    public BzStockOrderDto getBzStockOrderDto() {
        return bzStockOrderDto;
    }

    /**
     * Sets the value of the bzStockOrderDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzStockOrderDto }
     *     
     */
    public void setBzStockOrderDto(BzStockOrderDto value) {
        this.bzStockOrderDto = value;
    }

    /**
     * Gets the value of the bzShelfDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzShelfDto }
     *     
     */
    public BzShelfDto getBzShelfDto() {
        return bzShelfDto;
    }

    /**
     * Sets the value of the bzShelfDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzShelfDto }
     *     
     */
    public void setBzShelfDto(BzShelfDto value) {
        this.bzShelfDto = value;
    }

    /**
     * Gets the value of the bzProductDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzProductDto }
     *     
     */
    public BzProductDto getBzProductDto() {
        return bzProductDto;
    }

    /**
     * Sets the value of the bzProductDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzProductDto }
     *     
     */
    public void setBzProductDto(BzProductDto value) {
        this.bzProductDto = value;
    }

    /**
     * Gets the value of the itemStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemStatus() {
        return itemStatus;
    }

    /**
     * Sets the value of the itemStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemStatus(Long value) {
        this.itemStatus = value;
    }

    /**
     * Gets the value of the itemNum property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemNum() {
        return itemNum;
    }

    /**
     * Sets the value of the itemNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemNum(Long value) {
        this.itemNum = value;
    }

}
