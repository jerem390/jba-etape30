package com.jeremy.jba4.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeremy.jba4.entities.Blog;
import com.jeremy.jba4.entities.User;
import com.jeremy.jba4.service.BlogService;
import com.jeremy.jba4.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	
	

	
	

	



	@ModelAttribute("blog")
	public Blog constructBlog(){
		return new Blog();
	}
	
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		String name=principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "account";
	}
	
	
	@RequestMapping(value="/account",method=RequestMethod.POST)
	public String doAddBlog(@Valid @ModelAttribute("blog") Blog blog,BindingResult bindingResult, Principal principal, Model model){
		
		if(bindingResult.hasErrors()){
			return account(model, principal);
		}
		String name=principal.getName();
		
		
		blogService.save(blog, name);
	
		return "redirect:/account.html";
	}
	
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable Long id,Principal principal){
		
		blogService.delete(id,principal);
		
		return "redirect:/account.html";
	}
	

	
	
	@RequestMapping(value="/account/photo")
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
