package com.technical99.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technical99.entity.FullStackCourse;

@Repository
@Transactional
public interface FullStackCourseDao extends JpaRepository<FullStackCourse, Long> {
}
