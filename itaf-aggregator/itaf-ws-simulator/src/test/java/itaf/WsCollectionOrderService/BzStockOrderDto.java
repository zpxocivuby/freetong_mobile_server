
package itaf.WsCollectionOrderService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>bzStockOrderDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzStockOrderDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}operateDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.merchant}sysUserDto" minOccurs="0"/>
 *         &lt;element name="orderSerialNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderEdc" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="bzStockOrderItemDtos" type="{itaf.framework.ws.server.merchant}bzStockOrderItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzStockOrderDto", propOrder = {
    "sysUserDto",
    "orderSerialNo",
    "orderStatus",
    "orderEdc",
    "bzStockOrderItemDtos"
})
public class BzStockOrderDto
    extends OperateDto
{

    protected SysUserDto sysUserDto;
    protected String orderSerialNo;
    protected Long orderStatus;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderEdc;
    @XmlElement(nillable = true)
    protected List<BzStockOrderItemDto> bzStockOrderItemDtos;

    /**
     * ��ȡsysUserDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserDto() {
        return sysUserDto;
    }

    /**
     * ����sysUserDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserDto(SysUserDto value) {
        this.sysUserDto = value;
    }

    /**
     * ��ȡorderSerialNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderSerialNo() {
        return orderSerialNo;
    }

    /**
     * ����orderSerialNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderSerialNo(String value) {
        this.orderSerialNo = value;
    }

    /**
     * ��ȡorderStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrderStatus() {
        return orderStatus;
    }

    /**
     * ����orderStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrderStatus(Long value) {
        this.orderStatus = value;
    }

    /**
     * ��ȡorderEdc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderEdc() {
        return orderEdc;
    }

    /**
     * ����orderEdc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderEdc(XMLGregorianCalendar value) {
        this.orderEdc = value;
    }

    /**
     * Gets the value of the bzStockOrderItemDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzStockOrderItemDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzStockOrderItemDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzStockOrderItemDto }
     * 
     * 
     */
    public List<BzStockOrderItemDto> getBzStockOrderItemDtos() {
        if (bzStockOrderItemDtos == null) {
            bzStockOrderItemDtos = new ArrayList<BzStockOrderItemDto>();
        }
        return this.bzStockOrderItemDtos;
    }

}
