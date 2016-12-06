package com.jeremy.jba4.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jeremy.jba4.entities.Blog;
import com.jeremy.jba4.entities.Item;
import com.jeremy.jba4.entities.User;
import com.jeremy.jba4.exceptions.RssException;
import com.jeremy.jba4.repositories.BlogRepository;
import com.jeremy.jba4.repositories.ItemRepository;
import com.jeremy.jba4.repositories.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private RssService rssService;

	public void saveItems(Blog blog) {
		try {
			List<Item> items = rssService.getItems(blog.getUrl());

			for (Item item : items) {
				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
				if (savedItem == null) {
					item.setBlog(blog);
					itemRepository.save(item);
				}
			}
		} catch (RssException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);

		blog.setUser(user);
	
		blogRepository.save(blog);
		saveItems(blog);
	}

	public void delete(Long id, Principal principal) {
		Blog blog = blogRepository.findOne(id);
		if ((principal != null && blog != null)
				&& (principal.getName().equals(blog.getUser().getName()) || principal.getName().equals("admin"))) {
			blogRepository.delete(id);
		}
	}

	public Blog findById(Long id) {
		return blogRepository.findOne(id);
	}

	@Scheduled(fixedDelay=3600000)
	public void reloadBlogs(){
		System.err.println("tache planifiee");
		List<Blog> blogs=blogRepository.findAll();
		for (Blog blog : blogs) {
			saveItems(blog);
		}
	}
	
}
