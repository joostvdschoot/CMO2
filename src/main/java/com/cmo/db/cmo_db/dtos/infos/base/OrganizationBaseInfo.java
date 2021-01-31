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
 *  FOR CUSTOMIZE OrganizationInfoDto PLEASE EDIT ../OrganizationInfo.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the info of Organization object
 * 
 */

import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class OrganizationBaseInfo {
	
	private Long _id;
	// Attributes
    private Boolean Active;
    private String ExternalID;
    private String FormalName;
    private Boolean Liable;
    private String SearchName;
    private String Type;
	
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
}