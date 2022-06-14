package com.example.FE019W_beadando.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Courier {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotNull
    @Min(18)
    private int age;
    @NotNull
    @Max(200000)
    private int salary;
    @NotBlank
    private String scooterType;
}
