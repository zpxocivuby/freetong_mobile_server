
package itaf.WsOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzDistributionCompanyDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡbzServiceProviderTypeDto���Ե�ֵ��
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
     * ����bzServiceProviderTypeDto���Ե�ֵ��
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
