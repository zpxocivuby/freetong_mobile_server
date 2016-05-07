
package itaf.WsUserTakeDeliveryAddressService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for bzConsumerCreditEvalDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzConsumerCreditEvalDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzConsumerCreditDto" type="{itaf.framework.ws.server.consumer}bzConsumerCreditDto" minOccurs="0"/>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.consumer}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.consumer}bzOrderDto" minOccurs="0"/>
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
@XmlType(name = "bzConsumerCreditEvalDto", propOrder = {
    "bzConsumerCreditDto",
    "sysUserDto",
    "bzOrderDto",
    "evaluateRank",
    "evaluateContent",
    "evaluateTime"
})
public class BzConsumerCreditEvalDto
    extends BaseDto
{

    protected BzConsumerCreditDto bzConsumerCreditDto;
    protected SysUserDto sysUserDto;
    protected BzOrderDto bzOrderDto;
    protected Long evaluateRank;
    protected String evaluateContent;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar evaluateTime;

    /**
     * Gets the value of the bzConsumerCreditDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzConsumerCreditDto }
     *     
     */
    public BzConsumerCreditDto getBzConsumerCreditDto() {
        return bzConsumerCreditDto;
    }

    /**
     * Sets the value of the bzConsumerCreditDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzConsumerCreditDto }
     *     
     */
    public void setBzConsumerCreditDto(BzConsumerCreditDto value) {
        this.bzConsumerCreditDto = value;
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
     * Gets the value of the bzOrderDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzOrderDto }
     *     
     */
    public BzOrderDto getBzOrderDto() {
        return bzOrderDto;
    }

    /**
     * Sets the value of the bzOrderDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzOrderDto }
     *     
     */
    public void setBzOrderDto(BzOrderDto value) {
        this.bzOrderDto = value;
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
