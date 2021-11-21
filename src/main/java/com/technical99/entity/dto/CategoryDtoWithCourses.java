package com.technical99.entity.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "categoryId", "name", "spclearners", "course" , "fsCourse" , "spCourse" })
//@JsonPropertyOrder(alphabetic = true)
public class CategoryDtoWithCourses {

	private Long categoryId;
	private String name;
	private int sPCLearners;

	private List<CourseDto> course;

	private List<FSCourseDto> fsCourse;

	 private List<SPCourseDto> spCourse;
}
