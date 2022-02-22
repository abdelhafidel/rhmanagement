package com.upm.rh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bulletin")
public class Bulletin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDBULLETIN")
	private int idBulletin;
	@Column(name = "NBHEURESTRAVAILLER")
	private int nbHeurs;
	@Column(name = "NBHEURBENUS")
	private int nbHeursBenus;
	@Column(name = "PRIME")
	private double prime;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "IDEMPLOYE")
	private user user;

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public int getIdBulletin() {
		return idBulletin;
	}

	public void setIdBulletin(int idBulletin) {
		this.idBulletin = idBulletin;
	}

	public int getNbHeurs() {
		return nbHeurs;
	}

	public void setNbHeurs(int nbHeurs) {
		this.nbHeurs = nbHeurs;
	}
	
	public void addNbHeurs(int nbHeurs) {
		this.nbHeurs = this.nbHeurs+nbHeurs;
	}

	public int getNbHeursBenus() {
		return nbHeursBenus;
	}

	public void setNbHeursBenus(int nbHeursBenus) {
		this.nbHeursBenus = nbHeursBenus;
	}
	
	public void addNbHeursBenus(int nbHeursBenus) {
		this.nbHeursBenus = this.nbHeursBenus+nbHeursBenus;
	}

	public double getPrime() {
		return prime;
	}

	public void setPrime(double prime) {
		this.prime = prime;
	}

}
