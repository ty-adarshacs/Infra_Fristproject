package com.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infra.entity.Student;

@Repository
public interface  Repo extends JpaRepository<Student, Integer> {
	

}
