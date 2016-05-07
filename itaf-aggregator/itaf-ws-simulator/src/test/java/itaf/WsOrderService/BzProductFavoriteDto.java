
package itaf.WsOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzProductFavoriteDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzProductFavoriteDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.order}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.order}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzProductDto" type="{itaf.framework.ws.server.order}bzProductDto" minOccurs="0"/>
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
@XmlType(name = "bzProductFavoriteDto", propOrder = {
    "sysUserDto",
    "bzProductDto",
    "type"
})
public class BzProductFavoriteDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected BzProductDto bzProductDto;
    protected String type;

    /**
     * ��ȡsysUserDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserDto() {
        return sysUserDto;
    }

    /**
     * ����sysUserDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserDto(SysUserDto value) {
        this.sysUserDto = value;
    }

    /**
     * ��ȡbzProductDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzProductDto }
     *     
     */
    public BzProductDto getBzProductDto() {
        return bzProductDto;
    }

    /**
     * ����bzProductDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzProductDto }
     *     
     */
    public void setBzProductDto(BzProductDto value) {
        this.bzProductDto = value;
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
