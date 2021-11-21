package com.technical99.controller;

import java.util.List;

import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical99.entity.BatchMaster;
import com.technical99.entity.Category;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.ResponseHandler;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.service.BatchService;
import com.technical99.service.CategoryService;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
@RequestMapping("batch/")
public class BatchController {
	@Autowired
	private BatchService service;



	
	@GetMapping(value = "/getList")
    public ResponseEntity<Object> getList() {
        try {
            List<BatchMaster> list = service.getlist();

            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
        }
    }	
}
