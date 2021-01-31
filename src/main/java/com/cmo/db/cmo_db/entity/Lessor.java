package com.cmo.db.cmo_db.entity;

import javax.persistence.Entity;
import com.cmo.db.cmo_db.entity.base.LessorBase;

@Entity
public class Lessor extends LessorBase {

    public Lessor() {}

    public Lessor(String id) {
        this.set_id(Long.valueOf(id));
    }

	//OVERRIDE HERE YOUR CUSTOM MAPPER
	
	
}
