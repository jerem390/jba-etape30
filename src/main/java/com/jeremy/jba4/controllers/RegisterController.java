package com.jeremy.jba4.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jeremy.jba4.entities.User;
import com.jeremy.jba4.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String showRegister(){
		return "user-register";
		
		
	}
	
	@RequestMapping( method=RequestMethod.POST)
	public String doRegister( @Valid @ModelAttribute("user") User user,  BindingResult bindingResult, @RequestParam(value = "file", required = false) MultipartFile file ) throws IOException {
		if(bindingResult.hasErrors()){
			return "user-register";
		}
	
		// traitement de l'image
		
		if(!file.isEmpty()){
			System.err.println("fichier charge");
			BufferedImage bi=ImageIO.read(file.getInputStream());
			user.setPhoto(file.getBytes());
			user.setNomPhoto(file.getOriginalFilename());
		}
		
		
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	
	
	
	@ModelAttribute("user")
	public User constructUser(){
		return new User();
	}
	
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username){
		Boolean available=userService.findOne(username)==null;
		return available.toString();		
	
	}
}
