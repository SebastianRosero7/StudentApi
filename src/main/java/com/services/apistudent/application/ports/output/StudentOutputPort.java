package com.services.apistudent.application.ports.output;

import com.services.apistudent.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentOutputPort {

    List<Student> getStudent();
    Optional<Student> getStudentById(Long id);
    Student save(Student student);
    void delete(Long id);

}
