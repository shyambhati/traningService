package com.technical99.service;

import java.util.List;

import com.technical99.entity.CourseMaster;
import com.technical99.entity.SPCourse;
import com.technical99.entity.dto.SPCourseDtoListing;

public interface SPCourseService {
	
	
	public List<SPCourse> getlist();
	
	public List<SPCourseDtoListing> getlistDtoListing();
}
