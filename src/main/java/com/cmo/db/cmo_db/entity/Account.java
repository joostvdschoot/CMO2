package com.cmo.db.cmo_db.entity;

import javax.persistence.Entity;
import com.cmo.db.cmo_db.entity.base.AccountBase;

@Entity
public class Account extends AccountBase {

    public Account() {}

    public Account(String id) {
        this.set_id(Long.valueOf(id));
    }

	//OVERRIDE HERE YOUR CUSTOM MAPPER
	
	
}
