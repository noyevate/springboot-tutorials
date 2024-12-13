package com.nobafrica.demo2.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private final StudentService studentService;

    @PostMapping("/students")
    public StudentResponseDto saveStudent (
           @Valid @RequestBody StudentDto studentDto
    ) {
        return  this.studentService.saveStudent(studentDto);
    }

    @GetMapping("/students/all")
    public List<StudentResponseDto> findAllStudent () {
        return studentService.findAllStudent();
    }

    @GetMapping("/student/{student-id}")
    public StudentResponseDto findStudentById (
            @PathVariable("student-id") Integer id
    ) {
        return  studentService.findStudentById(id);
    }


//    finding students by first name
    @GetMapping("/student/search/{student-name}")
    public List<StudentResponseDto> findStudentsByNane(
            @PathVariable("student-name") String name
    ) {
        return studentService.findStudentsByNane(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(
            @PathVariable("student-id") Integer id
    ) {
        studentService.deleteStudent(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError)error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new  ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    

}
