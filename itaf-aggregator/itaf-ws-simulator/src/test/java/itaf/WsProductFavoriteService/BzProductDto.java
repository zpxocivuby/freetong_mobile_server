
package itaf.WsProductFavoriteService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzProductDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzProductDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="productPurchasePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="productColor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productOnSale" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isStockLimitless" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isShelfLimitless" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isStockSupport" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isShelfSupport" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzProductBrandDtos" type="{itaf.framework.ws.server.product}bzProductBrandDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trProductStockDtos" type="{itaf.framework.ws.server.product}trProductStockDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductCategorieDtos" type="{itaf.framework.ws.server.product}bzProductCategoryDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductAttachmentDtos" type="{itaf.framework.ws.server.product}bzProductAttachmentDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductEvaluationDtos" type="{itaf.framework.ws.server.product}bzProductEvaluationDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzInvoiceItemDtos" type="{itaf.framework.ws.server.product}bzInvoiceItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzPositionDtos" type="{itaf.framework.ws.server.product}bzPositionDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzCartDtos" type="{itaf.framework.ws.server.product}bzCartItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzStockOrderItemDtos" type="{itaf.framework.ws.server.product}bzStockOrderItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductFavoriteDtos" type="{itaf.framework.ws.server.product}bzProductFavoriteDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzOrderItemDtos" type="{itaf.framework.ws.server.product}bzOrderItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzProductDto", propOrder = {
    "sysUserDto",
    "productName",
    "productPrice",
    "productPurchasePrice",
    "productColor",
    "productDescription",
    "productOnSale",
    "isStockLimitless",
    "isShelfLimitless",
    "isStockSupport",
    "isShelfSupport",
    "bzProductBrandDtos",
    "trProductStockDtos",
    "bzProductCategorieDtos",
    "bzProductAttachmentDtos",
    "bzProductEvaluationDtos",
    "bzInvoiceItemDtos",
    "bzPositionDtos",
    "bzCartDtos",
    "bzStockOrderItemDtos",
    "bzProductFavoriteDtos",
    "bzOrderItemDtos"
})
public class BzProductDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected String productName;
    protected BigDecimal productPrice;
    protected BigDecimal productPurchasePrice;
    protected String productColor;
    protected String productDescription;
    protected Long productOnSale;
    protected Long isStockLimitless;
    protected Long isShelfLimitless;
    protected Long isStockSupport;
    protected Long isShelfSupport;
    @XmlElement(nillable = true)
    protected List<BzProductBrandDto> bzProductBrandDtos;
    @XmlElement(nillable = true)
    protected List<TrProductStockDto> trProductStockDtos;
    @XmlElement(nillable = true)
    protected List<BzProductCategoryDto> bzProductCategorieDtos;
    @XmlElement(nillable = true)
    protected List<BzProductAttachmentDto> bzProductAttachmentDtos;
    @XmlElement(nillable = true)
    protected List<BzProductEvaluationDto> bzProductEvaluationDtos;
    @XmlElement(nillable = true)
    protected List<BzInvoiceItemDto> bzInvoiceItemDtos;
    @XmlElement(nillable = true)
    protected List<BzPositionDto> bzPositionDtos;
    @XmlElement(nillable = true)
    protected List<BzCartItemDto> bzCartDtos;
    @XmlElement(nillable = true)
    protected List<BzStockOrderItemDto> bzStockOrderItemDtos;
    @XmlElement(nillable = true)
    protected List<BzProductFavoriteDto> bzProductFavoriteDtos;
    @XmlElement(nillable = true)
    protected List<BzOrderItemDto> bzOrderItemDtos;

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
     * ��ȡproductName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * ����productName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * ��ȡproductPrice���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * ����productPrice���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProductPrice(BigDecimal value) {
        this.productPrice = value;
    }

    /**
     * ��ȡproductPurchasePrice���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProductPurchasePrice() {
        return productPurchasePrice;
    }

    /**
     * ����productPurchasePrice���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProductPurchasePrice(BigDecimal value) {
        this.productPurchasePrice = value;
    }

    /**
     * ��ȡproductColor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductColor() {
        return productColor;
    }

    /**
     * ����productColor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductColor(String value) {
        this.productColor = value;
    }

    /**
     * ��ȡproductDescription���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * ����productDescription���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductDescription(String value) {
        this.productDescription = value;
    }

    /**
     * ��ȡproductOnSale���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProductOnSale() {
        return productOnSale;
    }

    /**
     * ����productOnSale���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProductOnSale(Long value) {
        this.productOnSale = value;
    }

    /**
     * ��ȡisStockLimitless���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIsStockLimitless() {
        return isStockLimitless;
    }

    /**
     * ����isStockLimitless���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIsStockLimitless(Long value) {
        this.isStockLimitless = value;
    }

    /**
     * ��ȡisShelfLimitless���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIsShelfLimitless() {
        return isShelfLimitless;
    }

    /**
     * ����isShelfLimitless���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIsShelfLimitless(Long value) {
        this.isShelfLimitless = value;
    }

    /**
     * ��ȡisStockSupport���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIsStockSupport() {
        return isStockSupport;
    }

    /**
     * ����isStockSupport���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIsStockSupport(Long value) {
        this.isStockSupport = value;
    }

    /**
     * ��ȡisShelfSupport���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIsShelfSupport() {
        return isShelfSupport;
    }

    /**
     * ����isShelfSupport���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIsShelfSupport(Long value) {
        this.isShelfSupport = value;
    }

    /**
     * Gets the value of the bzProductBrandDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzProductBrandDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzProductBrandDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzProductBrandDto }
     * 
     * 
     */
    public List<BzProductBrandDto> getBzProductBrandDtos() {
        if (bzProductBrandDtos == null) {
            bzProductBrandDtos = new ArrayList<BzProductBrandDto>();
        }
        return this.bzProductBrandDtos;
    }

    /**
     * Gets the value of the trProductStockDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trProductStockDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrProductStockDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrProductStockDto }
     * 
     * 
     */
    public List<TrProductStockDto> getTrProductStockDtos() {
        if (trProductStockDtos == null) {
            trProductStockDtos = new ArrayList<TrProductStockDto>();
        }
        return this.trProductStockDtos;
    }

    /**
     * Gets the value of the bzProductCategorieDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzProductCategorieDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzProductCategorieDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzProductCategoryDto }
     * 
     * 
     */
    public List<BzProductCategoryDto> getBzProductCategorieDtos() {
        if (bzProductCategorieDtos == null) {
            bzProductCategorieDtos = new ArrayList<BzProductCategoryDto>();
        }
        return this.bzProductCategorieDtos;
    }

    /**
     * Gets the value of the bzProductAttachmentDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzProductAttachmentDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzProductAttachmentDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzProductAttachmentDto }
     * 
     * 
     */
    public List<BzProductAttachmentDto> getBzProductAttachmentDtos() {
        if (bzProductAttachmentDtos == null) {
            bzProductAttachmentDtos = new ArrayList<BzProductAttachmentDto>();
        }
        return this.bzProductAttachmentDtos;
    }

    /**
     * Gets the value of the bzProductEvaluationDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzProductEvaluationDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzProductEvaluationDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzProductEvaluationDto }
     * 
     * 
     */
    public List<BzProductEvaluationDto> getBzProductEvaluationDtos() {
        if (bzProductEvaluationDtos == null) {
            bzProductEvaluationDtos = new ArrayList<BzProductEvaluationDto>();
        }
        return this.bzProductEvaluationDtos;
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
     * Gets the value of the bzPositionDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzPositionDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzPositionDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzPositionDto }
     * 
     * 
     */
    public List<BzPositionDto> getBzPositionDtos() {
        if (bzPositionDtos == null) {
            bzPositionDtos = new ArrayList<BzPositionDto>();
        }
        return this.bzPositionDtos;
    }

    /**
     * Gets the value of the bzCartDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzCartDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzCartDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzCartItemDto }
     * 
     * 
     */
    public List<BzCartItemDto> getBzCartDtos() {
        if (bzCartDtos == null) {
            bzCartDtos = new ArrayList<BzCartItemDto>();
        }
        return this.bzCartDtos;
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

    /**
     * Gets the value of the bzProductFavoriteDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzProductFavoriteDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzProductFavoriteDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzProductFavoriteDto }
     * 
     * 
     */
    public List<BzProductFavoriteDto> getBzProductFavoriteDtos() {
        if (bzProductFavoriteDtos == null) {
            bzProductFavoriteDtos = new ArrayList<BzProductFavoriteDto>();
        }
        return this.bzProductFavoriteDtos;
    }

    /**
     * Gets the value of the bzOrderItemDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzOrderItemDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzOrderItemDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzOrderItemDto }
     * 
     * 
     */
    public List<BzOrderItemDto> getBzOrderItemDtos() {
        if (bzOrderItemDtos == null) {
            bzOrderItemDtos = new ArrayList<BzOrderItemDto>();
        }
        return this.bzOrderItemDtos;
    }

}
