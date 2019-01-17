package com.app.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.demo.model.User;
import com.app.demo.repository.UserRepository;
import com.app.demo.service.UserService;

@Controller
public class DemoController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	private String prima (Model model) {
		model.addAttribute("messaggio", "Helloooooo prima pagina!!");
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	private String login() {
		return "login";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	private String home(Model model) {
		model.addAttribute("messaggio", "Hello home page!!!");
		return "home";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	private String register(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	private String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("successMessage", "Please correct the errors in the form");
			model.addAttribute("bindingResult", bindingResult);
			
		} else if (userService.isUserAlreadyPresent(user)) {
			model.addAttribute("successMessage", "User already exists!");
		} else {
			userService.saveUser(user);
			model.addAttribute("successMessage", "User Created!!");
		}
		model.addAttribute("user", user);
		
		return "register";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	private String user (Model model, Authentication authentication) {
		if (authentication != null)
		{
			System.out.println(authentication.getName());
			System.out.println(userRepository.findByEmail(authentication.getName()));
		} else {
			System.out.println("Non autenticato..");
		}
		model.addAttribute("messaggio", "User directory");
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
}
