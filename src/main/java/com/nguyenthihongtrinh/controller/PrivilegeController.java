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

import com.nguyenthihongtrinh.entity.Privilege;
import com.nguyenthihongtrinh.service.PrivilegeService;


/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class PrivilegeController {

	@Autowired
	private PrivilegeService privilegeService;
	
	
	
	@GetMapping("/admin/privilege")
	public ResponseEntity<List<Privilege>> getPrivilege() {
		List<Privilege> brands = (List<Privilege>) privilegeService.getPrivilege();
		if (brands.isEmpty()) {
			return new ResponseEntity<List<Privilege>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Privilege>>(brands, HttpStatus.OK);
	}
	
	@PostMapping("/admin/privilege")
	public ResponseEntity<Void> add(Privilege privilege) {
		privilegeService.add(privilege);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/privilege/{idPrivilege}")
	public ResponseEntity<Void> edit(@PathVariable("IdPrivilege") Integer idPrivilege,
			@RequestBody Privilege privilege) {
		Privilege privi = privilegeService.getByIdPri(idPrivilege);
		if (privi == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		privilegeService.update(privi);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/privilege/{idPrivilege}")
	public ResponseEntity<Void> delete(@PathVariable("IdPrivilege") Integer idPrivilege) {
		Privilege privilege = privilegeService.getByIdPri(idPrivilege);
		if (privilege == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		privilegeService.delete(idPrivilege);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}