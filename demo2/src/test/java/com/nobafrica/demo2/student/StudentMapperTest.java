package com.nobafrica.demo2.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();  // initializing
    }

    @Test
    public void shouldMapStudentDtoToStudentClass() {
        StudentDto dto = new StudentDto(
                "john",
                "mason",
                "mason@gmail.com",
                1);

        Student student = mapper.toStudent(dto);
        assertEquals(dto.firtName(), student.getFirtName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());

    }


    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null () {
        var exception = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The Student Dto should not be null", exception.getMessage());

    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        // Give:
        Student student = new Student(12,
                "jane@gail.com",
                "jane",
                "mason"
        );
        // Map:
        StudentResponseDto responseDto = mapper.toStudentResponseDto(student);
        // then expect:
        assertEquals(responseDto.email(), student.getEmail());
        assertEquals(responseDto.lastName(), student.getLastName());
        assertEquals(responseDto.firtName(), student.getFirtName());

    }





}