package com.ua.selectionCommittee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ua.selectionCommittee.domain.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer>{
  University getByName(String name);
}
