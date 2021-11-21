package com.technical99.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technical99.entity.Language;


@Repository
@Transactional
public interface LanguageDao extends JpaRepository<Language, Long>{

}
