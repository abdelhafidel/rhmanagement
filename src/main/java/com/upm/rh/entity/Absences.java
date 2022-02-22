package com.upm.rh.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "absences")
public class Absences {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDABSENCES")
	private int idAbsences;
	
	@Column(name = "DATEABSENCE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateAbsence;
	@Column(name = "DUREEABSENCE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dureeAbsence;
	
	@Column(name = "MOTIFABSENCE")
	private String motifAbsence;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "IDEMPLOYE")
	private user user;



	public int getIdAbsences() {
		return idAbsences;
	}

	public void setIdAbsences(int idAbsences) {
		this.idAbsences = idAbsences;
	}

	public Date getDateAbsence() {
		return dateAbsence;
	}

	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}

	public Date getDureeAbsence() {
		return dureeAbsence;
	}

	public void setDureeAbsence(Date dureeAbsence) {
		this.dureeAbsence = dureeAbsence;
	}

	public String getMotifAbsence() {
		return motifAbsence;
	}

	public void setMotifAbsence(String motifAbsence) {
		this.motifAbsence = motifAbsence;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}
	
	
	


}
