package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.product.BzProduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * 发货单条目
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_INVOICE_ITEM", catalog = "itaf")
public class BzInvoiceItem extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 5134143882561012877L;
	private Long id;
	private BzProduct bzProduct;
	private BzInvoice bzInvoice;
	private Long itemNum;

	public BzInvoiceItem() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_INVOICE_ITEM_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_PRODUCT_ID")
	public BzProduct getBzProduct() {
		return this.bzProduct;
	}

	public void setBzProduct(BzProduct bzProduct) {
		this.bzProduct = bzProduct;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_INVOICE_ID")
	public BzInvoice getBzInvoice() {
		return this.bzInvoice;
	}

	public void setBzInvoice(BzInvoice bzInvoice) {
		this.bzInvoice = bzInvoice;
	}

	@Column(name = "ITEM_NUM")
	public Long getItemNum() {
		return this.itemNum;
	}

	public void setItemNum(Long itemNum) {
		this.itemNum = itemNum;
	}

}
