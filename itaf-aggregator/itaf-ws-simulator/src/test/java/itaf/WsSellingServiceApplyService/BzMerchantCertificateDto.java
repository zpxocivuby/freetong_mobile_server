
package itaf.WsSellingServiceApplyService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzMerchantCertificateDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzMerchantCertificateDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.certificate}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzDistServiceApplyDto" type="{itaf.framework.ws.server.certificate}bzDistServiceApplyDto" minOccurs="0"/>
 *         &lt;element name="bzSellingServiceApplyDto" type="{itaf.framework.ws.server.certificate}bzSellingServiceApplyDto" minOccurs="0"/>
 *         &lt;element name="sysUserId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="certificateType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distServiceType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="distServiceCoverage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzMerchantCertificateDto", propOrder = {
    "bzDistServiceApplyDto",
    "bzSellingServiceApplyDto",
    "sysUserId",
    "certificateType",
    "companyName",
    "companyAddress",
    "distServiceType",
    "distServiceCoverage"
})
public class BzMerchantCertificateDto
    extends BaseDto
{

    protected BzDistServiceApplyDto bzDistServiceApplyDto;
    protected BzSellingServiceApplyDto bzSellingServiceApplyDto;
    protected Long sysUserId;
    protected Long certificateType;
    protected String companyName;
    protected String companyAddress;
    protected Long distServiceType;
    protected String distServiceCoverage;

    /**
     * 获取bzDistServiceApplyDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzDistServiceApplyDto }
     *     
     */
    public BzDistServiceApplyDto getBzDistServiceApplyDto() {
        return bzDistServiceApplyDto;
    }

    /**
     * 设置bzDistServiceApplyDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzDistServiceApplyDto }
     *     
     */
    public void setBzDistServiceApplyDto(BzDistServiceApplyDto value) {
        this.bzDistServiceApplyDto = value;
    }

    /**
     * 获取bzSellingServiceApplyDto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BzSellingServiceApplyDto }
     *     
     */
    public BzSellingServiceApplyDto getBzSellingServiceApplyDto() {
        return bzSellingServiceApplyDto;
    }

    /**
     * 设置bzSellingServiceApplyDto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BzSellingServiceApplyDto }
     *     
     */
    public void setBzSellingServiceApplyDto(BzSellingServiceApplyDto value) {
        this.bzSellingServiceApplyDto = value;
    }

    /**
     * 获取sysUserId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置sysUserId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSysUserId(Long value) {
        this.sysUserId = value;
    }

    /**
     * 获取certificateType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCertificateType() {
        return certificateType;
    }

    /**
     * 设置certificateType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCertificateType(Long value) {
        this.certificateType = value;
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
     * 获取companyAddress属性的值。
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
     * 设置companyAddress属性的值。
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
     *     {@link String }
     *     
     */
    public String getDistServiceCoverage() {
        return distServiceCoverage;
    }

    /**
     * 设置distServiceCoverage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistServiceCoverage(String value) {
        this.distServiceCoverage = value;
    }

}
