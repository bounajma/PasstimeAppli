package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private float price;

	//bi-directional many-to-one association to PromoCode
	@OneToMany(mappedBy="product")
	private List<PromoCode> promoCodes;

	public Product() {
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

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<PromoCode> getPromoCodes() {
		return this.promoCodes;
	}

	public void setPromoCodes(List<PromoCode> promoCodes) {
		this.promoCodes = promoCodes;
	}

	public PromoCode addPromoCode(PromoCode promoCode) {
		getPromoCodes().add(promoCode);
		promoCode.setProduct(this);

		return promoCode;
	}

	public PromoCode removePromoCode(PromoCode promoCode) {
		getPromoCodes().remove(promoCode);
		promoCode.setProduct(null);

		return promoCode;
	}

}