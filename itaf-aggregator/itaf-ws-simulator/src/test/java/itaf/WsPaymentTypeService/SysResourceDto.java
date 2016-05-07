
package itaf.WsPaymentTypeService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sysResourceDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="sysResourceDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.order}baseTreeDto">
 *       &lt;sequence>
 *         &lt;element name="parentDto" type="{itaf.framework.ws.server.order}sysResourceDto" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameZh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isNav" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="childrenDtos" type="{itaf.framework.ws.server.order}sysResourceDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sysRoleDtos" type="{itaf.framework.ws.server.order}sysRoleDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sysResourceDto", propOrder = {
    "parentDto",
    "type",
    "path",
    "nameZh",
    "nameEn",
    "description",
    "isNav",
    "childrenDtos",
    "sysRoleDtos"
})
public class SysResourceDto
    extends BaseTreeDto
{

    protected SysResourceDto parentDto;
    protected String type;
    protected String path;
    protected String nameZh;
    protected String nameEn;
    protected String description;
    protected Boolean isNav;
    @XmlElement(nillable = true)
    protected List<SysResourceDto> childrenDtos;
    @XmlElement(nillable = true)
    protected List<SysRoleDto> sysRoleDtos;

    /**
     * 获取parentDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SysResourceDto }
     *     
     */
    public SysResourceDto getParentDto() {
        return parentDto;
    }

    /**
     * 设置parentDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SysResourceDto }
     *     
     */
    public void setParentDto(SysResourceDto value) {
        this.parentDto = value;
    }

    /**
     * 获取type属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * 设置type属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * 获取path属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置path属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * 获取nameZh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameZh() {
        return nameZh;
    }

    /**
     * 设置nameZh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameZh(String value) {
        this.nameZh = value;
    }

    /**
     * 获取nameEn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * 设置nameEn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameEn(String value) {
        this.nameEn = value;
    }

    /**
     * 获取description属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置description属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 获取isNav属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNav() {
        return isNav;
    }

    /**
     * 设置isNav属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNav(Boolean value) {
        this.isNav = value;
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
     * {@link SysResourceDto }
     * 
     * 
     */
    public List<SysResourceDto> getChildrenDtos() {
        if (childrenDtos == null) {
            childrenDtos = new ArrayList<SysResourceDto>();
        }
        return this.childrenDtos;
    }

    /**
     * Gets the value of the sysRoleDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sysRoleDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSysRoleDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SysRoleDto }
     * 
     * 
     */
    public List<SysRoleDto> getSysRoleDtos() {
        if (sysRoleDtos == null) {
            sysRoleDtos = new ArrayList<SysRoleDto>();
        }
        return this.sysRoleDtos;
    }

}
