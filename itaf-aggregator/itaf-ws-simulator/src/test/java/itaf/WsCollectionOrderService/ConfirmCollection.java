
package itaf.WsCollectionOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>confirmCollection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="confirmCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bzCollectionOrderDto" type="{itaf.framework.ws.server.merchant}bzCollectionOrderDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmCollection", propOrder = {
    "bzCollectionOrderDto"
})
public class ConfirmCollection {

    protected BzCollectionOrderDto bzCollectionOrderDto;

    /**
     * ��ȡbzCollectionOrderDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzCollectionOrderDto }
     *     
     */
    public BzCollectionOrderDto getBzCollectionOrderDto() {
        return bzCollectionOrderDto;
    }

    /**
     * ����bzCollectionOrderDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzCollectionOrderDto }
     *     
     */
    public void setBzCollectionOrderDto(BzCollectionOrderDto value) {
        this.bzCollectionOrderDto = value;
    }

}
