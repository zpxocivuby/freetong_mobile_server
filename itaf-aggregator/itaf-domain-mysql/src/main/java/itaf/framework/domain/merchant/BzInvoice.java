package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.order.BzOrder;

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

/**
 * 
 * 发货单
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_INVOICE", catalog = "itaf")
public class BzInvoice extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = 5680272431830935975L;

	private Long id;
	private BzMerchant bzMerchant;
	private BzOrder bzOrder;
	private BzDistCompany bzDistCompany;
	private String invoiceSerialNo;
	private Long invoiceStatus;
	private String distAddress;
	private String distContactPerson;
	private String distContactNo;
	private String distPostcode;
	private Set<BzInvoiceItem> bzInvoiceItems = new HashSet<BzInvoiceItem>(0);
	private BzDistOrder bzDistOrder;

	public BzInvoice() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_INVOICE_ID", unique = true, nullable = false)
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
	@JoinColumn(name = "BZ_ORDER_ID")
	public BzOrder getBzOrder() {
		return this.bzOrder;
	}

	public void setBzOrder(BzOrder bzOrder) {
		this.bzOrder = bzOrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_DIST_COMPANY_ID")
	public BzDistCompany getBzDistCompany() {
		return this.bzDistCompany;
	}

	public void setBzDistCompany(BzDistCompany bzDistCompany) {
		this.bzDistCompany = bzDistCompany;
	}

	@Column(name = "INVOICE_SERIAL_NO", length = 100)
	public String getInvoiceSerialNo() {
		return this.invoiceSerialNo;
	}

	public void setInvoiceSerialNo(String invoiceSerialNo) {
		this.invoiceSerialNo = invoiceSerialNo;
	}

	@Column(name = "INVOICE_STATUS")
	public Long getInvoiceStatus() {
		return this.invoiceStatus;
	}

	public void setInvoiceStatus(Long invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzInvoice")
	public Set<BzInvoiceItem> getBzInvoiceItems() {
		return this.bzInvoiceItems;
	}

	public void setBzInvoiceItems(Set<BzInvoiceItem> bzInvoiceItems) {
		this.bzInvoiceItems = bzInvoiceItems;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bzInvoice")
	public BzDistOrder getBzDistOrder() {
		return this.bzDistOrder;
	}

	public void setBzDistOrder(BzDistOrder bzDistOrder) {
		this.bzDistOrder = bzDistOrder;
	}

}
