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

import com.nguyenthihongtrinh.entity.User;
import com.nguyenthihongtrinh.service.UserService;



/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class UserController {

	@Autowired
	private UserService	userService;
	
	
	
	@GetMapping("/admin/user")
	public ResponseEntity<List<User>> getUser() {
		List<User> brands = (List<User>) userService.getUser();
		if (brands.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<User>>(brands, HttpStatus.OK);
	}
	
	@PostMapping("/admin/user")
	public ResponseEntity<Void> add(User user) {
		userService.add(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/user/{iduser}")
	public ResponseEntity<Void> edit(@PathVariable("IdUser") Integer idUser,
			@RequestBody User user) {
		User user2 = userService.getByIdSub(idUser);
		if (user2 == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		userService.update(user2);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/user/{iduser}")
	public ResponseEntity<Void> delete(@PathVariable("IdUser") Integer idUser) {
		User user = userService.getByIdSub(idUser);
		if (user == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		userService.delete(idUser);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}