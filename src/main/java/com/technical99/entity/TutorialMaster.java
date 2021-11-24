package com.technical99.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.entity.entityenum.StatusTutorialEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TutorialMaster")
public class TutorialMaster {
	
	@Id
	@JsonProperty("Id")
	@Column(name = "PageId")
	private Long pageId;
	
	@Column(name = "LangId")
	private Long langId;
	
	@Column(name = "TechId")
	private Long techId;
	
	@Column(name = "TopicId")
	private Long topicId;
	
	
	@Column(name = "Metadata")
	private String metadata;
	
	@Column(name = "URLTitle")
	private String uRLTitle;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Page")
	private String page;
	
	@Column(name = "VideoId")
	private String videoId;	
	
	
	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private StatusTutorialEnum status;
	
	@Column(name = "Ordering")
	private Integer ordering;
	
	@Column(name = "Views")
	private Integer views;
	
	@Column(name = "Like")
	private Integer like;
	
	@Column(name = "UnLike")
	private Integer unLike;
	
	@Column(name = "RelatedLinks")
	private String relatedLinks;
	
	@Column(name = "Author")
	private Integer author;
	
	@Column(name = "PublishedDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate publishedDate;

	@Column(name = "CreatedDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate createdDate;
}
