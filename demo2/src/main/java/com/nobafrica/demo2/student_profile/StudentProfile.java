package com.nobafrica.demo2.student_profile;


import com.nobafrica.demo2.student.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;

    private String bio;

    public Integer getId() {
        return id;
    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }

//    connecting  to the Student class on to one
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;



    public StudentProfile() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
