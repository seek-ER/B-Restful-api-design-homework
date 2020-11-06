package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dao.GroupDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GroupRepository {

    private static final Map<Integer, GroupDAO> groups = new HashMap<>();

    static {
        for (int i = 1; i <= 6; i++) {
            GroupDAO initGroup = GroupDAO.builder()
                    .id(i)
                    .name("Team " + i)
                    .note("Team " + i)
                    .studentDAOS(new ArrayList<>()).build();
            groups.put(initGroup.getId(), initGroup);
        }
    }

    public Map<Integer, GroupDAO> getGroups() {
        return groups;
    }
}
