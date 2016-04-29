package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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


/**
 * The persistent class for the partner database table.
 * 
 */
@Entity
@NamedQuery(name="Partner.findAll", query="SELECT p FROM Partner p")
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String address;

	@Lob
	@Column(name="address_additional")
	private String addressAdditional;

	private String contact;

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date dateCreation;

	@Temporal(TemporalType.DATE)
	@Column(name="date_expiration")
	private Date dateExpiration;

	@Temporal(TemporalType.DATE)
	@Column(name="date_modification")
	private Date dateModification;

	private String email;

	@Column(name="home_phone")
	private String homePhone;

	private Double latitude;

	private Double longitude;

	@Column(name="mobile_phone")
	private String mobilePhone;

	private String postcode;

	private String town;

	@Column(name="valid_partner")
	private byte validPartner;

	private String website;

	//bi-directional many-to-one association to IdeaWe
	@OneToMany(mappedBy="partner",fetch = FetchType.EAGER)
	private List<IdeaWe> ideaWes;

	//bi-directional many-to-one association to Country
	@Transient
	@ManyToOne
	@JoinColumn(name="id_country")
	private Country country;

	//bi-directional many-to-one association to PartnerContentDescription
	@ManyToOne
	@JoinColumn(name="id_partner_content_description")
	private PartnerContentDescription partnerContentDescription;

	//bi-directional many-to-one association to PartnerFormat
	@ManyToOne
	@JoinColumn(name="id_partner_format")
	private PartnerFormat partnerFormat;

	//bi-directional many-to-one association to PartnerOverall
	@ManyToOne
	@JoinColumn(name="id_partner_overall")
	private PartnerOverall partnerOverall;

	public Partner() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateExpiration() {
		return this.dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Date getDateModification() {
		return this.dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public byte getValidPartner() {
		return this.validPartner;
	}

	public void setValidPartner(byte validPartner) {
		this.validPartner = validPartner;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<IdeaWe> getIdeaWes() {
		return this.ideaWes;
	}

	public void setIdeaWes(List<IdeaWe> ideaWes) {
		this.ideaWes = ideaWes;
	}

	public IdeaWe addIdeaWe(IdeaWe ideaWe) {
		getIdeaWes().add(ideaWe);
		ideaWe.setPartner(this);

		return ideaWe;
	}

	public IdeaWe removeIdeaWe(IdeaWe ideaWe) {
		getIdeaWes().remove(ideaWe);
		ideaWe.setPartner(null);

		return ideaWe;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public PartnerContentDescription getPartnerContentDescription() {
		return this.partnerContentDescription;
	}

	public void setPartnerContentDescription(PartnerContentDescription partnerContentDescription) {
		this.partnerContentDescription = partnerContentDescription;
	}

	public PartnerFormat getPartnerFormat() {
		return this.partnerFormat;
	}

	public void setPartnerFormat(PartnerFormat partnerFormat) {
		this.partnerFormat = partnerFormat;
	}

	public PartnerOverall getPartnerOverall() {
		return this.partnerOverall;
	}

	public void setPartnerOverall(PartnerOverall partnerOverall) {
		this.partnerOverall = partnerOverall;
	}

}