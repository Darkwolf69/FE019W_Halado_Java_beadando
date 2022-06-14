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
public class Customer {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotNull
    @Min(0)
    @Size(min = 9, max = 11)
    private int phoneNumber;
    @NotBlank
    private String address;
    @NotNull
    private int courierID;
}
