package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import java.util.List;

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
 * The persistent class for the partner_overall database table.
 * 
 */
@Entity
@Table(name="partner_overall")
@NamedQuery(name="PartnerOverall.findAll", query="SELECT p FROM PartnerOverall p")
public class PartnerOverall implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte lock;

	private String name;

	@Lob
	private String observation;

	private Integer position;

	//bi-directional many-to-one association to IdeaWeHotel
	@Transient
	@OneToMany(mappedBy="partnerOverall")
	private List<IdeaWeHotel> ideaWeHotels;

	//bi-directional many-to-one association to Partner
	@JsonIgnore
	@OneToMany(mappedBy="partnerOverall")
	private List<Partner> partners;

	//bi-directional many-to-one association to PartnerContentDescription
	@Transient
	@OneToMany(mappedBy="partnerOverall")
	private List<PartnerContentDescription> partnerContentDescriptions;

	//bi-directional many-to-one association to FranchiseSpace
	@Transient
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	//bi-directional many-to-one association to PartnerStatus
	@ManyToOne
	@JoinColumn(name="id_partner_status")
	private PartnerStatus partnerStatus;

	//bi-directional many-to-one association to PartnerStatusRaison
	@ManyToOne
	@JoinColumn(name="id_partner_status_raison")
	private PartnerStatusRaison partnerStatusRaison;

	//bi-directional many-to-one association to PartnerType
	@ManyToOne
	@JoinColumn(name="id_partner_type")
	private PartnerType partnerType;

	//bi-directional many-to-one association to PartnerSharing
	@Transient
	@OneToMany(mappedBy="partnerOverall")
	private List<PartnerSharing> partnerSharings;

	public PartnerOverall() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getLock() {
		return this.lock;
	}

	public void setLock(byte lock) {
		this.lock = lock;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public List<IdeaWeHotel> getIdeaWeHotels() {
		return this.ideaWeHotels;
	}

	public void setIdeaWeHotels(List<IdeaWeHotel> ideaWeHotels) {
		this.ideaWeHotels = ideaWeHotels;
	}

	public IdeaWeHotel addIdeaWeHotel(IdeaWeHotel ideaWeHotel) {
		getIdeaWeHotels().add(ideaWeHotel);
		ideaWeHotel.setPartnerOverall(this);

		return ideaWeHotel;
	}

	public IdeaWeHotel removeIdeaWeHotel(IdeaWeHotel ideaWeHotel) {
		getIdeaWeHotels().remove(ideaWeHotel);
		ideaWeHotel.setPartnerOverall(null);

		return ideaWeHotel;
	}

	public List<Partner> getPartners() {
		return this.partners;
	}

	public void setPartners(List<Partner> partners) {
		this.partners = partners;
	}

	public Partner addPartner(Partner partner) {
		getPartners().add(partner);
		partner.setPartnerOverall(this);

		return partner;
	}

	public Partner removePartner(Partner partner) {
		getPartners().remove(partner);
		partner.setPartnerOverall(null);

		return partner;
	}

	public List<PartnerContentDescription> getPartnerContentDescriptions() {
		return this.partnerContentDescriptions;
	}

	public void setPartnerContentDescriptions(List<PartnerContentDescription> partnerContentDescriptions) {
		this.partnerContentDescriptions = partnerContentDescriptions;
	}

	public PartnerContentDescription addPartnerContentDescription(PartnerContentDescription partnerContentDescription) {
		getPartnerContentDescriptions().add(partnerContentDescription);
		partnerContentDescription.setPartnerOverall(this);

		return partnerContentDescription;
	}

	public PartnerContentDescription removePartnerContentDescription(PartnerContentDescription partnerContentDescription) {
		getPartnerContentDescriptions().remove(partnerContentDescription);
		partnerContentDescription.setPartnerOverall(null);

		return partnerContentDescription;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

	public PartnerStatus getPartnerStatus() {
		return this.partnerStatus;
	}

	public void setPartnerStatus(PartnerStatus partnerStatus) {
		this.partnerStatus = partnerStatus;
	}

	public PartnerStatusRaison getPartnerStatusRaison() {
		return this.partnerStatusRaison;
	}

	public void setPartnerStatusRaison(PartnerStatusRaison partnerStatusRaison) {
		this.partnerStatusRaison = partnerStatusRaison;
	}

	public PartnerType getPartnerType() {
		return this.partnerType;
	}

	public void setPartnerType(PartnerType partnerType) {
		this.partnerType = partnerType;
	}

	public List<PartnerSharing> getPartnerSharings() {
		return this.partnerSharings;
	}

	public void setPartnerSharings(List<PartnerSharing> partnerSharings) {
		this.partnerSharings = partnerSharings;
	}

	public PartnerSharing addPartnerSharing(PartnerSharing partnerSharing) {
		getPartnerSharings().add(partnerSharing);
		partnerSharing.setPartnerOverall(this);

		return partnerSharing;
	}

	public PartnerSharing removePartnerSharing(PartnerSharing partnerSharing) {
		getPartnerSharings().remove(partnerSharing);
		partnerSharing.setPartnerOverall(null);

		return partnerSharing;
	}

}