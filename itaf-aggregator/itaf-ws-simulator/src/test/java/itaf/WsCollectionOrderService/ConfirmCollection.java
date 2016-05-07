
package itaf.WsCollectionOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>confirmCollection complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取bzCollectionOrderDto属性的值。
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
     * 设置bzCollectionOrderDto属性的值。
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
