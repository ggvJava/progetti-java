package com.theartofweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("messaggio", "Hello world!!!!");
		return "home";
	}
	
}
