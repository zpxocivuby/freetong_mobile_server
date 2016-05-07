
package itaf.WsDistributionModelService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzInvoiceDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzInvoiceDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserByBzMerchantIdDto" type="{itaf.framework.ws.server.merchant}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzOrderDto" type="{itaf.framework.ws.server.merchant}bzOrderDto" minOccurs="0"/>
 *         &lt;element name="sysUserByBzDistributionCompanyIdDto" type="{itaf.framework.ws.server.merchant}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzDistributionModelDto" type="{itaf.framework.ws.server.merchant}bzDistributionModelDto" minOccurs="0"/>
 *         &lt;element name="invoiceSerialNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="invoiceNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="distAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distContactPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distContactNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distPostcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bzInvoiceItemDtos" type="{itaf.framework.ws.server.merchant}bzInvoiceItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzDistributionOrderDtos" type="{itaf.framework.ws.server.merchant}bzDistributionOrderDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzInvoiceDto", propOrder = {
    "sysUserByBzMerchantIdDto",
    "bzOrderDto",
    "sysUserByBzDistributionCompanyIdDto",
    "bzDistributionModelDto",
    "invoiceSerialNo",
    "invoiceStatus",
    "invoiceNum",
    "distAddress",
    "distContactPerson",
    "distContactNo",
    "distPostcode",
    "bzInvoiceItemDtos",
    "bzDistributionOrderDtos"
})
public class BzInvoiceDto
    extends BaseDto
{

    protected SysUserDto sysUserByBzMerchantIdDto;
    protected BzOrderDto bzOrderDto;
    protected SysUserDto sysUserByBzDistributionCompanyIdDto;
    protected BzDistributionModelDto bzDistributionModelDto;
    protected String invoiceSerialNo;
    protected Long invoiceStatus;
    protected Long invoiceNum;
    protected String distAddress;
    protected String distContactPerson;
    protected String distContactNo;
    protected String distPostcode;
    @XmlElement(nillable = true)
    protected List<BzInvoiceItemDto> bzInvoiceItemDtos;
    @XmlElement(nillable = true)
    protected List<BzDistributionOrderDto> bzDistributionOrderDtos;

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
     * ��ȡbzOrderDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzOrderDto }
     *     
     */
    public BzOrderDto getBzOrderDto() {
        return bzOrderDto;
    }

    /**
     * ����bzOrderDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzOrderDto }
     *     
     */
    public void setBzOrderDto(BzOrderDto value) {
        this.bzOrderDto = value;
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
     * ��ȡbzDistributionModelDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzDistributionModelDto }
     *     
     */
    public BzDistributionModelDto getBzDistributionModelDto() {
        return bzDistributionModelDto;
    }

    /**
     * ����bzDistributionModelDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzDistributionModelDto }
     *     
     */
    public void setBzDistributionModelDto(BzDistributionModelDto value) {
        this.bzDistributionModelDto = value;
    }

    /**
     * ��ȡinvoiceSerialNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceSerialNo() {
        return invoiceSerialNo;
    }

    /**
     * ����invoiceSerialNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceSerialNo(String value) {
        this.invoiceSerialNo = value;
    }

    /**
     * ��ȡinvoiceStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * ����invoiceStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvoiceStatus(Long value) {
        this.invoiceStatus = value;
    }

    /**
     * ��ȡinvoiceNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvoiceNum() {
        return invoiceNum;
    }

    /**
     * ����invoiceNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvoiceNum(Long value) {
        this.invoiceNum = value;
    }

    /**
     * ��ȡdistAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistAddress() {
        return distAddress;
    }

    /**
     * ����distAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistAddress(String value) {
        this.distAddress = value;
    }

    /**
     * ��ȡdistContactPerson���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistContactPerson() {
        return distContactPerson;
    }

    /**
     * ����distContactPerson���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistContactPerson(String value) {
        this.distContactPerson = value;
    }

    /**
     * ��ȡdistContactNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistContactNo() {
        return distContactNo;
    }

    /**
     * ����distContactNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistContactNo(String value) {
        this.distContactNo = value;
    }

    /**
     * ��ȡdistPostcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistPostcode() {
        return distPostcode;
    }

    /**
     * ����distPostcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistPostcode(String value) {
        this.distPostcode = value;
    }

    /**
     * Gets the value of the bzInvoiceItemDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzInvoiceItemDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzInvoiceItemDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzInvoiceItemDto }
     * 
     * 
     */
    public List<BzInvoiceItemDto> getBzInvoiceItemDtos() {
        if (bzInvoiceItemDtos == null) {
            bzInvoiceItemDtos = new ArrayList<BzInvoiceItemDto>();
        }
        return this.bzInvoiceItemDtos;
    }

    /**
     * Gets the value of the bzDistributionOrderDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzDistributionOrderDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzDistributionOrderDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzDistributionOrderDto }
     * 
     * 
     */
    public List<BzDistributionOrderDto> getBzDistributionOrderDtos() {
        if (bzDistributionOrderDtos == null) {
            bzDistributionOrderDtos = new ArrayList<BzDistributionOrderDto>();
        }
        return this.bzDistributionOrderDtos;
    }

}
