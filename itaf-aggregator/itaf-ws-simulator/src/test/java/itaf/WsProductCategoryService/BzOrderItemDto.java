
package itaf.WsProductCategoryService;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzOrderItemDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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

    /**
     * ��ȡitemUnitPrice���Ե�ֵ��
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
     * ����itemUnitPrice���Ե�ֵ��
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
     * ��ȡitemDiscount���Ե�ֵ��
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
     * ����itemDiscount���Ե�ֵ��
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
     * ��ȡitemPreferential���Ե�ֵ��
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
     * ����itemPreferential���Ե�ֵ��
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
     * ��ȡitemAmount���Ե�ֵ��
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
     * ����itemAmount���Ե�ֵ��
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
     * ��ȡitemStockStatus���Ե�ֵ��
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
     * ����itemStockStatus���Ե�ֵ��
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
