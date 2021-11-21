package com.technical99.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical99.dao.BatchDao;
import com.technical99.dao.CategoryDao;
import com.technical99.entity.BatchMaster;
import com.technical99.entity.Category;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.CategoryDtoWithCourses;
import com.technical99.entity.dto.CategoryDtoWithLanguage;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.service.BatchService;
import com.technical99.service.CategoryService;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<BatchMaster> getlist() {
		return dao.findAll();
	}

	

}
