
package itaf.WsProductService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>trProductStockIdDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="trProductStockIdDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}operateDto">
 *       &lt;sequence>
 *         &lt;element name="bzProductId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzStockId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="stockNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trProductStockIdDto", propOrder = {
    "bzProductId",
    "bzStockId",
    "stockNum"
})
public class TrProductStockIdDto
    extends OperateDto
{

    protected Long bzProductId;
    protected Long bzStockId;
    protected Long stockNum;

    /**
     * ��ȡbzProductId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzProductId() {
        return bzProductId;
    }

    /**
     * ����bzProductId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzProductId(Long value) {
        this.bzProductId = value;
    }

    /**
     * ��ȡbzStockId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzStockId() {
        return bzStockId;
    }

    /**
     * ����bzStockId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzStockId(Long value) {
        this.bzStockId = value;
    }

    /**
     * ��ȡstockNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStockNum() {
        return stockNum;
    }

    /**
     * ����stockNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStockNum(Long value) {
        this.stockNum = value;
    }

}
