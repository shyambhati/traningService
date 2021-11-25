package com.technical99.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical99.dao.TechnologyDao;
import com.technical99.entity.Technology;
import com.technical99.entity.dto.TechnologyDto;
import com.technical99.service.TechnologyService;


@Service
public class TechnologyServiceImpl implements TechnologyService{

	@Autowired
	private TechnologyDao dao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Technology> getlist() {
		return dao.findAll();
	}

	@Override
	public List<TechnologyDto> getListDto() {
		
		return dao.findAll().stream().map(post -> modelMapper.map(post, TechnologyDto.class))
				.collect(Collectors.toList());
	
	}

	@Override
	public List<TechnologyDto> getListByLangId(int langId) {		
		return dao.findByLangId(langId).stream().map(post -> modelMapper.map(post, TechnologyDto.class))
				.collect(Collectors.toList());
	}
	
}
