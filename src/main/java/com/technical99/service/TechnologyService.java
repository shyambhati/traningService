package com.technical99.service;

import java.util.List;
import com.technical99.entity.Technology;
import com.technical99.entity.dto.TechnologyDto;

public interface TechnologyService {

	public List<Technology> getlist();	
	
	public List<TechnologyDto> getListDto();	
}
