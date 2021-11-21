package com.technical99.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;
import com.technical99.entity.CourseMaster;
import com.technical99.entity.FullStackCourse;
import com.technical99.entity.dto.APIResponse;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.CourseDtoFullListing;
import com.technical99.entity.dto.FSCourseDto;
import com.technical99.entity.dto.FSCourseDtoFullListing;
import com.technical99.entity.dto.FSCourseDtoListing;
import com.technical99.entity.dto.ResponseHandler;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.entity.specificationDTO.CourseRequest;
import com.technical99.entity.specificationDTO.FsCourseRequest;
import com.technical99.service.CourseService;
import com.technical99.service.FullStackCourseService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Full Stack Course", description = "All Full Stack Course Related API")
@RequestMapping(value = "fullStackCourse/")
public class FullStackCourseController {

	@Autowired
	private FullStackCourseService service;
	
	@GetMapping(value = "/getListFull")
    public ResponseEntity<Object> getListFull() {
        try {
            List<FullStackCourse> list = service.getFullList();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
        }
    }
	
	@GetMapping(value = "/getList")
    public ResponseEntity<Object> getList() {
        try {
            List<FSCourseDto> list = service.getListDto();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
        }
    }
	
	@GetMapping(value = "/getListing")
    public ResponseEntity<Object> getListing() {
        try {
            List<FSCourseDtoListing> list = service.getListing();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
        }
    }
	
	@PostMapping("search")
	public ResponseEntity<Object> find(@RequestBody FsCourseRequest specs) {
		try {
			List<FSCourseDtoFullListing> list = service.getFullListing(specs);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list, list.size());
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
		}
	}
	
	
}
