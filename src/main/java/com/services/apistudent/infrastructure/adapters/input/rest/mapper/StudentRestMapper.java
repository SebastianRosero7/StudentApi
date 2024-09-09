package com.services.apistudent.infrastructure.adapters.input.rest.mapper;

import com.services.apistudent.domain.model.Student;
import com.services.apistudent.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.apistudent.infrastructure.adapters.input.rest.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {

    Student toStudent(StudentCreateRequest studentCreateRequest);

    StudentResponse toStudentResponse(Student student);

    List<StudentResponse> toStudentResponses(List<Student> students);


}
