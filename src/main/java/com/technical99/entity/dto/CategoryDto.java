package com.technical99.entity.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.technical99.entity.Language;

import lombok.Data;

@Data
@JsonPropertyOrder({ "ID", "name", "spclearners",})
public class CategoryDto {
	
	@JsonProperty("ID")
	private Long categoryId;
	
	private String name;
	
	private int sPCLearners;
}
