
package itaf.WsMerchantService;

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
 *     &lt;extension base="{itaf.framework.ws.server.merchant}operateDto">
 *       &lt;sequence>
 *         &lt;element name="bzServiceProviderTypeDto" type="{itaf.framework.ws.server.merchant}bzServiceProviderTypeDto" minOccurs="0"/>
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzServiceProviderTypeDtos" type="{itaf.framework.ws.server.merchant}bzServiceProviderTypeDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzDistributionCompanieDtos" type="{itaf.framework.ws.server.merchant}bzDistributionCompanyDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzMerchantDtos" type="{itaf.framework.ws.server.merchant}bzMerchantDto" maxOccurs="unbounded" minOccurs="0"/>
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
    "bzServiceProviderTypeDto",
    "typeName",
    "typeCode",
    "level",
    "bzServiceProviderTypeDtos",
    "bzDistributionCompanieDtos",
    "bzMerchantDtos"
})
public class BzServiceProviderTypeDto
    extends OperateDto
{

    protected BzServiceProviderTypeDto bzServiceProviderTypeDto;
    protected String typeName;
    protected String typeCode;
    protected Long level;
    @XmlElement(nillable = true)
    protected List<BzServiceProviderTypeDto> bzServiceProviderTypeDtos;
    @XmlElement(nillable = true)
    protected List<BzDistributionCompanyDto> bzDistributionCompanieDtos;
    @XmlElement(nillable = true)
    protected List<BzMerchantDto> bzMerchantDtos;

    /**
     * 获取bzServiceProviderTypeDto属性的值。
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
     * 设置bzServiceProviderTypeDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzServiceProviderTypeDto }
     *     
     */
    public void setBzServiceProviderTypeDto(BzServiceProviderTypeDto value) {
        this.bzServiceProviderTypeDto = value;
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
     * Gets the value of the bzServiceProviderTypeDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzServiceProviderTypeDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzServiceProviderTypeDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzServiceProviderTypeDto }
     * 
     * 
     */
    public List<BzServiceProviderTypeDto> getBzServiceProviderTypeDtos() {
        if (bzServiceProviderTypeDtos == null) {
            bzServiceProviderTypeDtos = new ArrayList<BzServiceProviderTypeDto>();
        }
        return this.bzServiceProviderTypeDtos;
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
