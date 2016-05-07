
package itaf.WsUserTakeDeliveryAddressService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bzProductDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bzProductDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.consumer}baseDto">
 *       &lt;sequence>
 *         &lt;element name="bzMerchantId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzMerchantDto" type="{itaf.framework.ws.server.consumer}bzMerchantDto" minOccurs="0"/>
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
 *         &lt;element name="bzProductBrandDtos" type="{itaf.framework.ws.server.consumer}bzProductBrandDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trProductStockDtos" type="{itaf.framework.ws.server.consumer}trProductStockDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductCategorieDtos" type="{itaf.framework.ws.server.consumer}bzProductCategoryDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductAttachmentDtos" type="{itaf.framework.ws.server.consumer}bzProductAttachmentDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductEvaluationDtos" type="{itaf.framework.ws.server.consumer}bzProductEvaluationDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzInvoiceItemDtos" type="{itaf.framework.ws.server.consumer}bzInvoiceItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzPositionDtos" type="{itaf.framework.ws.server.consumer}bzPositionDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzCartDtos" type="{itaf.framework.ws.server.consumer}bzCartItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzStockOrderItemDtos" type="{itaf.framework.ws.server.consumer}bzStockOrderItemDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzProductFavoriteDtos" type="{itaf.framework.ws.server.consumer}bzProductFavoriteDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bzOrderItemDtos" type="{itaf.framework.ws.server.consumer}bzOrderItemDto" maxOccurs="unbounded" minOccurs="0"/>
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
    "bzMerchantId",
    "bzMerchantDto",
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

    protected Long bzMerchantId;
    protected BzMerchantDto bzMerchantDto;
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
     * Gets the value of the bzMerchantId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBzMerchantId() {
        return bzMerchantId;
    }

    /**
     * Sets the value of the bzMerchantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBzMerchantId(Long value) {
        this.bzMerchantId = value;
    }

    /**
     * Gets the value of the bzMerchantDto property.
     * 
     * @return
     *     possible object is
     *     {@link BzMerchantDto }
     *     
     */
    public BzMerchantDto getBzMerchantDto() {
        return bzMerchantDto;
    }

    /**
     * Sets the value of the bzMerchantDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BzMerchantDto }
     *     
     */
    public void setBzMerchantDto(BzMerchantDto value) {
        this.bzMerchantDto = value;
    }

    /**
     * Gets the value of the productName property.
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
     * Sets the value of the productName property.
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
     * Gets the value of the productPrice property.
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
     * Sets the value of the productPrice property.
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
     * Gets the value of the productPurchasePrice property.
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
     * Sets the value of the productPurchasePrice property.
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
     * Gets the value of the productColor property.
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
     * Sets the value of the productColor property.
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
     * Gets the value of the productDescription property.
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
     * Sets the value of the productDescription property.
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
     * Gets the value of the productOnSale property.
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
     * Sets the value of the productOnSale property.
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
     * Gets the value of the isStockLimitless property.
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
     * Sets the value of the isStockLimitless property.
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
     * Gets the value of the isShelfLimitless property.
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
     * Sets the value of the isShelfLimitless property.
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
     * Gets the value of the isStockSupport property.
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
     * Sets the value of the isStockSupport property.
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
     * Gets the value of the isShelfSupport property.
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
     * Sets the value of the isShelfSupport property.
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
