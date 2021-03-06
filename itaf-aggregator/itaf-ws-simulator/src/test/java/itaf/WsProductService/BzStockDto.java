
package itaf.WsProductService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzStockDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzStockDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}operateDto">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="stockLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stockNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="stockType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deductionNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="inTransitNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="trProductStockDtos" type="{itaf.framework.ws.server.product}trProductStockDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzStockDto", propOrder = {
    "rest"
})
public class BzStockDto
    extends OperateDto
{

    @XmlElementRefs({
        @XmlElementRef(name = "trProductStockDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stockType", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sysUserDto", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "deductionNum", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "id", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stockLocation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "inTransitNum", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stockNum", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * 获取内容模型的其余部分。
     * 
     * <p>
     * 由于以下原因, 您获取的是此 "catch-all" 属性: 
     * 字段名称 "Id" 由模式的两个不同部分使用。请参阅: 
     * http://localhost:8080/itaf-web-side/service/WsProductService?wsdl=WsProductService.wsdl#types1的第 0 行
     * http://localhost:8080/itaf-web-side/service/WsProductService?wsdl=WsProductService.wsdl#types1的第 0 行
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
     * {@link JAXBElement }{@code <}{@link TrProductStockDto }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link SysUserDto }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
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
