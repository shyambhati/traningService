package com.technical99.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical99.entity.Technology;
import com.technical99.entity.TutorialMaster;
import com.technical99.entity.dto.ResponseHandler;
import com.technical99.service.TechnologyService;
import com.technical99.service.TutorialMasterService;


@RestController
@RequestMapping("tutorial/")
public class TutorialMasterController {

	@Autowired
	private TutorialMasterService service;

	@GetMapping(value = "getList")
	public ResponseEntity<Object> getList() {
		try {
			List<TutorialMaster> list = service.getlist();
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list, list.size());
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
		}
	}
}
