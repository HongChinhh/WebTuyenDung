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
import com.nguyenthihongtrinh.entity.SubCategory;
import com.nguyenthihongtrinh.service.AccountService;
import com.nguyenthihongtrinh.service.ParentCategoryService;
import com.nguyenthihongtrinh.service.SubCategoryService;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class SubCategoryController {

	@Autowired
	private SubCategoryService	subCategoryService;
	
	
	
	@GetMapping("/admin/subcategory")
	public ResponseEntity<List<SubCategory>> getSubCategory() {
		List<SubCategory> brands = (List<SubCategory>) subCategoryService.getSubCategory();
		if (brands.isEmpty()) {
			return new ResponseEntity<List<SubCategory>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<SubCategory>>(brands, HttpStatus.OK);
	}
	
	@PostMapping("/admin/subcategory")
	public ResponseEntity<Void> add(SubCategory subCategory) {
		subCategoryService.add(subCategory);;
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/subcategory/{idsubcat}")
	public ResponseEntity<Void> edit(@PathVariable("IdSubCategory") Integer idSubCategory,
			@RequestBody SubCategory subCategory) {
		SubCategory suCategory = subCategoryService.getByIdSub(idSubCategory);
		if (suCategory == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		subCategoryService.update(subCategory);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/subcategory/{idsubcat}")
	public ResponseEntity<Void> delete(@PathVariable("IdSubCategory") Integer idSubCategory) {
		SubCategory subCategory = subCategoryService.getByIdSub(idSubCategory);
		if (subCategory == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		subCategoryService.delete(idSubCategory);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}