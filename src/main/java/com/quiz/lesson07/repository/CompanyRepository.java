package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{

	// Spring Data JPA
	
	// CompanyEntity save(엔티티객체)
	// findById(id);
	// delete(객체);
}
