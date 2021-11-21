package com.technical99.entity.dto;

import java.util.List;

import javax.persistence.Column;

import lombok.Data;

@Data
public class CourseDtoListing {

	int courseId;

	//int categoryId;

	String title;

	String courseName;

	float rating;

	int ratingCount;

	int learners;
	
	private List<BatchMasterDto> batch;

}
