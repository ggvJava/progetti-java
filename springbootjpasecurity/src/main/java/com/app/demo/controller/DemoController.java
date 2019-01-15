package com.app.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	private String prima (Model model) {
		model.addAttribute("messaggio", "Helloooooo prima pagina!!");
		return "home";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	private String home(Model model) {
		model.addAttribute("messaggio", "Hello home page");
		return "home";
	}
}
