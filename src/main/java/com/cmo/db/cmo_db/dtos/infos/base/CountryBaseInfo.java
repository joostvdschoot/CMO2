package com.cmo.db.cmo_db.dtos.infos.base;

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
 *  FOR CUSTOMIZE CountryInfoDto PLEASE EDIT ../CountryInfo.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the info of Country object
 * 
 */

import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class CountryBaseInfo {
	
	private Long _id;
	// Attributes
    private String Code;
    private String Name;
	
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
}