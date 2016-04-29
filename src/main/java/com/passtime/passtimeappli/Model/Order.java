package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_revive")
	private Date dateRevive;

	@Column(name="id_account")
	private int idAccount;

	@Column(name="id_address")
	private int idAddress;

	@Column(name="id_franchise_space")
	private int idFranchiseSpace;

	@Column(name="id_product")
	private int idProduct;

	@Column(name="id_promo_code")
	private int idPromoCode;

	private int quantity;

	@Column(name="total_price")
	private float totalPrice;

	@Column(name="transaction_id")
	private String transactionId;

	private int validated;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateRevive() {
		return this.dateRevive;
	}

	public void setDateRevive(Date dateRevive) {
		this.dateRevive = dateRevive;
	}

	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getIdAddress() {
		return this.idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public int getIdFranchiseSpace() {
		return this.idFranchiseSpace;
	}

	public void setIdFranchiseSpace(int idFranchiseSpace) {
		this.idFranchiseSpace = idFranchiseSpace;
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdPromoCode() {
		return this.idPromoCode;
	}

	public void setIdPromoCode(int idPromoCode) {
		this.idPromoCode = idPromoCode;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getValidated() {
		return this.validated;
	}

	public void setValidated(int validated) {
		this.validated = validated;
	}

}