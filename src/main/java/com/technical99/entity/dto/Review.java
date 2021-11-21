package com.technical99.entity.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.technical99.entity.CourseMaster;
import com.technical99.entity.User;

import lombok.Data;

@Entity
@Data
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Min(1)
	@Max(5)
	private int rating;

	private String comment;

	@ManyToOne(optional = false)
	private CourseMaster item;

	@ManyToOne(optional = false)
	private User author;
}
