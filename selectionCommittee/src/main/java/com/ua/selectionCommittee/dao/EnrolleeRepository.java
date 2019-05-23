package com.ua.selectionCommittee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ua.selectionCommittee.domain.Enrollee;

@Repository
public interface EnrolleeRepository extends JpaRepository<Enrollee, Integer>{

	Optional<Enrollee> findByLogin(String login);
}
