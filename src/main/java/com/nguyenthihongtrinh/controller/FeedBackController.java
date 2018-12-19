
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
import com.nguyenthihongtrinh.entity.FeedBack;
import com.nguyenthihongtrinh.entity.ParentCategory;
import com.nguyenthihongtrinh.entity.SubCategory;
import com.nguyenthihongtrinh.service.AccountService;
import com.nguyenthihongtrinh.service.FeedBackService;
import com.nguyenthihongtrinh.service.ParentCategoryService;
import com.nguyenthihongtrinh.service.SubCategoryService;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class FeedBackController {

	@Autowired
	private FeedBackService	feedBackService;
	
	
	
	@GetMapping("/admin/feedback")
	public ResponseEntity<List<FeedBack>> getFeedBack() {
		List<FeedBack> brands = (List<FeedBack>) feedBackService.getFeedBack();
		if (brands.isEmpty()) {
			return new ResponseEntity<List<FeedBack>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<FeedBack>>(brands, HttpStatus.OK);
	}
	
	@PostMapping("/admin/feedback")
	public ResponseEntity<Void> add(FeedBack feedBack) {
		feedBackService.add(feedBack);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/feedback/{idfeedback}")
	public ResponseEntity<Void> edit(@PathVariable("IdFeedBack") Integer idFeedBack,
			@RequestBody FeedBack feedBack) {
		FeedBack feBack = feedBackService.getByIdFeedBack(idFeedBack);
		if (feBack == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		feedBackService.update(feBack);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/feedback/{idfeedback}")
	public ResponseEntity<Void> delete(@PathVariable("IdFeedBack") Integer idFeedBack) {
		FeedBack feedBack = feedBackService.getByIdFeedBack(idFeedBack);
		if (feedBack == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		feedBackService.delete(idFeedBack);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}