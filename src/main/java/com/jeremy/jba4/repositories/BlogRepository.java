package com.jeremy.jba4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremy.jba4.entities.Blog;
import com.jeremy.jba4.entities.User;

public interface BlogRepository extends JpaRepository<Blog, Long>{

	List<Blog> findByUser(User user);
	
}
