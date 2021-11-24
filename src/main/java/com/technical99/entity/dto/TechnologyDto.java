package com.technical99.entity.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.technical99.entity.Topic;

import lombok.Data;

@Data
@JsonPropertyOrder({ "techId", "techName", "topics",})
public class TechnologyDto {


	private long techId;
	
	private String techName;
	
	private Set<TopicDto> topics;
}
