package com.samasouf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.samasouf.domain.Land;

@Repository
public interface LandRepository extends JpaRepository<Land, Long>, JpaSpecificationExecutor<Land> {

}
