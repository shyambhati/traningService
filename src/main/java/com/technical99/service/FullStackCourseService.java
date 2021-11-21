package com.technical99.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.technical99.entity.CourseMaster;
import com.technical99.entity.FullStackCourse;
import com.technical99.entity.dto.FSCourseDto;
import com.technical99.entity.dto.FSCourseDtoFullListing;
import com.technical99.entity.dto.FSCourseDtoListing;
import com.technical99.entity.specificationDTO.CourseRequest;
import com.technical99.entity.specificationDTO.FsCourseRequest;


public interface FullStackCourseService {

	public List<FullStackCourse> getFullList();
	public List<FSCourseDto> getListDto();
	public List<FSCourseDtoListing> getListing();
	
	public List<FSCourseDtoFullListing> getFullListing(FsCourseRequest specs);

}
