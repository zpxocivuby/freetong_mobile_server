
package itaf.WsDistributionModelService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzProductAttachmentDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzProductAttachmentDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzProductDto" type="{itaf.framework.ws.server.merchant}bzProductDto" minOccurs="0"/>
 *         &lt;element name="srcFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fileExt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzProductAttachmentDto", propOrder = {
    "bzProductDto",
    "srcFileName",
    "fileName",
    "fileType",
    "fileExt"
})
public class BzProductAttachmentDto
    extends BaseDto
{

    protected BzProductDto bzProductDto;
    protected String srcFileName;
    protected String fileName;
    protected Long fileType;
    protected String fileExt;

    /**
     * ��ȡbzProductDto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BzProductDto }
     *     
     */
    public BzProductDto getBzProductDto() {
        return bzProductDto;
    }

    /**
     * ����bzProductDto���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BzProductDto }
     *     
     */
    public void setBzProductDto(BzProductDto value) {
        this.bzProductDto = value;
    }

    /**
     * ��ȡsrcFileName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcFileName() {
        return srcFileName;
    }

    /**
     * ����srcFileName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcFileName(String value) {
        this.srcFileName = value;
    }

    /**
     * ��ȡfileName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * ����fileName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * ��ȡfileType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileType() {
        return fileType;
    }

    /**
     * ����fileType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileType(Long value) {
        this.fileType = value;
    }

    /**
     * ��ȡfileExt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileExt() {
        return fileExt;
    }

    /**
     * ����fileExt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileExt(String value) {
        this.fileExt = value;
    }

}
