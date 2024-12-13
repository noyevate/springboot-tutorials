package com.nobafrica.demo2.student;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
            StudentDto studentDto
    ) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudent() {
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

//    public List<Student> findAllStudent () {
//        return repository.findAll();
//    }

    public StudentResponseDto findStudentById (Integer id) {
        return  repository.findById(id)
                    .map(studentMapper::toStudentResponseDto)
                    .orElse(null);
    }

    public List<StudentResponseDto> findStudentsByNane(String name) {
        return repository.findAllByFirtNameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public void deleteStudent(Integer id) {
         repository.deleteById(id);
    }

}
