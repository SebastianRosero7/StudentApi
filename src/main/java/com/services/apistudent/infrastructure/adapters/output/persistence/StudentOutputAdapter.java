package com.services.apistudent.infrastructure.adapters.output.persistence;

import com.services.apistudent.application.ports.output.StudentOutputPort;
import com.services.apistudent.domain.model.Student;
import com.services.apistudent.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.services.apistudent.infrastructure.adapters.output.persistence.repository.StudentRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentOutputAdapter implements StudentOutputPort {

    private final StudentRespository studentRespository;
    private final StudentPersistenceMapper studentPersistenceMapper;

    //el mapper nos convierte los objetos planos a entidades u objetos de bases de datos
    //por lo cual en cada metodo se juega con estas conversiones (de pojo a entity i viceversa)
    @Override
    public List<Student> getStudent() {
        return studentPersistenceMapper.toStudentList(studentRespository.findAll());
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRespository.findById(id)
                .map(studentPersistenceMapper::toStudent);
    }

    @Override
    public Student save(Student student) {
        return studentPersistenceMapper
                .toStudent(studentRespository.
                        save(studentPersistenceMapper.toStudentEntity(student)));
    }

    @Override
    public void delete(Long id) {
        studentRespository.deleteById(id);
    }
}
