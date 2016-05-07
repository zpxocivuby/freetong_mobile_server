
package itaf.WsUserTakeDeliveryAddressService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzInvoiceItemDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzInvoiceItemDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzProductDto" type="{itaf.framework.ws.server.consumer}bzProductDto" minOccurs="0"/>
 *         &lt;element name="bzInvoiceDto" type="{itaf.framework.ws.server.consumer}bzInvoiceDto" minOccurs="0"/>
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
@XmlType(name = "bzInvoiceItemDto", propOrder = {
    "bzProductDto",
    "bzInvoiceDto",
    "itemNum"
})
public class BzInvoiceItemDto
    extends BaseDto
{

    protected BzProductDto bzProductDto;
    protected BzInvoiceDto bzInvoiceDto;
    protected Long itemNum;

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
