package com.nobafrica.demo2.student;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nobafrica.demo2.school.School;
import com.nobafrica.demo2.student_profile.StudentProfile;
import jakarta.persistence.*;

@Entity
@Table(name = "T_Students")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "c_fname", length = 20)
    private String firtName;

    private String lastName;

//


    @Column(unique = true)
    private String email;

    private int age;

//    connecting the student profile to the Student in a one to one connection
//    since one Student can only have one profile
//    also the student clas is the primary enttity
//    this means it should have the foreignKey

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL

    )
    private StudentProfile studentProfile;

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }



    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference     // the child Entity does not need to serialize the parent entity
    private School school;
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }



    public Student(int age, String email, String lastName, String firtName) {
        this.age = age;
        this.email = email;
        this.lastName = lastName;
        this.firtName = firtName;

    }

    public Student() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
