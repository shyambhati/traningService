package com.technical99.entity;

import java.time.LocalDate;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.technical99.entity.entityenum.BatchStatusEnum;
import com.technical99.entity.entityenum.BatchTypeEnum;
import com.technical99.entity.entityenum.LiveStatusEnum;
import com.technical99.entity.entityenum.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Topic")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TopicId")
	private Long topicId;
	
	@JsonIgnore
	@Column(name = "TechId")
	private long techId;
	
	@Column(name = "TopicName")
	private String topicName;
	
	
	@Column(name = "PQCount")
	private Integer pQCount;
	
	@Column(name = "IQCout")
	private Integer iQCount;
	
	@Column(name = "CSCount")
	private Integer cSCount;
	
	@JsonIgnore
	@Column(name = "TRSubtopics")
	private String tRSubtopics;

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	
	@Column(name = "CRF")
	private int CRF;
	
	@Column(name = "FSF")
	private int FSF;
	
	@Column(name = "SPF")
	private int SPF;
	
	@Column(name = "Weight")
	private Integer weight;
	
	@OneToMany( mappedBy = "topicId", cascade = CascadeType.MERGE,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set<TutorialMaster> links;
	
}
