
package itaf.WsDistributionModelService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>trProductStockDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="trProductStockDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="idDto" type="{itaf.framework.ws.server.merchant}trProductStockIdDto" minOccurs="0"/>
 *         &lt;element name="bzStockDto" type="{itaf.framework.ws.server.merchant}bzStockDto" minOccurs="0"/>
 *         &lt;element name="bzProductDto" type="{itaf.framework.ws.server.merchant}bzProductDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trProductStockDto", propOrder = {
    "idDto",
    "bzStockDto",
    "bzProductDto"
})
public class TrProductStockDto
    extends BaseDto
{

    protected TrProductStockIdDto idDto;
    protected BzStockDto bzStockDto;
    protected BzProductDto bzProductDto;

    /**
     * 获取idDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TrProductStockIdDto }
     *     
     */
    public TrProductStockIdDto getIdDto() {
        return idDto;
    }

    /**
     * 设置idDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TrProductStockIdDto }
     *     
     */
    public void setIdDto(TrProductStockIdDto value) {
        this.idDto = value;
    }

    /**
     * 获取bzStockDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzStockDto }
     *     
     */
    public BzStockDto getBzStockDto() {
        return bzStockDto;
    }

    /**
     * 设置bzStockDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzStockDto }
     *     
     */
    public void setBzStockDto(BzStockDto value) {
        this.bzStockDto = value;
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

}
