package com.technical99.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.technical99.dao.CourseDao;
import com.technical99.dao.Specifications.CourseSpecification;
import com.technical99.entity.CourseMaster;
import com.technical99.entity.dto.CategoryDto;
import com.technical99.entity.dto.CourseDtoFullListing;
import com.technical99.entity.dto.CourseDtoListing;
import com.technical99.entity.specificationDTO.CourseRequest;
import com.technical99.service.CourseService;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao dao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CourseSpecification spec;
	
//  @PostConstruct
//  public void initDB() {
//      List<CourseMasterEntity> products = IntStream.rangeClosed(1, 500)
//              .mapToObj(i -> new CourseMasterEntity(null,  new Random().nextInt(10),  new Random().nextInt(10), "Demo_"+i, "Course_"+i, 1, 1, new Random().nextInt(10000), CourseTypeEnum.F, 30, "Demo__"+i, "Demo__"+i, "Demo__"+i, "Demo__"+i, new Random().nextInt(1000), new Random().nextInt(100), StatusEnum.Live, 200F,5, 100F, i, "asdasd", "#111111", "asdasdasd"))
//              .collect(Collectors.toList());
//      dao.saveAll(products);
// }
	
	@Override
	public List<CourseMaster> getFullList() {
		return dao.findAll();
	}
	
	
	@Override
	public List<CategoryDto> getlistDto() {
		return dao.findAll().stream().map(post -> modelMapper.map(post, CategoryDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<CourseMaster> getlist() {
		return dao.getByIsTrandingAndIsDependent(1,0);
	}
	
	@Override
	public List<CourseDtoListing> getlisting() {
		 return dao.findAll().stream().map(post -> modelMapper.map(post, CourseDtoListing.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<CourseMaster> getSortedASC(String field) {
		 return  dao.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	@Override
	public List<CourseMaster> getSortedDESC(String field) {
		 return  dao.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	
	
	public Page<CourseMaster> getWithPagination(int offset, int pageSize) {
		Page<CourseMaster> products = dao.findAll(PageRequest.of(offset, pageSize));
		return products;
	}

	public Page<CourseMaster> getWithPaginationAndSortingASC(int offset, int pageSize, String field) {
		Page<CourseMaster> products = dao.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field).ascending()));
		return products;
	}
	
	public Page<CourseMaster> getWithPaginationAndSortingDESC(int offset, int pageSize, String field) {
		Page<CourseMaster> products = dao.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field).descending()));
		return products;
	}
	
	
	
	@Override
	public List<CourseDtoFullListing> getFullListing(CourseRequest specs) {
		 return dao.findAll(spec.get(specs)).stream().map(post -> modelMapper.map(post, CourseDtoFullListing.class))
				.collect(Collectors.toList());
	}
}
