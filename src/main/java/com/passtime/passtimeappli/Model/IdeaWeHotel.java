package com.passtime.passtimeappli.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the idea_we_hotel database table.
 * 
 */
@Entity
@Table(name="idea_we_hotel")
@NamedQuery(name="IdeaWeHotel.findAll", query="SELECT i FROM IdeaWeHotel i")
public class IdeaWeHotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to PartnerOverall
	@Transient
	@ManyToOne
	@JoinColumn(name="id_partner_overall")
	private PartnerOverall partnerOverall;

	public IdeaWeHotel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PartnerOverall getPartnerOverall() {
		return this.partnerOverall;
	}

	public void setPartnerOverall(PartnerOverall partnerOverall) {
		this.partnerOverall = partnerOverall;
	}

}