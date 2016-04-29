package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sector database table.
 * 
 */
@Entity
@NamedQuery(name="Sector.findAll", query="SELECT s FROM Sector s")
public class Sector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="available_franchise")
	private byte availableFranchise;

	private String name;

	@Column(name="name_franchise")
	private String nameFranchise;

	@Column(name="short_name")
	private String shortName;

	//bi-directional many-to-one association to FranchiseSpace
	@OneToMany(mappedBy="sector")
	private List<FranchiseSpace> franchiseSpaces;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="sector")
	private List<Reservation> reservations;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="id_country")
	private Country country;

	//bi-directional many-to-one association to SectorGroup
	@ManyToOne
	@JoinColumn(name="id_sector_group")
	private SectorGroup sectorGroup;

	//bi-directional many-to-one association to SectorStatus
	@ManyToOne
	@JoinColumn(name="id_sector_status")
	private SectorStatus sectorStatus;

	public Sector() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAvailableFranchise() {
		return this.availableFranchise;
	}

	public void setAvailableFranchise(byte availableFranchise) {
		this.availableFranchise = availableFranchise;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameFranchise() {
		return this.nameFranchise;
	}

	public void setNameFranchise(String nameFranchise) {
		this.nameFranchise = nameFranchise;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public List<FranchiseSpace> getFranchiseSpaces() {
		return this.franchiseSpaces;
	}

	public void setFranchiseSpaces(List<FranchiseSpace> franchiseSpaces) {
		this.franchiseSpaces = franchiseSpaces;
	}

	public FranchiseSpace addFranchiseSpace(FranchiseSpace franchiseSpace) {
		getFranchiseSpaces().add(franchiseSpace);
		franchiseSpace.setSector(this);

		return franchiseSpace;
	}

	public FranchiseSpace removeFranchiseSpace(FranchiseSpace franchiseSpace) {
		getFranchiseSpaces().remove(franchiseSpace);
		franchiseSpace.setSector(null);

		return franchiseSpace;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setSector(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setSector(null);

		return reservation;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public SectorGroup getSectorGroup() {
		return this.sectorGroup;
	}

	public void setSectorGroup(SectorGroup sectorGroup) {
		this.sectorGroup = sectorGroup;
	}

	public SectorStatus getSectorStatus() {
		return this.sectorStatus;
	}

	public void setSectorStatus(SectorStatus sectorStatus) {
		this.sectorStatus = sectorStatus;
	}

}