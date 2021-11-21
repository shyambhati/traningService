package com.technical99.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical99.dao.CategoryDao;
import com.technical99.entity.Category;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.CategoryDtoWithCourses;
import com.technical99.entity.dto.CategoryDtoWithLanguage;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Category> getlist(StatusEnum type) {
		return dao.findByStatus(type);
	}

	@Override
	public List<CategoryDto> getListDto(StatusEnum type) {
		return dao.findByStatus(type).stream().map(post -> modelMapper.map(post, CategoryDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<CategoryDtoWithLanguage> getListDtoWithLanguage(StatusEnum type) {
		return dao.findByStatus(type).stream().map(post -> modelMapper.map(post, CategoryDtoWithLanguage.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<CategoryDtoWithCourses> getListDtoWithCourse(StatusEnum type) {
		return dao.findByStatus(type).stream().map(post -> modelMapper.map(post, CategoryDtoWithCourses.class))
				.collect(Collectors.toList());
	}

}
