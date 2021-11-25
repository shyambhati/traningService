package com.technical99.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.technical99.entity.entityenum.IsTrainingEnum;
import com.technical99.entity.entityenum.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Language")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LangId")
	private int langId;

	@Column(name = "LangName")
	private String langName;

	@Column(name = "Prefix")
	private String prefix;

	@JsonIgnore
	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	StatusEnum status;

	@JsonIgnore
	@Column(name = "IsTraining")
	@Enumerated(EnumType.STRING)
	IsTrainingEnum isTraning;

	@Column(name = "About")
	private String about;

	@Column(name = "Ordering")
	private int ordering;

	@Column(name = "Image")
	private String image;

	@Column(name = "FAQ")
	private String faq;

	@Column(name = "SPCLearners")
	private int sPCLearners;

    @Column(name ="CategoryId")
    private Long categoryId;
}
