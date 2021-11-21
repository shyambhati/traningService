package com.technical99.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technical99.dao.FullStackCourseDao;
import com.technical99.entity.FullStackCourse;
import com.technical99.entity.dto.FullStackCourseDto;
import com.technical99.entity.dto.FullStackCourseDtoListing;
import com.technical99.service.FullStackCourseService;

@Service
public class FullStackCourseServiceImpl implements FullStackCourseService {

	@Autowired
	private FullStackCourseDao dao;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<FullStackCourse> getFullList() {
		return dao.findAll();
		// return dao.getByIsTrandingAndIsDependent(1,0);
	}
	
	@Override
	public List<FullStackCourseDto> getListDto() {
		return dao.findAll().stream().map(post -> modelMapper.map(post, FullStackCourseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<FullStackCourseDtoListing> getListing() {
		// TODO Auto-generated method stub
		return dao.findAll().stream().map(post -> modelMapper.map(post, FullStackCourseDtoListing.class))
				.collect(Collectors.toList());
		
	}

}
