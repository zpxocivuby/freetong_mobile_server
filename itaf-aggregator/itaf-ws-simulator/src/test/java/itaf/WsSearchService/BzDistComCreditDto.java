
package itaf.WsSearchService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzDistComCreditDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzDistComCreditDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.search}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.search}sysUserDto" minOccurs="0"/>
 *         &lt;element name="creditRank" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzDistComCreditEvals" type="{itaf.framework.ws.server.search}bzDistComCreditEvalDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzDistComCreditDto", propOrder = {
    "sysUserDto",
    "creditRank",
    "bzDistComCreditEvals"
})
public class BzDistComCreditDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected Long creditRank;
    @XmlElement(nillable = true)
    protected List<BzDistComCreditEvalDto> bzDistComCreditEvals;

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
     * Gets the value of the creditRank property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreditRank() {
        return creditRank;
    }

    /**
     * Sets the value of the creditRank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreditRank(Long value) {
        this.creditRank = value;
    }

    /**
     * Gets the value of the bzDistComCreditEvals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzDistComCreditEvals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzDistComCreditEvals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzDistComCreditEvalDto }
     * 
     * 
     */
    public List<BzDistComCreditEvalDto> getBzDistComCreditEvals() {
        if (bzDistComCreditEvals == null) {
            bzDistComCreditEvals = new ArrayList<BzDistComCreditEvalDto>();
        }
        return this.bzDistComCreditEvals;
    }

}
