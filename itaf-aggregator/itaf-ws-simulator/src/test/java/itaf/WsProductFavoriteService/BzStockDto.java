
package itaf.WsProductFavoriteService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzStockDto complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="bzStockDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.product}baseDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.product}sysUserDto" minOccurs="0"/>
 *         &lt;element name="stockLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stockNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="stockType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deductionNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="inTransitNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="trProductStockDtos" type="{itaf.framework.ws.server.product}trProductStockDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzStockDto", propOrder = {
    "sysUserDto",
    "stockLocation",
    "stockNum",
    "stockType",
    "deductionNum",
    "inTransitNum",
    "trProductStockDtos"
})
public class BzStockDto
    extends BaseDto
{

    protected SysUserDto sysUserDto;
    protected String stockLocation;
    protected Long stockNum;
    protected Long stockType;
    protected Long deductionNum;
    protected Long inTransitNum;
    @XmlElement(nillable = true)
    protected List<TrProductStockDto> trProductStockDtos;

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
     * ��ȡstockLocation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockLocation() {
        return stockLocation;
    }

    /**
     * ����stockLocation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockLocation(String value) {
        this.stockLocation = value;
    }

    /**
     * ��ȡstockNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStockNum() {
        return stockNum;
    }

    /**
     * ����stockNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStockNum(Long value) {
        this.stockNum = value;
    }

    /**
     * ��ȡstockType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStockType() {
        return stockType;
    }

    /**
     * ����stockType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStockType(Long value) {
        this.stockType = value;
    }

    /**
     * ��ȡdeductionNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeductionNum() {
        return deductionNum;
    }

    /**
     * ����deductionNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeductionNum(Long value) {
        this.deductionNum = value;
    }

    /**
     * ��ȡinTransitNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInTransitNum() {
        return inTransitNum;
    }

    /**
     * ����inTransitNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInTransitNum(Long value) {
        this.inTransitNum = value;
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

}
