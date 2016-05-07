
package itaf.WsDistributionModelService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>bzDistComCreditEvalDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡbzDistComCreditDto���Ե�ֵ��
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
     * ����bzDistComCreditDto���Ե�ֵ��
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
     * ��ȡbzOrder���Ե�ֵ��
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
     * ����bzOrder���Ե�ֵ��
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
     * ��ȡevaluateRank���Ե�ֵ��
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
     * ����evaluateRank���Ե�ֵ��
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
     * ��ȡevaluateContent���Ե�ֵ��
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
     * ����evaluateContent���Ե�ֵ��
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
     * ��ȡevaluateTime���Ե�ֵ��
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
     * ����evaluateTime���Ե�ֵ��
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
