
package itaf.WsDistributionServiceApplyService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>create complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="create">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dto" type="{itaf.framework.ws.server.certificate}bzDistServiceApplyDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "create", propOrder = {
    "dto"
})
public class Create {

    protected BzDistServiceApplyDto dto;

    /**
     * ��ȡdto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzDistServiceApplyDto }
     *     
     */
    public BzDistServiceApplyDto getDto() {
        return dto;
    }

    /**
     * ����dto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzDistServiceApplyDto }
     *     
     */
    public void setDto(BzDistServiceApplyDto value) {
        this.dto = value;
    }

}
