package itaf.framework.domain.merchant;

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 结算单
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_DIST_STATEMENT", catalog = "itaf")
public class BzDistStatement extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 9083821632034656821L;

	private Long id;
	private BzMerchant bzMerchant;
	private BzDistCompany bzDistCompany;
	private String statementSerialNo;
	private Long statementStatus;
	private Date statementTime;
	private BigDecimal merchantReceivableAmount;
	private BigDecimal merchantReceivedAmount;
	private BigDecimal distCompanyReceivableAmount;
	private BigDecimal distCompanyReceivedAmount;
	private Set<BzDistStatementItem> bzDistStatementItems = new HashSet<BzDistStatementItem>(
			0);

	public BzDistStatement() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_DIST_STATEMENT_ID", unique = true, nullable = false)
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
		return bzDistCompany;
	}

	public void setBzDistCompany(BzDistCompany bzDistCompany) {
		this.bzDistCompany = bzDistCompany;
	}

	@Column(name = "STATEMENT_SERIAL_NO", length = 100)
	public String getStatementSerialNo() {
		return statementSerialNo;
	}

	public void setStatementSerialNo(String statementSerialNo) {
		this.statementSerialNo = statementSerialNo;
	}

	@Column(name = "STATEMENT_STATUS")
	public Long getStatementStatus() {
		return statementStatus;
	}

	public void setStatementStatus(Long statementStatus) {
		this.statementStatus = statementStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STATEMENT_TIME", nullable = false, length = 19)
	public Date getStatementTime() {
		return statementTime;
	}

	public void setStatementTime(Date statementTime) {
		this.statementTime = statementTime;
	}

	@Column(name = "M_RECEIVABLE_AMOUNT", precision = 12)
	public BigDecimal getMerchantReceivableAmount() {
		return merchantReceivableAmount;
	}

	public void setMerchantReceivableAmount(BigDecimal merchantReceivableAmount) {
		this.merchantReceivableAmount = merchantReceivableAmount;
	}

	@Column(name = "M_RECEIVED_AMOUNT", precision = 12)
	public BigDecimal getMerchantReceivedAmount() {
		return merchantReceivedAmount;
	}

	public void setMerchantReceivedAmount(BigDecimal merchantReceivedAmount) {
		this.merchantReceivedAmount = merchantReceivedAmount;
	}

	@Column(name = "D_RECEIVABLE_AMOUNT", precision = 12)
	public BigDecimal getDistCompanyReceivableAmount() {
		return distCompanyReceivableAmount;
	}

	public void setDistCompanyReceivableAmount(
			BigDecimal distCompanyReceivableAmount) {
		this.distCompanyReceivableAmount = distCompanyReceivableAmount;
	}

	@Column(name = "D_RECEIVED_AMOUNT", precision = 12)
	public BigDecimal getDistCompanyReceivedAmount() {
		return distCompanyReceivedAmount;
	}

	public void setDistCompanyReceivedAmount(
			BigDecimal distCompanyReceivedAmount) {
		this.distCompanyReceivedAmount = distCompanyReceivedAmount;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzDistStatement")
	public Set<BzDistStatementItem> getBzDistStatementItems() {
		return bzDistStatementItems;
	}

	public void setBzDistStatementItems(
			Set<BzDistStatementItem> bzDistStatementItems) {
		this.bzDistStatementItems = bzDistStatementItems;
	}

}
