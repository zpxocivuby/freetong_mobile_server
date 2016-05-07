
package itaf.WsDistributionModelService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>bzDistComCreditEvalDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzDistComCreditEvalDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.merchant}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzDistComCreditDto" type="{itaf.framework.ws.server.merchant}bzDistComCreditDto" minOccurs="0"/>
 *         &lt;element name="bzOrder" type="{itaf.framework.ws.server.merchant}bzOrderDto" minOccurs="0"/>
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
     * 获取bzDistComCreditDto属性的值。
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
     * 设置bzDistComCreditDto属性的值。
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
     * 获取bzOrder属性的值。
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
     * 设置bzOrder属性的值。
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
