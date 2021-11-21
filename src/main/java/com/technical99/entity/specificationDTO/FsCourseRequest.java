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
public class FsCourseRequest {

	private String name;
	private String status;
	
	private int[] category;

}
