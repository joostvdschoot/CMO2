package com.cmo.db.cmo_db.entity;

import javax.persistence.Entity;
import com.cmo.db.cmo_db.entity.base.CreditLineBase;

@Entity
public class CreditLine extends CreditLineBase {

    public CreditLine() {}

    public CreditLine(String id) {
        this.set_id(Long.valueOf(id));
    }

	//OVERRIDE HERE YOUR CUSTOM MAPPER
	
	
}
