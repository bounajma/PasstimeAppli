package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sector_status database table.
 * 
 */
@Entity
@Table(name="sector_status")
@NamedQuery(name="SectorStatus.findAll", query="SELECT s FROM SectorStatus s")
public class SectorStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Sector
	@OneToMany(mappedBy="sectorStatus")
	private List<Sector> sectors;

	public SectorStatus() {
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

	public List<Sector> getSectors() {
		return this.sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	public Sector addSector(Sector sector) {
		getSectors().add(sector);
		sector.setSectorStatus(this);

		return sector;
	}

	public Sector removeSector(Sector sector) {
		getSectors().remove(sector);
		sector.setSectorStatus(null);

		return sector;
	}

}