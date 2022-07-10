package com.vtr.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vtr.blog.entities.Category;
import com.vtr.blog.entities.Post;
import com.vtr.blog.entities.User;
import com.vtr.blog.exceptions.ResourceNotFoundException;
import com.vtr.blog.payloads.CategoryDto;
import com.vtr.blog.payloads.PostDto;
import com.vtr.blog.payloads.PostPageResponse;
import com.vtr.blog.payloads.UserDto;
import com.vtr.blog.repository.CategoryRepo;
import com.vtr.blog.repository.PostRepo;
import com.vtr.blog.repository.UserRepo;
import com.vtr.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
		 User user=this.userRepo.findById(userId)
	    		   .orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		 Category cat=this.categoryRepo.findById(categoryId).orElseThrow(
					()->new ResourceNotFoundException("Category","category Id",categoryId));
		 
            Post post =this.modelMapper.map(postDto,Post.class);
            post.setImageName("default.png");
            post.setAddedDate(new Date());
            post.setUser(user);
            post.setCategory(cat);
            
            Post addedPost=this.postRepo.save(post);
            
           
            
		return this.modelMapper.map(addedPost, PostDto.class);
	}

	@Override
	public PostDto updatePostDto(PostDto postDto, Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("Post","post Id",postId)
				);
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost=this.postRepo.save(post);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("Post","post Id",postId)
				);
		this.postRepo.delete(post);
		
	}

	@Override
	public PostPageResponse getallPost(Integer pageNumber,Integer pageSize,String sortBy) {
		
		Pageable p=PageRequest.of(pageNumber, pageSize,Sort.by(sortBy));
		 Page<Post> pagePosts=this.postRepo.findAll(p);
		
		List<Post> posts=pagePosts.getContent();
		List<PostDto> postDtos=posts.stream().map(post->this.modelMapper.map(post, PostDto.class))
				      .collect(Collectors.toList());
		PostPageResponse ppr=new PostPageResponse();
		ppr.setContent(postDtos);
		ppr.setPageNumbe(pagePosts.getNumber());
		ppr.setPageSize(pagePosts.getSize());
		ppr.setTotalElements(pagePosts.getTotalElements());
		ppr.setTotalPages(pagePosts.getTotalPages());
		ppr.setLastPage(pagePosts.isLast());
		return ppr;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("Post","post Id",postId)
				);
	
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","category id ",categoryId));
		List<Post> posts=this.postRepo.findByCategory(cat);
		
		List<PostDto> postDtos=posts.stream().map(post->this.modelMapper.map(post, PostDto.class))
				              .collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getpostsByUser(Integer userId) {
		
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","user id ",userId));
		List<Post> posts=this.postRepo.findByUser(user);
		
		
		List<PostDto> postDtos=posts.stream().map(post->this.modelMapper.map(post, PostDto.class))
				              .collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		 
		List<Post> posts=this.postRepo.searchByTitle("%"+keyword+"%");
		List<PostDto> postDtos=posts.stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}
