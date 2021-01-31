package com.cmo.db.cmo_db.entity.base;

/**
 * 
 * 
  _____                      _              _ _ _     _   _     _        __ _ _      
 |  __ \                    | |            | (_) |   | | | |   (_)      / _(_) |     
 | |  | | ___    _ __   ___ | |_    ___  __| |_| |_  | |_| |__  _ ___  | |_ _| | ___ 
 | |  | |/ _ \  | '_ \ / _ \| __|  / _ \/ _` | | __| | __| '_ \| / __| |  _| | |/ _ \
 | |__| | (_) | | | | | (_) | |_  |  __/ (_| | | |_  | |_| | | | \__ \ | | | | |  __/
 |_____/ \___/  |_| |_|\___/ \__|  \___|\__,_|_|\__|  \__|_| |_|_|___/ |_| |_|_|\___|
 
                                                                                   
 * DO NOT EDIT THIS FILE!! 
 *
 *  FOR CUSTOMIZE CountryBase PLEASE EDIT ../Country.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the model of Country object
 * 
 */

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import java.util.stream.Collectors;

import com.cmo.db.cmo_db.entity.Country;
// Import relations
import com.cmo.db.cmo_db.entity.Lessor;

import com.cmo.db.cmo_db.entity.Organization;





@MappedSuperclass
public class CountryBase {
	
	@Id
	@GeneratedValue
	private Long _id;
	
	// Attributes
	@Column(nullable=false,unique=true)
    private String Code;
	@Column(nullable=false,unique=true)
    private String Name;
	
	// Relations Lessor
	@OneToMany(mappedBy="Country")
	private List<Lessor> Country_Lessor = new ArrayList<>();
	
	// Relations Organization
	@OneToMany(mappedBy="Country")
	private List<Organization> Country_Organization = new ArrayList<>();
	
	
	
	public Long get_id() {
		return _id;
	}

	public void set_id(Long id) {
		this._id = id;
	}
	
	public String getCode() {
		return Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
    
	// Relations Lessor
	
	public List<Lessor> getLessor() {
		return this.Country_Lessor;
	}

	public void addLessor(Lessor Lessor) {
		this.Country_Lessor.add(Lessor);
	}

	public void removeLessor(Lessor Lessor) {
		this.Country_Lessor.remove(Lessor);
	}
	
	// Relations Organization
	
	public List<Organization> getOrganization() {
		return this.Country_Organization;
	}

	public void addOrganization(Organization Organization) {
		this.Country_Organization.add(Organization);
	}

	public void removeOrganization(Organization Organization) {
		this.Country_Organization.remove(Organization);
	}
	

    
}