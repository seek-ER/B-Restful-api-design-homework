package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dao.GroupDAO;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDAO> grouping() {
        return groupService.grouping();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GroupDAO updateGroupName(@PathVariable Integer id, @RequestParam(value = "name") String newGroupName) {
        return groupService.updateGroupName(id, newGroupName);
    }
}
