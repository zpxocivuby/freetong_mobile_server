
package itaf.WsProductCategoryService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzProductCategoryDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzProductCategoryDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}operateDto">
 *       &lt;sequence>
 *         &lt;element name="bzProductCategoryDto" type="{itaf.framework.ws.server.product}bzProductCategoryDto" minOccurs="0"/>
 *         &lt;element name="categoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzProductDtos" type="{itaf.framework.ws.server.product}bzProductDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductCategorieDtos" type="{itaf.framework.ws.server.product}bzProductCategoryDto" maxOccurs="unbounded" minOccurs="0"/>
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
    "bzProductCategoryDto",
    "categoryName",
    "categoryCode",
    "level",
    "bzProductDtos",
    "bzProductCategorieDtos"
})
public class BzProductCategoryDto
    extends OperateDto
{

    protected BzProductCategoryDto bzProductCategoryDto;
    protected String categoryName;
    protected String categoryCode;
    protected Long level;
    @XmlElement(nillable = true)
    protected List<BzProductDto> bzProductDtos;
    @XmlElement(nillable = true)
    protected List<BzProductCategoryDto> bzProductCategorieDtos;

    /**
     * 获取bzProductCategoryDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzProductCategoryDto }
     *     
     */
    public BzProductCategoryDto getBzProductCategoryDto() {
        return bzProductCategoryDto;
    }

    /**
     * 设置bzProductCategoryDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzProductCategoryDto }
     *     
     */
    public void setBzProductCategoryDto(BzProductCategoryDto value) {
        this.bzProductCategoryDto = value;
    }

    /**
     * 获取categoryName属性的值。
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
     * 设置categoryName属性的值。
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
     * 获取categoryCode属性的值。
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
     * 设置categoryCode属性的值。
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
     * 获取level属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLevel() {
        return level;
    }

    /**
     * 设置level属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLevel(Long value) {
        this.level = value;
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
     * Gets the value of the bzProductCategorieDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzProductCategorieDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzProductCategorieDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzProductCategoryDto }
     * 
     * 
     */
    public List<BzProductCategoryDto> getBzProductCategorieDtos() {
        if (bzProductCategorieDtos == null) {
            bzProductCategorieDtos = new ArrayList<BzProductCategoryDto>();
        }
        return this.bzProductCategorieDtos;
    }

}
