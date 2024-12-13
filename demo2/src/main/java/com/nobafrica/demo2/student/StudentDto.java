package com.nobafrica.demo2.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(

        @NotEmpty(message = "First name should not be empty")
        String firtName,

        @NotEmpty(message = "last name should not be empty")
        String lastName,

        String email,

        Integer schoolId
) {
}
