
package itaf.WsCartItemService;

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
 * <p>bzProductDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzProductDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.cart}operateDto">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.cart}sysUserDto" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="productPurchasePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="productColor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productOnSale" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isStockLimitless" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isShelfLimitless" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isStockSupport" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isShelfSupport" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzProductBrandDtos" type="{itaf.framework.ws.server.cart}bzProductBrandDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trProductStockDtos" type="{itaf.framework.ws.server.cart}trProductStockDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductCategorieDtos" type="{itaf.framework.ws.server.cart}bzProductCategoryDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductAttachmentDtos" type="{itaf.framework.ws.server.cart}bzProductAttachmentDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductEvaluationDtos" type="{itaf.framework.ws.server.cart}bzProductEvaluationDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzInvoiceItemDtos" type="{itaf.framework.ws.server.cart}bzInvoiceItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzPositionDtos" type="{itaf.framework.ws.server.cart}bzPositionDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzCartDtos" type="{itaf.framework.ws.server.cart}bzCartItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzStockOrderItemDtos" type="{itaf.framework.ws.server.cart}bzStockOrderItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductFavoriteDtos" type="{itaf.framework.ws.server.cart}bzProductFavoriteDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzOrderItemDtos" type="{itaf.framework.ws.server.cart}bzOrderItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzProductDto", propOrder = {
    "rest"
})
public class BzProductDto
    extends OperateDto
{

    @XmlElementRefs({
        @XmlElementRef(name = "bzProductFavoriteDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "isShelfSupport", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzProductAttachmentDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "productDescription", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sysUserDto", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzProductEvaluationDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "id", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "productColor", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzProductBrandDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzPositionDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzProductCategorieDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "productPrice", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "isStockSupport", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzInvoiceItemDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "productName", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzOrderItemDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "trProductStockDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "productPurchasePrice", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "isShelfLimitless", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "productOnSale", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "isStockLimitless", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzCartDtos", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bzStockOrderItemDtos", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * ��ȡ����ģ�͵����ಿ�֡�
     * 
     * <p>
     * ��������ԭ��, ����ȡ���Ǵ� "catch-all" ����: 
     * �ֶ����� "Id" ��ģʽ��������ͬ����ʹ�á������: 
     * http://localhost:8080/itaf-web-side/service/WsCartItemService?wsdl=WsCartItemService.wsdl#types1�ĵ� 0 ��
     * http://localhost:8080/itaf-web-side/service/WsCartItemService?wsdl=WsCartItemService.wsdl#types1�ĵ� 0 ��
     * <p>
     * Ҫ���������, �뽫���Զ�������Ӧ����������������
     * ������һ���Ը���������: 
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
     * {@link JAXBElement }{@code <}{@link BzProductFavoriteDto }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BzProductAttachmentDto }{@code >}
     * {@link JAXBElement }{@code <}{@link SysUserDto }{@code >}
     * {@link JAXBElement }{@code <}{@link BzProductEvaluationDto }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link BzProductBrandDto }{@code >}
     * {@link JAXBElement }{@code <}{@link BzPositionDto }{@code >}
     * {@link JAXBElement }{@code <}{@link BzProductCategoryDto }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link BzInvoiceItemDto }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link TrProductStockDto }{@code >}
     * {@link JAXBElement }{@code <}{@link BzOrderItemDto }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link BzCartItemDto }{@code >}
     * {@link JAXBElement }{@code <}{@link BzStockOrderItemDto }{@code >}
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
