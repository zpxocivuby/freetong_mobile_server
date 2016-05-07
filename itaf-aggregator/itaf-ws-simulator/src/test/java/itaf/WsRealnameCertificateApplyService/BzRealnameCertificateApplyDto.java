
package itaf.WsRealnameCertificateApplyService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>bzRealnameCertificateApplyDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzRealnameCertificateApplyDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.certificate}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.certificate}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzAttachmentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approvalStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzWorkflowId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzRealnameCertificateDtos" type="{itaf.framework.ws.server.certificate}bzRealnameCertificateDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzRealnameCertificateApplyDto", propOrder = {
    "sysUserDto",
    "bzAttachmentId",
    "name",
    "sex",
    "birthdate",
    "mobile",
    "idType",
    "idNo",
    "approvalStatus",
    "bzWorkflowId",
    "bzRealnameCertificateDtos"
})
public class BzRealnameCertificateApplyDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected Long bzAttachmentId;
    protected String name;
    protected Long sex;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar birthdate;
    protected String mobile;
    protected Long idType;
    protected String idNo;
    protected Long approvalStatus;
    protected Long bzWorkflowId;
    @XmlElement(nillable = true)
    protected List<BzRealnameCertificateDto> bzRealnameCertificateDtos;

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
     * ��ȡbzAttachmentId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzAttachmentId() {
        return bzAttachmentId;
    }

    /**
     * ����bzAttachmentId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzAttachmentId(Long value) {
        this.bzAttachmentId = value;
    }

    /**
     * ��ȡname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * ����name���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * ��ȡsex���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSex() {
        return sex;
    }

    /**
     * ����sex���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSex(Long value) {
        this.sex = value;
    }

    /**
     * ��ȡbirthdate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthdate() {
        return birthdate;
    }

    /**
     * ����birthdate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthdate(XMLGregorianCalendar value) {
        this.birthdate = value;
    }

    /**
     * ��ȡmobile���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * ����mobile���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * ��ȡidType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdType() {
        return idType;
    }

    /**
     * ����idType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdType(Long value) {
        this.idType = value;
    }

    /**
     * ��ȡidNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * ����idNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNo(String value) {
        this.idNo = value;
    }

    /**
     * ��ȡapprovalStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * ����approvalStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApprovalStatus(Long value) {
        this.approvalStatus = value;
    }

    /**
     * ��ȡbzWorkflowId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzWorkflowId() {
        return bzWorkflowId;
    }

    /**
     * ����bzWorkflowId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzWorkflowId(Long value) {
        this.bzWorkflowId = value;
    }

    /**
     * Gets the value of the bzRealnameCertificateDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzRealnameCertificateDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzRealnameCertificateDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzRealnameCertificateDto }
     * 
     * 
     */
    public List<BzRealnameCertificateDto> getBzRealnameCertificateDtos() {
        if (bzRealnameCertificateDtos == null) {
            bzRealnameCertificateDtos = new ArrayList<BzRealnameCertificateDto>();
        }
        return this.bzRealnameCertificateDtos;
    }

}
