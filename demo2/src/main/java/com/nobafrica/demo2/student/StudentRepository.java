package com.nobafrica.demo2.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Integer> {
    List<Student> findAllByFirtNameContaining(String firstname);
}
