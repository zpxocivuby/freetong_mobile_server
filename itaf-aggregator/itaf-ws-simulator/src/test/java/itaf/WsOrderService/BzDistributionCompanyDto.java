
package itaf.WsOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzDistributionCompanyDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzDistributionCompanyDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.order}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzServiceProviderTypeDto" type="{itaf.framework.ws.server.order}bzServiceProviderTypeDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzDistributionCompanyDto", propOrder = {
    "bzServiceProviderTypeDto"
})
public class BzDistributionCompanyDto
    extends BaseDto
{

    protected BzServiceProviderTypeDto bzServiceProviderTypeDto;

    /**
     * 获取bzServiceProviderTypeDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzServiceProviderTypeDto }
     *     
     */
    public BzServiceProviderTypeDto getBzServiceProviderTypeDto() {
        return bzServiceProviderTypeDto;
    }

    /**
     * 设置bzServiceProviderTypeDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzServiceProviderTypeDto }
     *     
     */
    public void setBzServiceProviderTypeDto(BzServiceProviderTypeDto value) {
        this.bzServiceProviderTypeDto = value;
    }

}
