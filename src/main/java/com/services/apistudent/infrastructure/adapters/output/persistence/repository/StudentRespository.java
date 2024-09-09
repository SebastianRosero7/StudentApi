package com.services.apistudent.infrastructure.adapters.output.persistence.repository;

import com.services.apistudent.domain.model.Student;
import com.services.apistudent.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends JpaRepository<StudentEntity, Long> {
}
