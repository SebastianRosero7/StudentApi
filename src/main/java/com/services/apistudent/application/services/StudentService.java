package com.services.apistudent.application.services;

import com.services.apistudent.application.ports.input.StudentServicePort;
import com.services.apistudent.application.ports.output.StudentOutputPort;
import com.services.apistudent.domain.exception.StudentNotFountdException;
import com.services.apistudent.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentOutputPort studentOutputPort;
    //esta es una especie de controlador, intermediario entre la persistencia y la logica
    @Override
    public Student findStudentById(Long id) {
        return studentOutputPort.getStudentById(id).orElseThrow(() -> new StudentNotFountdException("Error"));
    }

    @Override
    public List<Student> findAllStudents() {
        return studentOutputPort.getStudent();
    }

    @Override
    public Student createStudent(Student student) {
        return studentOutputPort.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return studentOutputPort.getStudentById(id)
                .map(saveStudent ->{
                    saveStudent.setFirstName(student.getFirstName());
                    saveStudent.setLastName(student.getLastName());
                    saveStudent.setAddress(student.getAddress());
                    saveStudent.setAge(student.getAge());
                    return studentOutputPort.save(saveStudent);
                })
                .orElseThrow();
    }

    @Override
    public void deleteStudent(Long id) {
        if(studentOutputPort.getStudentById(id).isEmpty()){
            throw new StudentNotFountdException("Error");
        }

        studentOutputPort.delete(id);
    }
}
