
package itaf.WsCartItemService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>bzConsumerCreditEvalDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzConsumerCreditEvalDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.cart}operateDto">
 *       &lt;sequence>
 *         &lt;element name="bzConsumerCreditDto" type="{itaf.framework.ws.server.cart}bzConsumerCreditDto" minOccurs="0"/>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.cart}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.cart}bzOrderDto" minOccurs="0"/>
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
    extends OperateDto
{

    protected BzConsumerCreditDto bzConsumerCreditDto;
    protected SysUserDto sysUserDto;
    protected BzOrderDto bzOrderDto;
    protected Long evaluateRank;
    protected String evaluateContent;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar evaluateTime;

    /**
     * 获取bzConsumerCreditDto属性的值。
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
     * 设置bzConsumerCreditDto属性的值。
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
     * 获取bzOrderDto属性的值。
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
     * 设置bzOrderDto属性的值。
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
     * 获取evaluateRank属性的值。
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
     * 设置evaluateRank属性的值。
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
     * 获取evaluateContent属性的值。
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
     * 设置evaluateContent属性的值。
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
     * 获取evaluateTime属性的值。
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
     * 设置evaluateTime属性的值。
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
