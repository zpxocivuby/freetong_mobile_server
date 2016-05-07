
package itaf.WsOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzStockOrderItemDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzStockOrderItemDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.order}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzStockOrderDto" type="{itaf.framework.ws.server.order}bzStockOrderDto" minOccurs="0"/>
 *         &lt;element name="bzShelfDto" type="{itaf.framework.ws.server.order}bzShelfDto" minOccurs="0"/>
 *         &lt;element name="bzProductDto" type="{itaf.framework.ws.server.order}bzProductDto" minOccurs="0"/>
 *         &lt;element name="itemStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
@XmlType(name = "bzStockOrderItemDto", propOrder = {
    "bzStockOrderDto",
    "bzShelfDto",
    "bzProductDto",
    "itemStatus",
    "itemNum"
})
public class BzStockOrderItemDto
    extends BaseDto
{

    protected BzStockOrderDto bzStockOrderDto;
    protected BzShelfDto bzShelfDto;
    protected BzProductDto bzProductDto;
    protected Long itemStatus;
    protected Long itemNum;

    /**
     * ��ȡbzStockOrderDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzStockOrderDto }
     *     
     */
    public BzStockOrderDto getBzStockOrderDto() {
        return bzStockOrderDto;
    }

    /**
     * ����bzStockOrderDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzStockOrderDto }
     *     
     */
    public void setBzStockOrderDto(BzStockOrderDto value) {
        this.bzStockOrderDto = value;
    }

    /**
     * ��ȡbzShelfDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzShelfDto }
     *     
     */
    public BzShelfDto getBzShelfDto() {
        return bzShelfDto;
    }

    /**
     * ����bzShelfDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzShelfDto }
     *     
     */
    public void setBzShelfDto(BzShelfDto value) {
        this.bzShelfDto = value;
    }

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
     * ��ȡitemStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemStatus() {
        return itemStatus;
    }

    /**
     * ����itemStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemStatus(Long value) {
        this.itemStatus = value;
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
