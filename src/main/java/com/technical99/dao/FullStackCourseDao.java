package com.technical99.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.technical99.entity.FullStackCourse;

@RepositoryRestResource
@Transactional
public interface FullStackCourseDao extends JpaRepository<FullStackCourse, Long>,JpaSpecificationExecutor<FullStackCourse> {
}
