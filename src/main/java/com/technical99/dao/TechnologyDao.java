package com.technical99.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.technical99.entity.Category;
import com.technical99.entity.Technology;
import com.technical99.entity.dto.TechnologyDto;
import com.technical99.entity.entityenum.StatusEnum;

@Repository
@Transactional
public interface TechnologyDao extends JpaRepository<Technology, Integer>{
	public List<Technology> findByLangId(long langId);
	
}
