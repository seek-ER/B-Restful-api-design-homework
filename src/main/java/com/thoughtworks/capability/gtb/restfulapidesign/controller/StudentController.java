package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.bo.StudentBO;
import com.thoughtworks.capability.gtb.restfulapidesign.dao.StudentDAO;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDAO addStudent(@RequestBody StudentBO studentBO){
        return studentService.addStudent(studentBO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDAO> getStudents(@RequestParam(value = "gender",required = false) String gender ){
        return studentService.getStudents(gender);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDAO getOneStudent(@PathVariable Integer id){
        return studentService.getOneStudent(id);
    }
}
