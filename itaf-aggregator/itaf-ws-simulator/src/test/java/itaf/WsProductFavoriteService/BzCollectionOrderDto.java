
package itaf.WsProductFavoriteService;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzCollectionOrderDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡbzDistributionOrderDto���Ե�ֵ��
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
     * ����bzDistributionOrderDto���Ե�ֵ��
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
     * ��ȡreceivableAmount���Ե�ֵ��
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
     * ����receivableAmount���Ե�ֵ��
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
     * ��ȡactualAmount���Ե�ֵ��
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
     * ����actualAmount���Ե�ֵ��
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
     * ��ȡdistributionAmount���Ե�ֵ��
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
     * ����distributionAmount���Ե�ֵ��
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
