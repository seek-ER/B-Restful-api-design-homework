package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dao.GroupDAO;
import com.thoughtworks.capability.gtb.restfulapidesign.dao.StudentDAO;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public List<GroupDAO> grouping() {
        List<StudentDAO> students = studentRepository.getStudents(null);
        List<GroupDAO> groups = groupRepository.getGroups();
        groups.forEach(groupDAO -> groupDAO.setStudentDAOS(new ArrayList<>()));
        List<Integer> pendingGroupStudentId = students.stream().map(StudentDAO::getId).collect(Collectors.toList());
        for (int i = 0; i < students.size(); i++) {
            int randomStudentID = getRandomStudentID(pendingGroupStudentId);
            groups.get(i % 6).getStudentDAOS().add(students.get(randomStudentID - 1));
        }
        return groups;
    }

    private int getRandomStudentID(List<Integer> pendingGroupStudentId) {
        int deleteIndex = (int) (Math.random() * pendingGroupStudentId.size());
        return pendingGroupStudentId.remove(deleteIndex);
    }
}
