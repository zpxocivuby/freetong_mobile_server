
package itaf.WsProductFavoriteService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzUserPositionDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzUserPositionDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzPosition" type="{itaf.framework.ws.server.product}bzPositionDto" minOccurs="0"/>
 *         &lt;element name="serviceCoverage" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzUserPositionDto", propOrder = {
    "sysUserDto",
    "bzPosition",
    "serviceCoverage"
})
public class BzUserPositionDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected BzPositionDto bzPosition;
    protected Long serviceCoverage;

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
     * ��ȡbzPosition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzPositionDto }
     *     
     */
    public BzPositionDto getBzPosition() {
        return bzPosition;
    }

    /**
     * ����bzPosition���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzPositionDto }
     *     
     */
    public void setBzPosition(BzPositionDto value) {
        this.bzPosition = value;
    }

    /**
     * ��ȡserviceCoverage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getServiceCoverage() {
        return serviceCoverage;
    }

    /**
     * ����serviceCoverage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setServiceCoverage(Long value) {
        this.serviceCoverage = value;
    }

}
