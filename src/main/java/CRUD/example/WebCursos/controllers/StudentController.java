package CRUD.example.WebCursos.controllers;

import CRUD.example.WebCursos.dtos.StudentDTO;
import CRUD.example.WebCursos.models.Student;
import CRUD.example.WebCursos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody StudentDTO studentDTO) {
        Student student = studentRepository.save(new Student(studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail(), studentDTO.getPassword()));
        return ResponseEntity.ok(new StudentDTO(student.getFirstName(), student.getLastName(), student.getEmail(), student.getPassword()));
    }
}
