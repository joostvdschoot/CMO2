package com.cmo.db.cmo_db.entity;

import javax.persistence.Entity;
import com.cmo.db.cmo_db.entity.base.CountryBase;

@Entity
public class Country extends CountryBase {

    public Country() {}

    public Country(String id) {
        this.set_id(Long.valueOf(id));
    }

	//OVERRIDE HERE YOUR CUSTOM MAPPER
	
	
}
