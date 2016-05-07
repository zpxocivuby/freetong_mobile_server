
package itaf.WsUserTakeDeliveryAddressService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzProductCategoryDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzProductCategoryDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseTreeDto">
 *       &lt;sequence>
 *         &lt;element name="parentDto" type="{itaf.framework.ws.server.consumer}bzProductCategoryDto" minOccurs="0"/>
 *         &lt;element name="categoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bzProductDtos" type="{itaf.framework.ws.server.consumer}bzProductDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="childrenDtos" type="{itaf.framework.ws.server.consumer}bzProductCategoryDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzProductCategoryDto", propOrder = {
    "parentDto",
    "categoryName",
    "categoryCode",
    "bzProductDtos",
    "childrenDtos"
})
public class BzProductCategoryDto
    extends BaseTreeDto
{

    protected BzProductCategoryDto parentDto;
    protected String categoryName;
    protected String categoryCode;
    @XmlElement(nillable = true)
    protected List<BzProductDto> bzProductDtos;
    @XmlElement(nillable = true)
    protected List<BzProductCategoryDto> childrenDtos;

    /**
     * Gets the value of the parentDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzProductCategoryDto }
     *     
     */
    public BzProductCategoryDto getParentDto() {
        return parentDto;
    }

    /**
     * Sets the value of the parentDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzProductCategoryDto }
     *     
     */
    public void setParentDto(BzProductCategoryDto value) {
        this.parentDto = value;
    }

    /**
     * Gets the value of the categoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the value of the categoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryName(String value) {
        this.categoryName = value;
    }

    /**
     * Gets the value of the categoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * Sets the value of the categoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryCode(String value) {
        this.categoryCode = value;
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
     * Gets the value of the childrenDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childrenDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildrenDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzProductCategoryDto }
     * 
     * 
     */
    public List<BzProductCategoryDto> getChildrenDtos() {
        if (childrenDtos == null) {
            childrenDtos = new ArrayList<BzProductCategoryDto>();
        }
        return this.childrenDtos;
    }

}
