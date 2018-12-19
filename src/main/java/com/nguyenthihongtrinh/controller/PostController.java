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
import com.nguyenthihongtrinh.entity.Post;
import com.nguyenthihongtrinh.entity.SubCategory;
import com.nguyenthihongtrinh.service.AccountService;
import com.nguyenthihongtrinh.service.ParentCategoryService;
import com.nguyenthihongtrinh.service.PostService;
import com.nguyenthihongtrinh.service.SubCategoryService;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class PostController {

	@Autowired
	private PostService	postService;
	
	
	
	@GetMapping("/admin/post")
	public ResponseEntity<List<Post>> getPost() {
		List<Post> brands = (List<Post>) postService.getPost();
		if (brands.isEmpty()) {
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Post>>(brands, HttpStatus.OK);
	}
	
	@PostMapping("/admin/post")
	public ResponseEntity<Void> add(Post post) {
		postService.add(post);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/post/{idpost}")
	public ResponseEntity<Void> edit(@PathVariable("IdPost") Integer idPost,
			@RequestBody Post post) {
		Post post2 = postService.getByIdPost(idPost);
		if (post2 == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		postService.update(post);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/post/{idpost}")
	public ResponseEntity<Void> delete(@PathVariable("IdPost") Integer idPost) {
		Post post = postService.getByIdPost(idPost);
		if (post == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		postService.delete(idPost);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}