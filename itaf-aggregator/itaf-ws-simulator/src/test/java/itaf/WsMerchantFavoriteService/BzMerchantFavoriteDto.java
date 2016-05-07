
package itaf.WsMerchantFavoriteService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzMerchantFavoriteDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡsysUserBySysUserIdDto���Ե�ֵ��
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
     * ����sysUserBySysUserIdDto���Ե�ֵ��
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
     * ��ȡsysUserByBzMerchantIdDto���Ե�ֵ��
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
     * ����sysUserByBzMerchantIdDto���Ե�ֵ��
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
     * ��ȡmerchantType���Ե�ֵ��
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
     * ����merchantType���Ե�ֵ��
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
     * ��ȡtype���Ե�ֵ��
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
     * ����type���Ե�ֵ��
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
