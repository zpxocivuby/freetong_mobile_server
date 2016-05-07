
package itaf.WsOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzStockOrderItemDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取bzStockOrderDto属性的值。
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
     * 设置bzStockOrderDto属性的值。
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
     * 获取bzShelfDto属性的值。
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
     * 设置bzShelfDto属性的值。
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
     * 获取bzProductDto属性的值。
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
     * 设置bzProductDto属性的值。
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
     * 获取itemStatus属性的值。
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
     * 设置itemStatus属性的值。
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
     * 获取itemNum属性的值。
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
     * 设置itemNum属性的值。
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
