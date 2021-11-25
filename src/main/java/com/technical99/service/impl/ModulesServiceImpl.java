package com.technical99.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical99.dao.ModulesMapDao;
import com.technical99.entity.ModuleMap;
import com.technical99.service.ModulesService;

@Service
public class ModulesServiceImpl implements ModulesService {

	@Autowired
	private ModulesMapDao dao;
	
	@Override
	public List<ModuleMap> getListByLangId(int id) {
		return dao.findByLangId(id);
	}

}
