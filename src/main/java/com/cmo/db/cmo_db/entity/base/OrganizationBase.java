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
 *  FOR CUSTOMIZE OrganizationBase PLEASE EDIT ../Organization.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the model of Organization object
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

import com.cmo.db.cmo_db.entity.Organization;
// Import relations
import com.cmo.db.cmo_db.entity.Country;

import com.cmo.db.cmo_db.entity.Lessor;

import com.cmo.db.cmo_db.entity.Organization;

import com.cmo.db.cmo_db.entity.CreditLine;

import com.cmo.db.cmo_db.entity.Organization;

import com.cmo.db.cmo_db.entity.Organization;









@MappedSuperclass
public class OrganizationBase {
	
	@Id
	@GeneratedValue
	private Long _id;
	
	// Attributes
	@Column()
    private Boolean Active;
	@Column(nullable=false,unique=true)
    private String ExternalID;
	@Column()
    private String FormalName;
	@Column()
    private Boolean Liable;
	@Column()
    private String SearchName;
	@Column()
    private String Type;
	
	// Relations Country
	@ManyToOne(fetch = FetchType.LAZY)
	private Country Country;
	
	// Relations Lessor
	@ManyToOne(fetch = FetchType.LAZY)
	private Lessor Lessor;
	
	// Relations LiableParent
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization LiableParent;
	
	// Relations CreditLine
	@OneToMany(mappedBy="Organization")
	private List<CreditLine> Organization_CreditLine = new ArrayList<>();
	
	// Relations Parent
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization Parent;
	
	// Relations UtlimateParent
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization UtlimateParent;
	
	
	
	public Long get_id() {
		return _id;
	}

	public void set_id(Long id) {
		this._id = id;
	}
	
	public Boolean getActive() {
		return Active;
	}

	public void setActive(Boolean Active) {
		this.Active = Active;
	}
	public String getExternalID() {
		return ExternalID;
	}

	public void setExternalID(String ExternalID) {
		this.ExternalID = ExternalID;
	}
	public String getFormalName() {
		return FormalName;
	}

	public void setFormalName(String FormalName) {
		this.FormalName = FormalName;
	}
	public Boolean getLiable() {
		return Liable;
	}

	public void setLiable(Boolean Liable) {
		this.Liable = Liable;
	}
	public String getSearchName() {
		return SearchName;
	}

	public void setSearchName(String SearchName) {
		this.SearchName = SearchName;
	}
	public String getType() {
		return Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}
    
	public void setCountry(String Country) {
		this.Country = new Country(Country);
	}

	public Country getCountry() {
		return Country;
	}
	
	public void setLessor(String Lessor) {
		this.Lessor = new Lessor(Lessor);
	}

	public Lessor getLessor() {
		return Lessor;
	}
	
	public void setOrganization(String LiableParent) {
		this.LiableParent = new Organization(LiableParent);
	}

	public Organization getLiableParent() {
		return LiableParent;
	}
	
	// Relations CreditLine
	
	public List<CreditLine> getCreditLine() {
		return this.Organization_CreditLine;
	}

	public void addCreditLine(CreditLine CreditLine) {
		this.Organization_CreditLine.add(CreditLine);
	}

	public void removeCreditLine(CreditLine CreditLine) {
		this.Organization_CreditLine.remove(CreditLine);
	}
	
	public void setOrganization(String Parent) {
		this.Parent = new Organization(Parent);
	}

	public Organization getParent() {
		return Parent;
	}
	
	public void setOrganization(String UtlimateParent) {
		this.UtlimateParent = new Organization(UtlimateParent);
	}

	public Organization getUtlimateParent() {
		return UtlimateParent;
	}
	

    
}