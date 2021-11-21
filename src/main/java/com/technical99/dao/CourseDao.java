package com.technical99.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.technical99.entity.CourseMaster;

@RepositoryRestResource
@Transactional
public interface CourseDao extends JpaRepository<CourseMaster, Long>,JpaSpecificationExecutor<CourseMaster>{

	
	List<CourseMaster> getByIsTrandingAndIsDependent(int isTrending,int isDependent);
}
