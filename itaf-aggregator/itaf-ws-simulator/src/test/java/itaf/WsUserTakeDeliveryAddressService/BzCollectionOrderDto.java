
package itaf.WsUserTakeDeliveryAddressService;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzCollectionOrderDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzCollectionOrderDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzDistributionOrderDto" type="{itaf.framework.ws.server.consumer}bzDistributionOrderDto" minOccurs="0"/>
 *         &lt;element name="receivableAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="actualAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="distributionAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzCollectionOrderDto", propOrder = {
    "bzDistributionOrderDto",
    "receivableAmount",
    "actualAmount",
    "distributionAmount"
})
public class BzCollectionOrderDto
    extends BaseDto
{

    protected BzDistributionOrderDto bzDistributionOrderDto;
    protected BigDecimal receivableAmount;
    protected BigDecimal actualAmount;
    protected BigDecimal distributionAmount;

    /**
     * Gets the value of the bzDistributionOrderDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzDistributionOrderDto }
     *     
     */
    public BzDistributionOrderDto getBzDistributionOrderDto() {
        return bzDistributionOrderDto;
    }

    /**
     * Sets the value of the bzDistributionOrderDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzDistributionOrderDto }
     *     
     */
    public void setBzDistributionOrderDto(BzDistributionOrderDto value) {
        this.bzDistributionOrderDto = value;
    }

    /**
     * Gets the value of the receivableAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    /**
     * Sets the value of the receivableAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReceivableAmount(BigDecimal value) {
        this.receivableAmount = value;
    }

    /**
     * Gets the value of the actualAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    /**
     * Sets the value of the actualAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setActualAmount(BigDecimal value) {
        this.actualAmount = value;
    }

    /**
     * Gets the value of the distributionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDistributionAmount() {
        return distributionAmount;
    }

    /**
     * Sets the value of the distributionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDistributionAmount(BigDecimal value) {
        this.distributionAmount = value;
    }

}
