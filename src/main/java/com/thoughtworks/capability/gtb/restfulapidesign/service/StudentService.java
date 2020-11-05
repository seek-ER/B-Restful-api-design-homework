package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.bo.StudentBO;
import com.thoughtworks.capability.gtb.restfulapidesign.dao.StudentDAO;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentDAO addStudent(StudentBO studentBO) {
        return studentRepository.addStudent(studentBO);
    }
}
