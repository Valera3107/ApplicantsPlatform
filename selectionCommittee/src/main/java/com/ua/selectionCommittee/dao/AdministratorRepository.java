package com.ua.selectionCommittee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ua.selectionCommittee.domain.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{

	Optional<Administrator> findByLogin(String login);
}
