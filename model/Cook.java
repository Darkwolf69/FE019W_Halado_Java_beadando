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
public class Cook {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotNull
    @Min(18)
    private int age;
    @NotNull
    @Max(300000)
    private int salary;
    @NotNull
    private int pizzaID;
}
