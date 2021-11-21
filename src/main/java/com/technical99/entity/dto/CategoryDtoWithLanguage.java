package com.technical99.entity.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "categoryId", "name" ,"spclearners","language"})
//@JsonPropertyOrder(alphabetic = true)
public class CategoryDtoWithLanguage {
	
	
	private Long CategoryId;
	private String Name;
	private int SPCLearners;
	
	private List<LanguageDto> language;
}
