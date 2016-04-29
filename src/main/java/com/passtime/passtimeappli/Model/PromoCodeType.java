package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the promo_code_type database table.
 * 
 */
@Entity
@Table(name="promo_code_type")
@NamedQuery(name="PromoCodeType.findAll", query="SELECT p FROM PromoCodeType p")
public class PromoCodeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to PromoCode
	@OneToMany(mappedBy="promoCodeType")
	private List<PromoCode> promoCodes;

	public PromoCodeType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PromoCode> getPromoCodes() {
		return this.promoCodes;
	}

	public void setPromoCodes(List<PromoCode> promoCodes) {
		this.promoCodes = promoCodes;
	}

	public PromoCode addPromoCode(PromoCode promoCode) {
		getPromoCodes().add(promoCode);
		promoCode.setPromoCodeType(this);

		return promoCode;
	}

	public PromoCode removePromoCode(PromoCode promoCode) {
		getPromoCodes().remove(promoCode);
		promoCode.setPromoCodeType(null);

		return promoCode;
	}

}