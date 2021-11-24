package com.technical99.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical99.entity.BatchMaster;
import com.technical99.entity.Technology;
import com.technical99.entity.dto.ResponseHandler;
import com.technical99.entity.dto.TechnologyDto;
import com.technical99.service.TechnologyService;

import io.swagger.v3.oas.annotations.Hidden;


@RestController
@RequestMapping("technology/")
public class TechnologyController {
	
	@Autowired
	private TechnologyService service;
	
//	@GetMapping(value = "getList")
//    public ResponseEntity<Object> getList() {
//        try {
//            List<Technology> list = service.getlist();
//            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
//        } catch (Exception e) {
//            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
//        }
//    }	
//	
	

	@GetMapping(value = "getList")
    public ResponseEntity<Object> getList() {
        try {
            List<TechnologyDto> list = service.getListDto();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
        }
    }	

}
