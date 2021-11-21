package com.technical99.entity.dto;

import java.util.List;

import javax.persistence.Column;

import lombok.Data;

@Data
public class CourseDtoFullListing {

	int courseId;

	// int categoryId;

	String title;

	String courseName;

	float rating;

	int ratingCount;

	int learners;

	int duration;

	private List<BatchMasterDto> batch;

}
