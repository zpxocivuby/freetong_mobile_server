package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.order.BzOrder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 配送单
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_DIST_ORDER", catalog = "itaf")
public class BzDistOrder extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -6241131214017200690L;

	private Long id;
	private BzMerchant bzMerchant;
	private BzDistCompany bzDistCompany;
	private BzInvoice bzInvoice;
	private BzOrder bzOrder;
	private Long orderStatus;
	private BigDecimal orderDistance;
	private Long orderDirection;
	private String orderSerialNo;
	private Date orderEdc;
	private Long orderNum;
	private String distAddress;
	private String distContactPerson;
	private String distContactNo;
	private String distPostcode;
	private Long orderStatementStatus;
	private BzCollectionOrder bzCollectionOrder;
	private Set<BzDistOrderItem> bzDistOrderItems = new HashSet<BzDistOrderItem>(
			0);

	public BzDistOrder() {
	}

	public BzDistOrder(Date orderEdc) {
		this.orderEdc = orderEdc;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_DIST_ORDER_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_MERCHANT_ID")
	public BzMerchant getBzMerchant() {
		return this.bzMerchant;
	}

	public void setBzMerchant(BzMerchant bzMerchant) {
		this.bzMerchant = bzMerchant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_DIST_COMPANY_ID")
	public BzDistCompany getBzDistCompany() {
		return this.bzDistCompany;
	}

	public void setBzDistCompany(BzDistCompany bzDistCompany) {
		this.bzDistCompany = bzDistCompany;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_INVOICE_ID")
	public BzInvoice getBzInvoice() {
		return this.bzInvoice;
	}

	public void setBzInvoice(BzInvoice bzInvoice) {
		this.bzInvoice = bzInvoice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_ORDER_ID")
	public BzOrder getBzOrder() {
		return this.bzOrder;
	}

	public void setBzOrder(BzOrder bzOrder) {
		this.bzOrder = bzOrder;
	}

	@Column(name = "ORDER_STATUS")
	public Long getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Long orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "ORDER_DISTANCE", precision = 16, scale = 8)
	public BigDecimal getOrderDistance() {
		return this.orderDistance;
	}

	public void setOrderDistance(BigDecimal orderDistance) {
		this.orderDistance = orderDistance;
	}

	@Column(name = "ORDER_DIRECTION")
	public Long getOrderDirection() {
		return this.orderDirection;
	}

	public void setOrderDirection(Long orderDirection) {
		this.orderDirection = orderDirection;
	}

	@Column(name = "ORDER_SERIAL_NO", length = 100)
	public String getOrderSerialNo() {
		return this.orderSerialNo;
	}

	public void setOrderSerialNo(String orderSerialNo) {
		this.orderSerialNo = orderSerialNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORDER_EDC", nullable = false, length = 19)
	public Date getOrderEdc() {
		return this.orderEdc;
	}

	public void setOrderEdc(Date orderEdc) {
		this.orderEdc = orderEdc;
	}

	@Column(name = "ORDER_NUM")
	public Long getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "DIST_ADDRESS", length = 1000)
	public String getDistAddress() {
		return this.distAddress;
	}

	public void setDistAddress(String distAddress) {
		this.distAddress = distAddress;
	}

	@Column(name = "DIST_CONTACT_PERSON", length = 50)
	public String getDistContactPerson() {
		return this.distContactPerson;
	}

	public void setDistContactPerson(String distContactPerson) {
		this.distContactPerson = distContactPerson;
	}

	@Column(name = "DIST_CONTACT_NO", length = 50)
	public String getDistContactNo() {
		return this.distContactNo;
	}

	public void setDistContactNo(String distContactNo) {
		this.distContactNo = distContactNo;
	}

	@Column(name = "DIST_POSTCODE", length = 20)
	public String getDistPostcode() {
		return this.distPostcode;
	}

	public void setDistPostcode(String distPostcode) {
		this.distPostcode = distPostcode;
	}

	@Column(name = "ORDER_STATEMENT_STATUS")
	public Long getOrderStatementStatus() {
		return this.orderStatementStatus;
	}

	public void setOrderStatementStatus(Long orderStatementStatus) {
		this.orderStatementStatus = orderStatementStatus;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bzDistOrder")
	public BzCollectionOrder getBzCollectionOrder() {
		return this.bzCollectionOrder;
	}

	public void setBzCollectionOrder(BzCollectionOrder bzCollectionOrder) {
		this.bzCollectionOrder = bzCollectionOrder;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzDistOrder")
	public Set<BzDistOrderItem> getBzDistOrderItems() {
		return this.bzDistOrderItems;
	}

	public void setBzDistOrderItems(Set<BzDistOrderItem> bzDistOrderItems) {
		this.bzDistOrderItems = bzDistOrderItems;
	}

}
