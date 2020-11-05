package com.thoughtworks.capability.gtb.restfulapidesign.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDAO {
    private Integer id;
    private String name;
    private String gender;
    private String note;
}
