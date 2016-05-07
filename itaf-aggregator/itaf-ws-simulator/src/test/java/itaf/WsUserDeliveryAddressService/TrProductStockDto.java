
package itaf.WsUserDeliveryAddressService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trProductStockDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trProductStockDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="idDto" type="{itaf.framework.ws.server.merchant}trProductStockIdDto" minOccurs="0"/>
 *         &lt;element name="bzStockDto" type="{itaf.framework.ws.server.merchant}bzStockDto" minOccurs="0"/>
 *         &lt;element name="bzProductDto" type="{itaf.framework.ws.server.merchant}bzProductDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trProductStockDto", propOrder = {
    "idDto",
    "bzStockDto",
    "bzProductDto"
})
public class TrProductStockDto
    extends BaseDto
{

    protected TrProductStockIdDto idDto;
    protected BzStockDto bzStockDto;
    protected BzProductDto bzProductDto;

    /**
     * Gets the value of the idDto property.
     * 
     * @return
     *     possible object is
     *     {@link TrProductStockIdDto }
     *     
     */
    public TrProductStockIdDto getIdDto() {
        return idDto;
    }

    /**
     * Sets the value of the idDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrProductStockIdDto }
     *     
     */
    public void setIdDto(TrProductStockIdDto value) {
        this.idDto = value;
    }

    /**
     * Gets the value of the bzStockDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzStockDto }
     *     
     */
    public BzStockDto getBzStockDto() {
        return bzStockDto;
    }

    /**
     * Sets the value of the bzStockDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzStockDto }
     *     
     */
    public void setBzStockDto(BzStockDto value) {
        this.bzStockDto = value;
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

}
