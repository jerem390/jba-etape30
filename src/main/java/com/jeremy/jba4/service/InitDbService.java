package com.jeremy.jba4.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeremy.jba4.entities.Blog;
import com.jeremy.jba4.entities.Item;
import com.jeremy.jba4.entities.Role;
import com.jeremy.jba4.entities.User;
import com.jeremy.jba4.repositories.BlogRepository;
import com.jeremy.jba4.repositories.ItemRepository;
import com.jeremy.jba4.repositories.RoleRepository;
import com.jeremy.jba4.repositories.UserRepository;


@Transactional
@Service
public class InitDbService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	@PostConstruct
	public void init() throws IOException{
	
		
		Role roleUser=new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin=new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User admin=new User();
		admin.setName("admin");
		admin.setEnabled(true);
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		admin.setPassword(encoder.encode("admin"));
		List<Role> roles=new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		admin.setRoles(roles);
		userRepository.save(admin);
		
//		Blog blogJavaVids=new Blog();
//		blogJavaVids.setName("JavaVids");
//		blogJavaVids.setUser(admin);
//		blogJavaVids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
//		blogRepository.save(blogJavaVids);
//		
//		Item item1=new Item();
//		item1.setBlog(blogJavaVids);
//		item1.setTitle("first");
//		item1.setLink("http://www.javavids.com");
//		item1.setPublishedDate(new Date());
//		itemRepository.save(item1);
//		
//		
//		
//		Item item2=new Item();
//		item2.setBlog(blogJavaVids);
//		item2.setTitle("second");
//		item2.setLink("http://www.javavids.com");
//		item2.setPublishedDate(new Date());
//		itemRepository.save(item2);
//		///////////////////////////
//		
//		Item item3=new Item();
//		item3.setBlog(blogJavaVids);
//		item3.setTitle("third");
//		item3.setLink("http://www.javavids.com");
//		item3.setPublishedDate(new Date());
//		itemRepository.save(item3);
//		
//		Item item4=new Item();
//		item4.setBlog(blogJavaVids);
//		item4.setTitle("fourth");
//		item4.setLink("http://www.javavids.com");
//		item4.setPublishedDate(new Date());
//		itemRepository.save(item4);
//		
//		Item item5=new Item();
//		item5.setBlog(blogJavaVids);
//		item5.setTitle("cinquieme");
//		item5.setLink("http://www.javavids.com");
//		item5.setPublishedDate(new Date());
//		itemRepository.save(item5);
//
//
//		Item item6=new Item();
//		item6.setBlog(blogJavaVids);
//		item6.setTitle("sixieme");
//		item6.setLink("http://www.javavids.com");
//		item6.setPublishedDate(new Date());
//		itemRepository.save(item6);
//		
//		
//		
		
		
		
		
	}
	
	
	
	
}
