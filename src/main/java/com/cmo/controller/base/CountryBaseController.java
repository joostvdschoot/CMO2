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
import com.cmo.db.cmo_db.service.CountryService;
import com.cmo.db.cmo_db.entity.Country;
import com.cmo.db.cmo_db.dtos.CountryDto;

//IMPORT RELATIONS

import com.cmo.db.cmo_db.service.OrganizationService;

import com.cmo.db.cmo_db.service.LessorService;


public class CountryBaseController {
    
    @Autowired
	CountryService countryService;

	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	LessorService lessorService;
	

	@Autowired
	private ModelMapper modelMapper;



//CRUD METHODS

	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/country")
	public ResponseEntity<List<CountryDto>> getList() {
		List<Country> list = countryService.getAll();
		List<CountryDto> listDto = list.stream()
				.map(country -> convertToDto(country))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}



/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	private CountryDto convertToDto(Country country) {
		CountryDto countryDto = modelMapper.map(country, CountryDto.class);
		return countryDto;
	}
}
