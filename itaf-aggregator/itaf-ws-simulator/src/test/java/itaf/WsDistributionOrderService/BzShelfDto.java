
package itaf.WsDistributionOrderService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzShelfDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzShelfDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.merchant}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzProductId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="stockNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="soldNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzStockOrderItemDtos" type="{itaf.framework.ws.server.merchant}bzStockOrderItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzShelfDto", propOrder = {
    "sysUserDto",
    "bzProductId",
    "stockNum",
    "soldNum",
    "bzStockOrderItemDtos"
})
public class BzShelfDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected Long bzProductId;
    protected Long stockNum;
    protected Long soldNum;
    @XmlElement(nillable = true)
    protected List<BzStockOrderItemDto> bzStockOrderItemDtos;

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
     * 获取bzProductId属性的值。
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
     * 设置bzProductId属性的值。
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
     * 获取stockNum属性的值。
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
     * 设置stockNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStockNum(Long value) {
        this.stockNum = value;
    }

    /**
     * 获取soldNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSoldNum() {
        return soldNum;
    }

    /**
     * 设置soldNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSoldNum(Long value) {
        this.soldNum = value;
    }

    /**
     * Gets the value of the bzStockOrderItemDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzStockOrderItemDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzStockOrderItemDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzStockOrderItemDto }
     * 
     * 
     */
    public List<BzStockOrderItemDto> getBzStockOrderItemDtos() {
        if (bzStockOrderItemDtos == null) {
            bzStockOrderItemDtos = new ArrayList<BzStockOrderItemDto>();
        }
        return this.bzStockOrderItemDtos;
    }

}
