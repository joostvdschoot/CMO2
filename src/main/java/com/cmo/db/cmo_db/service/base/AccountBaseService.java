package com.cmo.db.cmo_db.service.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import com.cmo.db.cmo_db.entity.Account;

import com.cmo.db.cmo_db.entity.Lessor;

import com.cmo.db.cmo_db.repositories.AccountRepository;

@Service
@Transactional
public class AccountBaseService {

	
	@Autowired
	AccountRepository accountRepository;


    // CRUD METHODS
    
    // CRUD - CREATE
    
	public Account insert(Account account) {
		return accountRepository.save(account);
	}
	
	// CRUD - REMOVE
    
	public void delete(Long id) {
		accountRepository.delete(id);
	}

    
    // CRUD - FIND BY Lessor

    public List<Account> findByLessor(Lessor lessor) {
		return accountRepository.findByLessor(lessor);
	}
    
	// CRUD - GET ONE
    	
	public Account getOne(Long id) {
		return accountRepository.findOne(id);
	}

    	
    // CRUD - GET LIST
    	
	public List<Account> getAll() {
		List<Account> list = new ArrayList<>();
		accountRepository.findAll().forEach(list::add);
		return list;
	}
	

}
