package com.technical99.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.technical99.entity.entityenum.StatusEnum;

import lombok.Data;

@Entity
@Data
@Table(name = "SPCourseMaster")
public class SPCourseMaster {
	
	@Id
	@Column(name = "SPCourseId")
	private Long id;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "IsTranding")
	private int isTranding;
	
	@Column(name = "Duration")
	private int duration;
	
	@Column(name = "Price")
	private int price;
	
	@Column(name = "Rating")
	private Float rating;
	
	@Column(name = "RatingCount")
	private int ratingCount;
	
	@Column(name = "Learners")
	private int learners;
	
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
}
