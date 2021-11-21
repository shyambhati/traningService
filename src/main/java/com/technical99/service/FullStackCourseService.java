package com.technical99.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.technical99.entity.CourseMaster;
import com.technical99.entity.FullStackCourse;
import com.technical99.entity.dto.FullStackCourseDto;
import com.technical99.entity.dto.FullStackCourseDtoListing;


public interface FullStackCourseService {

	public List<FullStackCourse> getFullList();
	public List<FullStackCourseDto> getListDto();
	public List<FullStackCourseDtoListing> getListing();

}
