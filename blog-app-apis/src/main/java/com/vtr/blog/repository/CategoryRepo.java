package com.vtr.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtr.blog.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
