/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.technical99.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.technical99.entity.entityenum.CourseTypeEnum;
import com.technical99.entity.entityenum.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author SHYAM
 */
@Entity
@Table(name = "CertificateCourseMaster")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMaster {
	
	 @Id
     @Column(name = "CourseId")
     private long courseId;
	 
     @Column(name = "CategoryId")
     private long categoryId;
     
     @Column(name = "LangId")
     private int langId;
     
     @Column(name = "Title")
     private String title;
     
     @Column(name = "CourseName")
     private String courseName;
     
     @JsonIgnore
     @Column(name = "IsTranding")
     private int isTranding;
     
     @JsonIgnore
     @Column(name = "IsDependent")
     private int isDependent;
     
     @Column(name = "Learners")
     private int learners;
     

     @Column(name = "Duration")
     private int duration;
     
     @Column(name = "Statement")
     private String statement;
     
     @Column(name = "AboutCourse")
     private String aboutCourse;
     
     @Column(name = "Summary")
     private String summary;
     
     @Column(name = "QuickContents")
     private String quickContents;
     
     @Column(name = "Price")
     private int price;
     
     @Column(name = "Discount")
     private int discount;
     
     @Column(name = "Status")
     @Enumerated(EnumType.STRING)
     private StatusEnum status;
     
     @Column(name = "Rating")
     private float rating;
     
     @Column(name = "RatingCount")
     private int ratingCount;
     
     @Column(name = "CompletionRate")
     private float completionRate;
     
     @Column(name = "Ordering")
     private int ordering;
     
     @Column(name = "tag")
     private String tag;
     
     @Column(name = "bgColor")
     private String bgColor;
     
     @Column(name = "Image")
     private String image;
     
 	@OneToMany( mappedBy = "courseId", cascade = CascadeType.MERGE,orphanRemoval = true)
 	@LazyCollection(LazyCollectionOption.TRUE)
 	private Set<BatchMaster> batch;
}
