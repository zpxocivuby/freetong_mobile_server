
package itaf.WsUserTakeDeliveryAddressService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzDistributionModelDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzDistributionModelDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modelType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="modelDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bzInvoiceDtos" type="{itaf.framework.ws.server.consumer}bzInvoiceDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzDistributionModelDto", propOrder = {
    "modelName",
    "modelType",
    "modelDesc",
    "bzInvoiceDtos"
})
public class BzDistributionModelDto
    extends BaseDto
{

    protected String modelName;
    protected Long modelType;
    protected String modelDesc;
    @XmlElement(nillable = true)
    protected List<BzInvoiceDto> bzInvoiceDtos;

    /**
     * Gets the value of the modelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the value of the modelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelName(String value) {
        this.modelName = value;
    }

    /**
     * Gets the value of the modelType property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getModelType() {
        return modelType;
    }

    /**
     * Sets the value of the modelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setModelType(Long value) {
        this.modelType = value;
    }

    /**
     * Gets the value of the modelDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelDesc() {
        return modelDesc;
    }

    /**
     * Sets the value of the modelDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelDesc(String value) {
        this.modelDesc = value;
    }

    /**
     * Gets the value of the bzInvoiceDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzInvoiceDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzInvoiceDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzInvoiceDto }
     * 
     * 
     */
    public List<BzInvoiceDto> getBzInvoiceDtos() {
        if (bzInvoiceDtos == null) {
            bzInvoiceDtos = new ArrayList<BzInvoiceDto>();
        }
        return this.bzInvoiceDtos;
    }

}
