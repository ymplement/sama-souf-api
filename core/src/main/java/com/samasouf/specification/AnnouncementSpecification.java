package com.samasouf.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
            Join<Object, Object> landJoin = root.join("lands", JoinType.LEFT);

            // Filter by land type if specified in criteria.type
            if (StringUtils.hasText(criteria.getType())) {
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
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), "ACTIVE");
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
            Join<Object, Object> ownerJoin = root.join("owner", JoinType.INNER);
            return criteriaBuilder.equal(ownerJoin.get("owner_id"), ownerId);
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

            Join<Object, Object> landJoin = root.join("lands", JoinType.LEFT);
            Join<Object, Object> locationJoin = landJoin.join("location", JoinType.LEFT);

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

    /**
     * Specification for finding announcements by land price range
     * 
     * @param minPrice the minimum price
     * @param maxPrice the maximum price
     * @return specification for price range
     */
    public static Specification<Announcement> byPriceRange(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<Object, Object> landJoin = root.join("lands", JoinType.LEFT);

            if (minPrice != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(landJoin.get("price"), minPrice));
            }

            if (maxPrice != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(landJoin.get("price"), maxPrice));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * Specification for finding announcements by land surface range
     * 
     * @param minSurface the minimum surface
     * @param maxSurface the maximum surface
     * @return specification for surface range
     */
    public static Specification<Announcement> bySurfaceRange(Double minSurface, Double maxSurface) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<Object, Object> landJoin = root.join("lands", JoinType.LEFT);

            if (minSurface != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(landJoin.get("surface"), minSurface));
            }

            if (maxSurface != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(landJoin.get("surface"), maxSurface));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * Specification for finding announcements by land type
     * 
     * @param landType the land type (COMMERCIAL, RESIDENTIAL, etc.)
     * @return specification for land type
     */
    public static Specification<Announcement> byLandType(String landType) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(landType)) {
                return criteriaBuilder.conjunction();
            }
            Join<Object, Object> landJoin = root.join("lands", JoinType.LEFT);
            return criteriaBuilder.equal(landJoin.get("type"), landType);
        };
    }

    /**
     * Specification for finding announcements by certified lands only
     * 
     * @return specification for certified lands
     */
    public static Specification<Announcement> byCertifiedLands() {
        return (root, query, criteriaBuilder) -> {
            Join<Object, Object> landJoin = root.join("lands", JoinType.LEFT);
            return criteriaBuilder.equal(landJoin.get("isCertified"), true);
        };
    }

    /**
     * Specification for finding announcements by land status
     * 
     * @param landStatus the land status
     * @return specification for land status
     */
    public static Specification<Announcement> byLandStatus(String landStatus) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(landStatus)) {
                return criteriaBuilder.conjunction();
            }
            Join<Object, Object> landJoin = root.join("lands", JoinType.LEFT);
            return criteriaBuilder.equal(landJoin.get("status"), landStatus);
        };
    }

    /**
     * Specification for finding announcements with external source
     * 
     * @return specification for announcements with external source
     */
    public static Specification<Announcement> hasExternalSource() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get("externalSource"));
    }

    /**
     * Specification for finding announcements by external source type
     * 
     * @param sourceType the external source type
     * @return specification for external source type
     */
    public static Specification<Announcement> byExternalSourceType(String sourceType) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(sourceType)) {
                return criteriaBuilder.conjunction();
            }
            Join<Object, Object> sourceJoin = root.join("externalSource", JoinType.LEFT);
            return criteriaBuilder.equal(sourceJoin.get("type"), sourceType);
        };
    }

    /**
     * Creates a Pageable object from the criteria
     * 
     * @param criteria the search criteria containing pagination info
     * @return the Pageable object
     */
    public static Pageable createPageable(AnnouncementCriteria criteria) {
        int page = criteria.getPageNumber() != null ? criteria.getPageNumber() : 0;
        int size = criteria.getPageSize() != null ? criteria.getPageSize() : 10;

        // Default sorting by creation date (most recent first)
        Sort sort = Sort.by(Sort.Direction.DESC, "startDate");

        return PageRequest.of(page, size, sort);
    }
}
