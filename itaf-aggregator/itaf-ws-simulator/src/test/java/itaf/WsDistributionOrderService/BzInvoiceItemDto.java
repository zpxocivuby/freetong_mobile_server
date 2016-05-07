
package itaf.WsDistributionOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzInvoiceItemDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzInvoiceItemDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzProductDto" type="{itaf.framework.ws.server.merchant}bzProductDto" minOccurs="0"/>
 *         &lt;element name="bzInvoiceDto" type="{itaf.framework.ws.server.merchant}bzInvoiceDto" minOccurs="0"/>
 *         &lt;element name="itemNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzInvoiceItemDto", propOrder = {
    "bzProductDto",
    "bzInvoiceDto",
    "itemNum"
})
public class BzInvoiceItemDto
    extends BaseDto
{

    protected BzProductDto bzProductDto;
    protected BzInvoiceDto bzInvoiceDto;
    protected Long itemNum;

    /**
     * ��ȡbzProductDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzProductDto }
     *     
     */
    public BzProductDto getBzProductDto() {
        return bzProductDto;
    }

    /**
     * ����bzProductDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzProductDto }
     *     
     */
    public void setBzProductDto(BzProductDto value) {
        this.bzProductDto = value;
    }

    /**
     * ��ȡbzInvoiceDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzInvoiceDto }
     *     
     */
    public BzInvoiceDto getBzInvoiceDto() {
        return bzInvoiceDto;
    }

    /**
     * ����bzInvoiceDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzInvoiceDto }
     *     
     */
    public void setBzInvoiceDto(BzInvoiceDto value) {
        this.bzInvoiceDto = value;
    }

    /**
     * ��ȡitemNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemNum() {
        return itemNum;
    }

    /**
     * ����itemNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemNum(Long value) {
        this.itemNum = value;
    }

}
