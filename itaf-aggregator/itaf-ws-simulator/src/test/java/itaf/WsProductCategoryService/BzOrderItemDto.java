
package itaf.WsProductCategoryService;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzOrderItemDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzOrderItemDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}operateDto">
 *       &lt;sequence>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.product}bzOrderDto" minOccurs="0"/>
 *         &lt;element name="bzProductDto" type="{itaf.framework.ws.server.product}bzProductDto" minOccurs="0"/>
 *         &lt;element name="itemNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="itemUnitPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="itemDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="itemPreferential" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="itemAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="itemStockStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzOrderItemDto", propOrder = {
    "bzOrderDto",
    "bzProductDto",
    "itemNum",
    "itemUnitPrice",
    "itemDiscount",
    "itemPreferential",
    "itemAmount",
    "itemStockStatus"
})
public class BzOrderItemDto
    extends OperateDto
{

    protected BzOrderDto bzOrderDto;
    protected BzProductDto bzProductDto;
    protected Long itemNum;
    protected BigDecimal itemUnitPrice;
    protected BigDecimal itemDiscount;
    protected BigDecimal itemPreferential;
    protected BigDecimal itemAmount;
    protected Long itemStockStatus;

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

    /**
     * 获取itemUnitPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemUnitPrice() {
        return itemUnitPrice;
    }

    /**
     * 设置itemUnitPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemUnitPrice(BigDecimal value) {
        this.itemUnitPrice = value;
    }

    /**
     * 获取itemDiscount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemDiscount() {
        return itemDiscount;
    }

    /**
     * 设置itemDiscount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemDiscount(BigDecimal value) {
        this.itemDiscount = value;
    }

    /**
     * 获取itemPreferential属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemPreferential() {
        return itemPreferential;
    }

    /**
     * 设置itemPreferential属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemPreferential(BigDecimal value) {
        this.itemPreferential = value;
    }

    /**
     * 获取itemAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    /**
     * 设置itemAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemAmount(BigDecimal value) {
        this.itemAmount = value;
    }

    /**
     * 获取itemStockStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemStockStatus() {
        return itemStockStatus;
    }

    /**
     * 设置itemStockStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemStockStatus(Long value) {
        this.itemStockStatus = value;
    }

}
