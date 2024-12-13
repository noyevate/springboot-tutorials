package com.nobafrica.demo2.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import  org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {


    // Service we want to test
    @InjectMocks
    private StudentService studentService;

    // declare dependencies
    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        //Given
        StudentDto studentDto = new StudentDto("samu", "mason", "sam@gmail.com", 1);
        Student student = new Student (3,"sam@gmail.com", "mason", "samu");

        Student savedStudent = new Student(3, "sam@gmail.com", "mason", "samu");
        savedStudent.setId(1);

        //Mock Calls
        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDto(
                "samu",
                "mason",
                "sam@gmail.com"
                )
        );

        //When
        StudentResponseDto responseDto = studentService.saveStudent(studentDto);

        //Then
        assertEquals(studentDto.firtName(), responseDto.firtName());
        assertEquals(studentDto.lastName(), responseDto.lastName());
        assertEquals(studentDto.email(), responseDto.email());

        verify(studentMapper, times(1)).toStudent(studentDto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDto(savedStudent);

    }
}