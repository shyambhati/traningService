package com.technical99.service;
import java.util.List;
import org.springframework.data.domain.Page;
import com.technical99.entity.CourseMaster;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.CourseDtoFullListing;
import com.technical99.entity.dto.CourseDtoListing;
import com.technical99.entity.specificationDTO.CourseRequest;

public interface CourseService {

	public List<CourseMaster> getlist();
	
	public List<CategoryDto> getlistDto();
	
	public List<CourseDtoListing> getlisting();
	
	public List<CourseMaster> getFullList();

	public List<CourseMaster> getSortedASC(String field);

	public List<CourseMaster> getSortedDESC(String field);

	public Page<CourseMaster> getWithPagination(int offset, int pageSize);

	public Page<CourseMaster> getWithPaginationAndSortingASC(int offset, int pageSize, String field);
	
	public Page<CourseMaster> getWithPaginationAndSortingDESC(int offset, int pageSize, String field);
	
	/* Fullstack Course */
	
	public List<CourseDtoFullListing> getFullListing(CourseRequest specs);
}
