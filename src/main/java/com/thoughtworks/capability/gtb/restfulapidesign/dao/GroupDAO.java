package com.thoughtworks.capability.gtb.restfulapidesign.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDAO {
    private Integer id;
    private String name;
    private String note;
    private List<StudentDAO> studentDAOS;
}
