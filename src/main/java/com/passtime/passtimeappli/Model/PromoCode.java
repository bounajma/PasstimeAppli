package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the promo_code database table.
 * 
 */
@Entity
@Table(name="promo_code")
@NamedQuery(name="PromoCode.findAll", query="SELECT p FROM PromoCode p")
public class PromoCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String code;

	@Temporal(TemporalType.DATE)
	@Column(name="date_expiration")
	private Date dateExpiration;

	@Lob
	private String entitle;

	private int valid;

	private float value;

	//bi-directional many-to-one association to FranchiseSpace
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to PromoCodeType
	@ManyToOne
	@JoinColumn(name="id_promo_code_type")
	private PromoCodeType promoCodeType;

	public PromoCode() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateExpiration() {
		return this.dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getEntitle() {
		return this.entitle;
	}

	public void setEntitle(String entitle) {
		this.entitle = entitle;
	}

	public int getValid() {
		return this.valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PromoCodeType getPromoCodeType() {
		return this.promoCodeType;
	}

	public void setPromoCodeType(PromoCodeType promoCodeType) {
		this.promoCodeType = promoCodeType;
	}

}