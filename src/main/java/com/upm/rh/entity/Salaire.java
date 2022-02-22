package com.upm.rh.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "salaire")
public class Salaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDSALAIRE")
	private int idSalaire;
	
	@Column(name = "SALAIREBASE")
	private double salaireBase;

	@Column(name = "DATESALAIRE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateSalaire;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "IDEMPLOYE")
	private user user;

	public int getIdSalaire() {
		return idSalaire;
	}

	public void setIdSalaire(int idSalaire) {
		this.idSalaire = idSalaire;
	}

	public double getSalaireBase() {
		return salaireBase;
	}

	public void setSalaireBase(double salaireBase) {
		this.salaireBase = salaireBase;
	}

	public Date getDateSalaire() {
		return dateSalaire;
	}

	public void setDateSalaire(Date dateSalaire) {
		this.dateSalaire = dateSalaire;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}
	
	

}
