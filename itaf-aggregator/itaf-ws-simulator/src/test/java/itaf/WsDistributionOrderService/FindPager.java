
package itaf.WsDistributionOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>findPager complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="findPager">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currentIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findPager", propOrder = {
    "userId",
    "orderType",
    "currentIndex",
    "pageSize"
})
public class FindPager {

    protected Long userId;
    protected int orderType;
    protected int currentIndex;
    protected int pageSize;

    /**
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserId(Long value) {
        this.userId = value;
    }

    /**
     * 获取orderType属性的值。
     * 
     */
    public int getOrderType() {
        return orderType;
    }

    /**
     * 设置orderType属性的值。
     * 
     */
    public void setOrderType(int value) {
        this.orderType = value;
    }

    /**
     * 获取currentIndex属性的值。
     * 
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
     * 设置currentIndex属性的值。
     * 
     */
    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

    /**
     * 获取pageSize属性的值。
     * 
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置pageSize属性的值。
     * 
     */
    public void setPageSize(int value) {
        this.pageSize = value;
    }

}
