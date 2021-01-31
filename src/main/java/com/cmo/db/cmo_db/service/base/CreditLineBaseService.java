package com.cmo.db.cmo_db.service.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import com.cmo.db.cmo_db.entity.CreditLine;

import com.cmo.db.cmo_db.entity.Organization;

import com.cmo.db.cmo_db.repositories.CreditLineRepository;

@Service
@Transactional
public class CreditLineBaseService {

	
	@Autowired
	CreditLineRepository creditlineRepository;


    // CRUD METHODS
    
    // CRUD - CREATE
    
	public CreditLine insert(CreditLine creditline) {
		return creditlineRepository.save(creditline);
	}
	
	// CRUD - REMOVE
    
	public void delete(Long id) {
		creditlineRepository.delete(id);
	}

    
    // CRUD - FIND BY Organization

    public List<CreditLine> findByOrganization(Organization organization) {
		return creditlineRepository.findByOrganization(organization);
	}
    
	// CRUD - GET ONE
    	
	public CreditLine getOne(Long id) {
		return creditlineRepository.findOne(id);
	}

    	
    // CRUD - GET LIST
    	
	public List<CreditLine> getAll() {
		List<CreditLine> list = new ArrayList<>();
		creditlineRepository.findAll().forEach(list::add);
		return list;
	}
	

}
