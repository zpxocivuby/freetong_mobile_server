
package itaf.WsProductCategoryService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzUserPositionDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzUserPositionDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}operateDto">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzPosition" type="{itaf.framework.ws.server.product}bzPositionDto" minOccurs="0"/>
 *         &lt;element name="serviceCoverage" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzUserPositionDto", propOrder = {
    "rest"
})
public class BzUserPositionDto
    extends OperateDto
{

    @XmlElementRefs({
        @XmlElementRef(name = "bzPosition", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sysUserDto", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "serviceCoverage", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "id", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * ��ȡ����ģ�͵����ಿ�֡�
     * 
     * <p>
     * ��������ԭ��, ����ȡ���Ǵ� "catch-all" ����: 
     * �ֶ����� "Id" ��ģʽ��������ͬ����ʹ�á������: 
     * http://localhost:8080/itaf-web-side/service/WsProductCategoryService?wsdl=WsProductCategoryService.wsdl#types1�ĵ� 0 ��
     * http://localhost:8080/itaf-web-side/service/WsProductCategoryService?wsdl=WsProductCategoryService.wsdl#types1�ĵ� 0 ��
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
     * {@link JAXBElement }{@code <}{@link BzPositionDto }{@code >}
     * {@link JAXBElement }{@code <}{@link SysUserDto }{@code >}
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
