package com.nobafrica.demo2.student;


import com.nobafrica.demo2.school.School;
import org.springframework.stereotype.Service;

// used for mapping or creating mapping for the student(like service layer)
@Service
public class StudentMapper {
    public Student toStudent (StudentDto dto) {
        if ( dto == null) {
            throw new  NullPointerException("The Student Dto should not be null");
        }
        var student = new Student();
        //        creating setters
        student.setFirtName(dto.firtName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    //    transforming the response of the Student
    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirtName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
