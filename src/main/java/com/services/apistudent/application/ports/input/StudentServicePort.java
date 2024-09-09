package com.services.apistudent.application.ports.input;

import com.services.apistudent.domain.model.Student;

import java.util.List;

public interface StudentServicePort {

    Student findStudentById(Long id);
    List<Student> findAllStudents();
    Student createStudent(Student student);
    Student updateStudent(Long id,Student student);
    void deleteStudent(Long id);
}
