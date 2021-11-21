package com.technical99.controller;

import java.time.LocalDate;
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
import com.technical99.dao.CategoryDao;
import com.technical99.dao.CourseDao;
import com.technical99.dao.Specifications.CourseSpecification;
import com.technical99.entity.Category;
import com.technical99.entity.CourseMaster;
import com.technical99.entity.dto.APIResponse;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.CourseDtoFullListing;
import com.technical99.entity.dto.CourseDtoListing;
import com.technical99.entity.dto.ResponseHandler;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.entity.specificationDTO.CourseRequest;
import com.technical99.service.CourseService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Course", description = "All Course Related API")
@RequestMapping(value = "course/")
public class CourseController {

	@Autowired
	private CourseService service;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CourseDao courseDao;

	@Autowired
	private CourseSpecification courseSpecification;

	@GetMapping("getListFull")
	public List<CourseMaster> getListFull() {
		return service.getlist();
	}

	@GetMapping(value = "/getList")
	public ResponseEntity<Object> getList() {
		try {
			List<CourseDtoListing> list = service.getlisting();

			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list, list.size());
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
		}
	}

	@GetMapping(value = "/getListing")
	public ResponseEntity<Object> getListing() {
		try {
			List<CourseDtoListing> list = service.getlisting();

			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list, list.size());
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
		}
	}

//	Test only

	@Hidden
	@GetMapping("getSortedListASC/{field}")
	public List<CourseMaster> getSortedASC(@PathVariable @NotNull String field) {
		return service.getSortedASC(field);
	}

	@Hidden
	@GetMapping("getSortedListDESC/{field}")
	public List<CourseMaster> getSortedDESC(@PathVariable @NotNull String field) {
		return service.getSortedDESC(field);
	}

	@Hidden
	@GetMapping("pagination/{offset}/{pageSize}")
	private APIResponse<Page<CourseMaster>> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<CourseMaster> item = service.getWithPagination(offset, pageSize);
		return new APIResponse<>(item.getSize(), item);
	}

	@Hidden
	@GetMapping("/paginationAndSortASC/{offset}/{pageSize}/{field}")
	private APIResponse<Page<CourseMaster>> getWithPaginationAndSortingASC(@PathVariable int offset,
			@PathVariable int pageSize, @PathVariable String field) {
		Page<CourseMaster> item = service.getWithPaginationAndSortingASC(offset, pageSize, field);
		return new APIResponse<>(item.getSize(), item);
	}

	@Hidden
	@GetMapping("/paginationAndSortDESC/{offset}/{pageSize}/{field}")
	private APIResponse<Page<CourseMaster>> getWithPaginationAndSortingDESC(@PathVariable int offset,
			@PathVariable int pageSize, @PathVariable String field) {
		Page<CourseMaster> item = service.getWithPaginationAndSortingDESC(offset, pageSize, field);
		return new APIResponse<>(item.getSize(), item);
	}

	@PostMapping("search")
	public ResponseEntity<Object> find(@RequestBody CourseRequest specs) {
		try {
			List<CourseDtoFullListing> list = service.getFullListing(specs);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list, list.size());
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
		}
	}

}
