package com.vtr.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtr.blog.payloads.ApiResponse;
import com.vtr.blog.payloads.CategoryDto;
import com.vtr.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cDto){
		CategoryDto createdCategory=this.categoryService.createCategory(cDto);
		
		return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
	}
	
	@PutMapping("/{cid}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto cDto,@PathVariable Integer cid){
		CategoryDto updatedCategory=this.categoryService.updateCategory(cDto, cid);
		
		return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
	}
	@DeleteMapping("/{cid}")
	public ResponseEntity<ApiResponse> deletecategory(@PathVariable Integer cid){
		this.categoryService.deleteCategory(cid);
		return new ResponseEntity<>(new ApiResponse("Category is deleted Succeessfully.",true),HttpStatus.OK);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer cid){
		CategoryDto cdto=this.categoryService.getCategoryById(cid);
		return new ResponseEntity<>(cdto,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		List<CategoryDto> listOfcdtos=this.categoryService.getAllCategories();
		return new ResponseEntity<>(listOfcdtos,HttpStatus.OK);
	}
	
	
	
	
}
