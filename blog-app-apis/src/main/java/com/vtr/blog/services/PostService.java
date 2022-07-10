package com.vtr.blog.services;

import java.util.List;

import com.vtr.blog.entities.Post;
import com.vtr.blog.payloads.PostDto;
import com.vtr.blog.payloads.PostPageResponse;

public interface PostService {
	
	PostDto createPost(PostDto postDto,Integer postId,Integer categoryId);
	
	PostDto updatePostDto(PostDto postDto,Integer postId);
	
	void deletePost(Integer postId);
	
	PostPageResponse getallPost(Integer p1,Integer p2, String sortBy);
	
	PostDto getPostById(Integer postId);
	
	//get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getpostsByUser(Integer userId);
	
	//Search posts
	List<PostDto> searchPosts(String keyword);

}
