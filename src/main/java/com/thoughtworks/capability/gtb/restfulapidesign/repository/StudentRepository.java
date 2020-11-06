package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.bo.StudentBO;
import com.thoughtworks.capability.gtb.restfulapidesign.dao.StudentDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    public List<StudentDAO> getStudents(String gender) {
        if (gender == null){
            return new ArrayList<>(studentMap.values());
        }
        return studentMap.values().stream()
                .filter(studentDAO -> studentDAO.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public StudentDAO getOneStudent(Integer id) {
        return studentMap.get(id);
    }

    public StudentDAO updateStudent(Integer id, StudentBO studentBO) {
        StudentDAO updatingStudent = studentMap.get(id);
        if (updatingStudent == null){
            return null;
        }
        if (studentBO.getName() != null){
            updatingStudent.setName(studentBO.getName());
        }
        if (studentBO.getGender() != null){
            updatingStudent.setGender(studentBO.getGender());
        }
        if (studentBO.getNote() != null){
            updatingStudent.setNote(studentBO.getNote());
        }
        return updatingStudent;
    }
}
