package com.technical99.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technical99.entity.SPCourse;

@Repository
@Transactional
public interface SPCourseDao extends JpaRepository<SPCourse, Long>{

}
