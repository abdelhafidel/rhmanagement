package com.upm.rh.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employe")
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDEMPLOYE")
	private int id;
	@Column(name = "NOMEMPLOYE")
	private String nomeEmploye;
	@Column(name = "PRENOMEMPLOYE")
	private String prenomEmploye;
	@Column(name = "DIPLOMEEMPLOYE")
	private String diplomeEmploye;
	@Column(name = "AGEEMPLOYE")
	private int ageEmploye;
	@Column(name = "ADRESSEMPLOYE")
	private String adressEmploye;
	@Column(name = "TELEMPLOYE")
	private String telEmploye;
	@Column(name = "EMAILEMPLOYE")
	private String emailEMPLOYE;
	@Column(name = "CINEMPLOYE")
	private String cinEmploye;
	@Column(name = "LOGIN")
	private String username;
	@Column(name = "PWD")
	private String pwd;
	@Column(name = "Post")
	private String Post;
	@Column(name = "ROLE")
	private String role = "";

	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Bulletin bulletin;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Salaire salaire;
	
	//pour la gestion des conges
	@ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
	private List<Conge> conges;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Absences> absences;

	

	public Salaire getSalaire() {
		return salaire;
	}

	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}

	public Bulletin getBulletin() {
		return bulletin;
	}

	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}

	public List<Absences> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absences> absences) {
		this.absences = absences;
	}

	public List<Conge> getConges() {
		return conges;
	}

	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}

	public String getNomeEmploye() {
		return nomeEmploye;
	}

	public void setNomeEmploye(String nomeEmploye) {
		this.nomeEmploye = nomeEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getDiplomeEmploye() {
		return diplomeEmploye;
	}

	public void setDiplomeEmploye(String diplomeEmploye) {
		this.diplomeEmploye = diplomeEmploye;
	}

	public int getAgeEmploye() {
		return ageEmploye;
	}

	public void setAgeEmploye(int ageEmploye) {
		this.ageEmploye = ageEmploye;
	}

	public String getAdressEmploye() {
		return adressEmploye;
	}

	public void setAdressEmploye(String adressEmploye) {
		this.adressEmploye = adressEmploye;
	}

	public String getTelEmploye() {
		return telEmploye;
	}

	public void setTelEmploye(String telEmploye) {
		this.telEmploye = telEmploye;
	}

	public String getEmailEMPLOYE() {
		return emailEMPLOYE;
	}

	public void setEmailEMPLOYE(String emailEMPLOYE) {
		this.emailEMPLOYE = emailEMPLOYE;
	}

	public String getCinEmploye() {
		return cinEmploye;
	}

	public void setCinEmploye(String cinEmploye) {
		this.cinEmploye = cinEmploye;
	}

	public String getPost() {
		return Post;
	}

	public void setPost(String post) {
		Post = post;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<String> getRoleList() {
		if (this.role.length() > 0) {
			return Arrays.asList(this.role.split(","));
		}
		return new ArrayList<>();
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", nomeEmploye=" + nomeEmploye + ", prenomEmploye=" + prenomEmploye
				+ ", diplomeEmploye=" + diplomeEmploye + ", ageEmploye=" + ageEmploye + ", adressEmploye="
				+ adressEmploye + ", telEmploye=" + telEmploye + ", emailEMPLOYE=" + emailEMPLOYE + ", cinEmploye="
				+ cinEmploye + ", username=" + username + ", pwd=" + pwd + ", Post=" + Post + ", role=" + role + "]";
	}

}
