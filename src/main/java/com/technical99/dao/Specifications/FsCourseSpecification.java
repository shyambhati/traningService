package com.technical99.dao.Specifications;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import com.technical99.entity.CourseMaster;
import com.technical99.entity.FullStackCourse;
import com.technical99.entity.entityenum.BatchTypeEnum;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.entity.specificationDTO.CourseRequest;
import com.technical99.entity.specificationDTO.FsCourseRequest;

@Component
public class FsCourseSpecification {
	public Specification<FullStackCourse> get(FsCourseRequest request) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			predicates.add(cb.equal(root.get("status"), StatusEnum.Live));
			if (request.getName() != null && !request.getName().isEmpty()) {
				predicates.add(cb.equal(root.get("courseName"), request.getName()));
			}
		
			if (request.getCategory() != null && request.getCategory().length > 0) {
				List<Predicate> categoryPredicates = new ArrayList<Predicate>();
				for (Integer a : request.getCategory()) {
					categoryPredicates.add(cb.equal(root.get("categoryId"), a));
				}
				predicates.add(cb.or(categoryPredicates.toArray(new Predicate[] {})));
			}

			query.orderBy(cb.asc(root.get("courseName")));
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
	}

}
