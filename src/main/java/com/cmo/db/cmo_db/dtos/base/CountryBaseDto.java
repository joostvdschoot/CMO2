package com.cmo.db.cmo_db.dtos.base;

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
 *  FOR CUSTOMIZE CountryBaseDto PLEASE EDIT ../CountryDto.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the dto of Country object
 * 
 */

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.cmo.db.cmo_db.entity.Country;
// Import relations
import com.cmo.db.cmo_db.dtos.infos.LessorInfo;

import com.cmo.db.cmo_db.dtos.infos.OrganizationInfo;




public class CountryBaseDto {
	
	private Long _id;
	
	// Attributes
    private String Code;
    private String Name;
	
	// Relations Lessor
	private List<Long> Country_Lessor = new ArrayList<>();
	
	// Relations Organization
	private List<Long> Country_Organization = new ArrayList<>();
	
	
	
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
	
	public List<Long> getCountry_Lessor() {
		return this.Country_Lessor;
	}

    public void setCountry_Lessor(List<LessorInfo> list) {
		this.Country_Lessor = list.stream()
				.map(el -> el.get_id())
				.collect(Collectors.toList());
	}

	
	// Relations Organization
	
	public List<Long> getCountry_Organization() {
		return this.Country_Organization;
	}

    public void setCountry_Organization(List<OrganizationInfo> list) {
		this.Country_Organization = list.stream()
				.map(el -> el.get_id())
				.collect(Collectors.toList());
	}

	

    
}