
package itaf.WsCartItemService;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzOrderPaymentDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzOrderPaymentDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.cart}operateDto">
 *       &lt;sequence>
 *         &lt;element name="bzPaymentTypeDto" type="{itaf.framework.ws.server.cart}bzPaymentTypeDto" minOccurs="0"/>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.cart}bzOrderDto" minOccurs="0"/>
 *         &lt;element name="payStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="payAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzOrderPaymentDto", propOrder = {
    "bzPaymentTypeDto",
    "bzOrderDto",
    "payStatus",
    "payAmount"
})
public class BzOrderPaymentDto
    extends OperateDto
{

    protected BzPaymentTypeDto bzPaymentTypeDto;
    protected BzOrderDto bzOrderDto;
    protected Long payStatus;
    protected BigDecimal payAmount;

    /**
     * ��ȡbzPaymentTypeDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzPaymentTypeDto }
     *     
     */
    public BzPaymentTypeDto getBzPaymentTypeDto() {
        return bzPaymentTypeDto;
    }

    /**
     * ����bzPaymentTypeDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzPaymentTypeDto }
     *     
     */
    public void setBzPaymentTypeDto(BzPaymentTypeDto value) {
        this.bzPaymentTypeDto = value;
    }

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
     * ��ȡpayStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPayStatus() {
        return payStatus;
    }

    /**
     * ����payStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPayStatus(Long value) {
        this.payStatus = value;
    }

    /**
     * ��ȡpayAmount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * ����payAmount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayAmount(BigDecimal value) {
        this.payAmount = value;
    }

}
