
package itaf.WsPaymentTypeService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sysRoleDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="sysRoleDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.order}baseDto">
 *       &lt;sequence>
 *         &lt;element name="nameZh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sysResourceDtos" type="{itaf.framework.ws.server.order}sysResourceDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sysUserDtos" type="{itaf.framework.ws.server.order}sysUserDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sysRoleDto", propOrder = {
    "nameZh",
    "nameEn",
    "description",
    "sysResourceDtos",
    "sysUserDtos"
})
public class SysRoleDto
    extends BaseDto
{

    protected String nameZh;
    protected String nameEn;
    protected String description;
    @XmlElement(nillable = true)
    protected List<SysResourceDto> sysResourceDtos;
    @XmlElement(nillable = true)
    protected List<SysUserDto> sysUserDtos;

    /**
     * ��ȡnameZh���Ե�ֵ��
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
     * ����nameZh���Ե�ֵ��
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
     * ��ȡnameEn���Ե�ֵ��
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
     * ����nameEn���Ե�ֵ��
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
     * ��ȡdescription���Ե�ֵ��
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
     * ����description���Ե�ֵ��
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
     * Gets the value of the sysResourceDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sysResourceDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSysResourceDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SysResourceDto }
     * 
     * 
     */
    public List<SysResourceDto> getSysResourceDtos() {
        if (sysResourceDtos == null) {
            sysResourceDtos = new ArrayList<SysResourceDto>();
        }
        return this.sysResourceDtos;
    }

    /**
     * Gets the value of the sysUserDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sysUserDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSysUserDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SysUserDto }
     * 
     * 
     */
    public List<SysUserDto> getSysUserDtos() {
        if (sysUserDtos == null) {
            sysUserDtos = new ArrayList<SysUserDto>();
        }
        return this.sysUserDtos;
    }

}
