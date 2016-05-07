
package itaf.WsSellingServiceApplyService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzMerchantCertificateDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡbzDistServiceApplyDto���Ե�ֵ��
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
     * ����bzDistServiceApplyDto���Ե�ֵ��
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
     * ��ȡbzSellingServiceApplyDto���Ե�ֵ��
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
     * ����bzSellingServiceApplyDto���Ե�ֵ��
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
     * ��ȡsysUserId���Ե�ֵ��
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
     * ����sysUserId���Ե�ֵ��
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
     * ��ȡcertificateType���Ե�ֵ��
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
     * ����certificateType���Ե�ֵ��
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
     * ��ȡdistServiceType���Ե�ֵ��
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
     * ����distServiceType���Ե�ֵ��
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
     * ��ȡdistServiceCoverage���Ե�ֵ��
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
     * ����distServiceCoverage���Ե�ֵ��
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
