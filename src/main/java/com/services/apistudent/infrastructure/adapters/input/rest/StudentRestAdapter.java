package com.services.apistudent.infrastructure.adapters.input.rest;

import com.services.apistudent.application.ports.input.StudentServicePort;
import com.services.apistudent.application.services.StudentService;
import com.services.apistudent.domain.model.Student;
import com.services.apistudent.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import com.services.apistudent.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.apistudent.infrastructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor

public class StudentRestAdapter {

    private final StudentServicePort studentService;
    private final StudentRestMapper studentRestMapper;


    @GetMapping
    public List<StudentResponse> findAll() {
        return studentRestMapper.toStudentResponses(studentService.findAllStudents());
    }
    @GetMapping("/{id}")
    public StudentResponse findById(@PathVariable Long id) {
        return studentRestMapper.toStudentResponse(studentService.findStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> save(@Valid @RequestBody StudentCreateRequest student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentRestMapper.toStudentResponse(studentService.createStudent(studentRestMapper.toStudent(student))));
    }


    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentCreateRequest student) {
        return studentRestMapper.toStudentResponse(studentService.updateStudent(id, studentRestMapper.toStudent(student)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
