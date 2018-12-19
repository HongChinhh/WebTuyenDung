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
import com.nguyenthihongtrinh.entity.ParentCategory;
import com.nguyenthihongtrinh.service.AccountService;
import com.nguyenthihongtrinh.service.ParentCategoryService;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class ParentCategoryController {

	@Autowired
	private ParentCategoryService	parentCategoryService;
	
	
	
	@GetMapping("/admin/parentcategory")
	public ResponseEntity<List<ParentCategory>> getParentCat() {
		List<ParentCategory> brands = (List<ParentCategory>) parentCategoryService.getParentCat();
		if (brands.isEmpty()) {
			return new ResponseEntity<List<ParentCategory>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<ParentCategory>>(brands, HttpStatus.OK);
	}
	
	@PostMapping("/admin/parentcategory")
	public ResponseEntity<Void> add(ParentCategory parentCategory) {
		parentCategoryService.add(parentCategory);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/accounts/{idparentcat}")
	public ResponseEntity<Void> edit(@PathVariable("IdParentCat") Integer idParentCat,
			@RequestBody ParentCategory parentcat) {
		ParentCategory parentCat = parentCategoryService.getByIdParentCat(idParentCat);
		if (parentCat == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		parentCategoryService.update(parentcat);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/accounts/{idparentcat}")
	public ResponseEntity<Void> delete(@PathVariable("IdParenCat") Integer idParentCat) {
		ParentCategory parentCat = parentCategoryService.getByIdParentCat(idParentCat);
		if (parentCat == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		parentCategoryService.delete(idParentCat);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}