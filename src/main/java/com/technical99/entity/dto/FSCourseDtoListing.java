package com.technical99.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "CourseId",  "Title","Learners","Hours","Rating","RatingCount"})
public class FSCourseDtoListing {


    
	int courseId;

	//int categoryId;

	String title;

	@JsonProperty(value = "Hours")
	int Duration;
	
	int Learners;

	float Rating;

	int ratingCount;
}
