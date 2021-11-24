package com.technical99.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.technical99.entity.Technology;

@Repository
@Transactional
public interface TechnologyDao extends JpaRepository<Technology, Integer>{

}
