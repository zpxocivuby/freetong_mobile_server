
package itaf.WsUserTakeDeliveryAddressService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sysResourceDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sysResourceDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseTreeDto">
 *       &lt;sequence>
 *         &lt;element name="parentDto" type="{itaf.framework.ws.server.consumer}sysResourceDto" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameZh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isNav" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="childrenDtos" type="{itaf.framework.ws.server.consumer}sysResourceDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sysRoleDtos" type="{itaf.framework.ws.server.consumer}sysRoleDto" maxOccurs="unbounded" minOccurs="0"/>
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
     * Gets the value of the parentDto property.
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
     * Sets the value of the parentDto property.
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
     * Gets the value of the type property.
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
     * Sets the value of the type property.
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
     * Gets the value of the path property.
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
     * Sets the value of the path property.
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
     * Gets the value of the nameZh property.
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
     * Sets the value of the nameZh property.
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
     * Gets the value of the nameEn property.
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
     * Sets the value of the nameEn property.
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
     * Gets the value of the description property.
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
     * Sets the value of the description property.
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
     * Gets the value of the isNav property.
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
     * Sets the value of the isNav property.
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
