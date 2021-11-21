package com.technical99.dao.Specifications;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import com.technical99.entity.CourseMaster;
import com.technical99.entity.entityenum.BatchTypeEnum;
import com.technical99.entity.entityenum.StatusEnum;
import com.technical99.entity.specificationDTO.CourseRequest;

@Component
public class CourseSpecification {
	public Specification<CourseMaster> get(CourseRequest request) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			predicates.add(cb.equal(root.get("status"), StatusEnum.Live));
			if (request.getName() != null && !request.getName().isEmpty()) {
				predicates.add(cb.equal(root.get("courseName"), request.getName()));
			}

			if (request.getIsTranding() != 2) {

				predicates.add(cb.equal(root.get("isTranding"), request.getIsTranding()));
			}
			if (request.getCategory() != null && request.getCategory().length > 0) {
				List<Predicate> categoryPredicates = new ArrayList<Predicate>();
				for (Integer a : request.getCategory()) {
					categoryPredicates.add(cb.equal(root.get("categoryId"), a));
				}
				predicates.add(cb.or(categoryPredicates.toArray(new Predicate[] {})));
			}

			if (root.join("batch") != null) {
				if (request.getStartBatch() != null && !request.getStartBatch().isEmpty()) {
					predicates.add(cb.equal(root.join("batch").get("startTime"), request.getStartBatch()));
				}

				if (request.getEndBatch() != null && !request.getEndBatch().isEmpty()) {
					predicates.add(cb.equal(root.join("batch").get("endTime"), request.getEndBatch()));
				}

				if (request.getBatchType() != null && request.getBatchType().length > 0) {
					List<Predicate> typePredicates = new ArrayList<Predicate>();
					for (String a : request.getBatchType()) {
						if ("WE".equalsIgnoreCase(a))
							typePredicates.add(cb.equal(root.join("batch").get("batchType"), BatchTypeEnum.WE));
						else if ("WD".equalsIgnoreCase(a))
							typePredicates.add(cb.equal(root.join("batch").get("batchType"), BatchTypeEnum.WD));

					}
					predicates.add(cb.or(typePredicates.toArray(new Predicate[] {})));
				}
				if (request.getMonth() != null && !request.getMonth().isEmpty()
						&& !request.getMonth().equalsIgnoreCase("All")) {
					predicates.add(cb.equal(root.join("batch").get("month"), request.getMonth()));

				}
			}

			query.orderBy(cb.asc(root.get("ordering")));
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
	}

}
