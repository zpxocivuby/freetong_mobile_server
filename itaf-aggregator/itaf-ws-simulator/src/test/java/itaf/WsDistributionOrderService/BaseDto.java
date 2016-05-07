
package itaf.WsDistributionOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>baseDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="baseDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="objId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updatedBy" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="updatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="markForDelete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseDto", propOrder = {
    "id",
    "objId",
    "createdBy",
    "createdDate",
    "updatedBy",
    "updatedDate",
    "markForDelete"
})
@XmlSeeAlso({
    BzInvoiceItemDto.class,
    SysRoleDto.class,
    BzOrderPaymentDto.class,
    BzStockOrderDto.class,
    BzUserDeliveryAddressDto.class,
    BzProductEvaluationDto.class,
    BzMerchantCreditEvalDto.class,
    BzProductDto.class,
    BzMerchantCreditDto.class,
    BzOrderDto.class,
    BzPaymentTypeDto.class,
    BzConsumerCreditEvalDto.class,
    BzInvoiceDto.class,
    SysUserDto.class,
    BzProductFavoriteDto.class,
    BzPositionDto.class,
    BzStockDto.class,
    BzDistComCreditDto.class,
    BzCollectionOrderDto.class,
    BzStockOrderItemDto.class,
    BzDistributionModelDto.class,
    TrProductStockIdDto.class,
    BzOrderItemDto.class,
    BzShelfDto.class,
    BzCartItemDto.class,
    BaseTreeDto.class,
    BzDistributionOrderDto.class,
    BzOrderHistoryDto.class,
    BzProductBrandDto.class,
    BzProductAttachmentDto.class,
    BzConsumerCreditDto.class,
    BzUserTakeDeliveryAddressDto.class,
    BzUserPositionDto.class,
    TrProductStockDto.class,
    BzDistComCreditEvalDto.class
})
public abstract class BaseDto {

    protected Long id;
    protected Long objId;
    protected Long createdBy;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    protected Long updatedBy;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedDate;
    protected Boolean markForDelete;

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * 获取objId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getObjId() {
        return objId;
    }

    /**
     * 设置objId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setObjId(Long value) {
        this.objId = value;
    }

    /**
     * 获取createdBy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置createdBy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreatedBy(Long value) {
        this.createdBy = value;
    }

    /**
     * 获取createdDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置createdDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * 获取updatedBy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置updatedBy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUpdatedBy(Long value) {
        this.updatedBy = value;
    }

    /**
     * 获取updatedDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置updatedDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdatedDate(XMLGregorianCalendar value) {
        this.updatedDate = value;
    }

    /**
     * 获取markForDelete属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMarkForDelete() {
        return markForDelete;
    }

    /**
     * 设置markForDelete属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMarkForDelete(Boolean value) {
        this.markForDelete = value;
    }

}
