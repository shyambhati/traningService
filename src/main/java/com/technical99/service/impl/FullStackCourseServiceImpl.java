package com.technical99.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technical99.dao.FullStackCourseDao;
import com.technical99.dao.Specifications.CourseSpecification;
import com.technical99.dao.Specifications.FsCourseSpecification;
import com.technical99.entity.FullStackCourse;
import com.technical99.entity.dto.FSCourseDto;
import com.technical99.entity.dto.FSCourseDtoFullListing;
import com.technical99.entity.dto.FSCourseDtoListing;
import com.technical99.entity.specificationDTO.FsCourseRequest;
import com.technical99.service.FullStackCourseService;

@Service
public class FullStackCourseServiceImpl implements FullStackCourseService {

	@Autowired
	private FullStackCourseDao dao;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FsCourseSpecification spec;
	
	@Override
	public List<FullStackCourse> getFullList() {
		return dao.findAll();
		// return dao.getByIsTrandingAndIsDependent(1,0);
	}
	
	@Override
	public List<FSCourseDto> getListDto() {
		return dao.findAll().stream().map(post -> modelMapper.map(post, FSCourseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<FSCourseDtoListing> getListing() {
		return dao.findAll().stream().map(post -> modelMapper.map(post, FSCourseDtoListing.class))
				.collect(Collectors.toList());
		
	}
	
	@Override
	public List<FSCourseDtoFullListing> getFullListing(FsCourseRequest specs) {
		return dao.findAll(spec.get(specs)).stream().map(post -> modelMapper.map(post, FSCourseDtoFullListing.class))
				.collect(Collectors.toList());
		
	}

}
