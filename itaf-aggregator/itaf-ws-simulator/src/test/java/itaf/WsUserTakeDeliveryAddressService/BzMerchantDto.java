
package itaf.WsUserTakeDeliveryAddressService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzMerchantDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzMerchantDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzServiceProviderTypeDto" type="{itaf.framework.ws.server.consumer}bzServiceProviderTypeDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzMerchantDto", propOrder = {
    "bzServiceProviderTypeDto"
})
public class BzMerchantDto
    extends BaseDto
{

    protected BzServiceProviderTypeDto bzServiceProviderTypeDto;

    /**
     * Gets the value of the bzServiceProviderTypeDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzServiceProviderTypeDto }
     *     
     */
    public BzServiceProviderTypeDto getBzServiceProviderTypeDto() {
        return bzServiceProviderTypeDto;
    }

    /**
     * Sets the value of the bzServiceProviderTypeDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzServiceProviderTypeDto }
     *     
     */
    public void setBzServiceProviderTypeDto(BzServiceProviderTypeDto value) {
        this.bzServiceProviderTypeDto = value;
    }

}
