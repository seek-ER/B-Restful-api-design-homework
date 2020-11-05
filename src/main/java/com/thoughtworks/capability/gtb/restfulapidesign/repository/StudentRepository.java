package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.bo.StudentBO;
import com.thoughtworks.capability.gtb.restfulapidesign.dao.StudentDAO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StudentRepository {
    private final Map<Integer, StudentDAO> studentMap = new HashMap<>();
    AtomicInteger studentSize = new AtomicInteger(studentMap.size());

    public StudentDAO addStudent(StudentBO studentBO) {
        StudentDAO addedStudent = StudentDAO.builder()
                .id(studentSize.getAndIncrement()+1)
                .name(studentBO.getName())
                .gender(studentBO.getGender())
                .note(studentBO.getNote())
                .build();
        studentMap.put(addedStudent.getId(),addedStudent);
        return addedStudent;
    }

    public void deleteStudent(Integer id) {
        studentMap.remove(id);
    }
}
