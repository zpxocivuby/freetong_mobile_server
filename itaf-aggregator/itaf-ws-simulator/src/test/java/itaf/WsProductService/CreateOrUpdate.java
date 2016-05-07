
package itaf.WsProductService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>createOrUpdate complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="createOrUpdate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="dto" type="{itaf.framework.ws.server.product}bzProductDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createOrUpdate", propOrder = {
    "userId",
    "dto"
})
public class CreateOrUpdate {

    protected Long userId;
    protected BzProductDto dto;

    /**
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserId(Long value) {
        this.userId = value;
    }

    /**
     * 获取dto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzProductDto }
     *     
     */
    public BzProductDto getDto() {
        return dto;
    }

    /**
     * 设置dto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzProductDto }
     *     
     */
    public void setDto(BzProductDto value) {
        this.dto = value;
    }

}
