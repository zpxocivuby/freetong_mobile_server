
package itaf.WsDistributionModelService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>bzMerchantCreditEvalDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzMerchantCreditEvalDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.merchant}bzOrderDto" minOccurs="0"/>
 *         &lt;element name="bzMerchantCreditDto" type="{itaf.framework.ws.server.merchant}bzMerchantCreditDto" minOccurs="0"/>
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
@XmlType(name = "bzMerchantCreditEvalDto", propOrder = {
    "bzOrderDto",
    "bzMerchantCreditDto",
    "evaluateRank",
    "evaluateContent",
    "evaluateTime"
})
public class BzMerchantCreditEvalDto
    extends BaseDto
{

    protected BzOrderDto bzOrderDto;
    protected BzMerchantCreditDto bzMerchantCreditDto;
    protected Long evaluateRank;
    protected String evaluateContent;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar evaluateTime;

    /**
     * ��ȡbzOrderDto���Ե�ֵ��
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
     * ����bzOrderDto���Ե�ֵ��
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
     * ��ȡbzMerchantCreditDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzMerchantCreditDto }
     *     
     */
    public BzMerchantCreditDto getBzMerchantCreditDto() {
        return bzMerchantCreditDto;
    }

    /**
     * ����bzMerchantCreditDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzMerchantCreditDto }
     *     
     */
    public void setBzMerchantCreditDto(BzMerchantCreditDto value) {
        this.bzMerchantCreditDto = value;
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
