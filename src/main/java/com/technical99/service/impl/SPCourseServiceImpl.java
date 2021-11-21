package com.technical99.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical99.dao.SPCourseDao;
import com.technical99.entity.SPCourse;
import com.technical99.entity.dto.CourseDtoListing;
import com.technical99.entity.dto.SPCourseDtoListing;
import com.technical99.service.SPCourseService;

@Service
public class SPCourseServiceImpl implements SPCourseService {

	@Autowired
	private SPCourseDao dao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<SPCourse> getlist() {
		return dao.findAll();
	}
	
	@Override
	public List<SPCourseDtoListing> getlistDtoListing() {
		
		return dao.findAll().stream().map(post -> modelMapper.map(post, SPCourseDtoListing.class))
				.collect(Collectors.toList());
	}

}
