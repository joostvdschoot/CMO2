package com.cmo.db.cmo_db.service.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import com.cmo.db.cmo_db.entity.Country;

import com.cmo.db.cmo_db.repositories.CountryRepository;

@Service
@Transactional
public class CountryBaseService {

	
	@Autowired
	CountryRepository countryRepository;


    // CRUD METHODS
    
    	
    // CRUD - GET LIST
    	
	public List<Country> getAll() {
		List<Country> list = new ArrayList<>();
		countryRepository.findAll().forEach(list::add);
		return list;
	}
	

}
