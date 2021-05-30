package com.gkhnatn.springrestapitutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    private final StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public ResponseEntity<String> Post(@RequestBody Student student) {
        studentService.add(student);

        return ResponseEntity.ok("Created new student -> " + student.getName());
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<String> Delete(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);

        return ResponseEntity.ok("Deleted student with Id -> " + studentId );
    }

    @PutMapping("{studentId}")
    public ResponseEntity<String> Update(@PathVariable Long studentId,
                                         @RequestParam(required = false) String name,
                                         @RequestParam(required = false) String email){
        studentService.update(studentId, name, email);

        return ResponseEntity.ok("Updated student with Id -> " + studentId );
    }
}
