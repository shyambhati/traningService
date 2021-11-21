package com.technical99.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical99.entity.CourseMaster;
import com.technical99.entity.SPCourse;
import com.technical99.entity.dto.CategoryDtoWithLanguage;
import com.technical99.entity.dto.ResponseHandler;
import com.technical99.entity.dto.SPCourseDtoListing;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.service.CourseService;
import com.technical99.service.SPCourseService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "SPCourse", description = "All SP Course Related API")
@RequestMapping(value = "spcourse/")
public class SPCourseController {

	@Autowired
	private SPCourseService service;
	

	@Hidden
	@GetMapping("getList")
	public ResponseEntity<Object> getList() {
		   try {
	            List<SPCourse> list = service.getlist();
	            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
	        }
	}

	
	@GetMapping("getListing")
	public ResponseEntity<Object> getListWithLanguage() {
		   try {
	            List<SPCourseDtoListing> list = service.getlistDtoListing();
	            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
	        }
	}
}
