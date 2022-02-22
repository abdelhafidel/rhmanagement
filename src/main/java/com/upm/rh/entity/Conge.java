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
import javax.validation.constraints.Null;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "conge")
public class Conge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCONGE")
	private int idconge;
	
	@Column(name = "DATEDEPARTCONGE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departConge;
	
	@Column(name = "DATEFINCONGE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date finConge;
	
	@Column(name = "LIBCONGE")
	private String libConge;
	
	@Column(name = "NOM")
	private String nom;

	@Column(name = "ETATDEMANDE",nullable = true)
	private String ETATDEMANDE;
	
	
	@Column(name = "RAISONREFUS",nullable = true)
	private String refus;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "demande", 
	joinColumns = @JoinColumn(name = "IDCONGE", referencedColumnName = "IDCONGE"), 
	inverseJoinColumns = @JoinColumn(name = "IDEMPLOYE", referencedColumnName = "IDEMPLOYE"))
	private List<user> users;


	public List<user> getUsers() {
		return users;
	}


	public void setUsers(List<user> users) {
		this.users = users;
	}


	public int getIdconge() {
		return idconge;
	}


	public void setIdconge(int idconge) {
		this.idconge = idconge;
	}


	public Date getDepartConge() {
		return departConge;
	}


	public void setDepartConge(Date departConge) {
		this.departConge = departConge;
	}


	public Date getFinConge() {
		return finConge;
	}


	public void setFinConge(Date finConge) {
		this.finConge = finConge;
	}


	public String getLibConge() {
		return libConge;
	}


	public void setLibConge(String libConge) {
		this.libConge = libConge;
	}


	public String getETATDEMANDE() {
		return ETATDEMANDE;
	}


	public void setETATDEMANDE(String eTATDEMANDE) {
		ETATDEMANDE = eTATDEMANDE;
	}


	public String getRefus() {
		return refus;
	}


	public void setRefus(String refus) {
		this.refus = refus;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
