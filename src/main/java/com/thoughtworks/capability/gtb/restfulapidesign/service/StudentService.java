package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.bo.StudentBO;
import com.thoughtworks.capability.gtb.restfulapidesign.dao.StudentDAO;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentDAO addStudent(StudentBO studentBO) {
        return studentRepository.addStudent(studentBO);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }

    public List<StudentDAO> getStudents(String gender) {
        return studentRepository.getStudents(gender);
    }

    public StudentDAO getOneStudent(Integer id) {
        return studentRepository.getOneStudent(id);
    }

    public StudentDAO updateStudent(Integer id, StudentBO studentBO) {
        return studentRepository.updateStudent(id,studentBO);
    }
}
