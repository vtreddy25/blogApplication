package com.vtr.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtr.blog.payloads.ApiResponse;
import com.vtr.blog.payloads.CommentDto;
import com.vtr.blog.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
	private CommentService commentService;
	
    @PostMapping("/post/{postId}/comments")	
	public ResponseEntity<CommentDto> createComment(
			@RequestBody CommentDto commentDto,@PathVariable Integer postId){
    	CommentDto savedComment=this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<>(savedComment,HttpStatus.OK);
	}
    
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
    	this.commentService.deleteComment(commentId);
    	 ApiResponse apiResponse=new ApiResponse("deleted successfully",true);
    	return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
