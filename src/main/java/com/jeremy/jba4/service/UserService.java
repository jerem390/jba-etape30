package com.jeremy.jba4.service;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jeremy.jba4.entities.Blog;
import com.jeremy.jba4.entities.Item;
import com.jeremy.jba4.entities.Role;
import com.jeremy.jba4.entities.User;
import com.jeremy.jba4.repositories.BlogRepository;
import com.jeremy.jba4.repositories.ItemRepository;
import com.jeremy.jba4.repositories.RoleRepository;
import com.jeremy.jba4.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	
	public List<User> findAll(){
			return userRepository.findAll();
	}


	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(Long id) {
		User user=userRepository.findOne(id);
		List<Blog> blogs=blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		
		
		user.setBlogs(blogs);
	
		return user;
	}


	public void save(User user){
			user.setEnabled(true);
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
		
			List<Role> roles=new ArrayList<Role>();
			roles.add(roleRepository.findByName("ROLE_USER"));
			user.setRoles(roles);
			
			
		
			
	userRepository.save(user);	
	
	}


	public User findOneWithBlogs(String name) {
		User user=userRepository.findByName(name);
		return findOneWithBlogs(user.getId()) ;
	}


	public void delete(Long id) {
		userRepository.delete(id);
	}
	
	
	public User findOne(String name){
		return userRepository.findByName(name);
	}



	

}
