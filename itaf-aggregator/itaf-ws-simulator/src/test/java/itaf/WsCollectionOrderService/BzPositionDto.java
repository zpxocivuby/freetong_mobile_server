
package itaf.WsCollectionOrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzPositionDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzPositionDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}operateDto">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="z" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="bzUserPositionDtos" type="{itaf.framework.ws.server.merchant}bzUserPositionDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzUserDeliveryAddresseDtos" type="{itaf.framework.ws.server.merchant}bzUserDeliveryAddressDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductDtos" type="{itaf.framework.ws.server.merchant}bzProductDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzUserTakeDeliveryAddresseDtos" type="{itaf.framework.ws.server.merchant}bzUserTakeDeliveryAddressDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzPositionDto", propOrder = {
    "rest"
})
public class BzPositionDto
    extends OperateDto
{

    @XmlElementRefs({
        @XmlElementRef(name = "z", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "y", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "id", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzProductDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzUserTakeDeliveryAddresseDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzUserPositionDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "x", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzUserDeliveryAddresseDtos", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * 获取内容模型的其余部分。
     * 
     * <p>
     * 由于以下原因, 您获取的是此 "catch-all" 属性: 
     * 字段名称 "Id" 由模式的两个不同部分使用。请参阅: 
     * http://localhost:8080/itaf-web-side/service/WsCollectionOrderService?wsdl=WsCollectionOrderService.wsdl#types1的第 0 行
     * http://localhost:8080/itaf-web-side/service/WsCollectionOrderService?wsdl=WsCollectionOrderService.wsdl#types1的第 0 行
     * <p>
     * 要清除此属性, 请将属性定制设置应用于以下两个声明
     * 或其中一个以更改其名称: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link BzProductDto }{@code >}
     * {@link JAXBElement }{@code <}{@link BzUserTakeDeliveryAddressDto }{@code >}
     * {@link JAXBElement }{@code <}{@link BzUserPositionDto }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BzUserDeliveryAddressDto }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
        }
        return this.rest;
    }

}
