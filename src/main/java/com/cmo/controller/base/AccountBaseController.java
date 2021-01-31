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
import com.cmo.db.cmo_db.service.AccountService;
import com.cmo.db.cmo_db.entity.Account;
import com.cmo.db.cmo_db.dtos.AccountDto;

import com.cmo.db.cmo_db.entity.Lessor;

//IMPORT RELATIONS

import com.cmo.db.cmo_db.service.LessorService;


public class AccountBaseController {
    
    @Autowired
	AccountService accountService;

	
	@Autowired
	LessorService lessorService;
	

	@Autowired
	private ModelMapper modelMapper;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/account")
	public ResponseEntity<AccountDto> insert(@RequestBody Account obj) {
				
		//external relation Lessor
		if (obj.getLessor() != null) {
			if (obj.getLessor().get_id() == null)
				lessorService.insert(obj.getLessor());
			else
				lessorService.insert(lessorService.getOne(obj.getLessor().get_id()));
		}
				
		
		return ResponseEntity.ok().body(convertToDto(accountService.insert(obj)));
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@DeleteMapping("/account/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Account accountSelected = accountService.getOne(id);
		
		
		accountService.delete(id);
		return ResponseEntity.ok().build();
	}
	
    //CRUD - FIND BY Lessor
    
	@GetMapping("/account/findByLessor/{key}")
	public ResponseEntity<List<AccountDto>> findByLessor(@PathVariable("key") Long id) {
		
		Lessor lessor = lessorService.getOne(id);
		List<Account> accounts = accountService.findByLessor(lessor);
		List<AccountDto> accountsDto = accounts.stream()
				.map(account -> convertToDto(account))
				.collect(Collectors.toList());
		
		

		return ResponseEntity.ok().body(accountsDto);
	}
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/account/{id}")
	public ResponseEntity<AccountDto> get(@PathVariable("id") Long id) {
		Account accountSelected = accountService.getOne(id);
		return ResponseEntity.ok().body(convertToDto(accountSelected));
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/account")
	public ResponseEntity<List<AccountDto>> getList() {
		List<Account> list = accountService.getAll();
		List<AccountDto> listDto = list.stream()
				.map(account -> convertToDto(account))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}


    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/account/{id}")
	public ResponseEntity<AccountDto> update(@RequestBody Account obj, @PathVariable("id") Long id) {
	    
		//external relation Lessor
		if (obj.getLessor() != null) {
			if (obj.getLessor().get_id() == null)
				lessorService.insert(obj.getLessor());
			else
				lessorService.insert(lessorService.getOne(obj.getLessor().get_id()));
		}
				
		
		return ResponseEntity.ok().body(convertToDto(accountService.insert(obj)));
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	private AccountDto convertToDto(Account account) {
		AccountDto accountDto = modelMapper.map(account, AccountDto.class);
		return accountDto;
	}
}
