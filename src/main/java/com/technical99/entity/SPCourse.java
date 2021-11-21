package com.technical99.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sun.istack.Nullable;
import com.technical99.entity.entityenum.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SPCourseMaster")
@JsonPropertyOrder({ "Id", "CategoryId", "LangId","Title","Price","Duration","Learners","Rating","RatingCount","Status","IsTranding","Status","Statement","Features","Project","About","Faq","Tag","Metadata","CreatedDate","CreatedBy",})
public class SPCourse {

	@Id
	@JsonProperty("Id")
	@Column(name = "SPCourseId")
	private long sPCourseId;

	@Column(name = "CategoryId")
	private long categoryId;

	@Column(name = "LangId")
	private int langId;

	@Column(name = "Title")
	private String title;

	@Column(name = "IsTranding")
	private int isTranding;

	@Column(name = "Statement")
	private String statement;

	@Column(name = "Price")
	private int price;

	@Column(name = "Duration")
	private int duration;

	@Column(name = "Features")
	private String features;

	@Column(name = "Project")
	private String project;

	@Column(name = "Rating")
	private float rating;

	@Column(name = "RatingCount")
	private int ratingCount;

	@Column(name = "Learners")
	private int learners;

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	@Column(name = "About")
	private String about;

	@Column(name = "FAQ")
	private String faq;

	@Column(name = "Tag")
	private String tag;

	@Column(name = "Metadata")
	private String metadata;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@JsonFormat(pattern="dd-MM-yyyy")
	@Column(name = "CreatedDate")
	private LocalTime createdDate;

	@Nullable
	@Column(name = "CreatedBy")
	private long createdBy;
}
