package com.xyz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.app.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
