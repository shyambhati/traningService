package com.technical99.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.technical99.entity.dto.LanguageDto;
import com.technical99.entity.entityenum.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Category")
@NoArgsConstructor
@Getter
@Setter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private Long categoryId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	

	@JsonIgnore
	@Column(name = "IsTraining")
	private String isTraining;

	@JsonIgnore
	@Column(name = "SPCLearners")
	private int sPCLearners;


	@OneToMany( mappedBy = "categoryId", cascade = CascadeType.MERGE,orphanRemoval = true)
	@OrderBy("Ordering")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set<Language> language;
	
	
	@OneToMany( mappedBy = "categoryId", cascade = CascadeType.MERGE,orphanRemoval = true)
	@OrderBy("Ordering")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set<CourseMaster> course;
	
	
	@OneToMany( mappedBy = "categoryId", cascade = CascadeType.MERGE,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set<FullStackCourse> fscourse;
	
	@OneToMany( mappedBy = "categoryId", cascade = CascadeType.MERGE,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set<SPCourse> spcourse;
	
}
