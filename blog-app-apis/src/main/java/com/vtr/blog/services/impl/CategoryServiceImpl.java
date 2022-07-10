package com.vtr.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtr.blog.entities.Category;
import com.vtr.blog.exceptions.ResourceNotFoundException;
import com.vtr.blog.payloads.CategoryDto;
import com.vtr.blog.repository.CategoryRepo;
import com.vtr.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto cdto) {
		
		 Category cat=this.modelMapper.map(cdto, Category.class);
		 Category addedCat=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto cdto, Integer cid) {
		Category cat=this.categoryRepo.findById(cid).orElseThrow(
				()->new ResourceNotFoundException("Category","category Id",cid));
		cat.setCategoryDescription(cdto.getCategoryDescription());
		cat.setCategoryTitle(cdto.getCategoryTitle());
		Category updatedCategory=this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer cid) {
		
		Category cat=this.categoryRepo.findById(cid).orElseThrow(
				()-> new ResourceNotFoundException("Category","category id",cid));
		this.categoryRepo.delete(cat);

	}

	@Override
	public CategoryDto getCategoryById(Integer cid) {
		Category cat=this.categoryRepo.findById(cid).orElseThrow(
				()-> new ResourceNotFoundException("Category","category id",cid));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		
		List<Category> listOfCategories=this.categoryRepo.findAll();
		List<CategoryDto> listOfCategoryDtos=listOfCategories.stream()
				.map(cat->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return listOfCategoryDtos;
	}

}
