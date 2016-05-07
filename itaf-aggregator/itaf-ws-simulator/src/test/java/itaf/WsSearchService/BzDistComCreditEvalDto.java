
package itaf.WsSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for bzDistComCreditEvalDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzDistComCreditEvalDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.search}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.search}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzDistComCreditDto" type="{itaf.framework.ws.server.search}bzDistComCreditDto" minOccurs="0"/>
 *         &lt;element name="bzOrder" type="{itaf.framework.ws.server.search}bzOrderDto" minOccurs="0"/>
 *         &lt;element name="evaluateRank" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="evaluateContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="evaluateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzDistComCreditEvalDto", propOrder = {
    "sysUserDto",
    "bzDistComCreditDto",
    "bzOrder",
    "evaluateRank",
    "evaluateContent",
    "evaluateTime"
})
public class BzDistComCreditEvalDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected BzDistComCreditDto bzDistComCreditDto;
    protected BzOrderDto bzOrder;
    protected Long evaluateRank;
    protected String evaluateContent;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar evaluateTime;

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
     * Gets the value of the bzDistComCreditDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzDistComCreditDto }
     *     
     */
    public BzDistComCreditDto getBzDistComCreditDto() {
        return bzDistComCreditDto;
    }

    /**
     * Sets the value of the bzDistComCreditDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzDistComCreditDto }
     *     
     */
    public void setBzDistComCreditDto(BzDistComCreditDto value) {
        this.bzDistComCreditDto = value;
    }

    /**
     * Gets the value of the bzOrder property.
     * 
     * @return
     *     possible object is
     *     {@link BzOrderDto }
     *     
     */
    public BzOrderDto getBzOrder() {
        return bzOrder;
    }

    /**
     * Sets the value of the bzOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzOrderDto }
     *     
     */
    public void setBzOrder(BzOrderDto value) {
        this.bzOrder = value;
    }

    /**
     * Gets the value of the evaluateRank property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEvaluateRank() {
        return evaluateRank;
    }

    /**
     * Sets the value of the evaluateRank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEvaluateRank(Long value) {
        this.evaluateRank = value;
    }

    /**
     * Gets the value of the evaluateContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluateContent() {
        return evaluateContent;
    }

    /**
     * Sets the value of the evaluateContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluateContent(String value) {
        this.evaluateContent = value;
    }

    /**
     * Gets the value of the evaluateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEvaluateTime() {
        return evaluateTime;
    }

    /**
     * Sets the value of the evaluateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEvaluateTime(XMLGregorianCalendar value) {
        this.evaluateTime = value;
    }

}
