package com.technical99.entity.dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "pageId", "uRLTitle"})
public class TutorialMasterDto {


	private Long pageId;
	
	private String uRLTitle;
}
