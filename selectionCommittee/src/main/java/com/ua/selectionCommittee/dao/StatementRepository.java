package com.ua.selectionCommittee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ua.selectionCommittee.domain.Enrollee;
import com.ua.selectionCommittee.domain.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer>{

}
