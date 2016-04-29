package com.passtime.passtimeappli.Model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the partner_content_description database table.
 * 
 */
@Entity
@Table(name="partner_content_description")
@NamedQuery(name="PartnerContentDescription.findAll", query="SELECT p FROM PartnerContentDescription p")
public class PartnerContentDescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String agreement;

	@Lob
	private String description;

	@Column(name="for_all")
	private byte forAll;

	private String photo;

	@Column(name="photo_web")
	private String photoWeb;

	private String title;

	//bi-directional many-to-one association to Partner
	@JsonIgnore
	@OneToMany(mappedBy="partnerContentDescription")
	private List<Partner> partners;

	//bi-directional many-to-one association to PartnerOffer
	@ManyToOne
	@JoinColumn(name="id_partner_offer")
	private PartnerOffer partnerOffer1;

	//bi-directional many-to-one association to PartnerOffer
	@ManyToOne
	@JoinColumn(name="id_partner_offer_second")
	private PartnerOffer partnerOffer2;

	//bi-directional many-to-one association to PartnerOverall
	@Transient
	@ManyToOne
	@JoinColumn(name="id_partner_overall")
	private PartnerOverall partnerOverall;

	public PartnerContentDescription() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgreement() {
		return this.agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getForAll() {
		return this.forAll;
	}

	public void setForAll(byte forAll) {
		this.forAll = forAll;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhotoWeb() {
		return this.photoWeb;
	}

	public void setPhotoWeb(String photoWeb) {
		this.photoWeb = photoWeb;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Partner> getPartners() {
		return this.partners;
	}

	public void setPartners(List<Partner> partners) {
		this.partners = partners;
	}

	public Partner addPartner(Partner partner) {
		getPartners().add(partner);
		partner.setPartnerContentDescription(this);

		return partner;
	}

	public Partner removePartner(Partner partner) {
		getPartners().remove(partner);
		partner.setPartnerContentDescription(null);

		return partner;
	}

	public PartnerOffer getPartnerOffer1() {
		return this.partnerOffer1;
	}

	public void setPartnerOffer1(PartnerOffer partnerOffer1) {
		this.partnerOffer1 = partnerOffer1;
	}

	public PartnerOffer getPartnerOffer2() {
		return this.partnerOffer2;
	}

	public void setPartnerOffer2(PartnerOffer partnerOffer2) {
		this.partnerOffer2 = partnerOffer2;
	}

	public PartnerOverall getPartnerOverall() {
		return this.partnerOverall;
	}

	public void setPartnerOverall(PartnerOverall partnerOverall) {
		this.partnerOverall = partnerOverall;
	}

}