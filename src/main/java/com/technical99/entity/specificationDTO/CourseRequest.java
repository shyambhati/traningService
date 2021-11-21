package com.technical99.entity.specificationDTO;

import javax.persistence.Column;

import com.technical99.entity.entityenum.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseRequest {

	private String name;

	private String status;

	private int isTranding = 2;
	
	private int[] category;

	private String startBatch;
	
	private String endBatch;

	private String month;

	private String[] batchType;
}
