package com.technical99.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sipios.springsearch.anotation.SearchSpec;
import com.technical99.dao.CategoryDao;
import com.technical99.entity.Category;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.CategoryDtoWithCourses;
import com.technical99.entity.dto.CategoryDtoWithLanguage;
import com.technical99.entity.dto.ResponseHandler;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.service.CategoryService;
import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("category/")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@Autowired
	private CategoryDao categoryDao;
	
	 @Autowired
	    private com.technical99.dao.Specifications.CategorySpecification catSpecification;

	@Hidden
	@GetMapping("getListFull")
	public List<Category> getList2() {
		return service.getlist(StatusEnum.Live);
	}
	
	
//	@GetMapping("getA")
//	public String geta() {
//		String uri="http://localhost:9091/category/getList";
//		RestTemplate template=new RestTemplate();
//		String result="";
//		
//		for(int i=0;i<=5000;i++)
//		{	
//			 template=new RestTemplate();
//			 result=template.getForObject(uri, String.class);
//			 System.out.println("Called : "+i+" Result is : "+result);
//			 
//		}
//		return result;
//	}

	@GetMapping(value = "/getList")
    public ResponseEntity<Object> getList() {
	
        try {
            List<CategoryDto> list = service.getListDto(StatusEnum.Live);
            
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
        }
    }

	@GetMapping("getListWithLanguage")
	public ResponseEntity<Object> getListWithLanguage() {
		   try {
	            List<CategoryDtoWithLanguage> list = service.getListDtoWithLanguage(StatusEnum.Live);
	            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
	        }
	}

	@GetMapping("getListWithCourse")
	public  ResponseEntity<Object> getListWithCourse() {
		   try {
	            List<CategoryDtoWithCourses> list = service.getListDtoWithCourse(StatusEnum.Live);
	            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
	        }
	}
	
	@GetMapping("getListSearch")
	public  ResponseEntity<Object> getListSearch(@SearchSpec  Specification<Category> specs) {
		 try {
			// Specification<Category> specs1=new Specification("firstName", ":", "jo"));
			 
			 
			 
	            List<Category> list = categoryDao.findAll(Specification.where(specs));            
	            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
	        }
	}
	
	
	@PostMapping("find")
	public  ResponseEntity<Object> find(@RequestBody  Category specs) {
		 try {
			// Specification<Category> specs1=new Specification("firstName", ":", "jo"));

			 System.out.println("Name is : "+specs.getName());
	            List<Category> list = categoryDao.findAll(catSpecification.getUsers(specs));            
	            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
	        }
	}
	
//	@GetMapping("getListSearch")
//	public getListSearch(@SearchSpec specs: Specification<YourModel>): ResponseEntity<List<YourResponse>> {
//	    return ResponseEntity(yourRepository.findAll(Specification.where(specs)), HttpStatus.OK)
//	}

	
	
}
