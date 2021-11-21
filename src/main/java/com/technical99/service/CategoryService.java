package com.technical99.service;

import java.util.List;
import com.technical99.entity.Category;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.CategoryDtoWithCourses;
import com.technical99.entity.dto.CategoryDtoWithLanguage;
import com.technical99.entity.entityenum.StatusEnum;

public interface CategoryService {
	
	public List<Category> getlist(StatusEnum type);	
	
	public List<CategoryDto> getListDto(StatusEnum type);	
	
	public List<CategoryDtoWithLanguage> getListDtoWithLanguage(StatusEnum type);	
	
	public List<CategoryDtoWithCourses> getListDtoWithCourse(StatusEnum type);	
	
}
