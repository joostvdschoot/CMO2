package com.cmo.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.cmo.db.cmo_db.service.OrganizationService;
import com.cmo.db.cmo_db.entity.Organization;
import com.cmo.db.cmo_db.dtos.OrganizationDto;

import com.cmo.db.cmo_db.entity.Country;

import com.cmo.db.cmo_db.entity.Lessor;

import com.cmo.db.cmo_db.entity.Organization;

import com.cmo.db.cmo_db.entity.Organization;

import com.cmo.db.cmo_db.entity.Organization;

//IMPORT RELATIONS

import com.cmo.db.cmo_db.service.CountryService;

import com.cmo.db.cmo_db.service.LessorService;

import com.cmo.db.cmo_db.service.OrganizationService;

import com.cmo.db.cmo_db.service.CreditLineService;

import com.cmo.db.cmo_db.service.OrganizationService;

import com.cmo.db.cmo_db.service.OrganizationService;


public class OrganizationBaseController {
    
    @Autowired
	OrganizationService organizationService;

	
	@Autowired
	CountryService countryService;
	
	@Autowired
	LessorService lessorService;
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	CreditLineService creditlineService;
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	OrganizationService organizationService;
	

	@Autowired
	private ModelMapper modelMapper;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/organization")
	public ResponseEntity<OrganizationDto> insert(@RequestBody Organization obj) {
				
		//external relation Country
		if (obj.getCountry() != null) {
			if (obj.getCountry().get_id() == null)
				countryService.insert(obj.getCountry());
			else
				countryService.insert(countryService.getOne(obj.getCountry().get_id()));
		}
				
		//external relation Lessor
		if (obj.getLessor() != null) {
			if (obj.getLessor().get_id() == null)
				lessorService.insert(obj.getLessor());
			else
				lessorService.insert(lessorService.getOne(obj.getLessor().get_id()));
		}
				
		//external relation LiableParent
		if (obj.getLiableParent() != null) {
			if (obj.getLiableParent().get_id() == null)
				organizationService.insert(obj.getLiableParent());
			else
				organizationService.insert(organizationService.getOne(obj.getLiableParent().get_id()));
		}
				
		//external relation CreditLine
		if (obj.getCreditLine() != null && !obj.getCreditLine().isEmpty())
			obj.getCreditLine().forEach(creditline -> creditlineService.insert(creditline));
		
		//external relation Parent
		if (obj.getParent() != null) {
			if (obj.getParent().get_id() == null)
				organizationService.insert(obj.getParent());
			else
				organizationService.insert(organizationService.getOne(obj.getParent().get_id()));
		}
				
		//external relation UtlimateParent
		if (obj.getUtlimateParent() != null) {
			if (obj.getUtlimateParent().get_id() == null)
				organizationService.insert(obj.getUtlimateParent());
			else
				organizationService.insert(organizationService.getOne(obj.getUtlimateParent().get_id()));
		}
				
		
		return ResponseEntity.ok().body(convertToDto(organizationService.insert(obj)));
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@DeleteMapping("/organization/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Organization organizationSelected = organizationService.getOne(id);
		
		
		
		
		//external relation CreditLine
		if (organizationSelected.getCreditLine() != null && !organizationSelected.getCreditLine().isEmpty()) {
			organizationSelected.getCreditLine().forEach(creditline -> creditlineService.delete(creditline.get_id()));
		}
		
		
		
		organizationService.delete(id);
		return ResponseEntity.ok().build();
	}
	
    //CRUD - FIND BY Lessor
    
	@GetMapping("/organization/findByLessor/{key}")
	public ResponseEntity<List<OrganizationDto>> findByLessor(@PathVariable("key") Long id) {
		
		
		Lessor lessor = lessorService.getOne(id);
		List<Organization> organizations = organizationService.findByLessor(lessor);
		List<OrganizationDto> organizationsDto = organizations.stream()
				.map(organization -> convertToDto(organization))
				.collect(Collectors.toList());
		
		
		
		
		

		return ResponseEntity.ok().body(organizationsDto);
	}
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/organization/{id}")
	public ResponseEntity<OrganizationDto> get(@PathVariable("id") Long id) {
		Organization organizationSelected = organizationService.getOne(id);
		return ResponseEntity.ok().body(convertToDto(organizationSelected));
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/organization")
	public ResponseEntity<List<OrganizationDto>> getList() {
		List<Organization> list = organizationService.getAll();
		List<OrganizationDto> listDto = list.stream()
				.map(organization -> convertToDto(organization))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}


    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/organization/{id}")
	public ResponseEntity<OrganizationDto> update(@RequestBody Organization obj, @PathVariable("id") Long id) {
	    
		//external relation Country
		if (obj.getCountry() != null) {
			if (obj.getCountry().get_id() == null)
				countryService.insert(obj.getCountry());
			else
				countryService.insert(countryService.getOne(obj.getCountry().get_id()));
		}
				
		//external relation Lessor
		if (obj.getLessor() != null) {
			if (obj.getLessor().get_id() == null)
				lessorService.insert(obj.getLessor());
			else
				lessorService.insert(lessorService.getOne(obj.getLessor().get_id()));
		}
				
		//external relation LiableParent
		if (obj.getLiableParent() != null) {
			if (obj.getLiableParent().get_id() == null)
				organizationService.insert(obj.getLiableParent());
			else
				organizationService.insert(organizationService.getOne(obj.getLiableParent().get_id()));
		}
				
		//external relation CreditLine
		if (obj.getCreditLine() != null)
			obj.getCreditLine().forEach(creditline -> creditlineService.insert(creditline));
		
		//external relation Parent
		if (obj.getParent() != null) {
			if (obj.getParent().get_id() == null)
				organizationService.insert(obj.getParent());
			else
				organizationService.insert(organizationService.getOne(obj.getParent().get_id()));
		}
				
		//external relation UtlimateParent
		if (obj.getUtlimateParent() != null) {
			if (obj.getUtlimateParent().get_id() == null)
				organizationService.insert(obj.getUtlimateParent());
			else
				organizationService.insert(organizationService.getOne(obj.getUtlimateParent().get_id()));
		}
				
		
		return ResponseEntity.ok().body(convertToDto(organizationService.insert(obj)));
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	private OrganizationDto convertToDto(Organization organization) {
		OrganizationDto organizationDto = modelMapper.map(organization, OrganizationDto.class);
		return organizationDto;
	}
}
