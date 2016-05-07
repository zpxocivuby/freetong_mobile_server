
package itaf.WsDistributionServiceApplyService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>create complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取dto属性的值。
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
     * 设置dto属性的值。
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
