package com.jeremy.jba4.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremy.jba4.entities.Blog;
import com.jeremy.jba4.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findByBlog(Blog blog, Pageable pageable);

	Item findByBlogAndLink(Blog blog, String link);

}
