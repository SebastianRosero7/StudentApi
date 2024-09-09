package com.services.apistudent;

import com.services.apistudent.domain.model.Student;
import com.services.apistudent.infrastructure.adapters.output.persistence.entity.StudentEntity;
import com.services.apistudent.infrastructure.adapters.output.persistence.repository.StudentRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ApIstudentApplication implements CommandLineRunner {

    private final StudentRespository studentRespository;

    public static void main(String[] args) {
        SpringApplication.run(ApIstudentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<StudentEntity> students = Arrays.asList(
                new StudentEntity(null,"Juan","Perez",24,"carrera 14"),
                new StudentEntity(null, "Maria", "Gomez", 22, "Avenida 8"),
                new StudentEntity(null, "Luis", "Ramirez", 20, "Calle 12"),
                new StudentEntity(null, "Ana", "Martinez", 23, "Carrera 10"),
                new StudentEntity(null, "Carlos", "Rodriguez", 21, "Calle 5"),
                new StudentEntity(null, "Lucia", "Fernandez", 25, "Avenida 15"),
                new StudentEntity(null, "Jorge", "Lopez", 24, "Calle 22"),
                new StudentEntity(null, "Sofia", "Torres", 19, "Carrera 3"),
                new StudentEntity(null, "Diego", "Castro", 27, "Avenida 9"),
                new StudentEntity(null, "Isabel", "Ruiz", 22, "Calle 18"),
                new StudentEntity(null, "Miguel", "Mendoza", 26, "Carrera 8")

        );

        studentRespository.saveAll(students);
    }
}
