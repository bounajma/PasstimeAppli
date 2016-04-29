package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the partner_sharing database table.
 * 
 */
@Entity
@Table(name="partner_sharing")
@NamedQuery(name="PartnerSharing.findAll", query="SELECT p FROM PartnerSharing p")
public class PartnerSharing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="to_tourism")
	private byte toTourism;

	@Column(name="valid_sharing")
	private byte validSharing;

	//bi-directional many-to-one association to FranchiseSpace
	@ManyToOne
	@JoinColumn(name="id_franchise_space")
	private FranchiseSpace franchiseSpace;

	//bi-directional many-to-one association to PartnerOverall
	@Transient
	@ManyToOne
	@JoinColumn(name="id_partner_overall")
	private PartnerOverall partnerOverall;

	public PartnerSharing() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getToTourism() {
		return this.toTourism;
	}

	public void setToTourism(byte toTourism) {
		this.toTourism = toTourism;
	}

	public byte getValidSharing() {
		return this.validSharing;
	}

	public void setValidSharing(byte validSharing) {
		this.validSharing = validSharing;
	}

	public FranchiseSpace getFranchiseSpace() {
		return this.franchiseSpace;
	}

	public void setFranchiseSpace(FranchiseSpace franchiseSpace) {
		this.franchiseSpace = franchiseSpace;
	}

	public PartnerOverall getPartnerOverall() {
		return this.partnerOverall;
	}

	public void setPartnerOverall(PartnerOverall partnerOverall) {
		this.partnerOverall = partnerOverall;
	}

}