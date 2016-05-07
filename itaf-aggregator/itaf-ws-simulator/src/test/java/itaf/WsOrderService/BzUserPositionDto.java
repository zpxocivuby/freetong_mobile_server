
package itaf.WsOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzUserPositionDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzUserPositionDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.order}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.order}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzPositionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzPositionDto" type="{itaf.framework.ws.server.order}bzPositionDto" minOccurs="0"/>
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
    "sysUserId",
    "sysUserDto",
    "bzPositionId",
    "bzPositionDto",
    "serviceCoverage"
})
public class BzUserPositionDto
    extends BaseDto
{

    protected Long sysUserId;
    protected SysUserDto sysUserDto;
    protected Long bzPositionId;
    protected BzPositionDto bzPositionDto;
    protected Long serviceCoverage;

    /**
     * 获取sysUserId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置sysUserId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSysUserId(Long value) {
        this.sysUserId = value;
    }

    /**
     * 获取sysUserDto属性的值。
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
     * 设置sysUserDto属性的值。
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
     * 获取bzPositionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzPositionId() {
        return bzPositionId;
    }

    /**
     * 设置bzPositionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzPositionId(Long value) {
        this.bzPositionId = value;
    }

    /**
     * 获取bzPositionDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzPositionDto }
     *     
     */
    public BzPositionDto getBzPositionDto() {
        return bzPositionDto;
    }

    /**
     * 设置bzPositionDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzPositionDto }
     *     
     */
    public void setBzPositionDto(BzPositionDto value) {
        this.bzPositionDto = value;
    }

    /**
     * 获取serviceCoverage属性的值。
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
     * 设置serviceCoverage属性的值。
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
