package com.samasouf.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.domain.Announcement;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementSpecification {

    /**
     * Creates a specification based on the provided criteria
     * 
     * @param criteria the search criteria
     * @return the JPA specification
     */
    public static Specification<Announcement> createSpecification(AnnouncementCriteria criteria) {
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

            // Filter by status
            if (StringUtils.hasText(criteria.getStatus())) {
                predicates.add(criteriaBuilder.equal(root.get("status"), criteria.getStatus()));
            }

            // Filter by type
            if (StringUtils.hasText(criteria.getType())) {
                predicates.add(criteriaBuilder.equal(root.get("type"), criteria.getType()));
            }

            // Filter by announcement transaction
            if (criteria.getAnnouncementTransaction() != null) {
                predicates.add(criteriaBuilder.equal(root.get("announcementTransaction"),
                        criteria.getAnnouncementTransaction()));
            }

            // Filter by start date (announcements starting after this date)
            if (criteria.getStartDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), criteria.getStartDate()));
            }

            // Filter by end date (announcements ending before this date)
            if (criteria.getEndDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("endDate"), criteria.getEndDate()));
            }

            // Add join with Land entity for additional filtering if needed
            Join<Object, Object> landJoin = root.join("landId", JoinType.LEFT);

            // Filter by land type if specified in criteria.type and no direct type filter
            if (StringUtils.hasText(criteria.getType()) && !StringUtils.hasText(criteria.getStatus())) {
                predicates.add(criteriaBuilder.equal(landJoin.get("type"), criteria.getType()));
            }

            // Ensure announcement is not deleted (if you have soft delete)
            // predicates.add(criteriaBuilder.isNull(root.get("deletedAt")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * Specification for finding active announcements
     * 
     * @return specification for active announcements
     */
    public static Specification<Announcement> isActive() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), "active");
    }

    /**
     * Specification for finding announcements by owner
     * 
     * @param ownerId the owner ID
     * @return specification for announcements by owner
     */
    public static Specification<Announcement> byOwner(Long ownerId) {
        return (root, query, criteriaBuilder) -> {
            if (ownerId == null) {
                return criteriaBuilder.conjunction();
            }
            Join<Object, Object> ownerJoin = root.join("ownerId", JoinType.INNER);
            return criteriaBuilder.equal(ownerJoin.get("id"), ownerId);
        };
    }

    /**
     * Specification for finding announcements within a date range
     * 
     * @param startDate the start date
     * @param endDate   the end date
     * @return specification for date range
     */
    public static Specification<Announcement> withinDateRange(OffsetDateTime startDate, OffsetDateTime endDate) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (startDate != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), startDate));
            }

            if (endDate != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("endDate"), endDate));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * Specification for finding announcements by land location
     * 
     * @param city        the city name
     * @param departement the department name
     * @return specification for location-based search
     */
    public static Specification<Announcement> byLocation(String city, String departement) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<Object, Object> landJoin = root.join("landId", JoinType.LEFT);
            Join<Object, Object> locationJoin = landJoin.join("locationId", JoinType.LEFT);

            if (StringUtils.hasText(city)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(locationJoin.get("city")),
                        "%" + city.toLowerCase() + "%"));
            }

            if (StringUtils.hasText(departement)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(locationJoin.get("departement")),
                        "%" + departement.toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
