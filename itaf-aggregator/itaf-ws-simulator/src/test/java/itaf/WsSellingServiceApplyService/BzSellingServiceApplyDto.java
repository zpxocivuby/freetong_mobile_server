
package itaf.WsSellingServiceApplyService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzSellingServiceApplyDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzSellingServiceApplyDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.certificate}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.certificate}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzAttachmentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approvalStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzWorkflowId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzMerchantCertificateDtos" type="{itaf.framework.ws.server.certificate}bzMerchantCertificateDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzSellingServiceApplyDto", propOrder = {
    "sysUserDto",
    "bzAttachmentId",
    "companyName",
    "companyAddress",
    "approvalStatus",
    "bzWorkflowId",
    "bzMerchantCertificateDtos"
})
public class BzSellingServiceApplyDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected Long bzAttachmentId;
    protected String companyName;
    protected String companyAddress;
    protected Long approvalStatus;
    protected Long bzWorkflowId;
    @XmlElement(nillable = true)
    protected List<BzMerchantCertificateDto> bzMerchantCertificateDtos;

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
     * ��ȡcompanyName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * ����companyName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * ��ȡcompanyAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * ����companyAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyAddress(String value) {
        this.companyAddress = value;
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
     * Gets the value of the bzMerchantCertificateDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzMerchantCertificateDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzMerchantCertificateDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzMerchantCertificateDto }
     * 
     * 
     */
    public List<BzMerchantCertificateDto> getBzMerchantCertificateDtos() {
        if (bzMerchantCertificateDtos == null) {
            bzMerchantCertificateDtos = new ArrayList<BzMerchantCertificateDto>();
        }
        return this.bzMerchantCertificateDtos;
    }

}