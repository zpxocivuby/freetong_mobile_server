
package itaf.WsOrderService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzServiceProviderTypeDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzServiceProviderTypeDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.order}baseTreeDto">
 *       &lt;sequence>
 *         &lt;element name="parentDto" type="{itaf.framework.ws.server.order}bzServiceProviderTypeDto" minOccurs="0"/>
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenDtos" type="{itaf.framework.ws.server.order}bzServiceProviderTypeDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzDistributionCompanieDtos" type="{itaf.framework.ws.server.order}bzDistributionCompanyDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzMerchantDtos" type="{itaf.framework.ws.server.order}bzMerchantDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzServiceProviderTypeDto", propOrder = {
    "parentDto",
    "typeName",
    "typeCode",
    "childrenDtos",
    "bzDistributionCompanieDtos",
    "bzMerchantDtos"
})
public class BzServiceProviderTypeDto
    extends BaseTreeDto
{

    protected BzServiceProviderTypeDto parentDto;
    protected String typeName;
    protected String typeCode;
    @XmlElement(nillable = true)
    protected List<BzServiceProviderTypeDto> childrenDtos;
    @XmlElement(nillable = true)
    protected List<BzDistributionCompanyDto> bzDistributionCompanieDtos;
    @XmlElement(nillable = true)
    protected List<BzMerchantDto> bzMerchantDtos;

    /**
     * 获取parentDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzServiceProviderTypeDto }
     *     
     */
    public BzServiceProviderTypeDto getParentDto() {
        return parentDto;
    }

    /**
     * 设置parentDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzServiceProviderTypeDto }
     *     
     */
    public void setParentDto(BzServiceProviderTypeDto value) {
        this.parentDto = value;
    }

    /**
     * 获取typeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置typeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * 获取typeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * 设置typeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCode(String value) {
        this.typeCode = value;
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
     * {@link BzServiceProviderTypeDto }
     * 
     * 
     */
    public List<BzServiceProviderTypeDto> getChildrenDtos() {
        if (childrenDtos == null) {
            childrenDtos = new ArrayList<BzServiceProviderTypeDto>();
        }
        return this.childrenDtos;
    }

    /**
     * Gets the value of the bzDistributionCompanieDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzDistributionCompanieDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzDistributionCompanieDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzDistributionCompanyDto }
     * 
     * 
     */
    public List<BzDistributionCompanyDto> getBzDistributionCompanieDtos() {
        if (bzDistributionCompanieDtos == null) {
            bzDistributionCompanieDtos = new ArrayList<BzDistributionCompanyDto>();
        }
        return this.bzDistributionCompanieDtos;
    }

    /**
     * Gets the value of the bzMerchantDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzMerchantDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzMerchantDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzMerchantDto }
     * 
     * 
     */
    public List<BzMerchantDto> getBzMerchantDtos() {
        if (bzMerchantDtos == null) {
            bzMerchantDtos = new ArrayList<BzMerchantDto>();
        }
        return this.bzMerchantDtos;
    }

}
