package com.technical99.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.technical99.entity.entityenum.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Technology")
public class Technology {

	@Id
	@JsonProperty("Id")
	@Column(name = "TechId")
	private long techId;
	
	@Column(name = "LangId")
	private long langId;
	
	@Column(name = "TechName")
	private String techName;
	
	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	@Column(name = "TutorialCount")
	private int tutorialCount;
	
	@Column(name = "MCQCount")
	private int mCQCount;
	
	@Column(name = "IQCount")
	private int iQCount;
	
	@Column(name = "CSCount")
	private int cSCount;
	
	@Column(name = "Weight")
	private int weight;
	
	
	@Column(name = "Icon")
	private String icon;
	
	@OneToMany( mappedBy = "techId", cascade = CascadeType.MERGE,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set<Topic> topics;
	
}
