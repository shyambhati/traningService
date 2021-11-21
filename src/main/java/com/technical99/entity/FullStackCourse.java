package com.technical99.entity;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.technical99.entity.entityenum.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FullStackCourseMaster")
public class FullStackCourse {
	@Id
	@Column(name = "FSCourseId")
	private long fSCourseId;

	@Column(name = "CategoryId")
	private long categoryId;

	@Column(name = "LangId")
	private int langId;

	@Column(name = "Title")
	private String title;
	
	@Column(name = "CourseName")
	private String courseName;
	
	

	@Column(name = "Price")
	private int price;

	@Column(name = "Discount")
	private int Discount;

	@Column(name = "Duration")
	private int duration;

	@Column(name = "NOC")
	private int noc;

	@Column(name = "Statement")
	private String Statement;

	@Column(name = "Learners")
	private int learners;

	@Column(name = "Rating")
	private float Rating;

	@Column(name = "RatingCount")
	private int ratingCount;

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	@Column(name = "AboutCourse")
	private String aboutCourse;

	@Column(name = "Features")
	private String features;

	@Column(name = "Project")
	private String project;

	@Column(name = "FAQ")
	private String faq;

	@Column(name = "Metadata")
	private String metadata;

	@Column(name = "Image")
	private String image;

	@Column(name = "CreatedDate")
	private LocalTime createdDate;

	@Column(name = "CreatedBy")
	private long createdBy;

}
