package com.vtr.blog.services;

import java.util.List;

import com.vtr.blog.payloads.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto cdto);
	
	CategoryDto updateCategory(CategoryDto cdto,Integer cid);
	
	void deleteCategory(Integer cid);
	
	CategoryDto getCategoryById(Integer cid);
	
	List<CategoryDto> getAllCategories();
	
	
}
