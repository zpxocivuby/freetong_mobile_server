
package itaf.WsDistributionServiceApplyService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzDistServiceApplyDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzDistServiceApplyDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.certificate}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.certificate}sysUserDto" minOccurs="0"/>
 *         &lt;element name="bzAttachmentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distServiceType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="distServiceCoverage" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="approvalStatus" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzWorkflowId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzMerchantCertificateDtos" type="{itaf.framework.ws.server.certificate}bzMerchantCertificateDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzApprovalInfoList" type="{itaf.framework.ws.server.certificate}bzApprovalInfoDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzDistServiceApplyDto", propOrder = {
    "sysUserDto",
    "bzAttachmentId",
    "companyName",
    "distServiceType",
    "distServiceCoverage",
    "approvalStatus",
    "bzWorkflowId",
    "bzMerchantCertificateDtos",
    "bzApprovalInfoList"
})
public class BzDistServiceApplyDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected Long bzAttachmentId;
    protected String companyName;
    protected Long distServiceType;
    protected Long distServiceCoverage;
    protected Long approvalStatus;
    protected Long bzWorkflowId;
    @XmlElement(nillable = true)
    protected List<BzMerchantCertificateDto> bzMerchantCertificateDtos;
    @XmlElement(nillable = true)
    protected List<BzApprovalInfoDto> bzApprovalInfoList;

    /**
     * 获取sysUserDto属性的值。
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
     * 设置sysUserDto属性的值。
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
     * 获取bzAttachmentId属性的值。
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
     * 设置bzAttachmentId属性的值。
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
     * 获取companyName属性的值。
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
     * 设置companyName属性的值。
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
     * 获取distServiceType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDistServiceType() {
        return distServiceType;
    }

    /**
     * 设置distServiceType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDistServiceType(Long value) {
        this.distServiceType = value;
    }

    /**
     * 获取distServiceCoverage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDistServiceCoverage() {
        return distServiceCoverage;
    }

    /**
     * 设置distServiceCoverage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDistServiceCoverage(Long value) {
        this.distServiceCoverage = value;
    }

    /**
     * 获取approvalStatus属性的值。
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
     * 设置approvalStatus属性的值。
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
     * 获取bzWorkflowId属性的值。
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
     * 设置bzWorkflowId属性的值。
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

    /**
     * Gets the value of the bzApprovalInfoList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzApprovalInfoList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzApprovalInfoList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzApprovalInfoDto }
     * 
     * 
     */
    public List<BzApprovalInfoDto> getBzApprovalInfoList() {
        if (bzApprovalInfoList == null) {
            bzApprovalInfoList = new ArrayList<BzApprovalInfoDto>();
        }
        return this.bzApprovalInfoList;
    }

}
