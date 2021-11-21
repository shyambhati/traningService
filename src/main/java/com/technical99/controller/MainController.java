package com.technical99.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
public class MainController 
{

	
	@GetMapping(value = {"","/"})
	String Demo()
	{
		return "This is TraningService Module of Technical99 project";	
	}

}
