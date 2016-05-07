
package itaf.WsOrderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>findPager complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="findPager">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "orderStatus",
    "currentIndex",
    "pageSize"
})
public class FindPager {

    protected Long userId;
    protected int orderStatus;
    protected int currentIndex;
    protected int pageSize;

    /**
     * ��ȡuserId���Ե�ֵ��
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
     * ����userId���Ե�ֵ��
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
     * ��ȡorderStatus���Ե�ֵ��
     * 
     */
    public int getOrderStatus() {
        return orderStatus;
    }

    /**
     * ����orderStatus���Ե�ֵ��
     * 
     */
    public void setOrderStatus(int value) {
        this.orderStatus = value;
    }

    /**
     * ��ȡcurrentIndex���Ե�ֵ��
     * 
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
     * ����currentIndex���Ե�ֵ��
     * 
     */
    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

    /**
     * ��ȡpageSize���Ե�ֵ��
     * 
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * ����pageSize���Ե�ֵ��
     * 
     */
    public void setPageSize(int value) {
        this.pageSize = value;
    }

}
