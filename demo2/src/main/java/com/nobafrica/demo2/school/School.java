package com.nobafrica.demo2.school;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nobafrica.demo2.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    //    connecting the Student to the school, using the One to many
//    because a school can have many students
//    but a student can only hav one school
    @OneToMany(
            mappedBy = "school"
    )
    private List<Student> students;

    @JsonManagedReference       // the child Entity does not need to serialize the parent entity
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }




    public School(String name) {
        this.name = name;
    }

    public School() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
