package com.upm.rh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demandeformation")
public class DemandeFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDEMANDE")
	private int iddemande;
	@Column(name = "IDFORMATION")
	private int idformation;
	@Column(name = "IDEMPLOYE")
	private int idemploye;
	@Column(name = "DATEDEMANDE")
	private Date datedemande;
	@Column(name = "ETATDEMANDE")
	private String etatdemande;
	@Column(name = "RAISONREFUS")
	private String raisonrefus;

	public int getIddemande() {
		return iddemande;
	}

	public void setIddemande(int iddemande) {
		this.iddemande = iddemande;
	}

	public int getIdformation() {
		return idformation;
	}

	public void setIdformation(int idformation) {
		this.idformation = idformation;
	}

	public int getIdemploye() {
		return idemploye;
	}

	public void setIdemploye(int idemploye) {
		this.idemploye = idemploye;
	}

	public Date getDatedemande() {
		return datedemande;
	}

	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public String getEtatdemande() {
		return etatdemande;
	}

	public void setEtatdemande(String etatdemande) {
		this.etatdemande = etatdemande;
	}

	public String getRaisonrefus() {
		return raisonrefus;
	}

	public void setRaisonrefus(String raisonrefus) {
		this.raisonrefus = raisonrefus;
	}

}
