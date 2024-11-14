package com.sqc.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Nguyen Van A", 9),
                    new Student(2, "Nguyen Van B", 8),
                    new Student(3, "Nguyen Van C", 7)
            )
    );

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
       for (Student student : students) {
           if (student.getId() == id) {
               return ResponseEntity.ok(student);
           }
       }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
           student.setId((int) (Math.random() * 100000));
            students.add(student);
            return ResponseEntity.status(201).body(student);
        }
        catch (Exception e) {
           return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        try {
            student.setId(id);
            student.setName(student.getName());
            student.setScroe(student.getScroe());
            students.add(student);
            return ResponseEntity.ok(student);

        }  catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }


}
