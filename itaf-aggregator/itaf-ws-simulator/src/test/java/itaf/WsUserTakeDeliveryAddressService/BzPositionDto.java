
package itaf.WsUserTakeDeliveryAddressService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzPositionDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzPositionDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="z" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="bzUserPositionDtos" type="{itaf.framework.ws.server.consumer}bzUserPositionDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzUserDeliveryAddresseDtos" type="{itaf.framework.ws.server.consumer}bzUserDeliveryAddressDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductDtos" type="{itaf.framework.ws.server.consumer}bzProductDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzUserTakeDeliveryAddresseDtos" type="{itaf.framework.ws.server.consumer}bzUserTakeDeliveryAddressDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzPositionDto", propOrder = {
    "x",
    "y",
    "z",
    "bzUserPositionDtos",
    "bzUserDeliveryAddresseDtos",
    "bzProductDtos",
    "bzUserTakeDeliveryAddresseDtos"
})
public class BzPositionDto
    extends BaseDto
{

    protected BigDecimal x;
    protected BigDecimal y;
    protected BigDecimal z;
    @XmlElement(nillable = true)
    protected List<BzUserPositionDto> bzUserPositionDtos;
    @XmlElement(nillable = true)
    protected List<BzUserDeliveryAddressDto> bzUserDeliveryAddresseDtos;
    @XmlElement(nillable = true)
    protected List<BzProductDto> bzProductDtos;
    @XmlElement(nillable = true)
    protected List<BzUserTakeDeliveryAddressDto> bzUserTakeDeliveryAddresseDtos;

    /**
     * Gets the value of the x property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setX(BigDecimal value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setY(BigDecimal value) {
        this.y = value;
    }

    /**
     * Gets the value of the z property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getZ() {
        return z;
    }

    /**
     * Sets the value of the z property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setZ(BigDecimal value) {
        this.z = value;
    }

    /**
     * Gets the value of the bzUserPositionDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzUserPositionDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzUserPositionDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzUserPositionDto }
     * 
     * 
     */
    public List<BzUserPositionDto> getBzUserPositionDtos() {
        if (bzUserPositionDtos == null) {
            bzUserPositionDtos = new ArrayList<BzUserPositionDto>();
        }
        return this.bzUserPositionDtos;
    }

    /**
     * Gets the value of the bzUserDeliveryAddresseDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzUserDeliveryAddresseDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzUserDeliveryAddresseDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzUserDeliveryAddressDto }
     * 
     * 
     */
    public List<BzUserDeliveryAddressDto> getBzUserDeliveryAddresseDtos() {
        if (bzUserDeliveryAddresseDtos == null) {
            bzUserDeliveryAddresseDtos = new ArrayList<BzUserDeliveryAddressDto>();
        }
        return this.bzUserDeliveryAddresseDtos;
    }

    /**
     * Gets the value of the bzProductDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzProductDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzProductDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzProductDto }
     * 
     * 
     */
    public List<BzProductDto> getBzProductDtos() {
        if (bzProductDtos == null) {
            bzProductDtos = new ArrayList<BzProductDto>();
        }
        return this.bzProductDtos;
    }

    /**
     * Gets the value of the bzUserTakeDeliveryAddresseDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzUserTakeDeliveryAddresseDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzUserTakeDeliveryAddresseDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzUserTakeDeliveryAddressDto }
     * 
     * 
     */
    public List<BzUserTakeDeliveryAddressDto> getBzUserTakeDeliveryAddresseDtos() {
        if (bzUserTakeDeliveryAddresseDtos == null) {
            bzUserTakeDeliveryAddresseDtos = new ArrayList<BzUserTakeDeliveryAddressDto>();
        }
        return this.bzUserTakeDeliveryAddresseDtos;
    }

}
