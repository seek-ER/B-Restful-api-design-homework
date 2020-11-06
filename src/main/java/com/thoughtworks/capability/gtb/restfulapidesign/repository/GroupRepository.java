package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dao.GroupDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepository {

    private static final List<GroupDAO> groups = new ArrayList<>();

    static {
        for (int i = 1; i <= 6; i++) {
            GroupDAO initGroup = GroupDAO.builder()
                    .id(i)
                    .name("Team " + i)
                    .note("Team " + i)
                    .studentDAOS(new ArrayList<>()).build();
            groups.add(initGroup);
        }
    }

    public List<GroupDAO> getGroups() {
        return GroupRepository.groups;
    }
}
