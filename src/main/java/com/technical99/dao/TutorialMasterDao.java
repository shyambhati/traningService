package com.technical99.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technical99.entity.TutorialMaster;

@Repository
public interface TutorialMasterDao extends JpaRepository<TutorialMaster, Integer> {

}
