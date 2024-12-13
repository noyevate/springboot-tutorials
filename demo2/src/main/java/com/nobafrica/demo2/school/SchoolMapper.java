package com.nobafrica.demo2.school;

import org.springframework.stereotype.Service;





@Service
public class SchoolMapper {

    public static School toSchool(SchoolDto dto) {

        return new School(dto.name());
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
}
