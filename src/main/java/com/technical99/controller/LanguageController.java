package com.technical99.controller;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical99.entity.Category;
import com.technical99.entity.CourseMaster;
import com.technical99.entity.Language;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.CourseDtoListing;
import com.technical99.entity.dto.ResponseHandler;
import com.technical99.service.CategoryService;
import com.technical99.service.CourseService;
import com.technical99.service.LanguageService;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("language")
public class LanguageController {

	@Autowired
	private LanguageService service;
	

	@Autowired
	private ModelMapper modelMapper;

	@Hidden
	@GetMapping(value = "/getList")
	public ResponseEntity<Object> getListing() {
		try {
			List<Language> list = service.getlist();

			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list, list.size());
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
		}
	}
	
	
}
