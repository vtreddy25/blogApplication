package com.vtr.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtr.blog.entities.Category;
import com.vtr.blog.entities.Post;
import com.vtr.blog.entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {
	
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitle(@Param("key") String title);

}
