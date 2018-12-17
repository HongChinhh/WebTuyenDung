package com.nguyenthihongtrinh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.service.AccountService;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/login")
	public ResponseEntity<Integer> login(Account accountParam) {
		int result = accountService.login(accountParam);
		if (result < 1) {
			return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@GetMapping("/admin/accounts")
	public ResponseEntity<List<Account>> getAll() {
		List<Account> brands = (List<Account>) accountService.getAll();
		if (brands.isEmpty()) {
			return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Account>>(brands, HttpStatus.OK);
	}
	
	@PostMapping("/admin/accounts")
	public ResponseEntity<Void> add(Account account) {
		accountService.add(account);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/accounts/{username}")
	public ResponseEntity<Void> edit(@PathVariable("username") String userName,
			@RequestBody Account acc) {
		Account account = accountService.getByUserName(userName);
		if (account == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		accountService.update(acc);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/accounts/{username}")
	public ResponseEntity<Void> delete(@PathVariable("id") String userName) {
		Account account = accountService.getByUserName(userName);
		if (account == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		accountService.delete(userName);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}