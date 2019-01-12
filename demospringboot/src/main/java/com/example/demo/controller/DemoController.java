package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Persona;

@Controller
public class DemoController {
	
	/**
	 * REST service
	 * @return Persona
	 */
	@RequestMapping(value="/demo", 
			method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Persona> home() {
		
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.set("Author", "Marameo");
		return new ResponseEntity<Persona>(new Persona(), httpHeader, HttpStatus.OK);
	}
	
	/**
	 * WEB service
	 * @return ModelAndView
	 */
	@GetMapping("/web")
	public ModelAndView getPage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("messaggio", "Hello World!!!");
		return mv;
	}
}
