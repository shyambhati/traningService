package com.technical99.dao.Specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.technical99.entity.Category;

@Component
public class CategorySpecification {
	 public Specification<Category> getUsers(Category request) {
	        return (root, query, criteriaBuilder) -> {
	            List<Predicate> predicates = new ArrayList<>();
	            if (request.getName() != null && !request.getName().isEmpty()) {
	                predicates.add(criteriaBuilder.equal(root.get("name"), request.getName()));
	            }
//	            if (request.getName() != null && !request.getName().isEmpty()) {
//	                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")),
//	                        "%" + request.getName().toLowerCase() + "%"));
//	            }
//	            if (request.getGender() != null && !request.getGender().isEmpty()) {
//	                predicates.add(criteriaBuilder.equal(root.get("gender"), request.getGender()));
//	            }
	            query.orderBy(criteriaBuilder.desc(root.get("name")));
	            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	        };
	    }
	
}
