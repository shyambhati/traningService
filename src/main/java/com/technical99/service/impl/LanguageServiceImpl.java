package com.technical99.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical99.dao.LanguageDao;
import com.technical99.entity.Language;
import com.technical99.service.LanguageService;


@Service
public class LanguageServiceImpl implements LanguageService {

	
	@Autowired
	private LanguageDao dao;
	
	@Override
	public List<Language> getlist() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
