package com.cmo.db.cmo_db.service.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import com.cmo.db.cmo_db.entity.Organization;

import com.cmo.db.cmo_db.entity.Country;

import com.cmo.db.cmo_db.entity.Lessor;

import com.cmo.db.cmo_db.entity.Organization;

import com.cmo.db.cmo_db.entity.Organization;

import com.cmo.db.cmo_db.entity.Organization;

import com.cmo.db.cmo_db.repositories.OrganizationRepository;

@Service
@Transactional
public class OrganizationBaseService {

	
	@Autowired
	OrganizationRepository organizationRepository;


    // CRUD METHODS
    
    // CRUD - CREATE
    
	public Organization insert(Organization organization) {
		return organizationRepository.save(organization);
	}
	
	// CRUD - REMOVE
    
	public void delete(Long id) {
		organizationRepository.delete(id);
	}

    
    
    // CRUD - FIND BY Lessor

    public List<Organization> findByLessor(Lessor lessor) {
		return organizationRepository.findByLessor(lessor);
	}
    
    
    
    
	// CRUD - GET ONE
    	
	public Organization getOne(Long id) {
		return organizationRepository.findOne(id);
	}

    	
    // CRUD - GET LIST
    	
	public List<Organization> getAll() {
		List<Organization> list = new ArrayList<>();
		organizationRepository.findAll().forEach(list::add);
		return list;
	}
	

}
