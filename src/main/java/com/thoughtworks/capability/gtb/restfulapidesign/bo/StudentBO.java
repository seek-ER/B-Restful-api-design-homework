package com.thoughtworks.capability.gtb.restfulapidesign.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBO {
    private String name;
    private String gender;
    private String note;
}
