package com.cmo.db.cmo_db.service.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import com.cmo.db.cmo_db.entity.Lessor;

import com.cmo.db.cmo_db.entity.Country;

import com.cmo.db.cmo_db.entity.Lessor;

import com.cmo.db.cmo_db.repositories.LessorRepository;

@Service
@Transactional
public class LessorBaseService {

	
	@Autowired
	LessorRepository lessorRepository;


    // CRUD METHODS
    
    	
    // CRUD - GET LIST
    	
	public List<Lessor> getAll() {
		List<Lessor> list = new ArrayList<>();
		lessorRepository.findAll().forEach(list::add);
		return list;
	}
	

}
