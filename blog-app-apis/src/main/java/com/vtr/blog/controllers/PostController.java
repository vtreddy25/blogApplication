package com.vtr.blog.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vtr.blog.config.AppConstants;
import com.vtr.blog.payloads.ApiResponse;
import com.vtr.blog.payloads.PostDto;
import com.vtr.blog.payloads.PostPageResponse;
import com.vtr.blog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,
			@PathVariable Integer categoryId){
		
		PostDto createdPost =this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		
		List<PostDto> posts=this.postService.getpostsByUser(userId);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		
		List<PostDto> posts=this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto post=this.postService.getPostById(postId);
		return new ResponseEntity<>(post,HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostPageResponse> getAllPosts(
			@RequestParam(value="pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required=false)Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE,required=false) Integer pageSize,
			@RequestParam(value="sortBy",defaultValue=AppConstants.SORT_BY,required=false) String sortBy
			){
		
		PostPageResponse ppr=this.postService.getallPost(pageNumber,pageSize,sortBy);
		return new ResponseEntity<>(ppr,HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable  Integer postId){
		this.postService.deletePost(postId);
		return ResponseEntity.ok(new ApiResponse( "post deleted successfully",true));
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		
		PostDto updatedPost=this.postService.updatePostDto(postDto, postId);
		return new ResponseEntity<>(updatedPost,HttpStatus.OK);
	}
	
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchByTitle(
			@PathVariable String keywords){
		 List<PostDto> result=this.postService.searchPosts(keywords);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	
	
	
	
	
}
	
	
