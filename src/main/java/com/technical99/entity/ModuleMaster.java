package com.technical99.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.technical99.entity.entityenum.IsTrainingEnum;
import com.technical99.entity.entityenum.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ModuleMaster")
public class ModuleMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ModuleId")
	private int moduleId;
	
	@Column(name = "ModuleName")
	private String moduleName;
 
	@Column(name = "Count")
	private int count;
	
	@Column(name = "Descp")
	private String descp;

	@Column(name = "Icon")
	private String icon;

}
