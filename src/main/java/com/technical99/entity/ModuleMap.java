package com.technical99.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ModuleMap")
public class ModuleMap {

	@Id 
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ModMapId")
	private int modMapId;
	
	@Column(name = "LangId")
	private int langId;
	
	@JsonIgnore
	@Column(name = "ModuleId")
	private int moduleId;
	
	@OneToMany( mappedBy = "moduleId", cascade = CascadeType.MERGE,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set<ModuleMaster> modules;

}
