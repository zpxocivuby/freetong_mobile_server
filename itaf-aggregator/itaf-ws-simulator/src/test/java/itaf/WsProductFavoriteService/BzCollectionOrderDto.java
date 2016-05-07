
package itaf.WsProductFavoriteService;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzCollectionOrderDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzCollectionOrderDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzDistributionOrderDto" type="{itaf.framework.ws.server.product}bzDistributionOrderDto" minOccurs="0"/>
 *         &lt;element name="receivableAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="actualAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="distributionAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzCollectionOrderDto", propOrder = {
    "bzDistributionOrderDto",
    "receivableAmount",
    "actualAmount",
    "distributionAmount"
})
public class BzCollectionOrderDto
    extends BaseDto
{

    protected BzDistributionOrderDto bzDistributionOrderDto;
    protected BigDecimal receivableAmount;
    protected BigDecimal actualAmount;
    protected BigDecimal distributionAmount;

    /**
     * 获取bzDistributionOrderDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzDistributionOrderDto }
     *     
     */
    public BzDistributionOrderDto getBzDistributionOrderDto() {
        return bzDistributionOrderDto;
    }

    /**
     * 设置bzDistributionOrderDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzDistributionOrderDto }
     *     
     */
    public void setBzDistributionOrderDto(BzDistributionOrderDto value) {
        this.bzDistributionOrderDto = value;
    }

    /**
     * 获取receivableAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    /**
     * 设置receivableAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReceivableAmount(BigDecimal value) {
        this.receivableAmount = value;
    }

    /**
     * 获取actualAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    /**
     * 设置actualAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setActualAmount(BigDecimal value) {
        this.actualAmount = value;
    }

    /**
     * 获取distributionAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDistributionAmount() {
        return distributionAmount;
    }

    /**
     * 设置distributionAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDistributionAmount(BigDecimal value) {
        this.distributionAmount = value;
    }

}
