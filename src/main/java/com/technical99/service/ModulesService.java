package com.technical99.service;

import java.util.List;

import com.technical99.entity.Category;
import com.technical99.entity.ModuleMap;
import com.technical99.entity.entityenum.StatusEnum;

public interface ModulesService {
	
	public List<ModuleMap> getListByLangId(int id);	
}
