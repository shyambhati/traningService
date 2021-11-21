package com.technical99.entity.dto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	 public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object obj,int size) {
		  Map<String, Object> map =new LinkedHashMap<String, Object>();            
	           
	            map.put("data", obj);
	            map.put("message", message);
	            map.put("status", status.value());
	            map.put("size", size);
	            return new ResponseEntity<Object>(map,status);
	    }
}
