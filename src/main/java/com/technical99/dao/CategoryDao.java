package com.technical99.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.technical99.entity.Category;
import com.technical99.entity.Language;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.entityenum.StatusEnum;

import lombok.ToString;

//@Repository
@RepositoryRestResource
@Transactional
public interface CategoryDao  extends JpaRepository<Category, Long> ,JpaSpecificationExecutor<Category>{

	
	public List<Category> findByStatus(StatusEnum type);
}
