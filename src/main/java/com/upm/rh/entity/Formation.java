package com.upm.rh.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "formation")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDFORMATION")
	private int idformation;
	
	@Column(name = "FORMATIONLIBELLE")
	private String formationLibelle;
	
	@Column(name = "FORMATIONDUREE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date duree;
	
	@Column(name = "OBJECTIF")
	private String objectif;
	
	@Column(name = "FORMATIONDATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date formationDate;

	@Column(name = "LIEN")
	private String lien;
	
	

	

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	public int getIdformation() {
		return idformation;
	}

	public void setIdformation(int idformation) {
		this.idformation = idformation;
	}

	public String getFormationLibelle() {
		return formationLibelle;
	}

	public void setFormationLibelle(String formationLibelle) {
		this.formationLibelle = formationLibelle;
	}

	public Date getFormationDate() {
		return formationDate;
	}

	public void setFormationDate(Date formationDate) {
		this.formationDate = formationDate;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	
	
	

}
