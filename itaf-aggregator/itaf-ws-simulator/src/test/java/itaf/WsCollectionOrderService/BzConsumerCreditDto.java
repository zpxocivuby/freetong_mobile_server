
package itaf.WsCollectionOrderService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bzConsumerCreditDto complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bzConsumerCreditDto">
 *   &lt;complexContent>
 *     &lt;extension base="{itaf.framework.ws.server.merchant}operateDto">
 *       &lt;sequence>
 *         &lt;element name="sysUserDto" type="{itaf.framework.ws.server.merchant}sysUserDto" minOccurs="0"/>
 *         &lt;element name="creditRank" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bzConsumerCreditEvalDtos" type="{itaf.framework.ws.server.merchant}bzConsumerCreditEvalDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bzConsumerCreditDto", propOrder = {
    "sysUserDto",
    "creditRank",
    "bzConsumerCreditEvalDtos"
})
public class BzConsumerCreditDto
    extends OperateDto
{

    protected SysUserDto sysUserDto;
    protected Long creditRank;
    @XmlElement(nillable = true)
    protected List<BzConsumerCreditEvalDto> bzConsumerCreditEvalDtos;

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
     * 获取creditRank属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreditRank() {
        return creditRank;
    }

    /**
     * 设置creditRank属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreditRank(Long value) {
        this.creditRank = value;
    }

    /**
     * Gets the value of the bzConsumerCreditEvalDtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bzConsumerCreditEvalDtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBzConsumerCreditEvalDtos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BzConsumerCreditEvalDto }
     * 
     * 
     */
    public List<BzConsumerCreditEvalDto> getBzConsumerCreditEvalDtos() {
        if (bzConsumerCreditEvalDtos == null) {
            bzConsumerCreditEvalDtos = new ArrayList<BzConsumerCreditEvalDto>();
        }
        return this.bzConsumerCreditEvalDtos;
    }

}
