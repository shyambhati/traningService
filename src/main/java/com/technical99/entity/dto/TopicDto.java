package com.technical99.entity.dto;

import java.util.Set;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.technical99.entity.Topic;
import com.technical99.entity.TutorialMaster;

import lombok.Data;

@Data
@JsonPropertyOrder({ "topicId", "topicName", "topics",})
public class TopicDto {


	private Long topicId;

	private String topicName;
	
	private Set<TutorialMasterDto> links;
	
}
