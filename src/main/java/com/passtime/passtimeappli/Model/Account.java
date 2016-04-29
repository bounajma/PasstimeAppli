package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="account_active")
	private byte accountActive;

	@Lob
	private String address;

	@Lob
	@Column(name="address_additional")
	private String addressAdditional;

	@Column(name="change_password")
	private byte changePassword;

	@Temporal(TemporalType.DATE)
	@Column(name="date_birth")
	private Date dateBirth;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_last_connection")
	private Date dateLastConnection;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_registration")
	private Date dateRegistration;

	private String email;

	@Column(name="family_name")
	private String familyName;

	@Column(name="first_name")
	private String firstName;

	@Lob
	private String forbidden;

	@Column(name="home_phone")
	private String homePhone;
	@Column(name="key1")
	private String mykey;
	
	private String login;

	@Column(name="mobile_phone")
	private String mobilePhone;

	private String password;

	private String photo;

	private String postcode;

	private Integer timeout;

	private String title;

	private String token;

	private String town;

	//bi-directional many-to-one association to CentralManagement
	@Transient
	@ManyToOne
	@JoinColumn(name="id_central_management")
	private CentralManagement centralManagement;

	//bi-directional many-to-one association to Company
	@Transient
	@ManyToOne
	@JoinColumn(name="id_company")
	private Company company;

	//bi-directional many-to-one association to Country
	@ManyToOne()
	@JoinColumn(name="id_country")
	private Country country;

	//bi-directional many-to-one association to FranchiseSpace
	@Transient
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	//bi-directional many-to-one association to RightUser
	@Transient
	@ManyToOne
	@JoinColumn(name="id_right_user")
	private RightUser rightUser;

	//bi-directional many-to-one association to Address
	@Transient
	@OneToMany(mappedBy="account")
	private List<Address> addresses;

	//bi-directional many-to-one association to CodeCard
	@Transient
	@OneToMany(mappedBy="account")
	private List<CodeCard> codeCards;

	//bi-directional many-to-one association to Reservation
	@Transient
	@OneToMany(mappedBy="account")
	private List<Reservation> reservations;

	public Account() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte getAccountActive() {
		return this.accountActive;
	}

	public void setAccountActive(byte accountActive) {
		this.accountActive = accountActive;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressAdditional() {
		return this.addressAdditional;
	}

	public void setAddressAdditional(String addressAdditional) {
		this.addressAdditional = addressAdditional;
	}

	public byte getChangePassword() {
		return this.changePassword;
	}

	public void setChangePassword(byte changePassword) {
		this.changePassword = changePassword;
	}

	public Date getDateBirth() {
		return this.dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Date getDateLastConnection() {
		return this.dateLastConnection;
	}

	public void setDateLastConnection(Date dateLastConnection) {
		this.dateLastConnection = dateLastConnection;
	}

	public Date getDateRegistration() {
		return this.dateRegistration;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getForbidden() {
		return this.forbidden;
	}

	public void setForbidden(String forbidden) {
		this.forbidden = forbidden;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMykey() {
		return this.mykey;
	}

	public void setMykey(String key) {
		this.mykey = key;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Integer getTimeout() {
		return this.timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public CentralManagement getCentralManagement() {
		return this.centralManagement;
	}

	public void setCentralManagement(CentralManagement centralManagement) {
		this.centralManagement = centralManagement;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

	public RightUser getRightUser() {
		return this.rightUser;
	}

	public void setRightUser(RightUser rightUser) {
		this.rightUser = rightUser;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setAccount(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setAccount(null);

		return address;
	}

	public List<CodeCard> getCodeCards() {
		return this.codeCards;
	}

	public void setCodeCards(List<CodeCard> codeCards) {
		this.codeCards = codeCards;
	}

	public CodeCard addCodeCard(CodeCard codeCard) {
		getCodeCards().add(codeCard);
		codeCard.setAccount(this);

		return codeCard;
	}

	public CodeCard removeCodeCard(CodeCard codeCard) {
		getCodeCards().remove(codeCard);
		codeCard.setAccount(null);

		return codeCard;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setAccount(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setAccount(null);

		return reservation;
	}

}