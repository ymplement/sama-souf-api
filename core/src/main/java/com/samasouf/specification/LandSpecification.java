package com.samasouf.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.samasouf.criteria.LandCriteria;
import com.samasouf.domain.Land;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class LandSpecification {

    /**
     * Creates a specification based on the provided criteria
     * 
     * @param criteria the search criteria
     * @return the JPA specification
     */
    public static Specification<Land> createSpecification(LandCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filter by title (case-insensitive contains)
            if (StringUtils.hasText(criteria.getTitle())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),
                        "%" + criteria.getTitle().toLowerCase() + "%"));
            }

            // Filter by description (case-insensitive contains)
            if (StringUtils.hasText(criteria.getDescription())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("description")),
                        "%" + criteria.getDescription().toLowerCase() + "%"));
            }

            // Filter by surface range
            if (criteria.getMinSurface() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("surface"), criteria.getMinSurface()));
            }
            if (criteria.getMaxSurface() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("surface"), criteria.getMaxSurface()));
            }

            // Filter by price range
            if (criteria.getMinPrice() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), criteria.getMinPrice()));
            }
            if (criteria.getMaxPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), criteria.getMaxPrice()));
            }

            // Filter by type
            if (StringUtils.hasText(criteria.getType())) {
                predicates.add(criteriaBuilder.equal(root.get("type"), criteria.getType()));
            }

            // Filter by certification status
            if (criteria.getIsCertified() != null) {
                predicates.add(criteriaBuilder.equal(root.get("isCertified"), criteria.getIsCertified()));
            }

            // Filter by status
            if (StringUtils.hasText(criteria.getStatus())) {
                predicates.add(criteriaBuilder.equal(root.get("status"), criteria.getStatus()));
            }

            // Filter by announcement ID
            if (criteria.getAnnouncementId() != null) {
                Join<Object, Object> announcementJoin = root.join("announcement", JoinType.INNER);
                predicates.add(
                        criteriaBuilder.equal(announcementJoin.get("announcement_id"), criteria.getAnnouncementId()));
            }

            // Filter by location ID
            if (criteria.getLocationId() != null) {
                Join<Object, Object> locationJoin = root.join("location", JoinType.INNER);
                predicates.add(criteriaBuilder.equal(locationJoin.get("location_id"), criteria.getLocationId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * Creates a Pageable object from the criteria
     * 
     * @param criteria the search criteria containing pagination info
     * @return the Pageable object
     */
    public static Pageable createPageable(LandCriteria criteria) {
        int page = criteria.getPageNumber() != null ? criteria.getPageNumber() : 0;
        int size = criteria.getPageSize() != null ? criteria.getPageSize() : 10;

        // Default sorting by price (lowest first)
        Sort sort = Sort.by(Sort.Direction.ASC, "price");

        return PageRequest.of(page, size, sort);
    }
}
