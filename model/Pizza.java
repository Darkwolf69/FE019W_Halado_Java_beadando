package com.example.FE019W_beadando.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pizza {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotNull
    @Min(30)
    @Max(50)
    private int size;
    @NotNull
    @Min(1000)
    @Max(8000)
    private int price;
    @NotNull
    private int courierID;
}
