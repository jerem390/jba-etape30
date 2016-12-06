package com.jeremy.jba4.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeremy.jba4.entities.User;
import com.jeremy.jba4.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {

	@Autowired
	private UserService userService;

	
	
	@RequestMapping
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
		
		
	}
	
	
	@RequestMapping("/{id}")
	public String details(Model model,@PathVariable Long id){
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-details";
		
		
	}
	
	
	

	

	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable Long id){
		
		userService.delete(id);
		return "redirect:/users.html";
	}
	
	
	
	@RequestMapping(value="/photo")
	@ResponseBody
	public byte[] retrievePhoto(Long id, HttpServletResponse resp) throws IOException{
	
		User user=userService.findOne(id);
		
		if(user.getPhoto()==null){
			
			resp.sendError(404);
			return null;
		}
		
	
		return IOUtils.toByteArray(new ByteArrayInputStream(user.getPhoto()));
	}
	
}
