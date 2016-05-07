
package itaf.WsCollectionOrderService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzDistributionModelDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzDistributionModelDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}operateDto">
 *       &lt;sequence>
 *         &lt;element name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modelType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="modelDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bzInvoiceDtos" type="{itaf.framework.ws.server.merchant}bzInvoiceDto" maxOccurs="unbounded" minOccurs="0"/>
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
    extends OperateDto
{

    protected String modelName;
    protected Long modelType;
    protected String modelDesc;
    @XmlElement(nillable = true)
    protected List<BzInvoiceDto> bzInvoiceDtos;

    /**
     * 获取modelName属性的值。
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
     * 设置modelName属性的值。
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
     * 获取modelType属性的值。
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
     * 设置modelType属性的值。
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
     * 获取modelDesc属性的值。
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
     * 设置modelDesc属性的值。
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
