package com.cmo.db.cmo_db.entity;

import javax.persistence.Entity;
import com.cmo.db.cmo_db.entity.base.OrganizationBase;

@Entity
public class Organization extends OrganizationBase {

    public Organization() {}

    public Organization(String id) {
        this.set_id(Long.valueOf(id));
    }

	//OVERRIDE HERE YOUR CUSTOM MAPPER
	
	
}
