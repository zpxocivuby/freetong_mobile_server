
package itaf.WsMerchantFavoriteService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzMerchantFavoriteDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzMerchantFavoriteDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserBySysUserIdDto" type="{itaf.framework.ws.server.merchant}sysUserDto" minOccurs="0"/>
 *         &lt;element name="sysUserByBzMerchantIdDto" type="{itaf.framework.ws.server.merchant}sysUserDto" minOccurs="0"/>
 *         &lt;element name="merchantType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzMerchantFavoriteDto", propOrder = {
    "sysUserBySysUserIdDto",
    "sysUserByBzMerchantIdDto",
    "merchantType",
    "type"
})
public class BzMerchantFavoriteDto
    extends BaseDto
{

    protected SysUserDto sysUserBySysUserIdDto;
    protected SysUserDto sysUserByBzMerchantIdDto;
    protected Long merchantType;
    protected String type;

    /**
     * 获取sysUserBySysUserIdDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserBySysUserIdDto() {
        return sysUserBySysUserIdDto;
    }

    /**
     * 设置sysUserBySysUserIdDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserBySysUserIdDto(SysUserDto value) {
        this.sysUserBySysUserIdDto = value;
    }

    /**
     * 获取sysUserByBzMerchantIdDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserByBzMerchantIdDto() {
        return sysUserByBzMerchantIdDto;
    }

    /**
     * 设置sysUserByBzMerchantIdDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserByBzMerchantIdDto(SysUserDto value) {
        this.sysUserByBzMerchantIdDto = value;
    }

    /**
     * 获取merchantType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMerchantType() {
        return merchantType;
    }

    /**
     * 设置merchantType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMerchantType(Long value) {
        this.merchantType = value;
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

}
