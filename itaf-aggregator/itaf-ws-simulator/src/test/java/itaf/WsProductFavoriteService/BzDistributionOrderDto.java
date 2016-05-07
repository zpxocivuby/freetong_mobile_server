
package itaf.WsProductFavoriteService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>bzDistributionOrderDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzDistributionOrderDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserByBzMerchantIdDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="sysUserByBzDistributionCompanyIdDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzInvoiceDto" type="{itaf.framework.ws.server.product}bzInvoiceDto" minOccurs="0"/>
 *         &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderDistance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orderDirection" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderSerialNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderEdc" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="bzCollectionOrderDtos" type="{itaf.framework.ws.server.product}bzCollectionOrderDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzDistributionOrderDto", propOrder = {
    "sysUserByBzMerchantIdDto",
    "sysUserByBzDistributionCompanyIdDto",
    "bzInvoiceDto",
    "orderStatus",
    "orderDistance",
    "orderDirection",
    "orderSerialNo",
    "orderEdc",
    "bzCollectionOrderDtos"
})
public class BzDistributionOrderDto
    extends BaseDto
{

    protected SysUserDto sysUserByBzMerchantIdDto;
    protected SysUserDto sysUserByBzDistributionCompanyIdDto;
    protected BzInvoiceDto bzInvoiceDto;
    protected Long orderStatus;
    protected BigDecimal orderDistance;
    protected Long orderDirection;
    protected String orderSerialNo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderEdc;
    @XmlElement(nillable = true)
    protected List<BzCollectionOrderDto> bzCollectionOrderDtos;

    /**
     * ��ȡsysUserByBzMerchantIdDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserByBzMerchantIdDto() {
        return sysUserByBzMerchantIdDto;
    }

    /**
     * ����sysUserByBzMerchantIdDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserByBzMerchantIdDto(SysUserDto value) {
        this.sysUserByBzMerchantIdDto = value;
    }

    /**
     * ��ȡsysUserByBzDistributionCompanyIdDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SysUserDto }
     *     
     */
    public SysUserDto getSysUserByBzDistributionCompanyIdDto() {
        return sysUserByBzDistributionCompanyIdDto;
    }

    /**
     * ����sysUserByBzDistributionCompanyIdDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SysUserDto }
     *     
     */
    public void setSysUserByBzDistributionCompanyIdDto(SysUserDto value) {
        this.sysUserByBzDistributionCompanyIdDto = value;
    }

    /**
     * ��ȡbzInvoiceDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzInvoiceDto }
     *     
     */
    public BzInvoiceDto getBzInvoiceDto() {
        return bzInvoiceDto;
    }

    /**
     * ����bzInvoiceDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzInvoiceDto }
     *     
     */
    public void setBzInvoiceDto(BzInvoiceDto value) {
        this.bzInvoiceDto = value;
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
     * ��ȡorderDistance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderDistance() {
        return orderDistance;
    }

    /**
     * ����orderDistance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderDistance(BigDecimal value) {
        this.orderDistance = value;
    }

    /**
     * ��ȡorderDirection���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrderDirection() {
        return orderDirection;
    }

    /**
     * ����orderDirection���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrderDirection(Long value) {
        this.orderDirection = value;
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
     * Gets the value of the bzCollectionOrderDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzCollectionOrderDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzCollectionOrderDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzCollectionOrderDto }
     * 
     * 
     */
    public List<BzCollectionOrderDto> getBzCollectionOrderDtos() {
        if (bzCollectionOrderDtos == null) {
            bzCollectionOrderDtos = new ArrayList<BzCollectionOrderDto>();
        }
        return this.bzCollectionOrderDtos;
    }

}
