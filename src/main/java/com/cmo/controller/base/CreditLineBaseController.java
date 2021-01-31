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
import com.cmo.db.cmo_db.service.CreditLineService;
import com.cmo.db.cmo_db.entity.CreditLine;
import com.cmo.db.cmo_db.dtos.CreditLineDto;

import com.cmo.db.cmo_db.entity.Organization;

//IMPORT RELATIONS

import com.cmo.db.cmo_db.service.OrganizationService;


public class CreditLineBaseController {
    
    @Autowired
	CreditLineService creditlineService;

	
	@Autowired
	OrganizationService organizationService;
	

	@Autowired
	private ModelMapper modelMapper;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/creditline")
	public ResponseEntity<CreditLineDto> insert(@RequestBody CreditLine obj) {
				
		//external relation Organization
		if (obj.getOrganization() != null) {
			if (obj.getOrganization().get_id() == null)
				organizationService.insert(obj.getOrganization());
			else
				organizationService.insert(organizationService.getOne(obj.getOrganization().get_id()));
		}
				
		
		return ResponseEntity.ok().body(convertToDto(creditlineService.insert(obj)));
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@DeleteMapping("/creditline/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		CreditLine creditlineSelected = creditlineService.getOne(id);
		
		
		creditlineService.delete(id);
		return ResponseEntity.ok().build();
	}
	
    //CRUD - FIND BY Organization
    
	@GetMapping("/creditline/findByOrganization/{key}")
	public ResponseEntity<List<CreditLineDto>> findByOrganization(@PathVariable("key") Long id) {
		
		Organization organization = organizationService.getOne(id);
		List<CreditLine> creditlines = creditlineService.findByOrganization(organization);
		List<CreditLineDto> creditlinesDto = creditlines.stream()
				.map(creditline -> convertToDto(creditline))
				.collect(Collectors.toList());
		
		

		return ResponseEntity.ok().body(creditlinesDto);
	}
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/creditline/{id}")
	public ResponseEntity<CreditLineDto> get(@PathVariable("id") Long id) {
		CreditLine creditlineSelected = creditlineService.getOne(id);
		return ResponseEntity.ok().body(convertToDto(creditlineSelected));
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/creditline")
	public ResponseEntity<List<CreditLineDto>> getList() {
		List<CreditLine> list = creditlineService.getAll();
		List<CreditLineDto> listDto = list.stream()
				.map(creditline -> convertToDto(creditline))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}


    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/creditline/{id}")
	public ResponseEntity<CreditLineDto> update(@RequestBody CreditLine obj, @PathVariable("id") Long id) {
	    
		//external relation Organization
		if (obj.getOrganization() != null) {
			if (obj.getOrganization().get_id() == null)
				organizationService.insert(obj.getOrganization());
			else
				organizationService.insert(organizationService.getOne(obj.getOrganization().get_id()));
		}
				
		
		return ResponseEntity.ok().body(convertToDto(creditlineService.insert(obj)));
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	private CreditLineDto convertToDto(CreditLine creditline) {
		CreditLineDto creditlineDto = modelMapper.map(creditline, CreditLineDto.class);
		return creditlineDto;
	}
}
