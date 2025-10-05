package com.samasouf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.samasouf.domain.Announcement;

@Repository
public interface AnnouncementRepository
        extends JpaRepository<Announcement, Long>, JpaSpecificationExecutor<Announcement> {
    // JpaSpecificationExecutor already provides findAll(Specification, Pageable)
    // and count(Specification) methods
}
