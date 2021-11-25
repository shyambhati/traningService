package com.technical99.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical99.entity.ModuleMap;
import com.technical99.entity.dto.ResponseHandler;
import com.technical99.entity.dto.TechnologyDto;
import com.technical99.service.ModulesService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Modules", description = "All Modules Related API")
@RequestMapping(value = "modules/")
public class ModulesController {

	@Autowired
	private ModulesService service;
	
	@PostMapping(value = "getList")
    public ResponseEntity<Object> getListWithId(@RequestBody Map<String, String>  langId) {
		int id = Integer.parseInt(langId.get("langId"));
        try {
            List<ModuleMap> list = service.getListByLangId(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list,list.size());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,0);
        }
    }	
}
