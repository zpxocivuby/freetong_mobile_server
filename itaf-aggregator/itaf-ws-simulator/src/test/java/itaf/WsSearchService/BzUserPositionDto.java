
package itaf.WsSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzUserPositionDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzUserPositionDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.search}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.search}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzPositionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzPositionDto" type="{itaf.framework.ws.server.search}bzPositionDto" minOccurs="0"/>
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
     * Gets the value of the sysUserId property.
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
     * Sets the value of the sysUserId property.
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
     * Gets the value of the sysUserDto property.
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
     * Sets the value of the sysUserDto property.
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
     * Gets the value of the bzPositionId property.
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
     * Sets the value of the bzPositionId property.
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
     * Gets the value of the bzPositionDto property.
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
     * Sets the value of the bzPositionDto property.
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
     * Gets the value of the serviceCoverage property.
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
     * Sets the value of the serviceCoverage property.
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
