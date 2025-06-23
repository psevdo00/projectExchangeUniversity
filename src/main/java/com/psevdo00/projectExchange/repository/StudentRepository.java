package com.psevdo00.projectExchange.repository;

import com.psevdo00.projectExchange.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
