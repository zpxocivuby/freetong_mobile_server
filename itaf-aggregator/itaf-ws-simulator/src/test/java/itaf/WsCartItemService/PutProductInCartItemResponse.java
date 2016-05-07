
package itaf.WsCartItemService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>putProductInCartItemResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="putProductInCartItemResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{itaf.framework.ws.server.cart}wsPageResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putProductInCartItemResponse", propOrder = {
    "_return"
})
public class PutProductInCartItemResponse {

    @XmlElement(name = "return")
    protected WsPageResult _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WsPageResult }
     *     
     */
    public WsPageResult getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WsPageResult }
     *     
     */
    public void setReturn(WsPageResult value) {
        this._return = value;
    }

}
